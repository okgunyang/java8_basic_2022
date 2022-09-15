package sec4;

import java.util.Scanner;

public class Ex7 {
	public static void main(String[] args) {
		int money=0, balance=0;
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run){
			System.out.println("----------------------------------");
			System.out.println("1.예금 | 2. 출금 | 3. 잔액 | 4. 종료");
			System.out.println("----------------------------------");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			switch(num){
				case 1:
					System.out.print("예금할 금액을 입력하세요 : ");
					money = sc.nextInt();
					balance+=money;
					break;
				case 2:
					System.out.print("출금할 금액을 입력하세요 : ");
					money = sc.nextInt();
					balance-=money;
					break;
				case 3:
					System.out.println("잔액 : "+balance);
					break;
				case 4:
					System.out.print("프로그램 종료");
					run = false;
					break;
				default:
					System.out.println("해당 작업은 잘못된 번호입니다. 다시 입력해주세요");
			}
		}
	}
}