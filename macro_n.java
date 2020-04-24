/*
Design suitable data structures and implement pass-I of a two-pass macro-processor using
OOP features in Java
*/

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class macro_n
{
	public static void main(String args[])throws IOException
	{
		int MDTC=1;
		int MNTC=1;
		int index=1;
		int macroindex=0;
		String arg[]=new String[10];
		String mname[]=new String[10];
		String MNT[][]=new String[10][10];
		String MDT[][]=new String[10][10];
		String output =new Scanner(new File("macro.txt")).useDelimiter("\\Z").next();
		System.out.println(output);
		String result[]=output.split("\n");
		//for(int i=0;i<result.length;i++)
		//System.out.println(result[i]);

		String result1[]=output.split("[,\\s\\?]");

		//for(int i=0;i<result1.length;i++)
		//System.out.println(result1[i]);
		for(int k=0;k<result1.length;k++)
		{
			if(result1[k].equals("MACRO")||result1[k].equals("macro"))
			{
				//mname[macroindex]=result1[k+2];
				mname[macroindex]=result1[k+1];
				macroindex++;
			}
		}
		System.out.println("\nMACRO NAME TABLE\n—————————————–");
		System.out.println("VALUE OF MDTC\tMNTC\tNAME");
		for(int k=0;k<macroindex;k++)
		{
			System.out.println("\t"+MDTC+"\t"+MNTC+"\t"+mname[k]);
			MNTC=MNTC+1;
		}
		System.out.println("\n\n MACRO DEF TABLE\n—————————————–");
		System.out.println("INDEX\tCARD");
		for(int i=1;i<result.length;i++)
		{
			if(result[i].equals("START")||result[i].equals("start"))
			break;
			else
			{
				System.out.println(MDTC+"\t"+result[i]);
				MDTC=MDTC+1;
			} 
			
				
		}
		System.out.print("\n\nARGUMENT LIST ARRAY\n——————————–");
		for(int k=3;k<result1.length;k++)
		{
			if(result1[k].equals(mname[0]))
			{
				arg[0]=result1[k+1];
				arg[1]=result1[k+2];
				arg[2]=result1[k+3];
			}
		}
		System.out.println("\nINDEX\t ARGUMENTS");
		System.out.println("\n"+ index+ "\t" +arg[0]+"\n"+(index+1)+"\t"+arg[1]+"\n"+(index+2)+"\t"+arg[2]+"\n");
		
	}
}


/*
OUTPUT:-

unix@unix-HP-280-G1-MT:~/Desktop/teb_6$ javac macro.java
unix@unix-HP-280-G1-MT:~/Desktop/teb_6$ java macro

MACRO NAME TABLE
—————————————–
VALUE OF MDTC	MNTC	NAME
	1	1	incr
	1	2	decr


 MACRO DEF TABLE
—————————————–
INDEX	CARD
1	incr &arg1 , &arg2 , &arg3
2	move &arg2 , &arg1 
3	add &arg3 , &arg2
4	mend
5	macro
6	decr &r1 , &r2
7	add &r1 , &r2
8	mend


ARGUMENT LIST ARRAY
——————————–
INDEX	 ARGUMENTS

1	data1
2	data2
3	data3

*/
