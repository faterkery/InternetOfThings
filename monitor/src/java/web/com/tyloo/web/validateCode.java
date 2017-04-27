package com.tyloo.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.awt.image.codec.JPEGParam;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
/**
 * Servlet implementation class ValidateCode
 */
public class validateCode extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateCode() {
        super();
    }
    public void validateCodeCreater(ServletOutputStream out, HttpServletRequest request)
    {
        String[] str=new String[4];
        Random random=new Random();
        for(int i=0;i<4;i++)
        {
            int temp=random.nextInt(10);
            str[i]=String.valueOf(temp);
        }
        //根据得到的随机数，绘制验证码图片
        int width=100;
        int height=40;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g=image.createGraphics();
        g.clearRect(0,0,width,height);
        
        //背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        
        //字体
        g.setFont(new Font("serial",Font.BOLD,22));
 
        /**
         * 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
         */
        g.setColor(getRandColor(101,220));
        for (int i=0;i<155;i++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
           // int xl = random.nextInt(12);
            //int yl = random.nextInt(12);
           
            //g.drawLine(x,y,x+xl,y+yl);
            g.drawLine(x,y,x,y);
        }
        
        /*
        * 取随机产生的认证码(4位数字)
        */
       String sRand="";
       for(int i=0;i<4;i++){
           String temp = getRandomChar().toUpperCase();
           sRand += temp;
           /**
            * 将认证码显示到图象中
            */
           g.setColor(getRandColor(90,220));
           g.drawString(temp,23*i+6,26);
       }
       
       HttpSession session = request.getSession();
       session.setAttribute("validateCode",sRand);
        
        g.dispose();
        
        JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
        JPEGParam param=(JPEGParam) encoder.getDefaultJPEGEncodeParam(image);
        param.setQuality(1.0f,false);
        encoder.setJPEGEncodeParam(param);
        
        try {
            encoder.encode(image);
        } catch (ImageFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        validateCodeCreater(response.getOutputStream(), request);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    
    private Color getRandColor(int fc,int bc){ //给定范围获得随机颜色
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
    
    private String getRandomChar(){
        int rand = (int)Math.round(Math.random() * 2);
        long itmp = 0;
        char ctmp = '\u0000';
        switch(rand){
            case 1:
                itmp = Math.round(Math.random() * 25 + 65);
                ctmp = (char)itmp;
                return String.valueOf(ctmp);
            case 2:
                itmp = Math.round(Math.random() * 25 + 97);
                ctmp = (char)itmp;
                return String.valueOf(ctmp);
            default :
                itmp = Math.round(Math.random() * 9);
                return String.valueOf(itmp);
        }
    }
}
