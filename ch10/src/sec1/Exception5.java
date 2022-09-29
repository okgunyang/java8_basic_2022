package sec1;
//ClassNotFoundException : 지정한 클래스가 없거나 로딩이 되지 못한 경우 발생하는 경우로 반드시 예외처리
public class Exception5 {
	public static void main(String[] args) {
		try {
			Class cla = Class.forName("oracle.jdbc.driver");
		} catch (ClassNotFoundException e) {
			System.out.println("알 수 없는 클래스 또는 연결되지 않은 클래스");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("원인불명");
		} finally {
			System.out.println("종료");
		}
	}
}