package MainScene;

import javax.comm.CommDriver;
import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;

import chuanKouTong.ReadStr;

public class MainClass {

	public static void main(String[] args) {
		Thread_1 thread_1 =new Thread_1();
		new Thread(thread_1).start();
	}
}
