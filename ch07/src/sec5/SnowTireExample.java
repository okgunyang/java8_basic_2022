package sec5;

public class SnowTireExample{
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;  //자동 형변환

		snowTire.run();
		tire.run();
	}
}
