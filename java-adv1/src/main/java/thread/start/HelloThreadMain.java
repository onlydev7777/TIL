package thread.start;

public class HelloThreadMain {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": main() start");

        HelloThread helloThread = new HelloThread();
        helloThread.start();
        System.out.println(name + ": main() end");
    }
}
