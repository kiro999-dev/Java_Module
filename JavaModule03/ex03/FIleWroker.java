package ex03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FIleWroker implements Runnable  {
    private FileManager fileManager;
    FIleWroker(int id,FileManager fileManager)
    {
        this.fileManager = fileManager;
    }
    @Override 
    public void run()
    {
        while (true) {
            int filenumber = fileManager.getNextfile();
            if (filenumber == -1) {
                return;
            }
            String threadName=  Thread.currentThread().getName();
            String url = fileManager.getUrl(filenumber);

            System.out.printf("%s start downloading %s number %d\n",threadName,url,filenumber);
             try {
            String fileURL = url;
            String saveDir = "downloads";
            Files.createDirectories(Paths.get(saveDir));
            FileDownloader.downloadFile(fileURL, saveDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
            System.out.printf("%s  finish %s number %d\n",threadName,url,filenumber);
        }
    }
}
