package ex03;

import java.util.ArrayList;

public class FileManager   {
    private int index = 0;
    private ArrayList<String> URls;
    FileManager(ArrayList<String> urls)
    {
        URls = urls;
    }
    public  synchronized int getNextfile()
    {
        if(index >= URls.size())
            return -1;
        else
        {
            index++;
            return index;
        }
    }
    public String getUrl(int filenumber)
    {
        return URls.get(filenumber-1);
    }
    
}
