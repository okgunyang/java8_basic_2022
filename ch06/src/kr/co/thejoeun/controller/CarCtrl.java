package kr.co.thejoeun.controller;

//import kr.co.thejoeun.*;

public class CarCtrl {
	//CarDTO car1 = new CarDTO();
	public int item1=1;
	int item2=2;
	protected int item3=3;
	private int item4=4;
	/*
	public > protected > default > private
	다른 패키지에서 접근하는 경우 해당 클래스를 import 해야 함
	public : 모든 패키지에서 접근 가능하며, 클래스/필드/생성자/메소드에 지정 
	protected : 상속 관계에 있는 자식클래스 또는 같은 패키지에 있는 클래스에서 접근 가능하며, 
		필드/생성자/메서드에 지정 
		(단, 다른 패키지에 있는 자식클래스에서 접근할 경우 super 키워드로 접근해야함)
	default : 같은 패키지에 있는 클래스에서 접근 가능하며, 클래스/필드/생성자/메소드에 지정이 가능
		지정시에는 접근제한자를 생략하면 지정됨
	private : 같은 클래스에서만 접근 가능, 필드/생성자/메소드에 지정이 가능
	 */
}