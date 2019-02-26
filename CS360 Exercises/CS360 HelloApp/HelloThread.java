// Matthew Clark
// CS360 - Operating Systems
// Exercise - Hello Thread

public class HelloThread extends Thread
{
    private int name;
    public HelloThread(int name)
    {
        this.name = name;
    }
    @Override
    public void run()
    {
        if(name <= 20)
        {
            Thread aThread = new HelloThread(name + 1);
            aThread.start();
            try
            {
                aThread.join();
            } 
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Hello from " + this.name);
        }
    }
}