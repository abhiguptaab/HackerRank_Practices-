import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Solution10 {

    static boolean isAnagram(String a, String b) {
        // Complete the function
    	
    	char string1[] = a.toCharArray();
    	char string2[] = b.toCharArray();
        boolean flag=true;
        if (a.length()!=b.length())
            flag=false;

        else
        {
            
            Arrays.sort(string1);
            Arrays.sort(string2);
            
	        for(int i=0; i<a.length(); i++)
	        {
	        	System.out.print(string1[i]+" ");
	        	System.out.print(string2[i]+" ");
	            if(string1[i]!=string2[i])
	            	flag=false;
	        }
	        
        }
        return flag;
		
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}