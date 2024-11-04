package thread.start;

import static util.MyLogger.*;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        log("run()");
    }
}
