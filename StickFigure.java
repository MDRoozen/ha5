import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class StickFigure extends RandomShape{
    int[] xcords;
    int[] ycords;
    
    public StickFigure(int maxx, int maxy){
        super(maxx, maxy);
        
        int headSize=random.nextInt(6)+8;
        int headX=random.nextInt(maxx);
        int headY=random.nextInt(maxy);
        
        int lineWidth=2;
        int handLength=random.nextInt(20)+20;
        int bodyLength=random.nextInt(5)+30;
        
        ArrayList<Integer> xcordsa=new ArrayList<Integer>();
        ArrayList<Integer> ycordsa=new ArrayList<Integer>();
        
        for (int i=10;i<350;i+=7){
            xcordsa.add((int)(Math.sin(Math.toRadians(i))*headSize) + headX);
            ycordsa.add((int)(Math.cos(Math.toRadians(i))*headSize) + headY);
        }
        
        int handAngle=random.nextInt(70)+55;
        xcordsa.add((int)(-Math.sin(Math.toRadians(handAngle))*handLength) + headX);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY);
        xcordsa.add((int)(-Math.sin(Math.toRadians(handAngle))*handLength) + headX);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY + lineWidth);
        
        xcordsa.add(headX-lineWidth);
        ycordsa.add(headY+headSize+lineWidth);
        xcordsa.add(headX-lineWidth);
        ycordsa.add(headY+headSize+bodyLength);
        
        handAngle=random.nextInt(70)+5;
        
        xcordsa.add((int)(-Math.sin(Math.toRadians(handAngle))*handLength) + headX);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY + bodyLength);
        xcordsa.add((int)(-Math.sin(Math.toRadians(handAngle))*handLength) + headX + lineWidth);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY + bodyLength + lineWidth);
        
        xcordsa.add(headX);
        ycordsa.add(headY+headSize+bodyLength+3);
        
        handAngle=random.nextInt(70)+5;
        
        xcordsa.add((int)(Math.sin(Math.toRadians(handAngle))*handLength) + headX);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY + bodyLength);
        xcordsa.add((int)(Math.sin(Math.toRadians(handAngle))*handLength) + headX + lineWidth);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY + bodyLength - lineWidth);
        
        xcordsa.add(headX+lineWidth);
        ycordsa.add(headY+headSize+bodyLength);
        xcordsa.add(headX+lineWidth);
        ycordsa.add(headY+headSize+lineWidth);
        
        handAngle=random.nextInt(70)+55;
        xcordsa.add((int)(Math.sin(Math.toRadians(handAngle))*handLength) + headX + 5);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY + lineWidth);
        xcordsa.add((int)(Math.sin(Math.toRadians(handAngle))*handLength) + headX + 5);
        ycordsa.add((int)(Math.cos(Math.toRadians(handAngle))*handLength) + headY);
        
        xcords=new int[xcordsa.size()];
        ycords=new int[xcords.length];
        assert xcordsa.size()==ycordsa.size();
        for (int i=0; i<xcordsa.size(); i++){
            xcords[i]=xcordsa.get(i);
            ycords[i]=ycordsa.get(i);
        }
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.fillPolygon(xcords, ycords, xcords.length);
        g.setColor(Color.BLACK);
        g.drawPolygon(xcords, ycords, xcords.length);
    }
}

class RandomBinary extends RandomShape {
    
    int x;
    int y;
    String[] binary=new String[10];
    
    
    public RandomBinary(int maxx, int maxy){
        super(maxx, maxy);
        for (int i=0; i<binary.length; i++){
            binary[i]=Integer.toBinaryString(random.nextInt(256));
            while (binary[i].length()<8) {
                binary[i]+="0";
            }
            binary[i]=binary[i].substring(0,8);
        }
        x=random.nextInt(maxx+80)-40;
        y=random.nextInt(maxy+80)-40;
    }
    
    public void draw(Graphics g){
        
        FontMetrics metrics=g.getFontMetrics();
        int width=Math.max(metrics.charWidth('0'),metrics.charWidth('1'));
        int height=metrics.getHeight()+6;
        
        for (int i=0; i<(height*binary.length/2); i++){
            if (i<=binary.length*height/4){
                g.setColor(new Color(0,0,0, (i*255*2)/(binary.length*height)));
            }
            else {
                g.setColor(new Color(0,0,0, ((254/2-i)*255*2)/(binary.length*height)));
            }
            g.fillRect(x-5,y+i*2,width*8+10,2);
        }
        
        for (int i=0; i<binary.length; i++){
            g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (i*255)/binary.length));
            for (int j=0; j<8; j++){
                g.drawString(binary[i].substring(j,j+1), x+j*width, y+(i)*height+10);
            }
        }
    }
}

class Spiral extends RandomShape {
    int x;
    int y;
    int r;
    double startAngle;
    int length;
    
    double strech1;
    double strech2;
    
    public Spiral(int maxx, int maxy){
        super(maxx, maxy);
        x=random.nextInt(maxx);
        y=random.nextInt(maxy);
        length=random.nextInt(25)+10;
        startAngle=random.nextDouble()*Math.PI;
        
        strech1=random.nextDouble()*0.5 + 0.5;
        strech2=(random.nextDouble()*0.5+1)*strech1;
    }
    
    public void draw(Graphics g){
        int[] pointsx=new int[4];
        int[] pointsy=new int[4];
        
        double angledif=1/(double)length;
        
        for (int i=0; i<250; i++){
            double angle = (double)i / length;
            double innerradius=(double)i * strech1;
            double outerradius=(double)i * strech2;
            pointsx[0]=(int)(Math.sin(angle)*innerradius) + x;
            pointsy[0]=(int)(Math.cos(angle)*innerradius) + y;
            pointsx[1]=(int)(Math.sin(angle)*outerradius) + x;
            pointsy[1]=(int)(Math.cos(angle)*outerradius) + y;
            pointsx[2]=(int)(Math.sin(angle+angledif)*outerradius)+x;
            pointsy[2]=(int)(Math.cos(angle+angledif)*outerradius)+y;
            pointsx[3]=(int)(Math.sin(angle+angledif)*innerradius)+x;
            pointsy[3]=(int)(Math.cos(angle+angledif)*innerradius)+y;
            
            g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 255-i));
            g.fillPolygon(pointsx, pointsy, 4);
            g.drawPolygon(pointsx, pointsy, 4);
        }
    }
}