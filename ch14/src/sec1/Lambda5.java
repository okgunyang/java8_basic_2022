package sec1;
//Operator Style Lambda - 매개값과 리턴값이 각 각 어떤 데이터 타입이냐에 따라 여러 종류가 있음
import java.util.function.IntBinaryOperator;

public class Lambda5 {
	private static int[] scores = { 92, 95, 87 };
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for(int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
	
	public static void main(String[] args) {
		//최대값 얻기
		int max = maxOrMin(
			(a, b) -> {
				if(a>=b) return a;
				else return b;
			}
		);
		System.out.println("최대값: " + max);
		
		//최소값 얻기
		int min = maxOrMin(
			(a, b) -> {
				if(a<=b) return a;
				else return b;
			}
		);
		System.out.println("최소값: " + min);
	}
}