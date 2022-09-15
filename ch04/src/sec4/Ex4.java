package sec4;

public class Ex4 {
	//랜덤수 : 아무수나
	public static void main(String[] args) {
		int a=0, b=0;
		while(a+b!=5){
			a = (int) (Math.random()*6)+1; //1~6 까지의 아무 수
			b = (int) (Math.random()*6)+1;
			System.out.println("("+a+", "+b+")");
		}
		/* 로또 번호 추출 */
		for(int i=0;i<6;i++){
			int su = (int) (Math.random()*45)+1;
			System.out.println(su);
		}
	}
}