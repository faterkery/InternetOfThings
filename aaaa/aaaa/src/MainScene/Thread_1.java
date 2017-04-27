package MainScene;

import javax.comm.CommDriver;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;

public class Thread_1 implements Runnable{

	static int Time_count=0;
	static	CommPortIdentifier portId = null ;
	static	SerialPort serialPort = null;
	Read_data a;
	public Thread_1(){
		 CommDriver driver = null;
	     String driverName = "com.sun.comm.Win32Driver";
	     try {
				driver = (CommDriver) Class.forName(driverName).newInstance();
	            driver.initialize();
	           
	            portId =  CommPortIdentifier.getPortIdentifier("COM5");  
	            // 直接取得 COM3 端口
	            System.out.println(portId.getName()+":开启");
	     }
	     catch (Exception e) { 
	              //如果端口被占用就抛出这个异常
	              e.printStackTrace(); 
	    }
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Read_data a = null;
		try {
			a = new Read_data();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Time_count++;
			if(Time_count==5){
				a.display();
				new SendData().sendData();
				Time_count=0;
				try {
					a=new Read_data();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
