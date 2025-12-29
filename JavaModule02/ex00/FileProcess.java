import java.io.*;
import java.util.Map;;

public class FileProcess {
    private FileInputStream fileIn;
    private FileOutputStream fileOut;
    private String path;
    private byte[] magic;

    FileProcess(String path) {
        this.path = path;
    }
    public void processing()
    {
        magic = new byte[8];
        try {
            boolean flag = false;
            fileIn = new FileInputStream(path);
            fileOut = new FileOutputStream("result.txt",true);
            fileIn.read(magic);
            for (Map.Entry<String, byte[]> entry : FileSignatures.fileTypes.entrySet()) {
                if (startsWith(magic, entry.getValue())) {
                    System.out.println("PROCESSED");
                    String type = entry.getKey() + "\n";
                    fileOut.write(type.getBytes());
                    flag = true;
                    break;
                }
            }
            if(flag == false)
                {
                    System.out.println("UNDEFINED");
                }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static boolean startsWith(byte[] data, byte[] magic) {
        if (data.length < magic.length)
            return false;
        for (int i = 0; i < magic.length; i++) {
            if (data[i] != magic[i])
                return false;
        }
        return true;
    }

}