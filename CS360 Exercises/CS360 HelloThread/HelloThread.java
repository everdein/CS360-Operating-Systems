// Matthew Clark
// CS360 - Operating Systems

public class HelloThread extends Thread
{
    public HelloThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        System.out.println("Hello from " + getName());
    }
}