package sec3;

public class MotorCycle {
	Tire frontTire = new Tire(8, "앞");
	Tire backTire = new Tire(6, "뒤");
	
	public MotorCycle() {}
	
	public int run() {
		System.out.println("---- 오토바이가 달립니다. ----");
		if(frontTire.roll()==false) { stop(); return 1; }
		if(backTire.roll()==false) { stop(); return 2; }
		return 0;
	}
	public void stop(){
		System.out.println("오토바이가 멈춥니다.");
	}
}
