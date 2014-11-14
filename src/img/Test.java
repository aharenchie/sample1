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
            for(double  x=0;x<w;x++){
            	double  a = x/w;
            	System.out.print(a);
                int c1 = read1.getRGB((int)x, (int)y);
                int c2 = read2.getRGB((int)x, (int)y);
                
                int rate = 5;
                int pixel= 0XFF000000;
                int wk1= ((c1 & 0xFF0000)*rate)/5;      // 16～23= 赤色
                int wk2= ((c2 & 0xFF0000)*(4-rate))/5;
                pixel |= (wk1+wk2) & 0xFF0000;
                wk1= ((c1 & 0xFF00)*rate)/5;        // 8～15= 緑色
                wk2= ((c2 & 0xFF00)*(4-rate))/5;
                pixel |= (wk1+wk2) & 0xFF00;
                wk1= ((c1 & 0x00FF)*rate)/5;        // 0～7= 青色
                wk2= ((c2 & 0x00FF)*(4-rate))/5;
                pixel |= (wk1+wk2) & 0x00FF; //double  new_c = a*c2+(1-a)*c1;
                
                write.setRGB((int)x,(int)y,(int)pixel);
                
            }
        }
        
        File new_f = new File("ret.jpg");
        ImageIO.write(write, "jpg", new_f);
        System.out.print("finish");
    }
}