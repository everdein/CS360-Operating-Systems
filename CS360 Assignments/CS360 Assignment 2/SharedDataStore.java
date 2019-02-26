// Matthew Clark
// CS360 - Operating Systems
// Assignment 3: Problem 1

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedDataStore
{
    private Producer producer;
    private Consumer consumer;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private int[] data = {-1};
    private int count = 0;


    private int number;
    public SharedDataStore(int number)
    {
        this.number = number;
    }

    public void produce() throws InterruptedException 
    {
        lock.lock();
        if(data[0] == -1) 
        {
            System.out.println("producer produced");
            data[0] = (int) Math.random();
            full.signal();
        }
        else 
        {
            System.out.println("full already");
            empty.await();
        }
        lock.unlock();
    }
    
    public void consume() throws InterruptedException 
    {
        lock.lock();
        if(data[0] == -1) 
        {
            System.out.println("empty already");
            full.await();
        }
        else 
        {
            System.out.println("consumer consumed");
            data[0]=-1;
            empty.signal();
        }
        lock.unlock();
    }
}