// Matthew Clark
// CS360 - Operating Systems

// package Locks;

public class MyApp
{
    public static void main(String[] args)
    {
        SimpleMonitor sm = new SimpleMonitor();
        Thread t1 = new Thread(() ->
        {
           sm.increment();
        });
        Thread t2 = new Thread(() ->
        {
            sm.decrement();
        });
        Thread t3 = new Thread(() ->
        {
            sm.print();
        });
        Thread t4 = new Thread(() ->
        {
            sm.increment();
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}