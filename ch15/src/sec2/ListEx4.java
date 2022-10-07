package sec2;

import java.util.LinkedList;
import java.util.List;

import sec1.Student;

public class ListEx4 {
	public static void main(String[] args) {
		List<Student> sList = new LinkedList<Student>();
		
		Student s1 = new Student();
		s1.setNum(1);
		s1.setName("김기태");
		s1.setJumsu(100);
		sList.add(s1);
		
		Student s2 = new Student();
		s2.setNum(2);
		s2.setName("남송윤");
		s2.setJumsu(90);
		sList.add(s2);
		
		System.out.println("번호\t이름\t점수");
		for(int i=0;i<sList.size();i++){
			Student s = new Student();
			s = sList.get(i);
			System.out.println(s.getNum()+"\t"+s.getName()+"\t"+s.getJumsu());
		}
	}
}