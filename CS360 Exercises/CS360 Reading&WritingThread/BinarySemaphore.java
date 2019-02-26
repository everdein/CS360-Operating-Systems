// Matthew Clark
// CS360 - Operating Systems

public class BinarySemaphore extends CountingSemaphore
{
    public BinarySemaphore(int count)
    {
        super(count>=1?1:0);
    }
    @Override
    public synchronized void v()
    {
        super.v();
        if(count>1)
        {
            count = 1;
        }
    }
}