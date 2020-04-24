import java.util.Scanner;

public class Solution8 {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String Temp;
        String Set[]= new String[1000];
        for(int i=0; i<1000; i++)
        {
        	Set[i]="";
        }
        for(int i=0;i<=s.length()-k; i++)
        {
        	Set[i] = s.substring(i, i+k);
        }
      /*  for(int i=0; i<=s.length()-k; i++)
        {
        	System.out.print(Set[i]+" ");
        }
        System.out.print("\n");
        */
        for(int i=0; i<=s.length()-k; i++)
        {
        	for(int j=0; j<=s.length()-k-1; j++)
        	{
        		
        		
        		if(((Set[j]).compareTo(Set[j+1]))>0)
        		{
        			Temp=Set[j];
        			Set[j]=Set[j+1];
        			Set[j+1]=Temp;
        		}
        	}
        }
     /*   for(int i=0;i<s.length();i++)
        {
        	System.out.print(Set[i]+" ");
        }*/
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = Set[0];
        largest = Set[s.length()-k];
        //System.out.println("");
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}