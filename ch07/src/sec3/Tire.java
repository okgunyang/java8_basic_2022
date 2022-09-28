package sec3;

public class Tire {
	//멤버 필드
	public int maxRotation;	//최대 회전수(타이어 수명)
	public int accumulatedRotation;	//누적 회전수
	public String location;
	//생성자
	public Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	//멤버 메소드
	public boolean roll(){
		++accumulatedRotation;
		if(accumulatedRotation<maxRotation) {
			System.out.println(location + "Tire 수명 : "+(maxRotation-accumulatedRotation)+"회");
			return true;
		} else {
			System.out.println("**** "+location+" Tire 펑크 ****");
			return false;
		}
	}
	
}