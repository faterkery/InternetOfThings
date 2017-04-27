package com.tyloo.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.axis2.AxisFault;

public class LanzSMS {
	public static void sendsms(String phone, String content) {
		try {
			String message = content;
			URL url = new URL(
					"http://www.lanz.net.cn/LANZGateway/DirectSendSMSs.asp");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream(), "GB2312");

			String urlString = "UserID=847716" + "&Account=tianlu123"
					+ "&Password=45F6BDC7B98EEEB024047E7291F8F1ED4F259487"
					+ "&SMSType=1" + "&Content=" + message + "【天禄大地】"
					+ "&Phones=" + phone + "" + "&SendDate=" + "&Sendtime=";

			urlString = urlString.replace("%", "％");
			urlString = urlString.replace("+", "＋");

			out.write(urlString);
			out.flush();
			out.close();

			String sCurrentLine;
			String sTotalString;
			sCurrentLine = "";
			sTotalString = "";
			InputStream l_urlStream;
			l_urlStream = connection.getInputStream();

			BufferedReader l_reader = new BufferedReader(new InputStreamReader(
					l_urlStream));
			while ((sCurrentLine = l_reader.readLine()) != null) {
				sTotalString += sCurrentLine + "\r\n";
			}
			System.out.println(sTotalString);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		sendsms("15168085427", "你好1");
	}

}
