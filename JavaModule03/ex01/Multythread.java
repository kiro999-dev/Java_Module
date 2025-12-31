package ex01;
public class Multythread implements Runnable {
    private String inpute;
    private int count;
    Multythread(String inpute,int count)
    {
        this.inpute = inpute;
        this.count = count;
    }
    @Override 
    public synchronized void run()
    {
        for (int i = 0; i < count; i++) {
            System.out.println(inpute);
        }
    }
}