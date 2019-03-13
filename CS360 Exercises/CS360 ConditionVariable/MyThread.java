// Matthew Clark
// CS360 - Operating Systems

public class MyThread extends Thread
{
    private SimpleMonitor sm;
    public MyThread(String name, SimpleMonitor sm)
    {
        super(name);
        this.sm = sm;
    }
    @Override
    public void run()
    {
        if(getName().equals("t1"))
        {
            sm.increment();
        }
        else if(getName().equals("t2"))
        {
            sm.decrement();
        }
        else
        {
            try
            {
                sm.print();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}