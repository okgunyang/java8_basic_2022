package sec1;
//Supplier Style Lambda - 리턴값만 있으므로 리턴값이 어떤 데이터 타입이냐에 따라 다름
import java.util.function.IntSupplier;

public class Lambda4 {
	public static void main(String[] args) {
		IntSupplier intSupplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};
		
		int num = intSupplier.getAsInt();
		System.out.println("눈의 수: " + num);
	}
}