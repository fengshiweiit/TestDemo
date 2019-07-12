package thread;

import java.util.concurrent.TimeUnit;

public class HookThread {

    public static void main(String[] args) {
        //当jvm结束的时候执行的线程，  钩子线程
        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            try {
                System.out.println("the hook thread 1 is running");
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("the hoot thread 1 will exit");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            try {
                System.out.println("the hook thread 2 is running");
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("the hoot thread 2 will exit");
        }));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("the main thread will exit");
    }
}
