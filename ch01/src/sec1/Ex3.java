package sec1;
//저장 클래스
public class Ex3 {
	//멤버 필드 = 해당 클래스의 지역 변수
	private String name;  //학생명
	final static double PI = 3.14;
	private int kor;	//국어점수
	private int eng;	//영어점수
	private int mat;	//수학점수
	
//	private String res;
	
	//멤버 메서드 = 해당 클래스의 기능(처리하고자하는 일)을 나타냄
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
}
