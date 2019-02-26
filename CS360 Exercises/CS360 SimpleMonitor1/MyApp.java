// Matthew Clark
// CS360 - Operating Systems

public class MyApp 
{
    public static void main(String[] args) throws InterruptedException 
    {
        SimpleMonitor myMonitor = new SimpleMonitor();
        Thread t1 = new Thread(()-> 
        {
            try
            {
                myMonitor.produce();
            } 
            catch(InterruptedException e) 
            {
                // TODO Auto-generated catch blocke.printStackTrace();
            }
        });
        Thread t2 = new Thread(()-> 
        {
            try 
            {
                myMonitor.consume();
            } 
            catch(InterruptedException e) 
            {
                // TODO Auto-generated catch blocke.printStackTrace();
            }
        });
        Thread t3 = new Thread(()-> 
        {
            try 
            {
                myMonitor.produce();
            }
            catch(InterruptedException e) 
            {
                // TODO Auto-generated catch blocke.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}