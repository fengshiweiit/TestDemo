package thread;

/**
 * Created by fengshiwei on 2018/8/6.
 */
public class OtherTest {

    public static void main(String[] args) {
//        long l = System.currentTimeMillis();
//        Integer sum = forkJoinTest();
//        long l1 = System.currentTimeMillis();
//        System.out.println(sum);
//        System.out.println(l1 - l);

        String a = "123";
        String replace = a.replace("123", "0");
        System.out.println(replace);
    }

    static Integer forkJoinTest(){
        int sum = 0;
        for (int i = 0; i <= 100000000; i++) {
            sum += i;
        }
        return sum;
    }
}
