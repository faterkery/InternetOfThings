package com.tyloo.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.tyloo.fw.waf.WebContext;
import com.tyloo.modules.member.Constants;

public class DownLoadAction extends WebAction {

	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {
		String path = context.getParameter("path");
		if(StringUtils.isEmpty(path))
		{
			return "file404";
		}
		
		try {
			HttpServletResponse response = context.getResponse();
            // path是指欲下载的文件的路径。
			path = Constants.PORTAL_IMAGE_PATH + path;
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
//            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return null;
	}

}
