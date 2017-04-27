package com.renhenet.fw.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -5968914282054398271L;

	@SuppressWarnings("unused")
	private Log log = LogFactory.getLog(getClass());

	private Throwable rootCause;

	public BaseRuntimeException() {
		super();
	}

	public BaseRuntimeException(final String arg0) {
		this(arg0, null);
		rootCause = this;
	}

	public BaseRuntimeException(final Throwable arg0) {
		this("", arg0);
	}

	public BaseRuntimeException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);
		if (arg1 instanceof BaseRuntimeException) {
			rootCause = ((BaseRuntimeException) arg1).rootCause;
		} else {
			rootCause = arg1;
		}
	}
	
	public String getErrorString(){
		StringWriter out = new StringWriter();
		printStackTrace(new PrintWriter(out));
		return out.toString();
	}
}