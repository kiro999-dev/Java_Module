package fr.logic;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImagesConverter {
    public File bmpFile;
    public ImagesConverter(String file)
    {
        this.bmpFile = new File(file);
    }
    private void extractColors(BufferedImage  image)
    {
        int w = image.getWidth();
        int h = image.getHeight();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int rgb = image.getRGB(j, i);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;
                if(red == 255 && blue == 255 && green == 255)
                {
                    System.out.print('.');
                }
                else 
                    System.out.print('0');
            }
            System.out.println();
        }
    }
    public void readImage()
    {
        BufferedImage  image;
       try {
            image =  ImageIO.read(bmpFile);
            extractColors(image);
       } catch (Exception e) {
        System.out.println("ImagesConverter.readImage()");
       }
       
    }
}
