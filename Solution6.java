import java.util.*;
import java.text.*;


public class Solution6 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        Locale localeus =  Locale.US;
        NumberFormat dbl1 = NumberFormat.getCurrencyInstance(localeus);
        Locale localeindia = new Locale("en", "in");
        NumberFormat dbl2= NumberFormat.getCurrencyInstance(localeindia);
        //System.out.println(dbl.format(payment));
        Locale localechina= Locale.CHINA;
        NumberFormat dbl3= NumberFormat.getCurrencyInstance(localechina);
        Locale localefrance = Locale.FRANCE;
        NumberFormat dbl4 = NumberFormat.getCurrencyInstance(localefrance);
        String china = dbl3.format(payment);
        String us = dbl1.format(payment);
        String india = dbl2.format(payment);
        String france = dbl4.format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

