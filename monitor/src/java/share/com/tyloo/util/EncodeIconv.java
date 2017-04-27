package com.tyloo.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;

public class EncodeIconv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			String source = FileUtils.readFileToString(new File(args[0]),
					"latin1");
			// System.err.println("ssssssssssssss " + source);
			source = new String(source.getBytes("latin1"), "GBK");
			// System.err.println("ssssssssssssss111 " + source);
			FileUtils
					.writeStringToFile(new File(args[0] + ".1"), source, "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
