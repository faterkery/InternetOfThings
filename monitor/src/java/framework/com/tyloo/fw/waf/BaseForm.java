package com.tyloo.fw.waf;

import java.util.Date;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class BaseForm extends ActionForm {

	static {
		ConvertUtils.register(new DateConverter(), Date.class);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE).toString();
	}
}
