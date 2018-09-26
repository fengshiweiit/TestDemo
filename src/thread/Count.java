package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by fengshiwei on 2018/7/25.
 */
public class Count {

    private int num = 0;

//    Lock lock = new ReentrantLock();

    ReadWriteLock lock = new ReentrantReadWriteLock();

    public int add(){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = num++;
        return i;
    }

    public void get() {
        lock.readLock().lock();
        System.out.println("get begin==============" + Thread.currentThread().getName());
        try {
            Thread.sleep(79);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get end==============" + Thread.currentThread().getName());
        lock.readLock().unlock();
    }

    public void put() {
        lock.writeLock().lock();
        System.out.println("put begin==============" + Thread.currentThread().getName());
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("put end==============" + Thread.currentThread().getName());
        lock.writeLock().unlock();
    }
}
