// Matthew Clark
// CS360 - Operating Systems
// Assignment 3: Problem 1

public class Consumer extends Thread
{
    private SharedDataStore dataStore;
    public Consumer(SharedDataStore dataStore)
    {
        this.dataStore = dataStore;
    }
    @Override
    public void run()
    {
        while(true)
        {
            dataStore.consumer();
        }
    }
}