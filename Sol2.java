

import java.util.*;
import java.io.*;

class Sol2{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int Res[][] = new int[500][500];
        int ite[]= new int[500];
        for (int i=0; i<500; i++)
        {
        	ite[i]=0;
        }
       
        for(int i=0;i<t;i++){
           int  a = in.nextInt();
           int  b = in.nextInt();
           int  n = in.nextInt();
           //System.out.print(t);
           //System.out.print(a+" ");
           //System.out.print(b+" ");
           //System.out.print(n+"\n");
            for(int j=0; j<n; j++)
            {	
            	if(j==0)
            	{
            		ite[j]=pow(2,j)*b;
            		
            		Res[i][j]=a+ite[j];
            		
            	}
            	else
            	{
	            	ite[j]= pow(2,j)*b + ite[j-1];
	            	Res[i][j]=a+ite[j];
            	}
            }
            for(int j=0; j<n; j++)
            {	
            	System.out.print(Res[i][j] + " ");
            }
            System.out.print("\n");
        }
        in.close();
	}

	private static int pow(int i, int j) {
		// TODO Auto-generated method stub
		if(j==0)
			return 1;
		if(j==1)
			return i;
		if(j%2==0) return pow(i*i, j/2);
		else return i*pow(i*i, j/2);
		
	}
}



