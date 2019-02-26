// Matthew Clark
// CS360 - Operating Systems

// package Locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleMonitor
{
    private Lock lock = new ReentrantLock();
    // Lock must exist for condition to work.
    private Condition aboveZero = lock.newCondition();
    private int count;
    public void increment()
    {
        lock.lock();
        count++;
        System.out.println("Incremented to: " + count);
        if (count > 0)
        {
            aboveZero.signal();
        }
        lock.unlock();
    }
    public void decrement()
    {
        lock.lock();
        count--;
        System.out.println("Decremented to: " + count);
        lock.unlock();
    }
    public void print()
    {
        lock.lock();
        while (count <= 0)
        {
            try
            {
                aboveZero.await();
            }
            catch (InterruptedException e)
            {
            }
        }
        System.out.println("Printing: " + count);
        lock.unlock();
    }
}