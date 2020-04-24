import java.io.*;
import java.util.*;

class MySJF1 {
	public static void main(String argv[])
	{
		Scanner s = new Scanner(System.in);
		int noofproc;
		String Process[]=new String[20];
		int BT[]=new int[20];
		int AT[]=new int[20];
		int TAT[]=new int[20];
		int WT[]=new int[20];
		int RT[]=new int[20];
		System.out.println("Enetr number of process");
		noofproc = s.nextInt();
		System.out.println("Enetr processes");
		for(int i=0; i<noofproc; i++ )
		{
			Process[i]=s.next();
		}
		
		System.out.println("Enetr arrival time of processes");
		for(int i=0; i<noofproc; i++ )
		{
			AT[i]=s.nextInt();
		}
		
		System.out.println("Enetr burst time of processes");
		for(int i=0; i<noofproc; i++ )
		{
			BT[i]=s.nextInt();
		}
		
		
		System.out.println("Process\t Arrival_Time \t Busrt Time \t Turn_around_Time ");
		
		for(int i=0;i<noofproc;i++)
		{
			System.out.println(" "+Process[i]+"\t\t "+AT[i]+"\t\t "+BT[i]);
			System.out.println(" ");
		}
		
		
	
		
			
		
		
		
		
		System.out.println("Disply result");
		
		int completed=0, shortest=0;
		int minm = Integer.MAX_VALUE;
		int n= noofproc;
		int t=0;
		int finishtime=0;
		int avgtt=0, avgwt=0;
		boolean check=false;
		
		for(int i=0; i<noofproc; i++)
		{
			RT[i]=BT[i];
		}
		
		while(completed!=n)
		{
			for(int j=0; j<n; j++)
			{
				if(AT[j]<=t && RT[j]<minm && RT[j]>0)
				{
					shortest =j;
					minm= RT[j];
					check = true;
				}
			}
			
			if(check == false)
			{
				t++;
				continue;
			}
			
			RT[shortest]--;
			
			minm = RT[shortest];
			
			if(minm == 0)
			{
				minm= Integer.MAX_VALUE;
			}
			
			if(RT[shortest]==0)
			{
				completed++;
				check = false;
				finishtime=t+1;
				WT[shortest] = finishtime - BT[shortest] - AT[shortest];
				if(WT[shortest]<0)
					WT[shortest]=0;

			}
			t++;	
		}
		for(int i=0; i<noofproc; i++)
		{
			TAT[i]=WT[i]+BT[i];
		}
		
		System.out.println("\n=====================================================");
		System.out.println("Process\t Burst_Time \t Waiting Time \t Turn_around_Time ");
		for(int i=0;i<noofproc;i++)
		{
			System.out.println(" "+Process[i]+"\t\t "+BT[i]+"\t\t "+WT[i]+"\t\t "+TAT[i]);
			System.out.println(" ");
		}
		
		
		
		//Average waiting time
		for(int i=0;i<noofproc;i++)
		{
			avgwt=WT[i]+avgwt;
		}
		System.out.println("\nAverage waiting time:: "+avgwt/noofproc+" ms");
			
		
		//Average Turnaround time
		for(int i=0;i<noofproc;i++)
		{
			avgtt=TAT[i]+avgtt;
		}
		
		System.out.println("\nAverage Turnaround time:: "+avgtt/noofproc +" ms");


		
	
		

		
	}
	
	
}
