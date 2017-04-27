package com.renhenet.util;

import java.io.StringWriter;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;

public class VMParser {
	// private static VMUtils v = (VMUtils)
	// ServiceLocator.getService("vMUtils");

	private static VelocityEngine engine;

	// 配置文件的文件名，配置文件位于$BASE/conf下
	private static final String DEFAULT_CONF_FILE = "/velocity.properties";

	static {
		engine = new VelocityEngine();
		try {
			String absolutePath = VMParser.class.getResource(DEFAULT_CONF_FILE)
					.getFile();
			engine.init(absolutePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String substitute(String templateName, Context context) {
		// context.put("vMUtils", v);
		context.put("now", new Date());
		context.put("time", DateUtil.dateFormate(new Date(),
				"yyyy年MM月dd日HH时mm分"));
		if (StringUtils.isEmpty(templateName)) {
			return null;
		}
		try {
			Template tmplate = engine.getTemplate(templateName);
			if (tmplate != null) {
				StringWriter writer = new StringWriter();
				try {
					tmplate.merge(context, writer);
					String restring = writer.toString();
					writer.flush();
					writer.close();
					return restring;
				} catch (Exception _ex) {
					_ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			System.err.println("Template File: " + templateName);
			ex.printStackTrace();
		}
		return null;
	}
}
