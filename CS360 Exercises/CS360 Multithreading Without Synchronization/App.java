// Matthew Clark
// CS360 - Operating Systems
// Multithreading example without Synchronization.

public class App
{
    public static void main(String[] args)
    {
        PrintDemo pd = new PrintDemo();
        for(int i = 0; i < 5; i++)
        {
            SampleThread t = new SampleThread("Thread " + i, pd);
            t.start();
        }
    }
}