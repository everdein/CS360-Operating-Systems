// Matthew Clark
// CS360 - Operating Systems
// Quiz 1 Math Threads

public class MathCos implements Runnable
{
    private double value;
    public MathCos(double value)
    {
        this.value = value;
    }
    @Override
    public void run()
    {
        System.out.println(value);
    }
}