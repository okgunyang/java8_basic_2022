package sec1;
//Syntax Error, Runtime Error
//실행시 불거져 나오는 에러들 중 예외 사항들은 미리 사전에 알아서 예외 처리를 해야함
public class Exception3 {
	public static void main(String[] args) {
		String data1 = "1004";
		String data2 = "kim1004";
		
		try {
			int val1 = Integer.parseInt(data1);	//1004
			int val2 = Integer.parseInt(data2);	//kim1004
			
			System.out.println(val1);
			System.out.println(val2);
			System.out.println(val1+20);
		} catch(NumberFormatException e){
			System.out.println("숫자 형식 데이터가 아니므로 처리되지 못했음");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("알 수 없는 예외");
		} finally {
			System.out.println("종료");
		}
	}
}