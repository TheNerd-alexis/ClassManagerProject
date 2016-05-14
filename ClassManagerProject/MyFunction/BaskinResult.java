package gameProject.baskin;

import java.io.IOException;

public class BaskinResult extends Baskin{
	//베스킨 상속
	String title;
	int inning;
	static int lastNumber, count;
	boolean confCheck;
	
	public BaskinResult(){
		
	}
	public BaskinResult(String temp, int inning){
		//생성자에서 변수 초기화
		title = temp;
		this.inning = inning;
		lastNumber = 0;
		count = 0;
		confCheck = false;
	}
	
	public boolean resultStart() throws IOException {
		//중간메서드
		boolean bResult = false;
		int end = 0;
		String data = null;
		String result = null;
		boolean condition = true;
		while(condition){
			print(this.title + baskinInning(this.inning));
			print("1. 환경설정   2. 게임시작  3. 종료 \n");
			print("------------------------select : ");
			data = input();
			switch(data){	
			case "1":
				//1번 선택시 환경설정으로 들어감
				Input ip = new Input(this.title, this.inning);
				confCheck = ip.inputStart();
				break;
			case "2":
				if(confCheck){
					//환경설정이 입력되었을 경우만 게임이 시작되도록 설정
					BaskinGame bg = new BaskinGame(this.title, this.inning);
					result = bg.bgStart();
					print(result);
					bResult = true;
					print("\n계속하려면 엔터키를 입력하세요.");
					end = System.in.read();
				}else{ //아닐경우 에러메시지 출력
					print("환경설정을 먼저 해주세요\n");
				}
				condition = false;
				break;
			case "3":
				//3번 선택시 종료 (이전 메뉴로 넘어감)
				print("종료하시겠습니까? (y/n)");
				data = input();
				if(data.equals("y")||data.equals("Y")){
					condition = false;
				}
				break;
			default:
				print("잘못된 번호를 입력하셨습니다.\n");
			}
		}
		return bResult;
	}
}
