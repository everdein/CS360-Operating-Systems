// Matthew Clark
// CS360 - Operating Systems

class Counter
{
    private int count = 0;
    public synchronized void increment()
    {
        count++;
    }
    public synchronized void decrement()
    {
        count--;
    }
    public synchronized int getValue()
    {
        return count;
    }
}