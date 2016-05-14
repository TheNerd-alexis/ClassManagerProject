package Sunvae;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("선배면 1 후배면 2를 입력해주세요");
		Scanner input = new Scanner(System.in);
		int x;
		x= input.nextInt();
		switch (x) {
		
		
		case 1:
			
			Sunbae s1 = new Sunbae(100);
			
			List<User> sunbae=  new ArrayList<User>();
			s1.Sdata();
			sunbae.add(0,s1);
			
			
			
			break;

		case 2:
			
				
				Hoobae h1 = new Hoobae(201);
				List<User> hoobae = new ArrayList<User>();
				
				hoobae.add(h1);
				
				h1.Sdata();
				
			
				
		}
		
		
	}

}
