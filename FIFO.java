import java.io.*;
import java.util.*;

class FIFO
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int List[] = new int[20];
		int Frame[]= new int[20];
		int Pageno;
		int Frameno;
		int pagehit=0;
		int pagefault=0;
		
		
		System.out.print("Enter number of pages :: ");
		Pageno=s.nextInt();
		System.out.print("Enter number of pages :: ");
		Frameno=s.nextInt();
		
		System.out.print("Enter "+ Pageno + " pages");
		for(int i=1; i<= Pageno; i++)
		{
			List[i]=s.nextInt();
		}
		
		for(int i=1; i<= Frameno; i++)
		{
			Frame[i]=-1;
		}
		int num=0;
		for(int i=0; i<Pageno; i++ )
		{
			boolean falg=false;
			for(int j=0; j<Frameno; j++)
			{
				if(List[i]==Frame[j])
				{
					falg=true;
					pagehit++;
					
					break;
				}
			}
			
			if(num==Frameno)
				num=0;
			
			if(falg==false)
			{
				Frame[num]=List[i];
				num++;
			}
			
			  System.out.print("frame : ");
	            for(int k=0; k<Frameno; k++)
	                System.out.print(Frame[k]+" ");
	            System.out.println();
		}
		
		
		System.out.println(pagefault);
		System.out.println(pagehit);
	/*	for(int i=1; i<=Frameno; i++)
		{
			System.out.println(Frame[i]);
		}*/
		
	}
}