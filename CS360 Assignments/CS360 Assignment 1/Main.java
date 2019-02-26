// Matthew Clark
// CS360 - Operating Systems
// Assignment 1 - Multithreaded Balls

// Imports.
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.*;
// Creates Main class.
public class Main
{
    // Attributes.
    private static JFrame frame = new JFrame("Multithreaded Ball App");
    private static BallPanel panel = new BallPanel();
    // Window method creates window.
    public static void Window()
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
                Thread thread = new Thread(new BallRunnable(e.getX(), e.getY(), panel, frame));
                thread.start();
            }
        });
        // Sets window Size.
        frame.setSize(500, 500);
        // Adds panel to window.
        frame.add(panel);
        // Sets window to visitble.
        frame.setVisible(true);
    }
    // Main method calls window method and repaints window.
    public static void main(String[] args)
    {
        // Calls method Window.
        Window();
        // While true the panel will repaint.
        while(true)
        {
            // Repaints panel.
            panel.repaint();
        }
    }
}