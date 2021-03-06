import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * the mother of all random shapes
 *
 * @author huub
 */
abstract class RandomShape {  
    static Random random = new Random();
    
    /** color used for drawing this shape **/
    protected Color color;  
    /** position of the shape (upper left corner) **/
    protected int x, y;  
    
    /**
     * initializes color and position to random values
     * 
     * @param maxX, maxY give maximum values for the position
     */
    public RandomShape( int maxX, int maxY ) {
        // initialize to a random position
        x = random.nextInt(maxX);
        y = random.nextInt(maxY);
        // initialize to a random color
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        color = new Color(r,g,b); 
    }
    
    abstract void draw(Graphics g);
}