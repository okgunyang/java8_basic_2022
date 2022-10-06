package sec1;
//Function Style Lambda - 매개값과 리턴값이 각 각 어떤 데이터 타입이냐에 따라 여러 종류가 있음
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class Lambda6 {
	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93)
		);
		
		public static double avg(ToIntFunction<Student> function) {
			int sum = 0;
			for(Student student : list) {
				sum += function.applyAsInt(student);
			}
			double avg = (double) sum / list.size();
			return avg;
		}
		
		public static void main(String[] args) {
			double englishAvg = avg( s -> s.getEnglishScore() );
			System.out.println("영어 평균 점수: " + englishAvg);
			
			double mathAvg = avg( s -> s.getMathScore() );
			System.out.println("수학 평균 점수: " + mathAvg);
		}
}
class Student {
	private String name;
	private int englishScore;
	private int mathScore;
	
	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() { return name; }
	public int getEnglishScore() { return englishScore; }
	public int getMathScore() { return mathScore; }
}