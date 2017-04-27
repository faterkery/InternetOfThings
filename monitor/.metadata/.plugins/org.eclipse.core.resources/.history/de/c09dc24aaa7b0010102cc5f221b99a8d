package com.renhenet.fw.webservice;

import java.util.Date;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class LogHandler extends BasicHandler {
	private static Log logger = LogFactory.getLog(LogHandler.class);

	public void invoke(MessageContext msgContext) throws AxisFault {
		// 每当web服务被调用，都记录到log中。
		try {
			Date date = new Date();
			logger.info(date + " : WebService " + msgContext.getTargetService()
					+ " is invoked " + " userName:" + msgContext.getUsername()
					+ " password:" + msgContext.getPassword() + " remoteaddr:"
					+ msgContext.getStrProp("remoteaddr") + " method:"
					+ msgContext.getOperation().getMethod().getName());

		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}
}