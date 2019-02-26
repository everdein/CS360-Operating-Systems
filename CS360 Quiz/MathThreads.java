// Matthew Clark
// CS360 - Operating Systems
// Quiz 1 Math Threads

class MathThreads 
{
    public static void main(String[] args)
    {
        MathSin st = new MathSin(45);
        Thread ct = new Thread(new MathCos(30));
        st.start();
        ct.start();
        try
        {
            st.join();
            ct.join();
        }
        catch(InterruptedException IntExp)
        {
            IntExp.printStackTrace();
        }
    }
}