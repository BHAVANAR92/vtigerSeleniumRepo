package generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {
	public String getCommondata(String Key) throws Throwable
	
	{
		FileInputStream fis = new
				  FileInputStream("./src/test/resources/createorganization.properties");
		Properties pro =new Properties();
		pro.load(fis);
		
		String Value =pro.getProperty(Key);
		return Value;
		
	}

}
