package thread;


import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void test() {
        ParentInterface o = (ParentInterface) Proxy.newProxyInstance(ParentInterface.class.getClassLoader()
                , new Class<?>[]{ParentInterface.class}, new ProxyHandler(new ChildTest()));
        o.eat("rice");

    }
}
