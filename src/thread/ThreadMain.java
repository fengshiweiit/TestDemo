package thread;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fengshiwei on 2018/7/25.
 */
public class ThreadMain {
    
    public static void main(String[] args) throws Exception {
//        List<String> list = Arrays.asList("a", "b");
//        String s = list.toString();
//        System.out.println(s);
        //ThreadDemo1
//        ThreadDemo1 threadDemo1 = new ThreadDemo1();
//        for (int i = 0; i < 5; i++) {
//            new Thread(threadDemo1,i + "线程==========").start();
//        }
//        Thread thread = Thread.currentThread();
//        new Thread(thread).start();
//        System.out.println(thread.getName());

        //ThreadInterrupt
//        ThreadInterrupt threadInterrupt = new ThreadInterrupt();
//        Thread thread = new Thread(threadInterrupt);
//        thread.start();
//        System.out.println("线程是否已经被中断了=================" + thread.isInterrupted());
//        //在主线程中给threadInterrupt的状态设置为了中断状态,但此时线程并没有真正的中断 要其自己手动中断才算中断
//        Thread.sleep(1);
//        thread.interrupt();
//        System.out.println("线程是否已经被中断了=================" + thread.isInterrupted());

        //ThreadCount
//        ThreadCount threadCount = new ThreadCount();
//        //创建5个线程去执行任务
//        for (int i = 0; i < 1000; i++) {
//            new Thread(threadCount).start();
//        }

        //ThreadLock
//        Count count = new Count();
//        for (int i = 0; i < 2; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    count.get();
//                }
//            }.start();
//        }
//        Thread.sleep(10);
//        for (int i = 0; i < 2; i++) {
//            new Thread() {
//                @Override
//                public void run() {
//                    count.put();
//                }
//            }.start();
//        }
    }

}
