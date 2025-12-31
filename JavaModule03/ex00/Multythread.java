package ex00;
public class Multythread extends Thread {
    private String inpute;
    private int count;
    Multythread(String inpute,int count)
    {
        this.inpute = inpute;
        this.count = count;
    }
    @Override 
    public  void run()
    {
        for (int i = 0; i < count; i++) {
            System.out.println(inpute);
        }
    }
}