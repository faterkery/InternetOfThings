package chuanKouTong;


public class Ecute_data {

	public Basis get_Data(byte[] a){
	   Basis b = new Basis();Double[] temp=new Double[20];String[] kl=new String[50]; 
	   for(int i=0;i<a.length;i++){
		   if(i>=3){
			   a[i-3]=a[i];
		   }
	   }
	  String st= bytesToHexString(a);System.out.println(st);
	  String[] hg =st.split(" ");
	  for(int i=0;i<hg.length;i++){
//		  System.out.println(hg[i]);
//		  System.out.println(Integer.valueOf(hg[i],16).toString());
		  kl[i]=Integer.valueOf(hg[i],16).toString();
	  }
	  for(int i=0;i<16;i++){
		  temp[i]=Double.parseDouble(kl[i]);
	  }
		  b.temperate_1=temp[0]/10;b.temperate_2=temp[0]/10;
		  b.yuliu_1=temp[1]/10; b.yuliu_2=temp[1]/10;
		  b.vDian=temp[2]/100;
		  b.tuRangShiDU_1=temp[3];b.tuRangShiDU_2=temp[3];b.tuRangShiDU_3=temp[3];
		  b.carbon_dioxide_1=temp[4];b.carbon_dioxide_2=temp[4];b.carbon_dioxide_3=temp[4]/65535*5;
		  b.AINCH3_1=temp[5];b.AINCH3_2=temp[5];b.AINCH3_3=temp[5];
		  b.AINCH4_1=temp[6];b.AINCH4_2=temp[6];b.AINCH4_3=temp[6];
		  b.AINCH5_1=temp[7];b.AINCH5_2=temp[7];b.AINCH5_3=temp[7];
		  b.AINCH6_1=temp[8];b.AINCH6_2=temp[8];b.AINCH6_3=temp[8];
		  b.AINCH7_1=temp[9];b.AINCH7_2=temp[9];b.AINCH7_3=temp[9];
		  b.AINCH8_1=temp[10];b.AINCH8_2=temp[10];b.AINCH8_3=temp[10];
		  b.KIN=temp[11];
		  b.zhaoDu=temp[12];
		  b.shiTempPeure=temp[13]/10;
		  b.shiShiDu=temp[14]/10;
		  b.ziDongTongXuCount=temp[15];
	   return b;
	}
	
	/** 
     * byte数组转换成16进制字符串 
     * @param src 
     * @return 
     */  
    public static String bytesToHexString(byte[] src){    
    	   boolean fg=false;
           StringBuilder stringBuilder = new StringBuilder();       
           if (src == null || src.length <= 0) {       
               return null;       
           }       
           for (int i = 0; i < src.length-1; i++) {       
               int v = src[i] & 0xFF;       
               String hv = Integer.toHexString(v);       
               if (hv.length() < 2) {       
                   stringBuilder.append(0);       
               }   
               stringBuilder.append(hv);
               if(fg){
            	   stringBuilder.append(" ");fg=false;
                  }else{
            	   fg=true;
               }
           }       
           return stringBuilder.toString();       
       }
//	public static void main(String[] Args){
//		byte[] array ={(byte) 0x01,(byte) 0x04,(byte) 0x20,(byte) 0x4E,(byte) 0x20,
//				       (byte) 0x00,(byte) 0x00,(byte) 0x1E,(byte) 0xFF,(byte) 0xFF,
//				       (byte) 0xE3,(byte) 0xFF,(byte) 0xE7,(byte) 0xFF,(byte) 0xE8,
//				       (byte) 0xFF,(byte) 0xE8,(byte) 0xFF,(byte) 0xE5,(byte) 0xFF,
//				       (byte) 0xE7,(byte) 0xFF,(byte) 0xE8,(byte) 0xFF,(byte) 0xEA,
//				       (byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,
//				       (byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0xA2,
//				       (byte) 0x34,(byte) 0x10
//				       };
//		Basis a =new Basis();
//		a=get_Data(array);
//
//	    System.out.println("土壤温度 /10     "+a.temperate_1+"欧姆        "+a.temperate_2+"度");
//	    System.out.println("预留 /10     "+a.yuliu_1+"欧姆        "+a.yuliu_2+"度");
//	    System.out.println("电源电压/100    "+a.vDian+"V");
//	    System.out.println("土壤温度      "+a.tuRangShiDU_1+"    "+a.tuRangShiDU_2+"mA   "+a.tuRangShiDU_3+"V");
//	    System.out.println("二氧化碳      "+a.carbon_dioxide_1+"    "+a.carbon_dioxide_2+"mA   "+a.carbon_dioxide_3+"V");
//	    System.out.println("AINCH3      "+a.AINCH3_1+"    "+a.AINCH3_2+"mA   "+a.AINCH3_3+"V");
//	    System.out.println("AINCH4      "+a.AINCH4_1+"    "+a.AINCH4_2+"mA   "+a.AINCH4_3+"V");
//	    System.out.println("AINCH5      "+a.AINCH5_1+"    "+a.AINCH5_2+"mA   "+a.AINCH5_3+"V");
//	    System.out.println("AINCH6      "+a.AINCH6_1+"    "+a.AINCH6_2+"mA   "+a.AINCH6_3+"V");
//	    System.out.println("AINCH7      "+a.AINCH7_1+"    "+a.AINCH7_2+"mA   "+a.AINCH7_3+"V");
//	    System.out.println("AINCH8      "+a.AINCH8_1+"    "+a.AINCH8_2+"mA   "+a.AINCH8_3+"V");
//	    System.out.println("KIN    "+a.KIN);
//	    System.out.println("照度/10    "+a.zhaoDu);
//	    System.out.println("温度/10    "+a.shiTempPeure);
//	    System.out.println("温度/10    "+a.shiShiDu);
//	    System.out.println("自动通讯计数值    "+a.ziDongTongXuCount);
//	}
}
