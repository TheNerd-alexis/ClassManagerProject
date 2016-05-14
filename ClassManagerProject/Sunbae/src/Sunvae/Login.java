package Sunvae;

import java.util.*;

public class Login {
	
	Scanner scan = new Scanner(System.in);
	
	ArrayList<UserID> userList = new ArrayList<UserID>();
	
	
	public void join(){
		
	System.out.println("사용할 아이디를 입력하세요.");
	String id = scan.nextLine();
	
	System.out.println("얼마를 충전하시겠습니까?");
	int cash = scan.nextInt();
	
	System.out.println("아이디 등록완료 ");
	
	UserID user = new UserID();
	user.userID = id;
	user.userCash = cash;
	
	userList.add(user);
		System.out.println(userList);
		
	}
		
	
	}
	
	

