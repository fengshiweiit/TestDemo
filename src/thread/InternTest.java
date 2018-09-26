package thread;

/**
 * Created by fengshiwei on 2018/8/16.
 */
public class InternTest {

    public static void main(String[] args) {
//        String str1 = new String("a")+ new String("b");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "ab");

        //这段代码会在常量池中生成ab字符串
//        String str2 = "ab";
//        //这段代码会在在堆里生成ab的对象 还会在常量池中生成a,b
//        String str1 = new String("a")+ new String("b");
//        //srr1.intern()会在常量池中找到ab所以这个引用执行了str2
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1 == "ab");

//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);

//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();
//        System.out.println(s3 == s4);

        String str1 = new StringBuilder("刘").append("文涛").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);


    }
}
