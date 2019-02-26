// Matthew Clark
// CS360 - Operating Systems
// Exercise - Chat App

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.io.InputStreamReader;

public class ClientThread extends Thread
{
    private Client client;
    private Socket socket;

    public ClientThread(Client client, Socket socket)
    {
        this.client = client;
        this.socket = socket;

        
    }

    @Override
    public void run()
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true)
            {
                try
                {
                    String message = in.readLine();
                    client.updateView(message);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
    }

}