// Matthew Clark
// CS360 - Operating Systems

public class SimpleThread extends Thread
{
    private int x = 0;

    public SimpleThread(String name)
    {
        super(name);
    }
    @Override
    public void run()
    {
        x++;
        System.out.println(x + " by thread" + getName());
    }
    public static void main(String[] args)
    {
        SimpleThread[] threads = new SimpleThread[20];
        for(int i = 0; i < threads.length; i++)
        {
            threads[i] = new SimpleThread(i + "");
            System.out.println(threads[i]);
        }
    }
}