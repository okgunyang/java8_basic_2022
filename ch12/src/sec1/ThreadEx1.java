package sec1;
//쓰레드(Thread) : 현재 실행 중인 프로그램 또는 데이터나 프로세스를 의미하며,
//실제 컴퓨터에서는 두 개 이상의 쓰레드가 실행 중이게 되는데 이를 멀티 쓰레드라 함.
//쓰레드를 시작하려면 Thread 클래스 또는 ThreadRunnable 인터페이스로 부터 상속 받아 run 메소드를 기술하고,
//run 메소드 안에는 작업할 내용을 기술하며, main() 함수에서 해당 객체를 생성 후 객체.run() 하면 쓰레드를 시작할 수 있다.
//쓰레드는 다중 쓰레드라고 하더라도 순차적으로 처리되어 하나의 쓰레드가 실행이 완료되면, 다음 쓰레드를 자동으로 시작한다. -> 비선점형(run())
//다중 쓰레드에서 우선 순위나 주어진 실행시간이 다 되거나 sleep이 발생하는 동안 다른 쓰레드가 먼저 처리 될 수 있다. -> 선점형(start())
public class ThreadEx1 {
	public static void main(String[] args) {
		//ThreadRunnable(인터페이스)로 부터 상속받아 오버라이딩
		Thread th1 = new Thread(new ThreadWithRunnable());
		th1.run();	//쓰레드 시작
		
		//Thread(클래스)로 부터 상속받아 run메소드 선언
		ThreadWithClass th2 = new ThreadWithClass();
		//반드시, Thread(클래스)로 부터 상속받아 ThreadWithClass(클래스)에 run메소드로 기술해야함
		th2.run();	//쓰레드 시작
		
		
		ThreadWithClass th3 = new ThreadWithClass();	//비선점형
		th3.start();	//쓰레드 시작
		
		Thread th4 = new Thread(new ThreadWithRunnable());  //선점형
		th4.start();	//쓰레드 시작
	}
}
class ThreadWithClass extends Thread {
	@Override
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(this.getName());
			try {
				Thread.sleep(10); //1000 밀리초(ms)=1초 이므로 0.01초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
//Runnable은 인터페이스이므로 반드시 오버라이딩하여 해당 메소드를 구현체로 기술
class ThreadWithRunnable implements Runnable { 
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			//현재 실행 중인 쓰레드의 이름 출력
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(10);	//0.01초의 딜레이
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}