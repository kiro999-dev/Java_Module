package ex01;

public class Program {
    public static void main(String[] args)
    {
        Multythread t1 = new Multythread("egg",Integer.parseInt(args[0]));
        Multythread t2 = new Multythread("Hen",Integer.parseInt(args[0]));
        Multythread t3 = new Multythread("Human",Integer.parseInt(args[0]));
        Thread myt1 = new Thread(t1);
        Thread myt2 = new Thread(t2);
        myt1.start();
        myt2.start();
        try {
            myt1.join();
            myt2.join();
        } catch (Exception e) {
        }
        t3.run();
    }
}
