package sec2;

public class RemoteEx1 {
	public static void main(String[] args) {
		RemoteControl rc1;
		RemoteControl rc2;
		rc1 = new Television();
		rc2 = new Audio();
		
		rc1.turnOn();
		rc1.setVolume(8);
		rc1.setMute(true);
		rc1.turnOff();
		
		rc1 = rc2;	//오디오로 형변환
		
		rc1.turnOn();
		rc1.setVolume(5);
		rc1.setMute(true);
		rc1.turnOff();
		
		//인터페이스는 추상체(구현내용 없음)이므로 생성자로는 객체를 생성할 수 없다. 
		//RemoteControl rc3 = new RemoteControl();
		
		//익명의 구현 객체 : 구현 클래스없이 생성자에 직접 구현 내용을 기술하여 객체를 생성
		RemoteControl rc3 = new RemoteControl() {
			public void turnOn() { System.out.println("전원 ON"); }
			public void turnOff() { System.out.println("전원 OFF"); }
			public void setVolume(int volume) {
				System.out.println("볼륨 값 : "+volume);
			}
		};
		rc3.turnOn();
		rc3.setVolume(6);
		rc3.turnOff();
		//rc1 = new Audio(); //생성하여 형변환
		//rc2 = rc1;  //자동 형변환
		//rc1 = rc2;  //자동 형변환
		
		System.out.println("rc1은 Television의 객체? "+(rc1 instanceof Television));
		System.out.println("rc1은 Audio의 객체? "+(rc1 instanceof Audio));
		System.out.println("rc1은 RemoteControl의 객체? "+(rc1 instanceof RemoteControl));
		
		RemoteControl[] rc = null;
//		rc[0] = new Audio();
//		rc[1] = new Television();
		
	}
}