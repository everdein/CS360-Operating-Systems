// Matthew Clark
// CS360 - Operating Systems

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleMonitor
{
    private final Lock lock = new ReentrantLock();
    private final Condition aboveZero = lock.newCondition();
    private int count = 0;

    public void increment()
    {
        lock.lock();
        try
        {
            count++;
            System.out.println("incremented to " + count);
            if(count > 0)
            {
                System.out.println("Signaling...");
                aboveZero.signal();
            }
        }
        finally
        {
            System.out.println("unlocked");
            lock.unlock();
        }
    }
    public void decrement()
    {
        lock.lock();
        try
        {
            count--;
            System.out.println("decremented to " + count);
        }
        finally
        {
            System.out.println("unlocked");
            lock.unlock();
        }
    }
    public void print() throws InterruptedException
    {
        lock.lock();
        try
        {
            while(count <= 0)
            {
                System.out.println("waiting");
                aboveZero.await();
                System.out.println(">>" + count);
            }
            System.out.println("printing..." + count);
        }
        finally
        {
            lock.unlock();
        }
    }
}