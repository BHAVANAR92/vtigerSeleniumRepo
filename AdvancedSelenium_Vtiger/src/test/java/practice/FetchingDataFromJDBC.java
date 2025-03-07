package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchingDataFromJDBC {

	public static void main(String[] args) throws Throwable {
		Driver drvref = new Driver();
		DriverManager.registerDriver(drvref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedata", "root", "welcome1");
		Statement state =conn.createStatement();
		String Query = "select * from employee1";
		ResultSet result = state.executeQuery(Query);
		
		while(result.next())
		{
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" +result.getString(3) + "\t" + result.getString(4));
		}

	}

}
