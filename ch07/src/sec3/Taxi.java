package sec3;

public class Taxi extends Car {

	@Override
	public int run() {
		System.out.println("택시가 달립니다.");
		return super.run();
	}

	@Override
	public void stop() {
		System.out.println("택시가 멈춥니다.");
	}
}
