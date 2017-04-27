package Connect_Sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MainScene.GetTime;
import chuanKouTong.Basis;

public class TakeToSql {

	public void TakeData(Basis basis){
		Sqlconntion sqlconntion =new Sqlconntion();
		Connection conn=null;
		conn=sqlconntion.getConnection();
		try {
			String sql="";
		    sql="Insert INTO crop (Time_create,Temperature,Reserve,Voltage,Soil_temperature,CO2,AINCH3,AINCH4,AINCH5,AINCH6,AINCH7,AINCH8,KIN,Illumination,Temperature_S,Humidity)"
		         +"value('"+new StringToDate().string2Date()+"',"+basis.temperate_2+","+basis.yuliu_2+","+basis.vDian+","+basis.tuRangShiDU_1+","+basis.carbon_dioxide_1+","+basis.AINCH3_1+","+basis.AINCH4_1+","
		    		+basis.AINCH5_1+","+basis.AINCH6_1+","+basis.AINCH7_1+","+basis.AINCH8_1+","+basis.KIN+","+basis.zhaoDu+","+basis.shiTempPeure+","+basis.shiShiDu+")";
		    PreparedStatement ps=conn.prepareStatement(sql);
			try {
				ps = conn.prepareStatement(sql);
			    int rs1=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
