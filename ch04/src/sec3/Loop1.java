package sec3;

public class Loop1 {
	public static void main(String[] args) {
		int[] data = {90,80,70,65,75,95,85,60,90,95};  //data[0]~data[9]
		int tot=0;
/*
 			①			   ②              ③
  		for(반복변수 선언 및 초기화;조건식;증감식){
			반복할 실행문;     ④
		}
		반복변수가 부여된 초기값으로 시작하여 증감식에 따라 증감이 되다가 조건식이 만족하지 않으면, 더 이상 실행하지 않음
		① -> ② -> ④ -> ③ -> ② -> ④  실행하다가 ③ -> ② -> ④를 조건이 만족하는 동안 반복 수행
*/
		for(int a=0;a<data.length;a++){
			System.out.println(a+"번째 사람의 점수 : "+data[a]);
			tot=tot+data[a];   //누산
		}
		double avg = (float) tot / data.length;
		System.out.println("전체 총점 : "+tot+", 전체 평균 : "+avg);
	}
}