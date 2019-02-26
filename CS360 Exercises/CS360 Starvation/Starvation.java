// Matthew Clark
// CS360 - Operating Systems

public class Starvation extends Thread
{
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            System.out.println(".");
        }
    }
    public void stillRunning(int n)
    {
        System.out.println("Thread #" + n + " is still running.");
    }
}