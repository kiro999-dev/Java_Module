
public class Program
{
    public static void main(String[] args)
    {
        int num = 479598;
        int sum = 0;
        String x = String.valueOf(num);
        for(int i =0;i< x.length();i++)
        {
            sum += Character.getNumericValue(x.charAt(i));
        }
       System.out.println(sum);
    }
}  