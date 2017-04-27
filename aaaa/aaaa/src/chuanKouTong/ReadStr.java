package chuanKouTong;

import java.io.IOException; 
import java.io.InputStream; 
import java.io.OutputStream;
import java.util.TooManyListenersException; 

import javax.comm.CommDriver;
import javax.comm.CommPortIdentifier; 
import javax.comm.PortInUseException; 
import javax.comm.SerialPort;  
import javax.comm.SerialPortEvent;  
import javax.comm.SerialPortEventListener;  
import javax.comm.UnsupportedCommOperationException; 

import Connect_Sql.CreateTable;
import Connect_Sql.TakeToSql;


public class ReadStr {  
 static byte[] abc=new byte[50];
 static String str = "000000"; 
 Basis basis =new Basis();
 public void init()  
 {  
	 CommPortIdentifier portId = null ;
	 SerialPort serialPort = null;
  try{  
    portId =  CommPortIdentifier.getPortIdentifier("COM5");  
   // 直接取得 COM3 端口
         System.out.println(portId.getName()+":开启"); 
//             serialPort = (SerialPort) portId.open("MyReader", 4000); 
             //portId.open("串口所有者名称", 超时等待时间); 
             Read_data r =new Read_data(portId);
             new Thread(r).start();
         } catch (Exception e) { 
          //如果端口被占用就抛出这个异常
          e.printStackTrace(); 
        }
  
 }  
class Read_data implements Runnable, SerialPortEventListener { 
     InputStream inputStream; 
     SerialPort serialPort; 
     Thread readThread; 
     public Read_data(CommPortIdentifier portId) throws InterruptedException {  
         try {  
             serialPort = (SerialPort) portId.open("Reader", 2000); 
             //portId.open("串口所有者名称", 超时等待时间); 
         } catch (PortInUseException e) { 
          //如果端口被占用就抛出这个异常
          e.printStackTrace(); 
         } 
         try {
			OutputStream outputStream = serialPort.getOutputStream();
			 outputStream.write(new byte[]{(byte)0x01,(byte)0x04,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x10,(byte)0xF1,(byte)0xC6});
	            outputStream.flush();
	            //关闭输出流
	            outputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
         try {  
             inputStream = serialPort.getInputStream(); 
             //从COM5获取数据
         } catch (IOException e) {} 
  try {  
             serialPort.addEventListener(this); 
             //添加监听器
  } catch (TooManyListenersException e) {} 
         serialPort.notifyOnDataAvailable(true); 
         /* 侦听到串口有数据,触发串口事件*/ 
         try {  
             serialPort.setSerialPortParams(9600,//波特率
                 SerialPort.DATABITS_8,//数据位数
                 SerialPort.STOPBITS_1,//停止位
                 SerialPort.PARITY_NONE);//校验
         } catch (UnsupportedCommOperationException e) {} 
         readThread = new Thread(this); 
         readThread.start(); 
         //启动线程
     }  
     public  void run() { 
         try {  
             Thread.sleep(30000); 
          serialPort.close();  
          System.out.println("COM5:关闭"); 
          //设定30秒后端口关闭，程序随之结束
         } catch (InterruptedException e) {} 
     } 
     public void serialEvent(SerialPortEvent event) { 
         switch(event.getEventType()) { 
         case SerialPortEvent.BI: 
         case SerialPortEvent.OE: 
         case SerialPortEvent.FE: 
         case SerialPortEvent.PE: 
         case SerialPortEvent.CD: 
         case SerialPortEvent.CTS:  
         case SerialPortEvent.DSR: 
         case SerialPortEvent.RI:  
         case SerialPortEvent.OUTPUT_BUFFER_EMPTY:break;  
         case SerialPortEvent.DATA_AVAILABLE: 
             byte[] readBuffer = new byte[200];  
             try {  
                 while (inputStream.available() > 0) {  
                     int numBytes = inputStream.read(readBuffer); 
                     System.out.println("numBytes"+numBytes);
                     for (int i = 0; i < numBytes; i++) { 
                    	 abc[i]=readBuffer[i];
                         String hex = Integer.toHexString(readBuffer[i] & 0xFF); 
                         if (hex.length() == 1) { 
                           hex = '0' + hex; 
                         } 
                         hex=hex+' ';
                         System.out.print(hex.toUpperCase() ); 
                       } 
                     System.out.println();
                 }  
                 str = new String(readBuffer).trim();  
//                 System.out.println(readBuffer); 
                 //输出读入的字符
             } catch (IOException e) {} 
             Ecute_data e_d =new Ecute_data();
             basis=e_d.get_Data(abc);
             new InputMessage().show(basis);
             CreateTable a=new CreateTable();
             new TakeToSql().TakeData(basis);
             break; 
         } 
     } 
 }  
 public static void main(String[] args) 
 {  
	 CommDriver driver = null;
     String driverName = "com.sun.comm.Win32Driver";
     try {
         driver = (CommDriver) Class.forName(driverName).newInstance();
         driver.initialize();
     } catch (InstantiationException | IllegalAccessException
             | ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     
  ReadStr reader = new ReadStr(); 
  reader.init(); 
 } 
} 