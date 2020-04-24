import java.io.*;
import java.util.*;

class SJF
{
	public static void main(String args[]) throws IOException
	{	
		
		Scanner s=new Scanner(System.in);
		int[] process=new int[20];
		int[] arrival_time=new int[20];
		int[] burst_time=new int[20];
		int[] wait_time=new int[20];
		int[] wt=new int[20];
		int[] tt=new int[20];
		int sum=0;	
		int avgwt=0;
		int avgtt=0,pos,temp,i,j;	
		
		int nop;
		System.out.println("\nEnter the Number of Process:: ");
		nop=s.nextInt();
		
		for(i=0;i<nop;i++)
		{
			j=i+1;
			System.out.println("\nEnter process:: "+j);
			process[i]=s.nextInt();
		}
		
		System.out.println("\n==========Enter the Burst Time============");
		for(i=0;i<nop;i++)
		{
			j=i+1;
			System.out.println("\nEnter Burst time for process:: "+j);
			burst_time[i]=s.nextInt();
		}
		System.out.println("\n==========Enter the Arrival Time============");
		for(i=0;i<nop;i++)
		{
			j=i+1;
			System.out.println("\nEnter Arrival time for process:: "+j);
			arrival_time[i]=s.nextInt();
		}
		System.out.println("\n=====================================================");
		System.out.println("Process\t Burst_Time \t Arrival Time");
		for(i=0;i<nop;i++)
		{
			System.out.println(" "+process[i]+"\t\t "+burst_time[i]+"\t \t"+arrival_time[i]);
			System.out.println(" ");
		}

//new code
int n=nop;
		int rt[] = new int[n]; 
		
		// Copy the burst time into rt[] 
		for (i = 0; i < n; i++) 
			rt[i] = burst_time[i]; 
	
		int complete = 0, t = 0, minm = Integer.MAX_VALUE; 
		int shortest = 0, finish_time; 
		boolean check = false; 
	
		// Process until all processes gets 
		// completed 
		while (complete != n) { 
	
			// Find process with minimum 
			// remaining time among the 
			// processes that arrives till the 
			// current time` 
			for (j = 0; j < n; j++) 
			{ 
				if ((arrival_time[j] <= t) && 
				(rt[j] < minm) && rt[j] > 0) { 
					minm = rt[j]; 
					shortest = j; 
					check = true; 
				} 
			} 
	
			if (check == false) { 
				t++; 
				continue; 
			} 
	
			// Reduce remaining time by one 
			rt[shortest]--; 
	
			// Update minimum 
			minm = rt[shortest]; 
			if (minm == 0) 
				minm = Integer.MAX_VALUE; 
	
			// If a process gets completely 
			// executed 
			if (rt[shortest] == 0) { 
	
				// Increment complete 
				complete++; 
				check = false; 
	
				// Find finish time of current 
				// process 
				finish_time = t + 1; 
	
				// Calculate waiting time 
				wait_time[shortest]= finish_time - 
							burst_time[shortest] - 
							arrival_time[shortest]; 
	
				if (wait_time[shortest] < 0) 
					wait_time[shortest] = 0; 
			} 
			// Increment time 
			t++; 
		} 
	
		
		//calculating turn around time 
		for(i=0;i<nop;i++)
		{
			tt[i]=wait_time[i]+burst_time[i];
		}
		
		//final table display
		
		System.out.println("\n=====================================================");
		System.out.println("Process\t Burst_Time \t Waiting Time \t Turn_around_Time ");
		for(i=0;i<nop;i++)
		{
			System.out.println(" "+process[i]+"\t\t "+burst_time[i]+"\t\t "+wait_time[i]+"\t\t "+tt[i]);
			System.out.println(" ");
		}
		
		
		//Average waiting time
		for(i=0;i<nop;i++)
		{
			avgwt=wait_time[i]+avgwt;
		}
		System.out.println("\nAverage waiting time:: "+avgwt/nop +" ms");
			
		
		//Average Turnaround time
		for(i=0;i<nop;i++)
		{
			avgtt=tt[i]+avgtt;
		}
		
		System.out.println("\nAverage Turnaround time:: "+avgtt/nop +" ms");
		}
}
	
