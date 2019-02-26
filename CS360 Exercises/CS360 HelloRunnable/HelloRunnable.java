// Matthew Clark
// CS360 - Operating Systems

public class HelloRunnable implements Runnable
{
    private String name; 
    public HelloRunnable(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        System.out.println("Hello from" + name);
    }
}