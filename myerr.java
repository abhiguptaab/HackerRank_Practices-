import java.io.*;
import java.util.*;

class myerr {
	
	public static void main(String arg[])
	{
		int np;
		int f;
		Scanner s = new Scanner(System.in);
		System.out.println("enter Numner of Processes");
		np=s.nextInt();
		System.out.println("enter quantum time");
		f=s.nextInt();
		int temp;
		String process[] = new String[np];
		int AT[] = new int[np];
		int BT[] = new int[np];
		int WT[] = new int[np];
		int RT[] = new int[np];
		
		System.out.println("enter process");
		for(int i=0; i<np; i++)
		{
			process[i] = s.next();
		}
		System.out.println("enter Arrival time of process");
		for(int i=0; i<np; i++)
		{
			AT[i] = s.nextInt();
		}
		System.out.println("enter Burst time of process");
		for(int i=0; i<np; i++)
		{
			BT[i] = s.nextInt();
		}
		
		System.out.println("enter Burst time of process");
		for(int i=0; i<np; i++)
		{
			System.out.println(process[i]+" " + AT[i] +" "+ BT[i]);
		}
		for(int i=0; i<np; i++)
		{
			for(int j=i+1; j<np; j++)
			{
				if(AT[i]>AT[j])
				{
					temp=AT[i];
					AT[i]=AT[j];
					AT[j]=temp;
					temp=BT[i];
					BT[i]=BT[j];
					BT[j]=temp;
				}
			}
		}
		System.out.println("enter Burst time of process");
		for(int i=0; i<np; i++)
		{
			System.out.println(process[i]+" " + AT[i] +" "+ BT[i]);
		}
		for(int i=0; i<np; i++)
		{
			RT[i]=BT[i];
		}
		
		int q=0;
		int te[] = new int[np];
		int j=0;
		while(j<=np)
		{
			j++;
			for(int i=0; i<np; i++)
			{
				if(RT[i]==0) continue;
					if(RT[i]>f)
					{
						q=q+f;
						RT[i] = RT[i] - f;
						te[i]=te[i]+1;
					}
					else
					{
						WT[i]= q-te[i]*f;
						q=q+RT[i];
						RT[i]=RT[i]-RT[i];
					}
			}
		}
		
		for(int i=0; i<np; i++)
		{
			System.out.println(WT[i]+" ");
		}
		
		System.out.println("Waiting time ");
		int AWT=0;
		for(int i=0; i<np; i++)
		{
			System.out.println(WT[i]-AT[i]+" ");
			AWT=AWT+WT[i];
		}
		System.out.println("total Waiting time "+ AWT);

		System.out.println(AWT/np);

	}

}
