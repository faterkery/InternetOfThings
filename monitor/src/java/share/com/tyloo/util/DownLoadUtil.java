package com.tyloo.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.tyloo.fw.waf.WebContext;

public class DownLoadUtil {
	public static void downLoad(WebContext context, String path,
			String realFileName,String mimeType) {
		try {
			String contentType = mimeType;
			ByteArrayOutputStream baos = downloadFile(path);
			HttpServletResponse response = context
					.getResponse();
			response.setContentType(contentType);
			response.setHeader("Content-Disposition", "attachment; filename="
					+ new String(realFileName.getBytes("GBK"), "ISO8859_1"));
			ServletOutputStream out = response.getOutputStream();
			baos.writeTo(out);
			out.flush();
		} catch (IOException ex) {
			
		}
	}

	private static ByteArrayOutputStream downloadFile(String path)
			throws IOException {
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(baos);
			int i;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}
			bos.flush();// 提交文件流，很关键
			bis.close();
			return baos;
		} catch (Exception e) {
			return null;
		}
	}
}
