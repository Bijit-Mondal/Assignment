package codes.bijit;
class myownthread implements Runnable {
    Thread t;
    myownthread(String name)
    {
        t=new Thread(this, name);
        t.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Currently running the thread " + t + "value of i is " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Caught exception in thread " + t);
        }
    }
}
public class testthread {
    public static void main(String[] args) {
        myownthread mt=new myownthread("RKMVCC");
        try {
            System.out.println(mt.t.isAlive());
            mt.t.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Caught exception in thread " + mt.t);
        }
        myownthread moth=new myownthread("Bijit");
        try {
            moth.t.join();
        }
        catch (InterruptedException e)
        {
            System.out.println("Caught exception in thread " + moth.t);
        }
        System.out.println(mt.t.isAlive());
        System.out.println(moth.t.isAlive());
        System.out.println(Thread.currentThread());
    }
}
