package sec3;

public class FinalClass1 {
	final static double PI = 3.14; //멤버 상수
	static final byte MIN_VALUE = 0;
	static final byte MAX_VALUE = 100;
	final static double CIRCLE_LENGTH(){  //항상 같은 결과를 얻는 메서드
		return PI*100;
	}
}
