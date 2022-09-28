package sec2;

class A {}
class B extends A { }
class C extends A { }

class D extends B { }
class E extends C { }
public class PromotionEx {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		//다형성 : 부모 클래스에서 가진 내용들을 상속 받아 자식 클래스에서 다양하게 활용할 수 있음.
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = b;
		//B b2 = c;
		B b3 = d;
		//B b4 = e;
		
		//그러므로 부모자식관계 상에서만 객체를 생성하거나 형변환이 가능함
		//자식부모 관계 상에서는 자동 캐스팅 할 수 없으므로 강제 캐스팅해야 함
		//형제관계는 자동 캐스팅이나 강제 캐스팅될 수 없다.
	}
}