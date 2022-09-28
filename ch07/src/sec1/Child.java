package sec1;

public class Child extends Parent {
	int field3;
	String field4;
	
	public Child() { }
	public Child(int field1){ super(field1); }
	public Child(int field1, String field2){
		this(field1, field2, 100);
	}
	public Child(int field1, String field2, int field3){
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	//메서드 오버라이딩 : 부모로 부터 물려 받은 메서드를 다른 형태로 변형할 수 있도록 한 것
	//오버라이딩시 주의점
	//부모의 메소드와 동일한 리턴 타입, 메소드 이름, 매개변수 리스트를 가져야 함
	//접근 제한을 더 강하게 오버라이딩할 수는 없으나 더 늘쓴하게 할 수는 있음
	//새로운 예외를 처리하거나 강제할 수 없음
	@Override
	public int method2() {
		return 1004;
	}
	public String method3() { return "문자열";	}
	public void method4() { System.out.println("메소드4"); }
}
