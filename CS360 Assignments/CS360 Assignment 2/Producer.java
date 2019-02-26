import java.util.Random;

// Matthew Clark
// CS360 - Operating Systems
// Assignment 3: Problem 1

public class Producer extends Thread
{
    private SharedDataStore dataStore;
    public Producer(SharedDataStore dataStore)
    {
        this.dataStore = dataStore;
    }
    @Override
    public void run()
    {
        while(true)
        {
            Random r = new Random();
            int number = r.nextInt(10);
            dataStore.producer(number);
        }
    }
}