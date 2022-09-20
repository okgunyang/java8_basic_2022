package sec1;
//Member는 부모(super) 클래스, User는 자식(sub) 클래스
public class User extends Member {
	private int visited;
	public User(){ }
	public User(String id, int visited){
		
	}
	public User(String id, String pw) {
		super(id, pw); //super함수는 부모의 생성자 함수
	}
	public User(String id, String pw, int visited){
		super(id, pw); //super함수는 부모의 생성자 함수
		this.visited = visited;
	}
	
	
	
}
