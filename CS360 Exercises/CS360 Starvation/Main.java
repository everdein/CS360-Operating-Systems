// Matthew Clark
// CS360 - Operating Systems

class Main
{
    public static void main(String[] args)
    {
        Starvation thread1 = new Starvation();
        thread1.setPriority(10);
        Starvation thread2 = new Starvation();
        thread2.setPriority(10);
        Starvation thread3 = new Starvation();
        thread3.setPriority(10);
        Starvation thread4 = new Starvation();
        thread4.setPriority(10);
        Starvation thread5 = new Starvation();
        thread5.setPriority(10);
        Starvation thread6 = new Starvation();
        thread6.setPriority(10);
        Starvation thread7 = new Starvation();
        thread7.setPriority(10);
        Starvation thread8 = new Starvation();
        thread8.setPriority(10);
        Starvation thread9 = new Starvation();
        thread9.setPriority(10);
        Starvation thread10 = new Starvation();
        thread10.setPriority(10);
        Starvation thread11 = new Starvation();
        thread11.setPriority(1);

        thread1.start();
        System.out.println("Thread #1 is now running.");
        thread2.start();
        System.out.println("Thread #2 is now running.");
        thread3.start();
        System.out.println("Thread #3 is now running.");
        thread4.start();
        System.out.println("Thread #4 is now running.");
        thread5.start();
        System.out.println("Thread #5 is now running.");
        thread6.start();
        System.out.println("Thread #6 is now running.");
        thread7.start();
        System.out.println("Thread #7 is now running.");
        thread8.start();
        System.out.println("Thread #8 is now running.");
        thread9.start();
        System.out.println("Thread #9 is now running.");
        thread10.start();
        System.out.println("Thread #10 is now running.");
        thread11.start();
        System.out.println("Thread #11 is now running.");

        thread1.stillRunning(1);
        thread1.stillRunning(2);
        thread1.stillRunning(3);
        thread1.stillRunning(4);
        thread1.stillRunning(5);
        thread1.stillRunning(6);
        thread1.stillRunning(7);
        thread1.stillRunning(8);
        thread1.stillRunning(9);
        thread1.stillRunning(10);
        thread1.stillRunning(11);
    }
}

