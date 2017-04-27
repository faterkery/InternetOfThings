package com.tyloo.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.struts.upload.FormFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageHelper {

    public static final int DEFAULT_PADDING = 2;

    public static final Color DEFAULT_PADDING_COLOR = Color.WHITE;

    public static final MathContext MATH_CONTEXT = new MathContext(10, RoundingMode.HALF_UP);

    public static String getContentType(File file) throws IOException {
        String type;
        InputStream inputStream = new FileInputStream(file);
        byte[] header = new byte[10];
        try {
            inputStream.read(header);
        } finally {
            try {inputStream.close();} catch (Exception e) {}
        }

        if (header[0] == (byte) 'G' && header[1] == (byte) 'I' && header[2] == (byte) 'F')
            type = "GIF";
            // PNG   
        else if (header[1] == (byte) 'P' && header[2] == (byte) 'N' && header[3] == (byte) 'G')
            type = "PNG";
            // JPG
        else if (header[6] == (byte) 'J' && header[7] == (byte) 'F' && header[8] == (byte) 'I' && header[9] == (byte) 'F')
            type = "JPG";
        else
            type = "Unknown";

        return type;
    }

    public static void resizeFix(FormFile sourceFile, File targetFile, int fixW, int fixH) throws IOException {
        resizeFix(sourceFile, targetFile, fixW, fixH, DEFAULT_PADDING, DEFAULT_PADDING_COLOR);
    }

    public static void resizeFix(FormFile sourceFile, File targetFile, int fixW, int fixH, int padding, Color paddingColor) throws IOException {

        Image sourceImage = javax.imageio.ImageIO.read(sourceFile.getInputStream());
        if(sourceImage==null){
        	return;
        }
        int sourceWidth = sourceImage.getWidth(null);
        int sourceHeight = sourceImage.getHeight(null);
        int w, h, pw, ph;
        BigDecimal bSourceWidth = BigDecimal.valueOf(sourceWidth);
        BigDecimal bSourceHeight = BigDecimal.valueOf(sourceHeight);
        BigDecimal bFixW = BigDecimal.valueOf(fixW);
        BigDecimal bFixH = BigDecimal.valueOf(fixH);
        if (bSourceWidth.divide(bSourceHeight, MATH_CONTEXT).compareTo(bFixW.divide(bFixH, MATH_CONTEXT)) > 0) {
            w = fixW - 2 * padding;
            h = bFixW.divide(bSourceWidth, MATH_CONTEXT).multiply(bSourceHeight).intValue() - 2 * padding;
            pw = padding;
            ph = (fixH - h) / 2 + padding;
        } else {
            w = bFixH.divide(bSourceHeight, MATH_CONTEXT).multiply(bSourceWidth).intValue() - 2 * padding;
            h = fixH - 2 * padding;
            pw = (fixW - w) / 2 + padding;
            ph = padding;
        }
        BufferedImage _image = new BufferedImage(fixW, fixH, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = _image.getGraphics();
        graphics.setColor(paddingColor);
        graphics.fillRect(0, 0, fixW, fixH);
        graphics.drawImage(sourceImage.getScaledInstance(w, h, Image.SCALE_SMOOTH), pw, ph, w, h, null);
        FileOutputStream out = new FileOutputStream(targetFile);
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(_image);
        out.close();
    }


}
