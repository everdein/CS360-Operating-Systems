// Author: Matthew Clark
// Date: 03/03/2019
// Description: CS360 - Operating Systems | Assignment 1 - Multithreaded Balls


// Imports.
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
// Creates BallPanel class and extends Jpanel.
public class BallPanel extends JPanel
{
    // This is where ball objects are stored.
    private ArrayList<BouncingBallApplication> ballArrayList = new ArrayList<>();
    // Paint method paints the balls.
    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);
        for(int i = 0; i < ballArrayList.size() - 1; i++)
        {
            // Sets the ball color.
            g.setColor(ballArrayList.get(i).getColor());
            // Draws ball parameters.
            g.fillOval(ballArrayList.get(i).getX(), ballArrayList.get(i).getY(), ballArrayList.get(i).getDiameter(), ballArrayList.get(i).getDiameter());
        }
    }
    // Adds ball object to array.
    public void getBall(BouncingBallApplication ball)
    {
        ballArrayList.add(ball);
    }
}