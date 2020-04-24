import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Bankers {
	
	private int allocate[][], max[][], available[][], need[][], np, nr;
	private void input()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number of processes");
		np=s.nextInt();
		System.out.println("Enter Number of resourses");
		nr=s.nextInt();
		
		allocate = new int[np][nr];
		max = new int[np][nr];
		available = new int[1][nr];
		need = new int[np][nr];
		
		System.out.println("Enter allocation matrix");
		for(int i=0; i<np; i++)
		{
			for(int j=0; j<nr; j++)
			{
				allocate[i][j]=s.nextInt();
			}
		}
		
		System.out.println("Enter maximum matrix");
		for(int i=0; i<np; i++)
		{
			for(int j=0; j<nr; j++)
			{
				max[i][j]=s.nextInt();
			}
		}
		
		System.out.println("Enter available matrix");
		for(int j=0;j<nr;j++)
	         available[0][j]=s.nextInt();  
		
		
		s.close();
	}
	

	private int[][] calc_need()
	{
		for(int i=0; i<np; i++)
		{
			for(int j=0; j<nr; j++)
			{
				need[i][j]=max[i][j]-allocate[i][j];
			}
		}
		return need;
	}
	
	private boolean check(int i)
	{
		for(int j=0; j<nr; j++)
		{
			if(available[0][j]<need[i][j])
				return false;
		}
		return true;
	}
	
	public void issafe()
	{
		input();
		calc_need();
		boolean done[] = new boolean[np];
		int j=0;
		boolean allocated = false;
		while(j<np)
		{
			
			for(int i=0; i<np; i++)
			{
			if((!done[i])&&(check(i)))
			{
				for(int k=0; k<nr; k++)
				{
					allocate[0][k]= allocate[0][k]-need[i][k]+max[i][k];
				}
				 System.out.println("Allocated process : "+i);
				allocated=done[i]=true;
				j++;
			}
			if(!allocated) break;
			
			}
			
		}
		if(j==np)
			System.out.println("Success : ");
		else
			System.out.println("deadlock ");
		
	}
	 public static void main(String[] args) {
	       new Bankers().issafe();
	    }

}
