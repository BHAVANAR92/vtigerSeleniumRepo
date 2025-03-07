package generic_Utility;

import java.util.Random;

public class Java_Utility {
	public int getRandomValue()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);//this method is to avoid duplicates
		return ranNum;
	}

}
