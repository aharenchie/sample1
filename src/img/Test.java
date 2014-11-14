package img;
import img.ImageUtility;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
public class Test {
    public static void main(String[] args) throws IOException {
        File f1 = new File("./pic/red.jpg");
        File f2 = new File("./pic/blue.jpg");
        BufferedImage read1=ImageIO.read(f1);
        BufferedImage read2=ImageIO.read(f2);       
        
        int w = read1.getWidth(),h=read1.getHeight();
        BufferedImage write =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
        int count = 1;
        int alpha = 0;
        int max = w-1;
        
        for(int y=0;y<h;y++){
            for(int x=0;x<w;x++){
            	
            	alpha = x;
         /*   	
            	if(x < w/4)
            		alpha = 0;
            	
            	if(x >= w/4 && x < (w/4)*2)
            		alpha = 1;
            	
            	if(x >= (w/4)*2 && x < (w/4)*3)
            		alpha = 2;
            	
            	if(x >= (w/4)*3)
            		alpha = 3;
            		*/
            	
            	//System.out.print(alpha);
                int c1 = read1.getRGB(x, y);
                int a1 = ImageUtility.a(c1);
                int r1 = ImageUtility.r(c1);
                int g1 = ImageUtility.g(c1);
                int b1 = ImageUtility.b(c1);
                
                int c2 = read2.getRGB(x, y);
                int a2 = ImageUtility.a(c2);
                int r2 = ImageUtility.r(c2);
                int g2 = ImageUtility.g(c2);
                int b2 = ImageUtility.b(c2);
                
                int a = (alpha*a1 + (max-alpha)*a2)/max;
                int r = (alpha*r1 + (max-alpha)*r2)/max;
                int g = (alpha*g1 + (max-alpha)*g2)/max;
                int b = (alpha*b1 + (max-alpha)*b2)/max;
                
                int new_c = ImageUtility.argb(a, r, g, b);
                
                write.setRGB(x,y,new_c);
                
            }
        }
        
        File new_f = new File("ret.jpg");
        ImageIO.write(write, "jpg", new_f);
        System.out.print("finish");
    }
}