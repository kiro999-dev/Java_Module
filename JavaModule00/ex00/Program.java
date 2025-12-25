
public class Program
{
    public static void main(String[] args)
    {
         long  num = 99999999;
        int sum = 0;
        while (num > 0) {
                sum += num %10;
                num /= 10; 
        }
       System.out.println(sum);
    }
}  