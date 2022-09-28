package sec2;

public class SmartPhone extends DmbPhone {
	String appName;
	
	public void appStart(String appName){ 
		System.out.println(appName+"을 시작합니다."); 
	}
	public void appEnd(String appName){
		System.out.println(appName+"을 종료합니다.");
	}
}