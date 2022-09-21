package sec2;

public class StudentEx {
	public static void main(String[] args) {
		Student st1 = new Student("김기태", 90,80,90);
		System.out.println("이름\t총점\t평균\t학점\t판정");
		System.out.println(st1.name+"\t"+st1.calcTot()
				+"\t"+st1.calcAvg()+"\t"+st1.calHak()
				+"\t"+st1.calcRes());
	}
}