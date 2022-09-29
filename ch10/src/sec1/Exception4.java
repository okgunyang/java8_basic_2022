package sec1;
public class Exception4 {
	static class Animal{}
	static class Dog extends Animal{}
	static class Cat extends Animal{}
	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
		
		Cat cat = new Cat();
		changeDog(cat);
	}
	public static void changeDog(Animal animal){
		try {
			Dog dog = (Dog) animal;
		} catch(ClassCastException e){
			System.out.println("형제나 다른 패키지에 있는 클래스의 객체로 형변환 할 수 없음");
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("원인을 알 수 없음");
		} finally {
			System.out.println("종료");
		}
	}
}
