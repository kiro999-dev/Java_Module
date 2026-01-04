package ex03;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class FileDownloader {
    
    public static void downloadFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        try (InputStream in = url.openStream()) {
            String fileName = Paths.get(url.getPath()).getFileName().toString();
            Path outputPath = Paths.get(saveDir, fileName);
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
         
    }
   
}