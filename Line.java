import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Line extends RandomShape{
  int x1;
  int y1;
  int no;
  int[] xval;
  int[] yval;
  
  Line(int maxX, int maxY){
    super(maxX,maxY);
    no = 2+random.nextInt(2);
    xval = new int[no];
    yval = new int[no];
    
    for(int i=0;i<no;i++){
      xval[i] = -10+random.nextInt(maxX+20);
      yval[i] = -10+random.nextInt(maxY+20);
    }
    
  }
  
  @Override
  public void draw(Graphics g){
    g.setColor(color);
    g.drawPolyline(xval,yval, yval.length);
  }
}