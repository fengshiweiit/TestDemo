package thread;

/**
 * Created by fengshiwei on 2018/7/25.
 */
public class ThreadDemo1 implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
