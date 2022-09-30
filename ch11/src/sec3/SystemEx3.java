package sec3;

public class SystemEx3 {
	public static void main(String[] args) {
		//쓰레드가 걸린 시간 측정 = 성능 측정
		long time1 = System.nanoTime();
		
		long sum=0;
		for(int i=1;i<10000000;i++){
			sum+=i;
		}
		
		long time2 = System.nanoTime();
		//초>밀리초(1/1000)>마이크로초(1/1000000)>나노초(1/1000000000)
		System.out.println("합산 결과 : "+sum);
		System.out.println("걸린 시간 : "+(time2-time1));
	}
}