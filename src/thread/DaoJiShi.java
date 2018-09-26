package thread;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by fengshiwei on 2018/8/9.
 */
public class DaoJiShi {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime offWork = LocalTime.of(18, 00);
        long between = ChronoUnit.MINUTES.between(now, offWork);
        System.out.println(between);
    }
}
