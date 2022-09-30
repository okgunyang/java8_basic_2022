package sec2;

public class Student {
	public int sno;
	public String sname;
	public Student() { System.out.println("생성1");}
	public Student(int sno) { this.sno=sno; System.out.println("생성2"); }
	public Student(int sno, String sname) {
		this.sno = sno;
		this.sname = sname;
		System.out.println("생성3");
	}
	public void finalize(){
		System.out.println("소멸");
	}
	
}