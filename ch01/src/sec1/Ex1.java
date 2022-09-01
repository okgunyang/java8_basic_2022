package sec1;

//메인실행클래스 - 한 줄 각주로 빈 줄이나 코드의 끝 부분에 입력
public class Ex1 {  //Ex1:클래스명, { }:프로그램 블록의 시작과 끝
	/*
		여러 줄 각주
		각주 : 프로그램의 실행과 무관한 설명(Comment == Description)
	 */
	public static void main(String[] args) { 
		//main(){} : main 메서드
		//main의 괄호() 안에 있는 args는 매개변수
		System.out.println("하이~! 자바~!");
		Ex2 ex2 = new Ex2();
		ex2.method1();
		Ex3 st1 = new Ex3();
		st1.setName("김기태");
		st1.setKor(100);
		st1.setMat(100);
		st1.setEng(80);
		System.out.println("st1의 학생 이름은 "+st1.getName());
	}
}