package chuanKouTong;

public class InputMessage {
     public void show(Basis a){
	 System.out.println("土壤温度 /10     "+a.temperate_1+"欧姆        "+a.temperate_2+"度");
	    System.out.println("预留 /10     "+a.yuliu_1+"欧姆        "+a.yuliu_2+"度");
	    System.out.println("电源电压/100    "+a.vDian+"V");
	    System.out.println("土壤温度      "+a.tuRangShiDU_1+"    "+a.tuRangShiDU_2+"mA   "+a.tuRangShiDU_3+"V");
	    System.out.println("二氧化碳      "+a.carbon_dioxide_1+"    "+a.carbon_dioxide_2+"mA   "+a.carbon_dioxide_3+"V");
	    System.out.println("AINCH3      "+a.AINCH3_1+"    "+a.AINCH3_2+"mA   "+a.AINCH3_3+"V");
	    System.out.println("AINCH4      "+a.AINCH4_1+"    "+a.AINCH4_2+"mA   "+a.AINCH4_3+"V");
	    System.out.println("AINCH5      "+a.AINCH5_1+"    "+a.AINCH5_2+"mA   "+a.AINCH5_3+"V");
	    System.out.println("AINCH6      "+a.AINCH6_1+"    "+a.AINCH6_2+"mA   "+a.AINCH6_3+"V");
	    System.out.println("AINCH7      "+a.AINCH7_1+"    "+a.AINCH7_2+"mA   "+a.AINCH7_3+"V");
	    System.out.println("AINCH8      "+a.AINCH8_1+"    "+a.AINCH8_2+"mA   "+a.AINCH8_3+"V");
	    System.out.println("KIN    "+a.KIN);
	    System.out.println("照度/10    "+a.zhaoDu);
	    System.out.println("温度/10    "+a.shiTempPeure);
	    System.out.println("温度/10    "+a.shiShiDu);
	    System.out.println("自动通讯计数值    "+a.ziDongTongXuCount);
}
}
