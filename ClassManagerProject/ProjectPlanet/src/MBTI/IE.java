package MBTI;

import java.util.Scanner;

public class IE {

	int i;
	int e;
	
	int button;
	
	Scanner scan = new Scanner(System.in);
	
	
	public void A(){
		System.out.println("당신은 혼자 있을 때 ");
		System.out.println("1. 에너지가 회복된다 ");
		System.out.println("2. 외롭다. ");
		
		button = scan.nextInt();
		
		
		if(button == 1){
			i++;
			System.out.println("1을 선택하셨습니다.");
		}
		
		else if(button == 2){
			e++;
			System.out.println("2를 선택하셨습니다.");
		}
		
		else{
			System.out.println("다시 선택하세요 ");
			IE ie = new IE();}
		
		
		
	}
	
	
}
