// Matthew Clark
// CS360 - Operating Systems
// Assignment 2: Problem 1

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;
import java.util.LinkedList;

public class SharedDataStore 
{
    private Queue<Integer> queue = new LinkedList<>();
    private int maxSize;
    private Lock lock = new ReentrantLock();
    private Condition aboveZero = lock.newCondition();
    private Condition belowMax = lock.newCondition();

    public SharedDataStore(int maxSize) 
    {
        this.maxSize = maxSize;
    }

    public void produce(int n) 
    {
        lock.lock();
        while(queue.size() >= maxSize) 
        {
            try 
            {
                System.out.println("Producer wants to produce, but data store is full.");
                belowMax.await();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }

        }
        System.out.println("Producer: a new object is added: " + queue.add(n));
        System.out.println("Producer: Signalling that it is not empty.");
        aboveZero.signal();
        lock.unlock();
    }

    public void consume() 
    {
        lock.lock();
        while (queue.isEmpty()) 
        {
            try 
            {
                System.out.println("Consumer wants to consume, but it is empty.");
                aboveZero.await();
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer: an object is removed: " + queue.remove());
        System.out.println("Consumer: Signalling that it is not full.");
        belowMax.signal();
        lock.unlock();
    }
}