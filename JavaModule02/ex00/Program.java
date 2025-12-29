import java.util.Scanner;
public class Program {

    public static void main(String[] args) {
        
        Scanner readData = new Scanner(System.in);
        String data;
        while (true) {
           
            data = readData.next();
            if(data.equals("42"))
                break;
            FileProcess f = new FileProcess(data);
            f.processing();
        }
        readData.close();
    }
   
}
