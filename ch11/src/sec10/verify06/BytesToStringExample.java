package sec10.verify06;

public class BytesToStringExample {
	public static void main(String[] args) {
		byte[] bytes = { 73, 32, 108, 111, 118, 101, 32, 121, 111, 117 };
		String str = new String(bytes);
		//String str1 = bytes.toString();
		System.out.println( str );
	}
}