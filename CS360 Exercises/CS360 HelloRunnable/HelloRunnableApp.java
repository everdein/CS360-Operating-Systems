// Matthew Clark
// CS360 - Operating Systems

public class HelloRunnableApp
{
    public static void main(String[] args)
    {
        Thread t = new Thread(new HelloRunnable("Thread-1"));
        t.start();
        Thread t2 = new Thread(new HelloRunnable("Thread-2"));
        t2.start();
    }
}