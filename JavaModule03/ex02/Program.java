package ex02;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int arraySize = Integer.parseInt(args[0]);
        int[] array = new int[arraySize];
        Arrays.fill(array, 1);
        int ThreadCount = Integer.parseInt(args[1]);
        int start = 0;
        int end = arraySize / ThreadCount;
        for (int i = 0; i < ThreadCount; i++) {

            Summing task = new Summing(start, end, array, i + 1);
            Thread thread = new Thread(task);
            thread.start();
            start = end + 1;
            if (i == ThreadCount - 2)
                end = arraySize - 1;
            else
                end += arraySize / ThreadCount;
            try {
                thread.join();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Summing task = new Summing(start, end, array, 0);
        System.out.printf("Sum by threads: %d\n", task.Getsum());
    }
}
