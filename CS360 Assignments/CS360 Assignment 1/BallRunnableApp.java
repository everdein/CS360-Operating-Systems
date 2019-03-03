// Author: Matthew Clark
// Date: 03/03/2019
// Description: CS360 - Operating Systems | Assignment 1 - Multithreaded Balls

// Imports.
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
// Creates BallRunnableApp class.
public class BallRunnableApp
{
    // Attributes.
    private static JFrame frame = new JFrame("Multithreaded Ball App");
    private static BallPanel panel = new BallPanel();
    private BallPanel BallPanel;
    private BouncingBallApplication BouncingBallApplication;

    public BallRunnableApp()
    {
        // Creates mouse listener to allow the user to interract with the window.
        panel.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseReleased(MouseEvent e){}
            @Override
            public void mousePressed(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mouseEntered(MouseEvent e){}
            // Waits for mouse click.
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                Thread thread = new Thread(new BouncingBallApplication(e.getX(), e.getY(), panel, frame));
                thread.start();
                BallPanel.getBall();
            }
        });
        // Sets black background.
        panel.setBackground(Color.BLACK);
        // Sets window Size.
        frame.setSize(500, 500);
        // Adds panel to window.
        frame.add(panel);
        // Sets window to visitble.
        frame.setVisible(true);
    }
    // Main method.
    public static void main(String[] args)
    {
        BallRunnableApp app = new BallRunnableApp();

    }
}