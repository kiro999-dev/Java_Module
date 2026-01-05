package  fr.app;
import fr.logic.*;

public class app {
    public static void main(String[] args)
    {
        ImagesConverter image = new ImagesConverter("/home/zkhourba/Java_Module/JavaMoudle04/ex00/it.bmp");
        image.readImage();
    }
}
