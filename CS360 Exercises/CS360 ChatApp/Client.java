// Matthew Clark
// CS360 - Operating Systems
// Exercise - Chat App

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client
{
    private JFrame frm = new JFrame("Chat App");
    private JPanel pnl = new JPanel();
    private JTextArea chatTxt = new JTextArea(20,3);
    private JTextField msgTxt = new JTextField(20);
    private String chatLog = "";

    public Client(int port)
    {
        try
        {
            Socket socket = new Socket("localhost", port);
            System.out.println("Client connected...");

            // Implement GUI
            pnl.setLayout(new BorderLayout());
            pnl.add(new JScrollPane(chatTxt), BorderLayout.CENTER);

            pnl.add(msgTxt, BorderLayout.SOUTH);
            frm.add(pnl);

            msgTxt.addKeyListener(new KeyListener(){
            
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }
            
                @Override
                public void keyReleased(KeyEvent e) 
                {
                    // Read client message from msgTxt.
                    // Send it to server.
                    // Using outstream of socket.
                    if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                        String message = msgTxt.getText();
                        PrintWriter outstream;
                        try
                        {
                            outstream = new PrintWriter(socket.getOutputStream());
                            outstream.println(message);
                            outstream.flush();
                        }
                        catch(IOException e1)
                        {
                            e1.printStackTrace();
                        }   
                    }
                }
            
                @Override
                public void keyPressed(KeyEvent e) {
                    
                }
            });

            frm.setPreferredSize(new Dimension(200, 200));
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setVisible(true);
            frm.pack();

            ClientThread cThread = new ClientThread(this, socket);
            cThread.start();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client(1234);
    }

    public void updateView(String message)
    {
        chatLog += message + "\n";
        chatTxt.setText(chatLog);
    }
}