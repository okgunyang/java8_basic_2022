package sec1;
//FunctionalInterface 메소드를 기반으로 기능을 람다식으로 정의하여 활용 : 인터페이스를 선언하고, 추상체를 구현하므로써 람다식을 활용
public class Lambda1 {
	//일반 메소드 정의
	public int method1(int x, int y){
		return x+y;
	}
	/* 람다식 구현방식 정의 
	(x, y) -> { x+y };
	*/
	/*
	람다식 구현 종류  - 교재 689페이지
	Consumer : 매개값O 리턴값X
	Supplier : 매개값X 리턴값O
	Operator : 매개값O 리턴값O - 주로 매개값을 전달받아 처리(연산)하여 그 결과를 반환
				매개값과 리턴값의 데이터 타입이 주로 일치하는 경우
	Function : 매개값O 리턴값O - 주로 특정한 데이터 타입 매개값을 전달받아 처리(연산)하게 되면, 그 결과가 형변환되어 그 결과를 반환
			 	매개값의 데이터 타입과 리턴되는 결과의 데이터 타입이 다른 경우
	Predicate : 매개값O 리턴값의 데이터 타입이  논리형(true 또는 false) - 비교를 기반으로 하는 구현 종류
	*/
}
