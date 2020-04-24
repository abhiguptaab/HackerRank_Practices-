import java.io.*;
import java.util.*;

class optimal1 {
	
	public static void main(String argv[])
	{
		int noofpage=0;
		int noofframe=0;
		
		Scanner s= new Scanner(System.in);
		
		System.out.println("Enter number of pages");
		noofpage=s.nextInt();
		System.out.println("Enter number of frames");
		noofframe=s.nextInt();
		
		int pages[] = new int[noofpage];
		int frames[] = new int[noofframe];
		
		System.out.println("Enter pages");
		for(int i=0; i<noofpage; i++)
		{
			pages[i] = s.nextInt();
		}
		
		for(int i=0; i<noofframe; i++)
		{
			frames[i]=-1;
		}
		boolean flag=true;
		int pagehit=0;
		boolean flag2=true;
		
		
		int buffer[] = new int[noofpage];
		for(int i=0; i<noofpage; i++)
		{	int x=0;
		    int y=0;
			int page = pages[i];
			int count =0;
			for(int j=0; j<noofframe; j++)
			{
				if(page==frames[j])
				{
					pagehit++;
					flag=false;
					break;
				}
				else if(frames[j]==-1)
				{
					frames[j]=page;
					break;
				}
			}
			
			
			if(flag)
			{
				int pagetoreplace;
				for(int k=i+1; k<noofpage; k++)
				{
					for(int l=0; l<noofframe; l++)
					{
						
						if(pages[k]==frames[l])
						{
							buffer[count]=frames[l];
							flag2=true;
							count++;
						}
						
						else if(pages[k]!=frames[l])
						{
							y=l;
							flag2=false;
						}
							
					}
				}
				
				if(flag2)
				{
					int replace = buffer.length-1;
					pagetoreplace = buffer[replace];
					while(frames[x]!=pagetoreplace)
						x++;
					
					frames[x] = page;
				}
				else {
					frames[y] = page;
				}
			}
			for(int z=0; z<noofframe; z++)
			{
				System.out.print(frames[z] +" ");
			}
			System.out.println(" ");
		}
		System.out.println(pagehit);
		
	}
}
