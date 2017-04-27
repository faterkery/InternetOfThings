package com.renhenet.util;

/**
 * 
 * 
 * Title:
 * 
 * Description:
 * 
 * Copyright: Copyright renhenet.com (c) 2007
 * 
 * @author haoxz11
 * @created Aug 8, 2007 4:42:44 PM
 * @version $Id: SpellUtil.java,v 1.1.1.1 2008/01/22 05:25:24 luoxn Exp $
 */
public class SpellUtil {
	private static String _FromEncode_ = "GBK";
	private static String _ToEncode_ = "GBK";

	public static int compare(String str1, String str2) {
		int result = 0;
		String m_s1 = null;
		String m_s2 = null;
		try {
			m_s1 = new String(str1.getBytes(_FromEncode_), _ToEncode_);
			m_s2 = new String(str2.getBytes(_FromEncode_), _ToEncode_);
		} catch (Exception e) {
			return str1.compareTo(str2);
		}
		result = chineseCompareTo(m_s1, m_s2);
		return result;
	}

	public static int getCharCode(String s) {
		if (s == null && "".equals(s))
			return -1;
		byte b[] = s.getBytes();
		int value = 0;
		for (int i = 0; i < b.length && i <= 2; i++)
			value = value * 100 + b[i];

		return value;
	}

	public static int chineseCompareTo(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		int n = Math.min(len1, len2);
		for (int i = 0; i < n; i++) {
			int s1_code = getCharCode(s1.charAt(i) + "");
			int s2_code = getCharCode(s2.charAt(i) + "");
			if (s1_code * s2_code < 0)
				return Math.min(s1_code, s2_code);
			if (s1_code != s2_code)
				return s1_code - s2_code;
		}

		return len1 - len2;
	}

	public static String getBeginCharacter(String res) {
		String a = res;
		String result = "";
		for (int i = 0; i < a.length(); i++) {
			String current = a.substring(i, i + 1);
			int j=getASCII(current);
			if(j>=0xB0A1 && j<=0xB0C4)
				result = result + "a";
			else if((j>=0xB0C5 && j<=0xB0FE) ||
					(j>=0xB1A1 && j<=0xB1FE) ||
					(j>=0xB2A1 && j<=0xB2C0))
				result = result + "b";
			else if((j>=0xB2C1 && j<=0xB2FE) ||
					(j>=0xB3A1 && j<=0xB3FE) ||
					(j>=0xB4A1 && j<=0xB4ED))
				result = result + "c";
			else if((j>=0xB4EE && j<=0xB4FE) ||
					(j>=0xB5A1 && j<=0xB5FE) ||
					(j>=0xB6A1 && j<=0xB6E9))
				result = result + "d";
			else if((j>=0xB6EA && j<=0xB6FE) ||
					j==0xB7A1)
				result = result + "e";
			else if((j>=0xB7A2 && j<=0xB7FE) ||
					(j>=0xB8A1 && j<=0xB8C0))
				result = result + "f";
			else if((j>=0xB8C1 && j<=0xB8FE) ||
					(j>=0xB9A1 && j<=0xB9FD))
				result = result + "g";
			else if((j>=0xBAA1 && j<=0xBAFE) ||
					(j>=0xBBA1 && j<=0xBBF6) ||
					j==0xB9FE)
				result = result + "h";
			else if((j>=0xBBF7 && j<=0xBBFE) ||
					(j>=0xBCA1 && j<=0xBCFE) ||
					(j>=0xBDA1 && j<=0xBDFE) ||
					(j>=0xBEA1 && j<=0xBEFE) ||
					(j>=0xBFA1 && j<=0xBFA5))
				result = result + "j";
			else if((j>=0xBFA6 && j<=0xBFFE) ||
					(j>=0xC0A1 && j<=0xC0AB))
				result = result + "k";
			else if((j>=0xC0AC && j<=0xC0FE) ||
					(j>=0xC2A1 && j<=0xC2E7) ||
					(j>=0xC1A1 && j<=0xC1FE))
				result = result + "l";
			else if((j>=0xC2E8 && j<=0xC2FE) ||
					(j>=0xC3A1 && j<=0xC3FE) ||
					(j>=0xC4A1 && j<=0xC4C2))
				result = result + "m";
			else if((j>=0xC4C3 && j<=0xC4FE) ||
					(j>=0xC5A1 && j<=0xC5B5))
				result = result + "n";
			else if((j>=0xC5B6 && j<=0xC5BD))
				result = result + "o";
			else if((j>=0xC5BE && j<=0xC5FE) ||
					(j>=0xC6A1 && j<=0xC6D9))
				result = result + "p";
			else if((j>=0xC6DA && j<=0xC6FE) ||
					(j>=0xC8A1 && j<=0xC8BA) ||
					(j>=0xC7A1 && j<=0xC7FE))
				result = result + "q";
			else if((j>=0xC8BB && j<=0xC8F5))
				result = result + "r";
			else if((j>=0xC8F6 && j<=0xC8FE) ||
					(j>=0xC9A1 && j<=0xC9FE) ||
					(j>=0xCAA1 && j<=0xCAFE) ||
					(j>=0xCBA1 && j<=0xCBF9))
				result = result + "s";
			else if((j>=0xCBFA && j<=0xCBFE) ||
					(j>=0xCCA1 && j<=0xCCFE) ||
					(j>=0xCDA1 && j<=0xCDD9))
				result = result + "t";
			else if((j>=0xCDDA && j<=0xCDFE) ||
					(j>=0xCEA1 && j<=0xCEF3))
				result = result + "w";
			else if((j>=0xCEF4 && j<=0xCEFE) ||
					(j>=0xCFA1 && j<=0xCFFE) ||
					(j>=0xD0A1 && j<=0xD0FE) ||
					(j>=0xD1A1 && j<=0xD1B8))
				result = result + "x";
			else if((j>=0xD1B9 && j<=0xD1FE) ||
					(j>=0xD2A1 && j<=0xD2FE) ||
					(j>=0xD3A1 && j<=0xD3FE) ||
					(j>=0xD4A1 && j<=0xD4D0))
				result = result + "y";
			else if((j>=0xD4D1 && j<=0xD4FE) ||
					(j>=0xD5A1 && j<=0xD5FE) ||
					(j>=0xD6A1 && j<=0xD6FE) ||
					(j>=0xD7A1 && j<=0xD7F9))
				result = result + "z";
		}

		return result;
	}
	
	public static boolean isCn(String str){
		byte[] bytes = String.valueOf(str.charAt(0)).getBytes();
        if(bytes.length==2)return true;
        return false;
	}

	public static String getFirstStr(String str) {
		char a = str.charAt(0);
		char aa[] = { a };
		String sss = new String(aa);
		if (Character.isDigit(aa[0]))
			sss = "data";
		else if (a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z')
			sss = String.valueOf(a);
		else
			sss = getBeginCharacter(sss);
		return sss;
	}
	
	public static void main(String[] args) {
		System.out.println(SpellUtil.getFirstStr("µÔ"));
	}
	
	public static int getASCII(String current){
		byte[] bytes = (String.valueOf(current)).getBytes();
        System.out.println(bytes.length);
        if (bytes == null || bytes.length > 2 || bytes.length <= 0) { // ´íÎó
            return 0;
        }
        if (bytes.length == 1) { // Ó¢ÎÄ×Ö·û
            return 256 + bytes[0];
        }
        if (bytes.length == 2) { // ÖÐÎÄ×Ö·û
        	int hightByte = 256 + bytes[0];
            int lowByte = 256 + bytes[1];
        	if(bytes[0]>0){
        		hightByte-=256;
        	}
        	if(bytes[1]>0){
        		lowByte-=256;
        	}
            String ascii = Integer.toHexString(hightByte)+Integer.toHexString(lowByte);
            int j=Integer.valueOf(ascii,16);
            return j;
        }
        return 0;
	}
}
