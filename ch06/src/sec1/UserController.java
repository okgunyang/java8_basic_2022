package sec1;

public class UserController extends MemberController{
	
	//오버라이딩
	@Override
	public void join(String id, String password, String name){
		System.out.println("아이디 : "+id);
	}
	
	//오버로딩
	public void join(String id, String password){
		System.out.println("비밀번호 : "+password);
	}
}
