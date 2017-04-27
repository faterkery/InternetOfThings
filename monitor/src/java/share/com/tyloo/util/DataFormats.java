package com.tyloo.util;

import java.math.BigDecimal;

public class DataFormats {

	public static double setDoubleValue(double d,int limit){
		BigDecimal temp = new BigDecimal(d);
		temp = temp.setScale(limit, BigDecimal.ROUND_HALF_UP);
		return temp.doubleValue();
	}
	
	public static double setDoubleValue(double d){
		BigDecimal temp = new BigDecimal(d);
		temp = temp.setScale(2, BigDecimal.ROUND_HALF_UP);
		return temp.doubleValue();
	}
}
