package thread.start;

public class HelloThread extends Thread {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": HelloThread.run()");
    }
}
