// Matthew Clark
// CS360 - Operating Systems

public class HelloThreadApp
{
    private static HelloThread[] threads = new HelloThread[10];

    public static void main(String[] args) throws InterruptedException
    {
        for(int i = 0; i < threads.length; i++)
        {
            threads[i] = new HelloThread("Thread-" + i);
            threads[i].start();
        }
        for(int i = 0; i < threads.length; i++)
        {
            threads[i].join();
            System.out.println(threads[i].getName() + " returned");
        }
    }
}