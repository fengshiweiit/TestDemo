package thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler{
    private ChildTest childTest;

    public ChildTest getChildTest() {
        return childTest;
    }

    public void setChildTest(ChildTest childTest) {
        this.childTest = childTest;
    }

    public ProxyHandler(ChildTest childTest) {
        this.childTest = childTest;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(childTest, args);
        System.out.println("after");
        return null;
    }
}
