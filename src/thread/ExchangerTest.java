package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by fengshiwei on 2018/9/26.
 */

//线程会阻塞在Exchanger的exchange方法上，直到另外一个线程也到了同一个Exchanger的exchange方法时，
// 二者进行数据交换，然后两个线程继续执行自身相关的代码。
public class ExchangerTest {

    public static void main(String[] args) {
        List<Object> buffer1 = new ArrayList<>();
        List<Object> buffer2 = new ArrayList<>();

        //交换数据
        Exchanger<String> exchanger = new Exchanger<String>();

        Producer producer = new Producer("111", exchanger);
        Producer producer1 = new Producer("222", exchanger);

        new Thread(producer).start();
        new Thread(producer1).start();
    }
}
