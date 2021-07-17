package org.nic;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;

public class CorruptorLogic {

	public int height;
    public int width;
    
    public Color[][] filterImage(Image image){

    	height = (int) image.getHeight();
    	width = (int) image.getWidth();
    	
        Color[][] Color = getPixelData(image);
        int randomNum = ThreadLocalRandom.current().nextInt(0, (6) + 1);

        if (randomNum==1) {
        return (
        		corruptorWrap
        		(
        				corruptorVert
        				(
        						corruptor
        						(Color))));
        }
        else {
        	return Color; 
    	}

    }

    public Color[][] getPartPixelData(Image image){
        Color[][] Image = new Color[(int) image.getHeight()][(int) image.getWidth()];
       
    	PixelReader pixelReader = image.getPixelReader();

        for (int i = 0;i<image.getHeight();i++) {
        	
            for (int j = 0; j < image.getWidth(); j++) {
                
                Color pixel = pixelReader.getColor(j,i);

                double r = pixel.getRed();
                double g = pixel.getGreen();
                double b = pixel.getBlue();
                double a = pixel.getOpacity();

                Color f = new Color(r,g,b,a);

                Image[i][j]=f;
            }
        }

        return Image;
    }

    public Color[][] getPixelData(Image image){

        Color[][] Image = new Color[(int) image.getHeight()][(int) image.getWidth()];
        
        PixelReader pixelReader = image.getPixelReader();
       
        for (int i = 0;i<image.getHeight();i++) {
        	
            for (int j = 0; j < image.getWidth(); j++) {
                
                Color pixel = pixelReader.getColor(j,i);

                double r = pixel.getRed();
                double g = pixel.getGreen();
                double b = pixel.getBlue();
                double a = pixel.getOpacity();

                Color f = new Color(r,g,b,a);

                Image[i][j]=f;
            }
        }

        return Image;
    }

    public double[] tintOne(double r,double g,double b) {
    	g-=0.3;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        
        r+=0.15;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintTwo(double r,double g,double b) {
        g-=0.0;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.0;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b+=0.2;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintThree(double r,double g,double b) {
        g+=0.1;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.1;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b-=1;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }



        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintFour(double r,double g,double b) {
        g+=0.1;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.06;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b+=0.0;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintFive(double r,double g,double b) {
        g+=0.0;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.0;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b-=0.0;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintSix(double r,double g,double b) {
        g+=0.0;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.0;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b-=0.0;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintSeven(double r,double g,double b) {
        g+=0.0;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.0;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b-=0.0;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintEight(double r,double g,double b) {
        g+=0.0;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.0;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b-=0.0;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintNine(double r,double g,double b) {
        g+=0.0;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.0;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b-=0.0;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }
    public double[] tintTen(double r,double g,double b) {
        g+=0.0;
        if(g<0) {
                g=0;
        }
        else if(g>1) {
                g=1;
        }
        r+=0.0;
        if(r<0) {
                r=0;
        }
        else if(r>1) {
                r=1;
        }
        b-=0.0;
        if(b>1) {
                b=1;
        }
        else if(b<0) {
                b=0;
        }
        double[] rgb = {r,g,b};
                return rgb;
    }

    public Color[][] corruptor(Color[][] pixels){
        int startPoint=0;
    	double[] rgb = {0,0,0};

	    int randomH = ThreadLocalRandom.current().nextInt((int) (height/7), (int) ((height) + 1));
	    int randomW = ThreadLocalRandom.current().nextInt((int) (width/7), (int) ((width) + 1));
	    int randomCount = ThreadLocalRandom.current().nextInt((int) (0), (3) + 1);
	      
       	int thisWidth;
        int endPoint;//height
        
        if(randomCount==0) {
        	thisWidth=width;
        	endPoint=height;
    	}
        else if (randomCount==1) {
        	thisWidth=width;
        	endPoint=randomH;

        }
        else if (randomCount==2) {
        	thisWidth=randomW;
        	endPoint=height;
        }
        else {
        	thisWidth=randomW;
        	endPoint=randomH;

        }
        
        while (startPoint+(thisWidth/150)<endPoint) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, (height/150) + 1);
            int randomColour = ThreadLocalRandom.current().nextInt(0, (10) + 1);
            
	        for (int i=0;i<thisWidth;i++) {
	            for (int j = startPoint; j < startPoint+randomNum; j++) {
	            	if(j<height&&i<width) {
		            	double r = pixels[j][i].getRed();
		                double g = pixels[j][i].getGreen();
		                double b = pixels[j][i].getBlue();
		                
		                
		                if (randomColour==0) {
		                	rgb = tintOne(r,g,b);
		                }
		                else if (randomColour==1) {
		                	rgb = tintTwo(r,g,b);
		                }
		                else if (randomColour==2) {
		                	rgb = tintThree(r,g,b);
		                }
		                else if (randomColour==3) {
		                	rgb = tintFour(r,g,b);
		                }
		                else if (randomColour==4) {
		                	rgb = tintFive(r,g,b);
		                }
		                else if (randomColour==5) {
		                	rgb = tintSix(r,g,b);
		                }
		                else if (randomColour==6) {
		                	rgb = tintSeven(r,g,b);
		                }
		                else if (randomColour==7) {
		                	rgb = tintEight(r,g,b);
		                }
		                else if (randomColour==8) {
		                	rgb = tintNine(r,g,b);
		                }
		                else {
		                	rgb = tintTen(r,g,b);
		                }
		                //double newGrey = (r+g+b)/3;
		                Color f = new Color(rgb[0],rgb[1],rgb[2],1.0);
		                pixels[j][i]=f;
	            	}
                }
            }
	        startPoint+=randomNum;
        }
        return pixels;
        }

    public Color[][] corruptorWrap(Color[][] pixels){
    	

        int randomH = ThreadLocalRandom.current().nextInt((int) (height/3), (int) ((height) + 1));
        int randomW = ThreadLocalRandom.current().nextInt((int) (width/3), (int) ((width) + 1));
        int randomCount = ThreadLocalRandom.current().nextInt((int) (0), (3) + 1);
        int random = ThreadLocalRandom.current().nextInt(0, 40 + 1);
        
        if(randomCount==0) {
	        for (int i=0;i<width;i++) {
	        	//CHANGE THIS VALUE TO CHANGE BLOCK SIZE
	        	if(i%100==0) {
	            	random = ThreadLocalRandom.current().nextInt(0, 40 + 1);
	        	}
	        	for (int j =0;j< height; j++) {
	            	if (j>40&&i>40&&i<width-40&&j<height-40) {
	            		pixels[j][i]=pixels[j+random][i];
	            	}	}
                }
	        return pixels;
        }
        else if(randomCount==1) {
	        for (int i=0;i<width;i++) {
	        	//CHANGE THIS VALUE TO CHANGE BLOCK SIZE
	        	if(i%100==0) {
	            	random = ThreadLocalRandom.current().nextInt(0, 40 + 1);
	        	}
	        	for (int j =0;j< randomH; j++) {
	            	if (j>40&&i>40&&i<width-40&&j<randomH-40) {
	            		pixels[j][i]=pixels[j+random][i];
	            	}	}
                }
	        return pixels;
        }
        
        else if(randomCount==2) {
	        for (int i=0;i<randomW;i++) {
	        	//CHANGE THIS VALUE TO CHANGE BLOCK SIZE
	        	if(i%100==0) {
	            	random = ThreadLocalRandom.current().nextInt(0, 40 + 1);
	        	}
	        	for (int j =0;j< height; j++) {
	            	if (j>40&&i>40&&i<randomW-40&&j<height-40) {
	            		pixels[j][i]=pixels[j+random][i];
	            	}	}
                }
	        return pixels;
        }
        
        else{
	        for (int i=0;i<randomW;i++) {
	        	//CHANGE THIS VALUE TO CHANGE BLOCK SIZE
	        	if(i%100==0) {
	            	random = ThreadLocalRandom.current().nextInt(0, 40 + 1);
	        	}
	        	for (int j =0;j< randomH; j++) {
	            	if (j>40&&i>40&&i<randomW-40&&j<randomH-40) {
	            		pixels[j][i]=pixels[j+random][i];
	            	}	}
                }
	        return pixels;
        }   
	        
        }        

    public Color[][] corruptorVert(Color[][] pixels){
        int startPoint=0;
    	double[] rgb = {0,0,0};
    	
    	
		
	    int randomH = ThreadLocalRandom.current().nextInt((int) (height/7), (int) ((height) + 1));
	    int randomW = ThreadLocalRandom.current().nextInt((int) (width/7), (int) ((width) + 1));
	    int randomCount = ThreadLocalRandom.current().nextInt((int) (0), (3) + 1);
	      
       	int thisHeight;
        int endPoint;
        
        if(randomCount==0) {
        	thisHeight=height;
        	endPoint=width;
        }
        else if (randomCount==1) {
        	thisHeight=randomH;
        	endPoint=width;
        }
        else if (randomCount==2) {
        	thisHeight=height;
        	endPoint=randomW;
        }
        else {
        	thisHeight=randomH;
        	endPoint=randomW;
        }
        
        while (startPoint+(width/150)<endPoint) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, (width/150) + 1);
            int randomColour = ThreadLocalRandom.current().nextInt(0, (5) + 1);
	        for (int i=0;i<thisHeight;i++) {
	            for (int j = startPoint; j < startPoint+randomNum; j++) {
	            	//System.out.println("i: "+i);
	            	//System.out.println("j: "+j);
	                double r = pixels[i][j].getRed();
	                double g = pixels[i][j].getGreen();
	                double b = pixels[i][j].getBlue();
	                if (randomColour==0) {
	                	rgb = tintOne(r,g,b);
	                }
	                else if (randomColour==1) {
	                	rgb = tintTwo(r,g,b);
	                }
	                else if (randomColour==2) {
	                	rgb = tintThree(r,g,b);
	                }
	                else if (randomColour==3) {
	                	rgb = tintFour(r,g,b);
	                }
	                else {
	                	rgb = tintFive(r,g,b);
	                }
	                //double newGrey = (r+g+b)/3;
	                Color f = new Color(rgb[0],rgb[1],rgb[2],1.0);
	                pixels[i][j]=f;
                }
            }
	        startPoint+=randomNum;
        }
        return pixels;
        }
    
    public void saveImage(Color[][] pixels, String filename) {
        WritableImage wimg = new WritableImage(width, height);
        PixelWriter pw = wimg.getPixelWriter();
       
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
            	
                pw.setColor(i, j, pixels[j][i]);
            }
        }
        BufferedImage bImage = SwingFXUtils.fromFXImage(wimg, null);
        try {
            ImageIO.write(bImage, "png", new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

















