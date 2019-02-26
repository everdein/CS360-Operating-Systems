// Matthew Clark
// CS360 - Operating Systems

public class CounterThreadSample
{
    public static void main(String[] args)
    {
        Counter counter = new Counter();
        Thread t1 = new Thread(()->
        {
            counter.increment();
        });
        Thread t2 = new Thread(() ->
        {
            counter.increment();
        });
        t1.start();
        t2.start();

            System.out.println(counter.getValue());
    }
}