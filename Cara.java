import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * starter file for Random Artist hoework assignment
 * 
 * code has to be added by you 
 * 
 * @author huub & kees
 */

public class Cara extends JPanel implements ActionListener {
    Random random = new Random();
    ArrayList<RandomShape> shapes;
    //...
    
    public Cara() {
        setPreferredSize(new Dimension(400,300)); // make panel 400 by 300 pixels
        // ... 
    }

    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);     // clears the background
        // draw all shapes       
        // ...
        g.setColor(Color.WHITE);
        g.fillRect(0,0,400,300);
      for (RandomShape s : shapes){
          s.draw(g);
        }
    }

    /**
     * redraws the Cara JPanel, when the button is pressed. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        regenerate();
        repaint();
    }

    public void regenerate() {
      // clear the shapes list
      //...
      shapes = new ArrayList<RandomShape>();
      // create random shapes 
      // ... 
      
      int no = random.nextInt(21) +10;
      for(int i = 0; i<no;i++){
        int choice = random.nextInt(2);
        if(choice == 0){
        shapes.add(new Rectangle(400,300));
        }else if(choice == 1){
        shapes.add(new Line(400,300));
        }
      }
    }
}
