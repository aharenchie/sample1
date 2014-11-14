package img;
import img.ImageUtility;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
public class Test {
    public static void main(String[] args) throws IOException {
        File f1 = new File("./pic/blue.jpg");
        File f2 = new File("./pic/red.jpg");
        BufferedImage read1=ImageIO.read(f1);
        BufferedImage read2=ImageIO.read(f2);       
        
        double  w = read1.getWidth(),h=read1.getHeight();
        BufferedImage write =
                new BufferedImage((int)w, (int)h, BufferedImage.TYPE_INT_RGB);
        
        for(double  y=0;y<h;y++){
            for(double  x=1;x<=w;x++){
            	double  a = x/w;
            	System.out.print(a);
                int c1 = read1.getRGB((int)x-1, (int)y);
                int c2 = read2.getRGB((int)x-1, (int)y);
                double  new_c = a*c2+(1-a)*c1;
                
                write.setRGB((int)x-1,(int)y,(int)new_c);
                
            }
        }
        
        File new_f = new File("ret.jpg");
        ImageIO.write(write, "jpg", new_f);
        System.out.print("finish");
    }
}