package gameProject.baskin;

import java.io.IOException;
import java.util.Scanner;

public class Baskin {
	Scanner sc = new Scanner(System.in);
	int inning = 0;
	
	public Baskin(){
	}
	
	public void baskinStart() throws IOException{
		//베스킨 라빈스 시작 메서드
		boolean check;
		boolean condition = true;
		String title = null;
		String select = null;
		inning++;
		//회차를 위한 변수 증가
		while(condition){
			title = getTitle() + baskinInning(inning) + getMenu();
			//타이틀 출력
			print(title);
			select = input();
			switch (select) {
			case "1":
				//1번 선택시 게임 시작
				BaskinResult re = new BaskinResult(getTitle(), inning);
				check = re.resultStart();
				if(check){
					inning++;
				}
				break;
			case "2":
				//2번 선택시 종료
				print("종료하시겠습니까? (y/n)");
				select = input();
				if (select.equals("y") || select.equals("Y")) {
					condition = false;
				}
				break;
			default:
				print("잘못된 값을 입력하셨습니다.");
			}
		}
	}

	//베스킨 라빈스 타이틀 ---------------------------------------------------------------
	public String getTitle(){
		String sResult = null;
		StringBuffer sb = new StringBuffer();
		sb.append("\n\n");
		sb.append("********************************************\n");
		sb.append("*                                          *\n");
		sb.append("*          !!    베스킨 라빈스     !!          *\n");
		sb.append("*                           제작자 : 고명수   *\n");
		sb.append("*                                 ver 1.0  *\n");
		sb.append("********************************************\n");
		sResult = sb.toString();
		return sResult;
	}
	
	public String baskinInning(int idx){
		String sResult = null;
		StringBuffer sb = new StringBuffer();
		sb.append("[ "+ idx + " ] 회차 베스킨라빈스 \n\n");
		sResult = sb.toString();
		return sResult;
	}
	
	public String getMenu(){
		String sResult = null;
		StringBuffer sb = new StringBuffer();
		sb.append("  1. 시작 \t 2. 종료\n");
		sb.append("--------------------------- 선택 : ");
		sResult = sb.toString();
		return sResult;
	}
	
	//------------------------------------------------------------------------------
	
	public String input(){
		//입력 메서드
		return sc.next();
	}
	
	public void print(String text){
		//출력 메서드
		System.out.print(text);
	}
}
