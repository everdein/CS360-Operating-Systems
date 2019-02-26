// Matthew Clark
// CS360 - Operating Systems
// Assignment 1 - Multithreaded Balls

// Imports.
import java.awt.Color;
import java.util.Random;
import javax.swing.*;
// Creates BallRunnable class and implements Runnable.
public class BallRunnable implements Runnable
{
    // Attributes.
    private Random rand = new Random();
    private int x;
    private int y;
    private int diameter;
    private int speed;
    private Color color;
    private int xVelocity;
    private int yVelocity;
    private BallPanel BallPanel;
    private JFrame JFrame;
    // Method BallRunnable declares attributes.
    public BallRunnable(int x, int y, BallPanel BallPanel, JFrame JFrame)
    {
        // Declarations.
        this.x = x;
        this.y = y;
        this.diameter = 20;
        this.speed = rand.nextInt(1)+2;
        this.color = new Color((int)(Math.random() * 0x1000000));
        this.xVelocity = rand.nextInt(10);
        this.yVelocity = rand.nextInt(10);
        this.BallPanel = BallPanel;
        this.JFrame = JFrame;
    }
    // Run creates the balls and moves the balls.
    @Override
    public void run()
    {
        // Gets ball.
        BallPanel.getBall(this);
        // Prints attributes of each ball created.
        System.out.println(this.x + ", " + this.y + ", " + this.diameter + ", " + this.speed + ", " + this.color + ", " + 
                           this.JFrame.getHeight() + ", " + this.JFrame.getWidth() + ", " + this.xVelocity + ", " + 
                           this.yVelocity + ", " + this.speed
                          );
        // While true the following if statements will take place.
        while (true) {
            // When the ball is going off the screen in the x and y negative
            // direction both xVelocity and yVelocity to a random positive number.
            if (this.x <= 0) {
                this.xVelocity = rand.nextInt(10);
            }
            if (this.y <= 0) {
                this.yVelocity = rand.nextInt(10);
            }
            // When the ball is going off the screen in the x direction both xVelocity 
            // and yVelocity are randomized and the xVelocity is reversed.
            if (this.x >= 500 - 20) {
                this.xVelocity = rand.nextInt(10);
                this.xVelocity = this.xVelocity * (-1);
            }
            // When the ball is going off the screen in the y direction both xVelocity 
            // and yVelocity are randomized and the yVelocity is reversed.
            if (this.y >= 500 - 45) {
                this.yVelocity = rand.nextInt(10);
                this.yVelocity = this.yVelocity * (-1);
            }
            // Modifies xVelocity and yVelocity.
            this.x += this.xVelocity;
            this.y += this.yVelocity;
            // Repaints BallPanel.
            BallPanel.repaint();
            // Provides smoothing for fast threads.
            try 
            {
                Thread.sleep(5);
            }
            // Catches interrupted exception.
            catch (InterruptedException e) 
            {
                // Helps the programmer to understand where the actual problem occurred.
                e.printStackTrace();
            }
        }
    }
    // Creates getX getter.
    public int getX()
    {
        return this.x;
    }
    // Creates getY getter.
    public int getY()
    {
        return this.y;
    }
    // Creates getDiameter getter.
    public int getDiameter()
    {
        return this.diameter;
    }
    // Creates getColor getter.
    public Color getColor()
    {
        return this.color;
    }

}