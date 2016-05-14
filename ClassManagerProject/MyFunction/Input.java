package gameProject.baskin;

public class Input extends BaskinResult{
	boolean[] check;
	String title;
	int inning;
	
	public Input(String title, int inning){
		//생성자 변수 초기화
		check = new boolean[2];
		this.title = title;
		this.inning = inning;
	}
	
	public boolean inputStart(){
		//환경설정 입력을 받기 위한 메서드
		String data = null;
		boolean con = true;
		boolean checkNumber;
		while(con){
			print(this.title + baskinInning(this.inning));
			print("1. 마지막숫자    2. 1회입력가능횟수   B.이전화면\n");
			print("---------------------------- select : ");
			data = input();
			switch (data) {
			case "1":
				//1번 선택시 마지막숫자(벌칙숫자) 입력
				checkNumber = true;
				while(checkNumber){
					print("마지막 숫자를 입력하세요 : ");
					data = input();	
					if(integerOrNot(data)){
						//문자인지 숫자인지 판별
						lastNumber = Integer.parseInt(data);
						//판별후 저장 => 스태틱으로 지정된 값에 저장
						checkNumber = false;
					}else{
						print("숫자만 입력가능합니다. 다시 입력해 주세요");
					}
				}
				if(lastNumber !=0){
					check[0]=true;
					//나중에 환경설정을 먼저 입력받도록 하기 위해 boolean 배열값 변경
				}
				break;
			case "2":
				//2번 입력시 한번에 입력가능한 숫자 입력
				checkNumber = true;
				while(checkNumber){
					print("한번에 입력가능한 최대횟수를 입력하세요 : ");
					data = input();
					if(integerOrNot(data)){
						//문자체크후 저장
						count = Integer.parseInt(data);
						checkNumber = false;
					}else{
						print("숫자만 입력가능합니다. 다시 입력해 주세요");
					}
				}
				if(count !=0){
					check[1]=true;
					//나중에 환경설정을 먼저 입력받도록 하기 위해 boolean 배열값 변경
				}
				break;
			case "b": case "B":
				if(check[0]&&check[1]){
					confCheck = true;
					//2가지 모두 입력되었을 경우 게임시작을 할수 있는 boolean값 변경
				}
				con = false;
				break;
			default:
				print("잘못 입력하셨습니다. 다시 입력해 주세요\n");
			}
		}
		return confCheck;
	}
	
	public boolean integerOrNot(String strData){ // 입력값이 숫자인지 문자인지 판별 : 
		char[] charData = strData.toCharArray();
		boolean check=true;
		while(check){
			for(int i=0; i<charData.length; i++){		
				if(!Character.isDigit(charData[i])){
						check = !check;
						break;
				}
			}
			break;	
		}return check;
	}

}
