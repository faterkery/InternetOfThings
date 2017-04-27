package com.tyloo.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;

import com.tyloo.fw.waf.WebContext;

public class PicOutPutStreamAction extends WebAction {

	@Override
	public String webProcess(WebContext context, Object member)
			throws ServletException {

		String path = context.getParameter("path");
		
        String isHttp =path.substring(0,4);
        String savePath = null ;
        if(isHttp.equals("http")){
        	savePath=path;
        }else{
		 savePath = servlet.getServletContext().getRealPath("/") + path;
		 }
		File pic = new File(savePath);
		BufferedOutputStream bout = null;
		InputStream in = null;
		try {
			  if(isHttp.equals("http")){
				  //new一个URL对象  
			        URL url = new URL(savePath);  
			        //打开链接  
			        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
			        //设置请求方式为"GET"  
			        conn.setRequestMethod("GET");  
			        //超时响应时间为5秒  
			        conn.setConnectTimeout(5 * 1000);  
			        //通过输入流获取图片数据  
			        in = conn.getInputStream();  
			  }
			  else
			  {	
				  in = new FileInputStream(pic);
			  }
			 bout = new BufferedOutputStream(context.getResponse()
					.getOutputStream());
			byte b[] = new byte[1024];
			int len = in.read(b);
			while (len > 0) {
				bout.write(b, 0, len);
				len = in.read(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (bout != null) {
					bout.close();
				}

				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return null;
	}
	
}
