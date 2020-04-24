import java.util.*;
class Hexa2Decimal {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String Hexa;
		Hexa = sc.next();
		int deci = Integer.parseInt(Hexa);
		int decimal = deci%16;
		System.out.println(decimal);
		
	}
}
