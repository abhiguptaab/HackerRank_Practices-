import java.util.*;
import java.io.*;

class optimal
{	
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int pageframesize,no_of_pages,i,j,k,pos=0,max;
		int flag1,flag2,flag3;
		int page_fault=0;
		int temp[]=new int[10];
		
		System.out.println("Enter the no of frames");
		pageframesize=Integer.parseInt(br.readLine());
		int frame[]=new int[pageframesize];
		
		System.out.println("enter the no of pages");
		no_of_pages=Integer.parseInt(br.readLine());
		
		int pages[]=new int[no_of_pages];
		System.out.println("enter the pages");
		for(i=0;i<no_of_pages;i++)
		{
			pages[i]=Integer.parseInt(br.readLine());
			
		}
		
		for(i=0;i<pageframesize;i++)
		{
			frame[i]=-1;
		}
		
		for(i=0;i<no_of_pages;i++)
		{
			flag1=flag2=0;
			
			for(j=0;j<pageframesize;j++)
			{
				if(frame[j]==pages[i])
				{
					flag1=flag2=1;
					System.out.println("page hit");
					break;
					
				}
			}//for analysing
			
			if(flag1==0)
			{
				for(j=0;j<pageframesize;j++)
				{
					if(frame[j]==-1)
					{
						page_fault++;
						frame[j]=pages[i];
						flag2=1;
						break;
						
					}
				}
			}//
			
			if(flag2==0)
			{
				flag3=0;
				for(j=0;j<pageframesize;j++)
				{
					temp[j]=-1;
					
					for(k=i+1;k<no_of_pages;k++)
					{
						if(frame[j]==pages[k])
						{
							temp[j]=k;
							break;
						}
					}
				}
				//for(j=0;j<pageframesize;j++)
				//{
					//System.out.println("temp"+temp[j]);
				//}
			//end of if loop
			
			for(j=0;j<pageframesize;j++)
			{
				if(temp[j]==-1)
				{
					pos=j;
					flag3=1;
					//System.out.println("position"+pos);
					break;
				}
			}
			
			if(flag3==0)
			{
				max=temp[0];
				pos=0;
				
				for(j=1;j<pageframesize;j++)
				{
					if(temp[j]>max)
					{
						max=temp[j];
						pos=j;
					}
				}
			}
			
			frame[pos]=pages[i];
			page_fault++;
		}
		for(j = 0; j < pageframesize; j++)				  
		{	
		   System.out.print("\t"+ frame[j]);
						
		    }
		    System.out.println();
		 
		}
	}
}	
/*

***********output*************

unix@unix-HP-280-G1-MT:~$ javac optimal1.java
unix@unix-HP-280-G1-MT:~$ java optimal1
Enter the no of frames
3
enter the no of pages
20
enter the pages
7
0
1
2
0
3
0
4
2
3
0
3
2
1
2
0
1
7
0
1
	7	-1	-1
	7	0	-1
	7	0	1
	2	0	1
page hit
	2	0	1
	2	0	3
page hit
	2	0	3
	2	4	3
page hit
	2	4	3
page hit
	2	4	3
	2	0	3
page hit
	2	0	3
page hit
	2	0	3
	2	0	1
page hit
	2	0	1
page hit
	2	0	1
page hit
	2	0	1
	7	0	1
page hit
	7	0	1
page hit
	7	0	1
	
	*/

