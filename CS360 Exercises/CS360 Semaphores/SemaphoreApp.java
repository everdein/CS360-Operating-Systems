// Matthew Clark
// CS360 - Operating Systems

import java.lang.InterruptedException;

public class SemaphoreApp
{
    public static void main(String[] args) throws InterruptedException
    {
        int[] data = {-1, -1, -1, -1};
        BinarySemaphore sem = new BinarySemaphore(10);
        ThreadA[] threads = new ThreadA[10];
        for(int i = 0; i < threads.length; i++)
        {
            threads[i] = new ThreadA("Thread-" + i, sem, data);
            threads[i].start();
        }
        for(int i = 0; i < threads.length; i++)
        {
            // try
            // {
                threads[i].join();
            // }
            // catch(InterruptedException e)
            // {
            //     return;
            // }
        }
        ThreadA t1 = new ThreadA("Thread-1", sem, data);
        t1.start();
        ThreadA t2 = new ThreadA("Thread-2", sem, data);
        t2.start();
    }
}