package com.tyloo.util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class FtpUtils {
	public static void main(String[] args) {
		// testUpload();
		// testDownload();
		FtpUtils a = new FtpUtils();

//		a.upload("172.18.122.232", 21, "gsyh", "gsyhqwe",
//				"D:\\workspace\\zhoushan\\web\\upload\\gas\\dzdw20100818.001",
//				"/", "dzdw20100818.001");

		a.upload("172.28.28.28", 1001, "DKYH", "",
				"D:\\workspace\\zhoushan\\web\\upload\\water\\20100826.003",
				"/", "20100826.003");

		 FtpUtils.download("172.28.28.28", 1001, "DKYH", "", "D:\\", "/",
				"20100826.003");
	}

	/**
	 * FTP上传单个文件测试
	 */
	public boolean upload(String ip, int port, String user, String password,
			String filePath, String ftpPath, String fileName) {
		FTPClient ftpClient = new FTPClient();
		FileInputStream fis = null;

		boolean upStatus = false;
		try {
			ftpClient.setDefaultPort(port);
			ftpClient.connect(ip);
			ftpClient.login(user, password);

			File srcFile = new File(filePath);
			fis = new FileInputStream(srcFile);
			// 设置上传目录
			ftpClient.changeWorkingDirectory(ftpPath);
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("GBK");
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.storeFile(fileName, fis);
			upStatus = true;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("FTP客户端出错！", e);
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
		return upStatus;
	}

	/**
	 * FTP下载单个文件测试
	 */
	public static boolean download(String ip, int port, String user,
			String password, String filePath, String ftpPath, String fileName) {
		FTPClient ftpClient = new FTPClient();
		FileOutputStream fos = null;
		boolean upStatus = false;
		try {
			ftpClient.setDefaultPort(port);
			ftpClient.connect(ip);
			ftpClient.login(user, password);
			String remoteFileName = ftpPath + fileName;
			fos = new FileOutputStream(filePath + fileName);
			ftpClient.setBufferSize(1024);
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.retrieveFile(remoteFileName, fos);
			fos.close();
		} catch (IOException e) {
			upStatus = true;
			e.printStackTrace();
			throw new RuntimeException("FTP客户端出错！", e);
		} finally {
			IOUtils.closeQuietly(fos);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
		return upStatus;
	}

}
