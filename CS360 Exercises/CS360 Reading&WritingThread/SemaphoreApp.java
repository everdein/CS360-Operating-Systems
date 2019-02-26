// Matthew Clark
// CS360 - Operating Systems

public class SemaphoreApp
{
    public static void main(String[] args) throws InterruptedException
    {
        int[] data = {-1, -1, -1, -1};
        BinarySemaphore binarySem = new BinarySemaphore(1);
        CountingSemaphore countingSem = new CountingSemaphore(2);
        WritingThread[] writingThreads = new WritingThread[2];
        for(int i = 0; i < writingThreads.length; i ++)
        {
            writingThreads[i] = new WritingThread("ThreadWrite-" + i, binarySem, data);
            writingThreads[i].start();
        }
        for(int i = 0; i < writingThreads.length; i++)
        {
            writingThreads[i].join();
        }
        ReadingThread[] readingThreads = new ReadingThread[10];
        for(int i = 0; i < readingThreads.length; i ++)
        {
            readingThreads[i] = new ReadingThread("ThreadRead-" + i, countingSem, data);
            readingThreads[i].start();
        }
        for(int i = 0; i < readingThreads.length; i++)
        {
            readingThreads[i].join();
        }
    }
}