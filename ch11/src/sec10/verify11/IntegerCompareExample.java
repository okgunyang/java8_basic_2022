package sec10.verify11;

public class IntegerCompareExample {
	public static void main(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;
		//-128~127 범위의 데이터는 비교하면, 같다고 할 수 있지만 
		//해당 1바이트 범위(-128~127)를 벗어난 데이터는 비교가 서로 다른 값으로 이루어짐
		System.out.println( obj1 == obj2 );
		System.out.println( obj3 == obj4 );
	}
}