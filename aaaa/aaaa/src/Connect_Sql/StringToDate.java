package Connect_Sql;

import java.text.*;
import java.util.Locale;

import MainScene.GetTime;

public class StringToDate {
	  public String string2Date(){
	  java.util.Date dt = new java.util.Date();

	  java.text.SimpleDateFormat sdf = 
	       new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	  String currentTime = sdf.format(dt);
	  return currentTime;
	  
	  }
	}