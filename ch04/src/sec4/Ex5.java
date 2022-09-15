package sec4;

public class Ex5 {
	public static void main(String[] args) {
		//4x+5y=60 - x와 y에 특정 값을 대입하였을 경우에 계산결과가 60이 되는 해를 구하라
		for(int x=1;x<=10;x++){
			for(int y=1;y<=10;y++){
				if(4*x+5*y==60) System.out.println("("+x+","+y+")");
			}
		}
	}
}