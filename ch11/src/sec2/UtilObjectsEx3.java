package sec2;

import java.util.Objects;

public class UtilObjectsEx3 {
	public static void main(String[] args){
		Student s1 = null;
		Student s2 = new Student(4, "정진석");
		Student s3 = new Student(5, "지각생");
		
		System.out.println();
		if(Objects.isNull(s1)){
			System.out.println("s1이 null 입니다.");
		} else {
			System.out.println("s1이 null 아닙니다.");
		}
		
		if(Objects.nonNull(s2)){
			System.out.println("s2이 null 아닙니다.");
		} else {
			System.out.println("s2이 null 입니다.");
		}
		
		if(s1==null){
			System.out.println("s1이 null 입니다.");
		} else {
			System.out.println("s1이 null 아닙니다.");
		}
		
		if(s3!=null){
			System.out.println("s3이 null 아닙니다.");
		} else {
			System.out.println("s3이 null 입니다.");
		}
	}
}
