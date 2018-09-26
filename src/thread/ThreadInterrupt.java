package thread;

/**
 * Created by fengshiwei on 2018/7/25.
 */
public class ThreadInterrupt implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            if (!Thread.currentThread().isInterrupted()){
                System.out.println(i + "==============");
            }
        }
    }
}
