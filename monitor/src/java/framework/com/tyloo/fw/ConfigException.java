package com.tyloo.fw;

import com.tyloo.fw.exception.BaseRuntimeException;

public class ConfigException extends BaseRuntimeException {
	private static final long serialVersionUID = 7156067119307056550L;

	public ConfigException() {
		super();
	}

	public ConfigException(String arg0) {
		super(arg0);
	}

	public ConfigException(Throwable arg0) {
		super(arg0);
	}

	public ConfigException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
