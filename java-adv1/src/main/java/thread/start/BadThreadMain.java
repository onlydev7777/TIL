package thread.start;

public class BadThreadMain {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": main() start");

        HelloThread helloThread = new HelloThread();
        helloThread.run();
        System.out.println(name + ": main() end");
    }
}
