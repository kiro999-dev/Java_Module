package ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
public class Program {
    public static void main(String[] args) {
        Scanner readData = new Scanner(System.in);
        String line;
        String[] splited;
        int weeks = 1;
        List<Integer> listOfgreads = new ArrayList<>();
        while (weeks < 18) {
            System.out.print("-> ");
            line = readData.nextLine();
            splited = line.split(" ");
            if (splited[0].compareTo("42") == 0)
                break;
            if (splited[0].compareTo("Week") != 0 ||
                    splited[1].compareTo(String.valueOf(weeks)) != 0) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            } else {
                int i = 0;
                int minGread = Integer.MAX_VALUE;
                int gread = 0;
                System.out.print("-> ");
                while (i < 5) {
                    
                    gread = readData.nextInt();
                    
                    if (minGread > gread)
                        minGread = gread;
                    i++;
                }
                listOfgreads.add(minGread);
            }
            readData.nextLine();
            weeks++;
        }
        for (int i = 0; i < listOfgreads.size(); i++) {
            System.err.printf(" Week %d ", i + 1);
            for (int j = 0; j < listOfgreads.get(i); j++) {
                System.out.print("=");
            }
            System.out.printf(">\n");
        }
        readData.close();
    }
}
