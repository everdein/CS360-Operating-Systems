// Matthew Clark
// CS360 - Operating Systems

import java.util.Random;

public class ReadingThread extends Thread
{
    private CountingSemaphore sem;
    private int[] data;
    public ReadingThread(String name, CountingSemaphore sem, int[] data)
    {
        super(name);
        this.sem = sem;
        this.data = data;
    }
    @Override
    public void run()
    {
        sem.p();
        Random r = new Random();
        int index = r.nextInt(data.length);
        System.out.println(getName() + " reading: " + data[index]);
        sem.v();
    }
}