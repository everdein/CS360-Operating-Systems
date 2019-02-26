// Matthew Clark
// CS360 - Operating Systems

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
        while(count < 0)
        {
            try
            {
                System.out.println("Waiting");
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
            System.out.println("Notify...");
            notify();
        }
    }
}