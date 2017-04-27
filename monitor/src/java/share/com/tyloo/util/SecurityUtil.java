package com.tyloo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.bouncycastle.util.encoders.Hex;

import sun.misc.BASE64Decoder;

/**
 * 
 * Title:加密，解密类，不能直接加密中文，中文要urlencode一下再加密
 * 
 * Description:
 * 
 * Copyright: Copyright (c) 2005
 * 
 * @author luoxn
 * @created 2005-6-7 11:04:33
 * @version $Id: SecurityUtil.java,v 1.1.1.1 2008/01/22 05:25:24 luoxn Exp $
 */
public class SecurityUtil {

	private static final String key = "AEBFADEBA9ABCDEF";

	private static final String iv = "12345679";

	private static final SecretKeySpec keyspec = new SecretKeySpec(key
			.getBytes(), "Blowfish");

	private static final IvParameterSpec ivspec = new IvParameterSpec(iv
			.getBytes());

	// private static Cipher cipher;

	// static {
	// try {
	// cipher = Cipher.getInstance("Blowfish/CBC/NoPadding");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public static String encrypt(int istr) {
		return encrypt(istr + "");
	}

	public static String encrypt(String str) {
		if (str != null) {
			String blank = "            ";
			
			
			try {
				str = blank + str + blank+ blank.substring(0, (8 - str.getBytes("UTF-8").length % 8) % 8);
				//System.out.println("==============加密长度==============" + str.getBytes("UTF-8").length);
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			byte[] encrypted;
			String re = null;
			try {
				Cipher cipher = Cipher.getInstance("Blowfish/CBC/NoPadding");
				cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
				encrypted = cipher.doFinal(str.getBytes("UTF-8"));
				re = bytesToHex(encrypted);
			} catch (Exception e) {
				System.err.println("Encrypted error: " + str);
				e.printStackTrace();

			}

			return re;
		} else {
			return str;
		}

	}

	/**
	 * 解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decrypt(String str) {
		try {
			Cipher cipher = Cipher.getInstance("Blowfish/CBC/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
			byte[] decrypted = cipher.doFinal(Hex.decode(str));
			String d = new String(decrypted);
			return StringUtils.trim(d);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String bytesToHex(byte[] data) {
		if (data == null) {
			return null;
		} else {
			int len = data.length;
			String str = "";
			for (int i = 0; i < len; i++) {
				if ((data[i] & 0xFF) < 16)
					str = str + "0"
							+ java.lang.Integer.toHexString(data[i] & 0xFF);
				else
					str = str + java.lang.Integer.toHexString(data[i] & 0xFF);

			}
			return str;
		}

	}

	// 老的php里的解密方式，导数据用
	private static final String ENC_KEY = "78llad7f1njdy7f23nadifu23djfdu";

	private static String prepareKey(String str) {
		String key = ENC_KEY;
		while (key.length() < str.length()) {
			key += ENC_KEY;
		}
		return key;
	}

	public static String oldDecrypt(String src) {
		try {
			String str = new String(new BASE64Decoder().decodeBuffer(URLDecoder
					.decode(src, "GBK")));
			String key = prepareKey(str);
			String f = "c";

			char[] c = new char[str.length()];
			char[] c1 = new char[str.length() - 1];
			c[0] = f.toCharArray()[0];
			for (int i = 1; i < str.length(); i++) {
				int ci = str.toCharArray()[i - 1] ^ str.toCharArray()[i]
						^ key.toCharArray()[i - 1];
				c1[i - 1] = (char) ci;
			}
			f = new String(c1);

			return f;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
