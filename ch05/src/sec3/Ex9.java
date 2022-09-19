package sec3;

import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;
        Scanner scanner = new Scanner(System.in);
        
        while(run) {
            System.out.println("-----------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("-----------------------------------------------------");
            System.out.println("선택> ");
 
            int selectNo = scanner.nextInt();
 
            if(selectNo == 1) {
            	System.out.print("학생수> ");
            	studentNum = scanner.nextInt();
            	scores = new int[studentNum];
            } else if(selectNo == 2) {
            	for(int i=0;i<studentNum;i++){
            		System.out.print("scores["+i+"]");
            		scores[i] = scanner.nextInt();
            	}
            } else if(selectNo == 3) {
            	for(int i=0;i<studentNum;i++){
            		System.out.print("scores["+i+"]: "+scores[i]);
            	}
            } else if(selectNo == 4) {
            	int max=0;
            	int sum =0;
            	double avg = 0.0;
            	
            	for(int i=0;i<studentNum;i++){
            		if(scores[i] > max) max = scores[i];
            		sum += scores[i];
            	}
            	
            	avg = (double) sum / studentNum;
            	
            	System.out.println("최고점수 : "+max);
            	System.out.println("평균점수 : "+avg);
            } else if(selectNo == 5) {
                run = false;
            }
        }    
        System.out.println("프로그램 종료");
    }
}
