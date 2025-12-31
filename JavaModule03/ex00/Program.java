package ex00;

public class Program {
    public static void main(String[] args)
    {
        Multythread t1 = new Multythread("egg",Integer.parseInt(args[0]));
        Multythread t2 = new Multythread("Hen",Integer.parseInt(args[0]));
        Multythread t3 = new Multythread("Human",Integer.parseInt(args[0]));
        t1.start();
        t2.start();
        try {
            t1.join();
             t2.join();
        } catch (Exception e) {
        }
        t3.run();
    }
}
