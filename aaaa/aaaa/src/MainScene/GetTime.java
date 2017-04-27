package MainScene;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {
	public  String getTime() { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String d=df.format(new Date());// new Date()为获取当前系统时间
//		Date d =new Date();
		return d;
	}
}