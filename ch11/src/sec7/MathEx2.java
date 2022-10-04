package sec7;

public class MathEx2 {
	public static void main(String[] args) {
		int num;
		for(int i=0;i<5;i++){
			num = (int) (Math.random()*6) + 1;
			System.out.println("주사위 눈: " + num);
		}
	}
}