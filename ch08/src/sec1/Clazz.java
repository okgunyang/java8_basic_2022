package sec1;
//다중상속 : implements 로 여러 개의 인터페이스로 부터 상속을 받을 수 있음
public class Clazz implements Interface1, Interface2 {
	@Override
	public void method1() { }

	@Override
	public int method2(int pa1, String pa2) { return 0;	}

	@Override
	public void method5() { }

	@Override
	public int method6(String a) {	return 0;	}
}
