package img;
import img.ImageUtility;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
public class Test {
    public static void main(String[] args) throws IOException {
        File f1 = new File("./pic/test1.jpg");
        File f2 = new File("./pic/test2.jpg");
        BufferedImage read1=ImageIO.read(f1);
        BufferedImage read2=ImageIO.read(f2);       
        
        int w = read1.getWidth(),h=read1.getHeight();
        BufferedImage write =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        for(int y=0;y<h;y++){
            for(int x=0;x<w;x++){
                int c1 = read1.getRGB(x, y);
                int c2 = read2.getRGB(x, y);
                int new_c = (c1+c2)/2;
                
                write.setRGB(x,y,new_c);
                
            }
        }
        
        File new_f = new File("ret.jpg");
        ImageIO.write(write, "jpg", new_f);
        System.out.print("finish");
    }
}