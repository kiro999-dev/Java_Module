package ex03;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("enter file urls and number of threads plz");
            return;
        }
        ArrayList<String> URls = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                URls.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberThreads = Integer.parseInt(args[1]);
        Thread[] t = new Thread[numberThreads];
        FileManager fileManager = new FileManager(URls);
        for (int i = 0; i < numberThreads; i++) {

            t[i] = new Thread(new FIleWroker(i, fileManager));
        }
        for (int i = 0; i < numberThreads; i++) {
            t[i].start();
        }
        for (int i = 0; i < numberThreads; i++) {
            try {
                t[i].join();
            } catch (Exception e) {
                System.err.println("erros");
            }
        }
    }

}
