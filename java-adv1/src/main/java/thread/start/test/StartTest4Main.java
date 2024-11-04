package thread.start.test;

import static util.MyLogger.*;

public class StartTest4Main {
    public static void main(String[] args) {
        log("main() start");


            Thread threadA = new Thread(()->{
                try {
                    while (true){
                        Thread.sleep(1000);
                        log("A");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Thread-A");
            threadA.start();

            Thread threadB = new Thread(()->{
                try {
                    while (true){
                        Thread.sleep(500);
                        log("B");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Thread-B");
            threadB.start();
    }
}
