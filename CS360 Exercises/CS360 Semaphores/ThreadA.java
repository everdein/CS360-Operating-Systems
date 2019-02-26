// Matthew Clark
// CS360 - Operating Systems

public class ThreadA extends Thread
{
    private CountingSemaphore sem;
    private int[] data;
    public ThreadA(String name, CountingSemaphore sem, int[] data)
    {
        super(name);
        this.sem = sem;
        this.data = data;
    }
    @Override
    public void run()
    {
        System.out.println(getName() + " is running");
        sem.p();
        criticalRegion();
        sem.v();
    }
    private void criticalRegion()
    {
        for(int i = 0; i < data.length; i++)
        {
            data[i] = i;
        }
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
}