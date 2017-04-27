package Connect_Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateTable {

	public CreateTable(){
		Sqlconntion sqlconntion =new Sqlconntion();
		Connection conn=null;
		conn=sqlconntion.getConnection();
		try {
			String sql="select * from information_schema.TABLES where table_schema ='crop' and table_name = 'crop';";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false){
				System.out.println("没有此表");
				createTable(conn);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void createTable(Connection conn){
		String sql ="create table crop(id Integer  auto_increment primary key,Time_create datetime,Temperature float NOT NULL,Reserve  float,Voltage Integer,Soil_temperature Integer,CO2 Integer NOT NULL,AINCH3 Integer,AINCH4 Integer,AINCH5 Integer,AINCH6 Integer,AINCH7 Integer,AINCH8 Integer,KIN Integer NOT NULL,Illumination  Integer NOT NULL,Temperature_S  float NOT NULL,Humidity  float)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
		    int rs=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
