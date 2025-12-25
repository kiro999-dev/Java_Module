package ex02;

import java.util.Scanner;

public class Program {
    public static long sumOfdigits(long num) {
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static boolean isprim(long number) {
        if(number <=1)
            return false;
        int i = 2;
        while (i < Math.sqrt(number)) {
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner queries = new Scanner(System.in);
        long sum = 0;
        int count = 0;
        long number;
        while (true) {
            System.out.print("--> ");
            number = queries.nextLong();
            if (number == 42)
                break;
            else {
                sum = sumOfdigits(number);
                if(isprim(sum))
                    count++;
            }
        }
        System.out.printf("Count of coffee-request : %d", count);
        queries.close();
    }
}
