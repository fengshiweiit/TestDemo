package thread;

/**
 * Created by fengshiwei on 2018/7/25.
 */
public class ThreadCount implements Runnable{

    private Count count = new Count();

    @Override
    public synchronized void run() {
        int add = count.add();
//        System.out.println(add);
    }
}
