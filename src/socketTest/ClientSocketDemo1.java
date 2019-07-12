package socketTest;

import thread.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ClientSocketDemo1 {

    public static void main(String[] args) throws Exception {
//        List<Integer> list = new ArrayList<>();
//        CountDownLatch countDownLatch = new CountDownLatch(8000);
//        for (int i = 0; i < 8000; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    list.add(1);
//                    countDownLatch.countDown();
//                }
//            };
//            Thread thread = new Thread(runnable);
//            thread.start();
//        }
//        countDownLatch.await();
//        System.out.println(list.size());

//        Class<User> userClass = User.class;
//        List<String> list = new ArrayList<>();
//        User<String> objectUser = new User<>();
//        User<Integer> user = new User<>();
//        objectUser.setList(list);
//        Class<String> tClass = objectUser.getTClass();
//        Type type = ((ParameterizedType) objectUser.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        System.out.println(type);
//        Class aClass = objectUser.getClass();
//        Field field = aClass.getDeclaredField("t");
//        Type type = ((ParameterizedType)objectUser.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//
//        Type genericType = field.getGenericType();
//        ParameterizedType genericType1 = (ParameterizedType) genericType;
//        Type[] actualTypeArguments = genericType1.getActualTypeArguments();
//        for (Type actualTypeArgument : actualTypeArguments) {
//            Class actualTypeArgument1 = (Class) actualTypeArgument;
//            System.out.println(actualTypeArgument1);
//        }

        List<User> list = new ArrayList<>();
        list.add(new User(1,"aa",10));
        list.add(new User(1,"bb",10));
        list.add(new User(1,"cc",11));

        Function<User,User> function = (x -> {
            x.setName(x.getName() + "name");
            return x;
        });

        List<User> collect = list.stream().map(function).collect(toList());
        System.out.println(collect);


    }

    private static Function<List<User>,List<User>> addOne(List<User> list){
        Function<List<User>,List<User>> function = (a -> {
            a.forEach(x -> {
                x.setName(x.getName() + "name");
            });
            return a;
        });
        return function;
    }

}
