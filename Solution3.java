import java.io.*;
import java.util.*;
import java.text.*;
import java.util.regex.*;

public class Solution3 {
	
    static Scanner scan = new Scanner(System.in);
	public static int B=scan.nextInt();
	public static int H=scan.nextInt();
	public static boolean flag=false;
	
	static {
		try
		{
			if(B<= 0 || H<= 0)
			{
				flag = false;
				throw new Exception("Breadth and height must be positive");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
	public static void main(String args[])
	{
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
			
	}

}
