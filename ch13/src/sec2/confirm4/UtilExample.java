package sec2.confirm4;
//[UtilExample.java]
public class UtilExample {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("홍길동",35);
        Integer age = Util.getValue(pair, "홍길동");
        System.out.println(age);
        
        ChildPair<String,Integer> childPair = new ChildPair<>("홍삼원",20);
        Integer childAge = Util.getValue(childPair,"홍삼순");
        System.out.println(childAge);
        
        /*OtherPair<String,Integer> otherPair = new OtherPair<>("홍삼원",20);
         * OtherPair는 Pair를 상속하지 않으므로 예외가 발생해야 합니다.
         * int otherAge = Util.getValue(otherPair,"홍삼원");
         * System.out.println(otherAge);
         */
 
    }
}
//[Pair.java]
class Pair<K, V> {
    private K k;
    private V v;
    
    public Pair (K k, V v) {
        this.k = k;
        this.v = v;
    }
    
    public K getKey() {
        return k;
    }
    public V getValue() {
        return v;
    }
}

//[ChildPair.java]
class ChildPair<K,V> extends Pair<K,V> {
    
    public ChildPair (K k, V v) {
        super(k,v);
    }
}

//[Util.java]
class Util {
    // 방법 1
    public static <K,V> V getValue(Pair<K,V> p, K k) {
        if (p.getKey() == k) {
            return p.getValue();
        } else {
            return null;
        }
    }
    
    // 방법 2
//    public static <P extends Pair<K,V>, K , V> V getValue(P p, K k) {
//	    if (p.getKey() == k) {
//	        return p.getValue();
//	    } else {
//	        return null;
//	    }
//    }
}