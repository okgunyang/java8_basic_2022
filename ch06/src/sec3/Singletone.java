package sec3;
/* 싱글톤 : 자바 디자인 패턴 중에서 오로지 하나의 객체만 생성할 수 있도록 하는 객체 지향 프로그래밍 패턴 */
public class Singletone {
	private static Singletone single = new Singletone();
	private Singletone() {}
	static Singletone getInstance(){
		return single;
	}
}