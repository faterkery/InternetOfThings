package com.tyloo.fw.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseVo implements Serializable {
	private static final long serialVersionUID = -1723269088876196712L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE).toString();
	}

}
