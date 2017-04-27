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
	 * FTP�ϴ������ļ�����
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
			// �����ϴ�Ŀ¼
			ftpClient.changeWorkingDirectory(ftpPath);
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("GBK");
			// �����ļ����ͣ������ƣ�
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.storeFile(fileName, fis);
			upStatus = true;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("FTP�ͻ��˳�����", e);
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�FTP���ӷ����쳣��", e);
			}
		}
		return upStatus;
	}

	/**
	 * FTP���ص����ļ�����
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
			// �����ļ����ͣ������ƣ�
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.retrieveFile(remoteFileName, fos);
			fos.close();
		} catch (IOException e) {
			upStatus = true;
			e.printStackTrace();
			throw new RuntimeException("FTP�ͻ��˳�����", e);
		} finally {
			IOUtils.closeQuietly(fos);
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�FTP���ӷ����쳣��", e);
			}
		}
		return upStatus;
	}

}