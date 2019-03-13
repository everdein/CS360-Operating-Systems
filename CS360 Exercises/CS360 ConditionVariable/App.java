// Matthew Clark
// CS360 - Operating Systems

public class App
{
    public static void main(String[] args)
    {
        SimpleMonitor sm = new SimpleMonitor();
        MyThread t1 = new MyThread("t1", sm);
        MyThread t2 = new MyThread("t2", sm);
        MyThread t3 = new MyThread("t3", sm);
        t1.start();
        t2.start();
        t3.start();
    }
}