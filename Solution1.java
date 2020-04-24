import java.util.*;

class Solution1{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int arr[] = new int[100];
		
		//String[] array = sc.nextLine().split(" ");
		//// sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for(int i=0; i<n; i++)
		{
		//	int arrayitem = Integer.parseInt(array[i]);
		//	arr[i]=arrayitem;
			arr[i]=sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+ " ");
		}
		
		int num=n;
		int sum=0, cnt=0;
		for(int i=1; i<=n;i++)
		{
			num=num+n-i;
		}
		int outarr[][] = new int[50][50];
		
		for(int i=0; i<n; i++)
		{
			for(int k=0; k< n-i;  k++)
			{
				for(int j=-1+k; j<=i+k; j++)
				{
					sum=sum+arr[j+1];
					
				}
				System.out.println(sum+ " ");
				if(sum<0)
				{//System.out.println("neg" +sum);
					cnt++;
				}
			}
		}
		
		System.out.println();
	/*	for(int i=0; i<n; i++)
		{
			for(int j=0; j<n;j++)
			{
				System.out.print(outarr[i][j] +" ");
			}
			System.out.println();
		}*/
		System.out.println(num);
		System.out.println(cnt);
		sc.close();
	}
}

