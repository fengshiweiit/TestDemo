package thread;

/**
 * Created by fengshiwei on 2018/7/25.
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return threadLocal;
    }

    public int getNext() {
        Integer integer = threadLocal.get();
        threadLocal.set(integer + 1);
        return threadLocal.get();
    }

    public static void main(String[] args) {

    }
}
