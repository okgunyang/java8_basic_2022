package sec2;
//throws는 예외 떠넘기기
public class Throw1 {
	public static void main(String[] args) {
		String name = null;
		nullPassing(name);
		
		int[] arr = new int[3];
		arrayPassing(arr);
		
		String data = "kim1004";
		try {
			int val1 = Integer.parseInt(data);
			System.out.println(val1);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	static void arrayPassing(int[] arr) throws
		ArrayIndexOutOfBoundsException, NullPointerException {
		for(int i=0;i<5;i++){
			arr[i] = i*10;
		}
	}
	static void nullPassing(String data) throws NullPointerException{
		System.out.println(data);
	}
}