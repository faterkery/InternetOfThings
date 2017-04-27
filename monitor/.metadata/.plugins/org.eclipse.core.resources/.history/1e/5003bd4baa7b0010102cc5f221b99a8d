package com.renhenet.util.editor;

import java.util.*;

@SuppressWarnings("unchecked")
public class FCKeditorConfigurations extends HashMap {
	private static final long serialVersionUID = -2702079982359038561L;

	public FCKeditorConfigurations() {
		super();
	}

	public String getUrlParams() {
		StringBuffer osParams = new StringBuffer();

		for (Iterator i = this.entrySet().iterator(); i.hasNext();) {
			Map.Entry entry = (Map.Entry) i.next();
			if (entry.getValue() != null)
				osParams.append("&" + encodeConfig(entry.getKey().toString())
						+ "=" + encodeConfig(entry.getValue().toString()));
		}
		return osParams.toString();
	}

	private String encodeConfig(String txt) {
		txt = txt.replaceAll("&", "%26");
		txt = txt.replaceAll("=", "%3D");
		txt = txt.replaceAll("\"", "%22");
		return txt;
	}

}
