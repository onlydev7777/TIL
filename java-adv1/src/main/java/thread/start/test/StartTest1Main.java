package thread.start.test;

import static util.MyLogger.*;

public class StartTest1Main {
    public static void main(String[] args) {
        log("main() start");

        CounterThread counterThread = new CounterThread();
        counterThread.start();

        log("main() end");
    }
    static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i=1; i<=5;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log("value : " + i);
            }
        }
    }
}
