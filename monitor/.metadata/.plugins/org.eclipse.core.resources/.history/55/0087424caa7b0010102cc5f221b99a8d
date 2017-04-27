package com.renhenet.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	@SuppressWarnings("unchecked")
	public static ArrayList<String[]> getListMatcher(String str, String regex) {
		ArrayList<String[]> list = new ArrayList();
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			int i = matcher.groupCount();
			String[] s = new String[i];
			for (int j = 1; j < (i + 1); j++)
				s[j - 1] = matcher.group(j);
			list.add(s);
		}
		return list;
	}

	public static String replaceMatcher(String str, String regex, String tostr) {
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		StringBuffer buf = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(buf, tostr);
		}
		matcher.appendTail(buf);
		return buf.toString();
	}

	public static String getHiddenInputRegex() {
		return "<input[^>]+type=\"hidden\"[^>]+name=\"([^\"]+)\"[^>]+value=\"([^\"]*)\"[^>]*>";
	}
}
