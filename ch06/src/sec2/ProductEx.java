package sec2;

import java.util.Scanner;

public class ProductEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Product p1 = new Product();
		System.out.print("제품코드 : ");
		p1.setPid(sc.next());
		System.out.print("제품명 : ");
		p1.setPname(sc.next());
		System.out.print("제품수량 : ");
		p1.setAmount(sc.nextInt());
		System.out.print("제품가격 : ");
		p1.setPrice(sc.nextInt());
		System.out.print("이미지 : ");
		p1.setImg(sc.next());
		
		Product p2 = new Product("a01","냉장고",3,80000);
		
		System.out.println("제품코드\t제품명\t제품수량\t제품가격\t이미지");
		System.out.println(p1.getPid()+"\t"+p1.getPname()
				+"\t"+p1.getAmount()+"\t"+p1.getPrice()
				+"\t"+p1.getImg());
		System.out.println("예상 판매 금액 : "+p1.calcMoney());
		sc.close();
	}
}
