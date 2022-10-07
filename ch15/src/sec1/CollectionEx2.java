package sec1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionEx2 {
	public static void main(String[] args) {
		List lst = new ArrayList();   //가장 적합
		lst = new Vector();
		lst = new LinkedList();
		
		ArrayList lst2 = new ArrayList(); //형제 형변환이 힘듦

		method1(lst);
		method1(lst2);
		//method2(lst); lst는 List로 선언된 것이며 메소드의 매개변수는 ArrayList로 선언되었기 때문에
		//형변환이 불가하여 사용할 수 없음
		method2(lst2);
	}
	static void method1(List ls){}
	static void method2(ArrayList ls){}
}