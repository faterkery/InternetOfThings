package com.renhenet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class HaoRuntime {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HaoRuntime.class);

	/**
	 * 取错误方式运行，不回显。
	 * 
	 * @param cmd
	 *            命令
	 * @return
	 */
	public static void getErrorRun(String[] cmd) throws IOException {
		Process child = Runtime.getRuntime().exec(cmd);
		logger.info("cmd:" + StringUtil.joinString(cmd, " "));

		InputStream is = child.getErrorStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);

		while (reader.readLine() != null) {
		}

		is.close();
		isr.close();
		reader.close();
	}

	/**
	 * 取错误方式运行，回显。
	 * 
	 * @param cmd
	 *            命令
	 * @return
	 */
	public static String getErrorRunInfo(String[] cmd) throws IOException {
		Process child = Runtime.getRuntime().exec(cmd);
		logger.info("cmd:" + StringUtil.joinString(cmd, " "));

		InputStream is = child.getErrorStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);

		StringBuffer xmlstr = new StringBuffer();
		String temp = null;
		while ((temp = reader.readLine()) != null) {
			if (temp.length() != 0) {
				xmlstr.append(temp);
			}
		}

		is.close();
		isr.close();
		reader.close();
		return xmlstr.toString();
	}

	/**
	 * 取正常方式运行，回显。
	 * 
	 * @param cmd
	 *            命令
	 * @return
	 */
	public static String getRunInfo(String[] cmd) throws IOException {
		Process child = Runtime.getRuntime().exec(cmd);
		logger.info("cmd:" + StringUtil.joinString(cmd, " "));

		return getCmdRunInfo(child);
	}

	/**
	 * 取正常方式运行，回显。
	 * 
	 * @param cmd
	 *            命令
	 * @return
	 */
	public static String getRunInfo(String cmd, String[] envp)
			throws IOException {
		Process child = Runtime.getRuntime().exec(cmd, envp);
		logger.info("cmd:" + cmd);

		return getCmdRunInfo(child);
	}

	private static String getCmdRunInfo(Process child) throws IOException {
		InputStream is = child.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);

		StringBuffer xmlstr = new StringBuffer();
		String temp = null;

		while ((temp = reader.readLine()) != null) {
			if (temp.length() != 0) {
				xmlstr.append(temp);
			}
		}
		is.close();
		isr.close();
		reader.close();

		return xmlstr.toString();
	}

	/**
	 * 取正常方式运行，不回显。
	 * 
	 * @param cmd
	 *            命令
	 * @return
	 */
	public static void getRun(String[] cmd) throws IOException {
		Process child = Runtime.getRuntime().exec(cmd);
		logger.info("cmd:" + StringUtil.joinString(cmd, " "));

		InputStream is = child.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);

		while (reader.readLine() != null) {
		}

		is.close();
		isr.close();
		reader.close();
	}
}
