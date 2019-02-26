// Matthew Clark
// CS360 - Operating Systems
// Assignment 3: Problem 1

public class App
{
    public static void main(String[] args)
    {
        SharedDataStore dataStore = new SharedDataStore(5); // Max capacity.
        Producer producer = new Producer(dataStore);
        Consumer consumer = new Consumer(dataStore);
        producer.start();
        consumer.start();
    }
}