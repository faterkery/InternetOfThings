package com.renhenet.fw.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BaseException extends Exception {
	private static final long serialVersionUID = 5978340891371554603L;

	@SuppressWarnings("unused")
	private Log log = LogFactory.getLog(getClass());

	private Throwable rootCause;
	public BaseException() {
		super();
	}

	public BaseException(String s) {
		this(s, null);
		rootCause = this;
	}
	public BaseException(String s, Throwable e) {
		super(s);

		if (e instanceof BaseException) {

			rootCause = ((BaseException) e).rootCause;
		} else {

			rootCause = e;
		}
	}

	public BaseException(Throwable e) {
		this("", e);
	}

	public Throwable getRootCause() {

		return rootCause;
	}
	
	public String getErrorString(){
		StringWriter out = new StringWriter();
		printStackTrace(new PrintWriter(out));
		return out.toString();
	}
}