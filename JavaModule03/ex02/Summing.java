package ex02;

public class Summing implements Runnable {
    final private int start;
    final private int end;
    final private int[] arr;
    private static int sum = 0;
    final private int id;
    
    public Summing(int start, int end, int[] arr, int id) {
        this.start = start;
        this.end = end;
        this.arr = arr;
        this.id = id;
    }
    
    private void summing() {
        int sectionSum = 0;
        for (int i = start; i <= end; i++) {
            sectionSum += arr[i];
        }
        
        synchronized(Summing.class) {
            sum += sectionSum;
        }
        
        System.out.printf("Thread %d: from %d to %d sum is %d\n", id, start, end, sectionSum);
    }
    
    @Override 
    public void run() {
        summing();
    }
    
    public static int Getsum() {
        return sum;
    }
}