package sec4;

public class Member {
	String name;	//멤버 필드(Field = Attribute = Property)
	String id;
	String password;
	int age;
	
	public Member(String name){ }	//생성자(Constructor)
	public Member(String name, String id){ 
		this.name = name;	this.id = id;
	}
	
	public void setName(String name) { this.name = name; }	//메소드(Method)
}
