/*
TEB 50  
optimal algorithm
*/
import java.io.*;
import java.util.Scanner;
class OPTIMAL
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n,f,pg,i,j,k,max,replace,pgf=0,p_flag,FrameFullFlag;
		boolean flag;
		System.out.println("\nEnter the number of frames : ");
		f=sc.nextInt();
		System.out.println("Enter the number of pages");
		n=sc.nextInt();
		int frame[]=new int[f];
		int pages[]=new int[n];
		int temp[]=new int[f];
		System.out.println("Enter the page references : \n");
		for(i=0;i<n;i++)
		{
			pages[i]=sc.nextInt();
		}
		
		for(i=0;i<f;i++)
		{
			frame[i]=-1;
		}
		
		//Consider all pages one by one 
		for(pg=0;pg<n;pg++)
		{
			flag=true;
			
			//page hit start
			for(i=0;i<f;i++)
			{
				if(frame[i]==pages[pg])
				{
					flag=false;
					break;
				}
			}//page hit end
			
			//page fault start
			if(flag)
			{
				//condition check for frame is not full start
				FrameFullFlag=1;
				for(i=0;i<f;i++)
				{
					if(frame[i]==-1)
					{
						FrameFullFlag=0;
						break;
					}
				}
				
				
				if(FrameFullFlag==0)
				{
					frame[i]=pages[pg];
				}//condition check for frame is not full end
				
				//condtion for frame is full start
				else
				{
					for(i=0;i<f;i++)
					{
						temp[i]=-1;
					}
		
					for(i=0;i<f;i++)
					{
						for(j=pg+1;j<n;j++)
						{
							if(frame[i]==pages[j])
							{
								temp[i]=j;
								break;
							}
						}
					 }
					 p_flag=0;
					 for(i=0;i<f;i++)
					 {
					 	if(temp[i]==-1)
					 	{
					 		frame[i]=pages[pg];
					 		p_flag=1;
					 		break;
					 	}
					 }
					 if(p_flag==0)
					 {
						 max=temp[0];
						 for(i=1;i<f;i++)
						 {
						 	if(temp[i]>max)
						 		max=temp[i];
						 }
						 replace=pages[max];
						 for(i=0;i<f;i++)
						 {
						 	if(frame[i]==replace)
						 	{
						 		frame[i]=pages[pg];
						 		break;
						 	}
						 		
						 }
					 }
				}//condtion for frame is full end
				
				System.out.print("\nFrame : \t");
				for(i=0;i<f;i++)
				{
					System.out.print(frame[i]+"   ");
				}
				pgf++;
			}//page fault end
			else
			{
				System.out.print("\nFrame : \t");
				for(i=0;i<f;i++)
				{
					System.out.print(frame[i]+"   ");
				}
			}
		}
		System.out.println("\nNumber of page fault"+pgf);
	}//End of main function
}//End of class






