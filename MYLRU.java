import java.io.*;
import java.util.*;


class MYLRU {
	public static void main(String args[]) throws InterruptedException
	{
		
		Scanner s= new Scanner(System.in);
		int pages[] = new int[30];
		int frames[] = new int[30];
		int pagetoreplace;
		int recent[] = new int[30];
		int pageit, pg, page, pagehit = 0;
		int k=0;
		int pageno, frameno, recentno;
		boolean flag2=true;
		System.out.println("Enter the numer of pages");
		pageno = s.nextInt();
		System.out.println("Enter the numer of frames");
		frameno = s.nextInt();
		
		for(int i=0; i<pageno; i++)
		{
			System.out.println("Enter "+ i + "th page");
			pages[i] = s.nextInt();
		}
		
		for(int i=0; i<frameno; i++)
		{
			frames[i]=-1;
		}
		
		for(int i=0; i<frameno; i++)
		{
			recent[i]=-1;
		}
		
		for(int i=0; i<pageno; i++)
		{
			page=pages[i];
			boolean flag=false;
			for(int j=0; j<frameno; j++)
			{
				if(frames[j]==page)
				{
					flag=true;
					pagehit++;
					break;
				}
			}
			
			if(flag==false)
			{
				int count=0;
				
				if(i>=3)
				{
					pageit = i-1;
					while(count < 0)
					{
						 
						pg= pages[pageit];
						flag2=true;
						
					for(int j=0; j<frameno; j++)
					{
						if(recent[j]==pg)
						{
							flag2=false;
							break;
						}
							
					}
					
					if(flag2)
					{
						recent[count]= pg;
						count++;
						pageit--;
					}
					else
						pageit--;
					}
					
				recentno = recent.length-1;
				pagetoreplace=recent[recentno];
				while(frames[k]!=pagetoreplace)
				{
					k++;
				}
				frames[k]=page;
				}
				else
					frames[i]=page;
			}
			  System.out.print("frame : ");                          //STEP 7
	            for(int p=0; p<frameno; p++)
	                System.out.print(frames[p]+" ");
	            System.out.println();
		}
		System.out.println(pagehit);
		
	}
}
