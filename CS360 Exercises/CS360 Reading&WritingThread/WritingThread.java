// Matthew Clark
// CS360 - Operating Systems

import java.util.Random;

public class WritingThread extends Thread
{
	private BinarySemaphore sem;
	private int[] data;
    public WritingThread(String name, BinarySemaphore sem, int[] data) 
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
		int number = r.nextInt(10);
        for (int i = 0; i < data.length; i++) 
        {
			data[i] = i + number;
		}
        for (int i = 0; i < data.length; i++) 
        {
			System.out.print(data[i] + " ");
		}
		sem.v();
	}
}