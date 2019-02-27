// Matthew Clark
// CS360 - Operating Systems
// Assignment 2: Problem 1

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedDataStore 
{
    private Stack<Integer> stack = new Stack<>();
    private int maxSize;
    private Lock lock = new ReentrantLock();
    private Condition aboveZero = lock.newCondition();
    private Condition belowMax = lock.newCondition();

    public SharedDataStore(int maxSize) 
    {
        this.maxSize = maxSize;
        stack.setSize(maxSize);
    }

    public void produce(int n) throws InterruptedException 
    {
        lock.lock();
        while(stack.size() >= maxSize) 
        {
            System.out.println("Producer wants to produce, but data store is full.");
            belowMax.await();
        }
        System.out.println("Producer: a new object is added: " + stack.push(n));
        System.out.println("Producer: Signalling that it is not empty.");
        aboveZero.signal();
        lock.unlock();
    }

    public void consume() throws InterruptedException 
    {
        lock.lock();
        while (stack.isEmpty()) 
        {
            System.out.println("Consumer wants to consume, but it is empty.");
            aboveZero.await();
        }
        System.out.println("Consumer: an object is removed: " + stack.pop());
        System.out.println("Consumer: Signalling that it is not full.");
        belowMax.signal();
        lock.unlock();
    }
}