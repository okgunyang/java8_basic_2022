package sec1;

import java.util.ArrayList;

public class ClassEx1 {
	public static void main(String[] args) {
		AnimalList<LandAnimal> ani1 = new AnimalList<>();
		
		ani1.add(new Cat());
		ani1.add(new LandAnimal());
		ani1.add(new Dog());
		ani1.add(new Birds());
		
		for(int i=0;i<ani1.size();i++){
			ani1.get(i).crying();
		}
	}
}
class AnimalList<T extends LandAnimal>{
	ArrayList<T> lst = new ArrayList<T>();
	void add(T animal) { lst.add(animal); }
	T get(int index) { return lst.get(index); }
	boolean remove(T animal) { return lst.remove(animal); }
	int size() { return lst.size(); }
}
class LandAnimal {
	public void crying() {
		System.out.println("육지 동물");
	}
}
class Cat extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("야옹야옹");
	}
}
class Dog extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("멍멍");
	}
}
class Birds extends LandAnimal{
	@Override
	public void crying() {
		System.out.println("짹짹");
	}
}