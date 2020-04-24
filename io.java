import java.util.*;
import java.io.*;

class io{
    public static void main(String args[]){

        int x=2;
        int y=8;
        System.out.print(pow(x,y));
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

