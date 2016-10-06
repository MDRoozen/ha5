import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Rectangle extends RandomShape{
  int x1;
  int y1;
  
  
  Rectangle(int maxX, int maxY){
    super(maxX,maxY);
    x1 = 5 + random.nextInt(10);
    y1 = 5 + random.nextInt(10);
    
    
  }
  
  @Override
  public void draw(Graphics g){
    g.setColor(color);
    g.fillRect(x,y,x1,y1);
  }
}