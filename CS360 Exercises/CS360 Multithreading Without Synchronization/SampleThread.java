// Matthew Clark
// CS360 - Operating Systems
// Multithreading example without Synchronization.

public class SampleThread extends Thread
{
    PrintDemo pd;
    public SampleThread(String name, PrintDemo pd)
    {
        super(name);
        this.pd = pd;
    }
    @Override
    public void run()
    {
        System.out.println(getName() + " is printing...");
        pd.printCount();
    }
}