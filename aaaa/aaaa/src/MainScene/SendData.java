package MainScene;

import java.io.OutputStream;

import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;


public class SendData {

     public void sendData(){
    	 CommPortIdentifier portId = null ;
    	 SerialPort serialPort = null;
         try{  
         portId =  CommPortIdentifier.getPortIdentifier("COM5");  
         // 直接取得 COM3 端口
         System.out.println(portId.getName()+":开启");
         serialPort = (SerialPort) portId.open("myReader", 1000);
         OutputStream outputStream = serialPort.getOutputStream();
		 outputStream.write(new byte[]{(byte)0x01,(byte)0x04,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x10,(byte)0xF1,(byte)0xC6});
         outputStream.flush();
          //关闭输出流
         outputStream.close();
         serialPort.close();
         System.out.println("发送成功");
         }
         catch(Exception e){
         }
     }
}
