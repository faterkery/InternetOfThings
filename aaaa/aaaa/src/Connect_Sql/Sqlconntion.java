package Connect_Sql;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlconntion {

	public static Connection getConnection()
	{
		Connection conn=null;
		String className="com.mysql.jdbc.Driver";
		String driverUrl="jdbc:mysql://127.0.0.1:3306/crop?useUnicode=true&characterEncoding=utf8";
		String username="root";
		String pwd="root";
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(driverUrl,username,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
