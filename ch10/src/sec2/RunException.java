package sec2;
//UserException 클래스 정의
public class RunException extends Exception {
	public RunException() {} 
	public RunException(String message) {
		super(message+"사용자 정의");
	}
}