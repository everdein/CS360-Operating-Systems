// Matthew Clark
// CS360 - Operating Systems
// Quiz 1 Math Threads

public class MathSin extends Thread
{
    private double value;
    public MathSin(double value)
    {
        this.value = value;
    }
    @Override
    public void run()
    {
        System.out.println(value);
    }
}