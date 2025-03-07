package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoJdbc {

	public static void main(String[] args) throws Throwable {
		Driver drvref = new Driver();
		DriverManager.registerDriver(drvref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employedata", "root", "welcome1");
		Statement state =conn.createStatement();
		String query = "insert into employee1(regno,firstname,lastname,address)values('3', 'girija', 'g', 'uttarahalli')";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("user is created");
			
		}
		else
		{
			System.out.println("user not created");
		}
	}
	

}
