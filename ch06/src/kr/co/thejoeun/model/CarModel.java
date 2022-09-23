package kr.co.thejoeun.model;

import kr.co.thejoeun.controller.CarCtrl;

public class CarModel {
	public static void main(String[] args) {
		CarCtrl car1 = new CarCtrl();
		car1.item1 = 10;
		//car1.item2 = 20; - protected
		//car1.item3 = 30; - default
		//car1.item4 = 40; - private
	}
}
