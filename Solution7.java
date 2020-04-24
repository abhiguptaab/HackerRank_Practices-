import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution7 {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        int flag=0;
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

       for (int i=0; i<t; i++)
       {
    	   for(int j=0;  j<t; j++)
    	   {
    		   if(pair_left[i]!=pair_left[j] && pair_right[i]!=pair_right[j] && i!=j)
    		   {
    			   flag++;
    			  
    		   }
    			   
    	   }
    	   System.out.println(flag);
       }




//Write your code here

    }
}