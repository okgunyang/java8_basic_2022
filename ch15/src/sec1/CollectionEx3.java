package sec1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionEx3 {
	public static void main(String[] args) {
		Set set1 = new HashSet();
		set1 = new TreeSet();
		
		HashSet set2 = new HashSet();
		//set2 = new TreeSet(); 형변환이 힘듦
		
		method1(set1);
		method1(set2);
		//method2(set1);
		method2(set2);
	}
	static void method1(Set s){ }
	static void method2(HashSet s){ }
}