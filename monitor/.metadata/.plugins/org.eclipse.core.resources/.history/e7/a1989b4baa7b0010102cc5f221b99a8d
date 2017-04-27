package com.renhenet.util;

public class IpUtil {
	public static int enaddr(String ip){
		String[] iparr=ip.split("\\.");
		int tmp=NumberUtil.toInt(iparr[0])*256*256*256+NumberUtil.toInt(iparr[1])*256*256+NumberUtil.toInt(iparr[2])*256+NumberUtil.toInt(iparr[3])-1;
		return tmp;
	}
	
	public static String deaddr(int ip){
		ip++;
		String tmp1=String.valueOf(Math.floor(ip/256/256/256));
		int tmp21=NumberUtil.toInt(tmp1)*256*256*256;
		String tmp2=String.valueOf(Math.floor((ip-tmp21)/256/256));
		int tmp31=NumberUtil.toInt(tmp2)*256*256+tmp21;
		String tmp3=String.valueOf(Math.floor((ip-tmp31)/256));
		String tmp4=String.valueOf((ip-NumberUtil.toInt(tmp3)*256-tmp31));
		String tmp=String.format("%s.%s.%s.%s",tmp1,tmp2,tmp3,tmp4);
		return tmp;
	}
}
