package Sunvae;

import java.util.Scanner;

public class Sunbae extends User{
	
	Scanner scan = new Scanner(System.in);
	String company; // 1. 지원회사 2. 현재 직장
	public void Scompany(){
		
		System.out.println("현재 직장 : ");
		company = scan.nextLine();
		
		
		
	}
	
	public Sunbae(int id) {
		this.id = id;
	}
		
	
}
