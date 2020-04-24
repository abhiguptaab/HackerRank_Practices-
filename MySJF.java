import java.io.*;
import java.util.*;

class MySJF{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int avgwt = 0, avgtt=0;
		int No_of_proc;
		int AT[]= new int[20];
		String Pno[]= new String[20];
		int BT[]= new int[20];
		int WT[]= new int[20];
		int TAT[]= new int[20];
		
		System.out.println("Enter The number of processes");
		No_of_proc=s.nextInt();
		
		for(int i=0; i<No_of_proc; i++)
		{
			System.out.println("Enter Process Number");
			Pno[i]=s.next();
		}
		
		for(int i=0; i<No_of_proc; i++)
		{
			System.out.println("Enter Arrival time of process "+ i);
			AT[i]=s.nextInt();
		}
	
		for(int i=0; i<No_of_proc; i++)
		{
			System.out.println("Enter Busrt time of process "+ i);
			BT[i]=s.nextInt();
		}
	
		int completed=0, t=0, minm=Integer.MAX_VALUE;
		int finish_time; 
		int shortest = 0; 
		int rt[]=new int[20];
		int n= No_of_proc;
		boolean check = false;
		for(int i=0; i<n; i++)
		{
			rt[i]=BT[i];
		}
		
		while(completed!=n)
		{
			for(int j=0; j<n; j++)
			{
				if(AT[j]<=t && rt[j]<minm && rt[j]>0)
				{
					shortest = j;
					minm = rt[j];
					check = true;
				}
			}
			
			if(check == false)
			{
				t++;
				continue;
			}
			
			rt[shortest]--;
			
			minm = rt[shortest];
			if(minm ==0 )
			{
				minm=Integer.MAX_VALUE;
			}
			
			if(rt[shortest]==0)
			{
				completed++;
				check=false;
				
				finish_time=t+1;
				WT[shortest]= finish_time-BT[shortest]-AT[shortest];
				if(WT[shortest]<0)
					WT[shortest]=0;
			}
			t++;
		}
		
		
		for(int i=0; i<No_of_proc; i++)
		{
			TAT[i]=WT[i]+BT[i];
		}
		
		System.out.println("\n=====================================================");
		System.out.println("Process\t Burst_Time \t Waiting Time \t Turn_around_Time ");
		for(int i=0;i<No_of_proc;i++)
		{
			System.out.println(" "+Pno[i]+"\t\t "+BT[i]+"\t\t "+WT[i]+"\t\t "+TAT[i]);
			System.out.println(" ");
		}
		
		
		
		//Average waiting time
		for(int i=0;i<No_of_proc;i++)
		{
			avgwt=WT[i]+avgwt;
		}
		System.out.println("\nAverage waiting time:: "+avgwt/No_of_proc+" ms");
			
		
		//Average Turnaround time
		for(int i=0;i<No_of_proc;i++)
		{
			avgtt=TAT[i]+avgtt;
		}
		
		System.out.println("\nAverage Turnaround time:: "+avgtt/No_of_proc +" ms");

		
		
		
	}
}