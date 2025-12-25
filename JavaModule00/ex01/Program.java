package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int number = scan.nextInt();
            if (number <= 1) {
                System.err.println(("IllegalArgument"));
                System.exit(-1);
            }
            int count = 0;
            boolean fact = true;
            int i = 2;
            while (i < Math.sqrt(number)) {
                count++;
                if (number % i == 0) {
                    count++;
                    fact = false;
                    break;
                }
                i++;
            }
            System.out.print(fact);
            System.out.print(" ");
            System.out.println((count));
            scan.close();
        } catch (Exception e) {
            System.err.println(("its BIG number"));
        }

    }
}