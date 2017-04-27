package com.tyloo.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HaoImageScale {
	private int width;

	private int height;

	private int scaleWidth;

	private double support = 3.0;

	private double PI = 3.14159265358978;

	private double[] contrib;

	private double[] normContrib;

	private double[] tmpContrib;

	private int nDots;

	private int nHalfDots;

	/**
	 * 缩图
	 */
	public BufferedImage imageZoom2MinSize(BufferedImage srcBufferImage,
			int width, int height) {
		double w1 = srcBufferImage.getWidth();
		double h1 = srcBufferImage.getHeight();
		if (w1 > width || h1 > height) {
			CalContrib();
			BufferedImage pbOut = HorizontalFiltering(srcBufferImage, width);
			pbOut = VerticalFiltering(pbOut, height);
			return pbOut;
		}
		return srcBufferImage;
	}

	/**
	 * 转换图片
	 */
	public BufferedImage imageZoom2FixedWidth(BufferedImage srcBufferImage,
			int w) {
		width = srcBufferImage.getWidth();
		height = srcBufferImage.getHeight();
		int h = 0;
		if (width > w) {
			double y = (double) height / (double) width;
			h = (int) Math.round(w * y);
		} else {
			w = width;
			h = height;
		}
		scaleWidth = w;
		width = w;
		height = h;
		BufferedImage pbOut = null;
		CalContrib();
		pbOut = HorizontalFiltering(srcBufferImage, w);
		BufferedImage pbFinalOut = VerticalFiltering(pbOut, h);
		return pbFinalOut;
	}

	/**
	 * 转换图片
	 */
	public BufferedImage imageZoom2MinSize(BufferedImage srcBufferImage,
			int minsize) {
		width = srcBufferImage.getWidth();
		height = srcBufferImage.getHeight();
		int w = 0;
		int h = 0;
		if (width > height) {
			double x = (double) width / (double) height;
			w = (int) Math.round(minsize * x);
			h = minsize;
		} else {
			double y = (double) height / (double) width;
			h = (int) Math.round(minsize * y);
			w = minsize;
		}
		scaleWidth = w;
		BufferedImage pOut = null;
		BufferedImage pbOut = null;
		CalContrib();
		if (pOut == null) {
			pbOut = HorizontalFiltering(srcBufferImage, w);
		} else {
			pbOut = HorizontalFiltering(pOut, w);
		}
		BufferedImage pbFinalOut = VerticalFiltering(pbOut, h);
		return pbFinalOut;
	}

	/**
	 * 转换图片
	 */
	public BufferedImage imageZoom2Square(BufferedImage srcBufferImage, int size) {
		width = srcBufferImage.getWidth();
		height = srcBufferImage.getHeight();
		scaleWidth = size;
		BufferedImage pOut = null;
		BufferedImage pbOut = null;
		if (width != height) {
			int x = 0;
			int y;
			int w2;
			if (width < height) {
				y = height - width;
				w2 = width;
			} else {
				y = 0;
				w2 = height;
			}
			pOut = srcBufferImage.getSubimage(x, y, w2, w2);
			width = w2;
			height = w2;
		}
		if (DetermineResultSize(size, size) == 1) {
			if (pOut == null)
				pOut = srcBufferImage;
			return pOut;
		}
		CalContrib();
		if (pOut == null) {
			pbOut = HorizontalFiltering(srcBufferImage, size);
		} else {
			pbOut = HorizontalFiltering(pOut, size);
		}
		BufferedImage pbFinalOut = VerticalFiltering(pbOut, size);
		return pbFinalOut;
	}

	/**
	 * 截图
	 * 
	 * @param filepath
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage fileImgSubImage(String filepath, int x, int y,
			int width, int height) {
		BufferedImage bis = this.getfileImg(filepath);
		if (bis == null)
			return null;
		return bis.getSubimage(x, y, width, height);
	}

	public BufferedImage fileImgSubSquareImage(String filepath,
			double percentX, double percentY, int size) {
		BufferedImage bis = this.getfileImg(filepath);
		if (bis == null)
			return null;
		double w1 = bis.getWidth();
		double h1 = bis.getHeight();
		int w = (int) Math.round((percentX / 100) * w1);
		int h = (int) Math.round((percentY / 100) * h1);
		int w2 = size;
		int h2 = size;
		if (h1 < size)
			h2 = (int) h1;
		if (w1 < size)
			w2 = (int) w1;
		return bis.getSubimage(w, h, w2, h2);
	}

	public BufferedImage fileImgZoom2MinSize(String filepath, int minsize) {
		BufferedImage bis = this.getfileImg(filepath);
		if (bis == null)
			return null;
		return this.imageZoom2MinSize(bis, minsize);
	}

	public BufferedImage getfileImg(String filepath) {
		File fi = new File(filepath);
		if (!fi.exists())
			return null;
		BufferedImage bis = null;
		try {
			bis = ImageIO.read(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			Image i = Toolkit.getDefaultToolkit().getImage(filepath);
			if (i == null)
				return null;
			bis = this.createBufferedImage(i);
		}
		return bis;
	}

	public BufferedImage fileImgZoom2FixedWidth(String filepath, int w) {
		BufferedImage bis = this.getfileImg(filepath);
		if (bis == null)
			return null;
		return this.imageZoom2FixedWidth(bis, w);
	}

	public BufferedImage fileImgZoom2Square(String filepath, int size) {
		BufferedImage bis = this.getfileImg(filepath);
		if (bis == null)
			return null;
		return this.imageZoom2Square(bis, size);
	}

	public BufferedImage fileImgZoom2MinSize(String filepath, int width,
			int height) {
		BufferedImage bis = this.getfileImg(filepath);
		if (bis == null)
			return null;
		return this.imageZoom2MinSize(bis, width, height);
	}

	/**
	 * 决定图像尺寸
	 */
	private int DetermineResultSize(int w, int h) {
		double scaleH, scaleV;
		scaleH = (double) w / (double) width;
		scaleV = (double) h / (double) height;
		// 需要判断一下scaleH，scaleV，不做放大操作
		if (scaleH >= 1.0 || scaleV >= 1.0) {
			return 1;
		}
		return 0;

	}

	private double Lanczos(int i, int inWidth, int outWidth, double Support) {
		double x;

		x = (double) i * (double) outWidth / inWidth;

		return Math.sin(x * PI) / (x * PI) * Math.sin(x * PI / Support)
				/ (x * PI / Support);

	}

	//
	// 高度宽度相同
	//
	private void CalContrib() {
		nHalfDots = (int) (width * support / scaleWidth);
		nDots = nHalfDots * 2 + 1;
		try {
			contrib = new double[nDots];
			normContrib = new double[nDots];
			tmpContrib = new double[nDots];
		} catch (Exception e) {
			System.out.println("init contrib,normContrib,tmpContrib" + e);
		}

		int center = nHalfDots;
		contrib[center] = 1.0;

		double weight = 0.0;
		int i = 0;
		for (i = 1; i <= center; i++) {
			contrib[center + i] = Lanczos(i, width, scaleWidth, support);
			weight += contrib[center + i];
		}

		for (i = center - 1; i >= 0; i--) {
			contrib[i] = contrib[center * 2 - i];
		}

		weight = weight * 2 + 1.0;

		for (i = 0; i <= center; i++) {
			normContrib[i] = contrib[i] / weight;
		}

		for (i = center + 1; i < nDots; i++) {
			normContrib[i] = normContrib[center * 2 - i];
		}
	}

	// 处理边缘
	private void CalTempContrib(int start, int stop) {
		double weight = 0;

		int i = 0;
		for (i = start; i <= stop; i++) {
			weight += contrib[i];
		}

		for (i = start; i <= stop; i++) {
			tmpContrib[i] = contrib[i] / weight;
		}

	}

	private int GetRedValue(int rgbValue) {
		int temp = rgbValue & 0x00ff0000;
		return temp >> 16;
	}

	private int GetGreenValue(int rgbValue) {
		int temp = rgbValue & 0x0000ff00;
		return temp >> 8;
	}

	private int GetBlueValue(int rgbValue) {
		return rgbValue & 0x000000ff;
	}

	private int ComRGB(int redValue, int greenValue, int blueValue) {

		return (redValue << 16) + (greenValue << 8) + blueValue;
	}

	// 行水平滤波
	private int HorizontalFilter(BufferedImage bufImg, int startX, int stopX,
			int start, int stop, int y, double[] pContrib) {
		double valueRed = 0.0;
		double valueGreen = 0.0;
		double valueBlue = 0.0;
		int valueRGB = 0;
		int i, j;

		for (i = startX, j = start; i <= stopX; i++, j++) {
			valueRGB = bufImg.getRGB(i, y);

			valueRed += GetRedValue(valueRGB) * pContrib[j];
			valueGreen += GetGreenValue(valueRGB) * pContrib[j];
			valueBlue += GetBlueValue(valueRGB) * pContrib[j];
		}

		valueRGB = ComRGB(Clip((int) valueRed), Clip((int) valueGreen),
				Clip((int) valueBlue));
		return valueRGB;

	}

	// 图片水平滤波
	private BufferedImage HorizontalFiltering(BufferedImage bufImage, int iOutW) {
		int dwInW = bufImage.getWidth();
		int dwInH = bufImage.getHeight();
		int value = 0;
		BufferedImage pbOut = new BufferedImage(iOutW, dwInH,
				BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < iOutW; x++) {

			int startX;
			int start;
			int X = (int) (((double) x) * ((double) dwInW) / (iOutW) + 0.5);
			int y = 0;

			startX = X - nHalfDots;
			if (startX < 0) {
				startX = 0;
				start = nHalfDots - X;
			} else {
				start = 0;
			}

			int stop;
			int stopX = X + nHalfDots;
			if (stopX > (dwInW - 1)) {
				stopX = dwInW - 1;
				stop = nHalfDots + (dwInW - 1 - X);
			} else {
				stop = nHalfDots * 2;
			}

			if (start > 0 || stop < nDots - 1) {
				CalTempContrib(start, stop);
				for (y = 0; y < dwInH; y++) {
					value = HorizontalFilter(bufImage, startX, stopX, start,
							stop, y, tmpContrib);
					pbOut.setRGB(x, y, value);
				}
			} else {
				for (y = 0; y < dwInH; y++) {
					value = HorizontalFilter(bufImage, startX, stopX, start,
							stop, y, normContrib);
					pbOut.setRGB(x, y, value);
				}
			}
		}

		return pbOut;

	}

	private int VerticalFilter(BufferedImage pbInImage, int startY, int stopY,
			int start, int stop, int x, double[] pContrib) {
		double valueRed = 0.0;
		double valueGreen = 0.0;
		double valueBlue = 0.0;
		int valueRGB = 0;
		int i, j;

		for (i = startY, j = start; i <= stopY; i++, j++) {
			valueRGB = pbInImage.getRGB(x, i);

			valueRed += GetRedValue(valueRGB) * pContrib[j];
			valueGreen += GetGreenValue(valueRGB) * pContrib[j];
			valueBlue += GetBlueValue(valueRGB) * pContrib[j];
		}

		valueRGB = ComRGB(Clip((int) valueRed), Clip((int) valueGreen),
				Clip((int) valueBlue));
		return valueRGB;

	}

	private BufferedImage VerticalFiltering(BufferedImage pbImage, int iOutH) {
		int iW = pbImage.getWidth();
		int iH = pbImage.getHeight();
		int value = 0;
		BufferedImage pbOut = new BufferedImage(iW, iOutH,
				BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < iOutH; y++) {

			int startY;
			int start;
			int Y = (int) (((double) y) * ((double) iH) / (iOutH) + 0.5);

			startY = Y - nHalfDots;
			if (startY < 0) {
				startY = 0;
				start = nHalfDots - Y;
			} else {
				start = 0;
			}

			int stop;
			int stopY = Y + nHalfDots;
			if (stopY > (iH - 1)) {
				stopY = iH - 1;
				stop = nHalfDots + (iH - 1 - Y);
			} else {
				stop = nHalfDots * 2;
			}

			if (start > 0 || stop < nDots - 1) {
				CalTempContrib(start, stop);
				for (int x = 0; x < iW; x++) {
					value = VerticalFilter(pbImage, startY, stopY, start, stop,
							x, tmpContrib);
					pbOut.setRGB(x, y, value);
				}
			} else {
				for (int x = 0; x < iW; x++) {
					value = VerticalFilter(pbImage, startY, stopY, start, stop,
							x, normContrib);
					pbOut.setRGB(x, y, value);
				}
			}
		}
		return pbOut;
	}

	private BufferedImage createBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		if (w <= 0 || h <= 0)
			return null;
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = bi.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return bi;
	}

	private int Clip(int x) {
		if (x < 0)
			return 0;
		if (x > 255)
			return 255;
		return x;
	}

	public static void ImgToFile(BufferedImage img, String filepath, String type) {
		File fo = new File(filepath); // 将要转换出的小图文件
		try {
			ImageIO.write(img, type, fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ImgToFile(BufferedImage img, String filepath) {
		HaoImageScale.ImgToFile(img, filepath, "jpeg");
	}

	/**
	 * 得到图片宽长
	 * 
	 * @param filepath
	 * @return
	 */
	public static int[] getImageSize(String filepath) {
		BufferedImage bi = null;
		int[] size = new int[2];
		try {
			bi = ImageIO.read(new File(filepath));
			size[0] = bi.getWidth();
			size[1] = bi.getHeight();
		} catch (IOException e) {
			size[0] = 0;
			size[1] = 0;
		}
		return size;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
