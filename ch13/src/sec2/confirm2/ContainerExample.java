package sec2.confirm2;
//[ContainerExample.java]
public class ContainerExample {
    public static void main(String[] args) {
        Container<String> container1 = new Container<> ();
        container1.set("홍길동");
        String str = container1.get();
        
        Container<Integer> container2 = new Container<>();
        container2.set(6);
        int value = container2.get();
    }
}
//[Container.java]
class Container<T> {
    private T t;
 
    public T get() {
        return t;
    }
    public void set(T t) {
        this.t = t;
    }
}