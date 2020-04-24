import java.util.*;

class Decimal2Hexa{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n;
		n=sc.nextInt();
		int temp=0,k=0;
		char[] hexa = new char[20];
		
		
		while(n!=0)
		{
			temp=n%16;
			if(temp<10) {
				hexa[k]=(char) (temp+48);
				k++;
			}
			else if(temp>=10) {
				hexa[k]=(char) (temp+55);
				k++;
			}
			n=n/16;
		}
		
		for(int i=k-1; i>=0; i--)
		{
			System.out.print(hexa[i]+" ");
		}
	}
}