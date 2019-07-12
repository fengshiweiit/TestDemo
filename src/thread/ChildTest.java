package thread;

public class ChildTest implements ParentInterface{

    @Override
    public void eat(String food) {
        System.out.println("eat " + food);
    }
}
