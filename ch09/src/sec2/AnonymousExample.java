package sec2;

public class AnonymousExample {
	public static void main(String[] args) {
        Anonymous anony = new Anonymous();
        
        anony.field.run(); //필드를 이용한 익명 객체 만들기
        anony.method1();	//메소드를 이용한 익명 객체 만들기
        anony.method2(		//메소드의 매개변수를 이용한 익명 객체 만들기
    		new Vehicle(){
	            @Override
	            public void run(){
	                System.out.println("트럭이 달립니다.");
	            }
    		}
        );
	}
}