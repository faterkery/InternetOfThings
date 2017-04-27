package com.tyloo.fw.sms;

import java.util.Date;
import cn.net.emay.metone.api.MO;

public class SmsMO extends MO {

	private Date sendTime;

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
}