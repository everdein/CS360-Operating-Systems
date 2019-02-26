// Matthew Clark
// CS360 - Operating Systems

import java.lang.InterruptedException;

public class CountingSemaphore
{
    protected int count;
    public CountingSemaphore(int count)
    {
        this.count = count;
    }
    public synchronized void p()
    {
        count--;
        System.out.println("Waiting.");
        if(count < 0)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                return;
            }
        }
    }
    public synchronized void v()
    {
        count++;
        if(count <= 0)
        {
            System.out.println("Notify.");
            notify();
        }
    }
}