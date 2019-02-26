// Matthew Clark
// CS360 - Operating Systems

import java.lang.InterruptedException;
import java.io.IOException;
public class ThreadSleep
{
    public static void main(String[] args) throws InterruptedException
    {
        String[] days = {"M","T","W","Th","F","S","Su"};
        for(int i = 0; i < days.length; i++)
        {
            System.out.println(days[i]);
            try
            {
                Thread.sleep(400);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        if(Thread.interrupted())
        {
            return;
        }
    }
}