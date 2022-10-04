package sec10.verify03;

public class Student {
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentNum() {
		return studentNum;
	}

	//같은 학생인지 비교
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student student = (Student) obj;
			if(studentNum.equals(student.getStudentNum())) {
				return true;
			}
		}
		return false;
	}
	
	//학생(student) 객체의 hashcode를 리턴
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}
}
