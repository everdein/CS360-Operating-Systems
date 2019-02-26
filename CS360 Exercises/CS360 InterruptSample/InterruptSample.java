// Matthew Clark
// CS360 - Operating Systems

import java.lang.InterruptedException;
import java.util.Random;

public class InterruptSample
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread newThread = new Thread(() ->
        {
            for(int i = 0; i < 1E8; i++)
            {
                if(Thread.currentThread().isInterrupted())
                {
                    System.out.println("Stopped!");
                    break;
                }
                System.out.println("Math.sin("+i+")");
                Math.sin(new Random().nextDouble());
                System.out.println();
            }
        });
        newThread.start();
        Thread.sleep(500);
        newThread.interrupt();
        newThread.join();
        System.out.println("Done");
    }
}