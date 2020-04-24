import java.io.*;
import java.util.*;
import java.lang.*; 

public class Solution9 {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String[] Set1=new String[50];
        String[] Set2=new String[50];
        boolean flag = true;
        for(int i=0; i<A.length(); i++)
        {
        	Set1[i]=A.substring(i, i+1);
        }
        for(int i=A.length()-1, j=0; i>=0; j++,i--)
        {
        	Set2[j]=A.substring(i, i+1);
        }
   /*     for(int i=0;i<A.length();i++)
        System.out.print(Set1[i]+" ");
        for(int j=0;j<A.length();j++)
            System.out.print(Set2[j]+" ");
        */
        for(int i=0; i<A.length();i++)
        {
        	if((Set1[i]).compareTo(Set2[i])!=0)
        	{
        		flag=false;
        	}
        }
        if(flag==true)
        {
        	System.out.println("Yes");
        }
        if(flag==false)
        {
        	System.out.println("No");
        }
    }
}



