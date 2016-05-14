package gameProject.baskin;

import java.util.Random;

public class BaskinGame extends BaskinResult{
	//BaskinResult 상속
	String title;
	int inning, currentNumber, comSelect , comNumber, winNumber;
	public BaskinGame(String temp, int inning){
		//생성자에서 변수 초기화
		this.title = temp;
		this.inning = inning;
		currentNumber = 0;
		comSelect = 0;
		winNumber = 0;
		comNumber = lastNumber-1;
	}
	
	public String bgStart(){
		String sResult = null;
		String data = null;
		boolean condition = true;
		while(condition){
			print(this.title + baskinInning(this.inning));
			print("[ 시작 순서 ] \n");
			print("1. 본인           2. 컴퓨터\n");
			print("--------------------select : ");
			data = input();
			switch (data) {
			case "1":
				//시작 순서 1번 선택시 사용자가 먼저 입력 시작
				sResult = userStart();
				condition = false;
				break;
			case "2":
				//시작 순서 2번 선택시 컴퓨터가 먼저 입력 시작
				sResult = comStart();
				condition = false;
				break;
			default:
				print("잘못입력하셨습니다. 다시 입력해주세요\n");
			}
		}
		return sResult;		
	}
	
	public String userStart(){
		//사용자가 먼저 시작시
		String sResult = null;
		boolean con = true;
		boolean userCheck = true;
		boolean comCheck = true;
		print("[ 마지막 숫자 ] : " + lastNumber + "  [ 1회입력가능수 ] : "+ count + "\n");
		while(con){
			if(currentNumber == lastNumber){
				//현재숫자와 마지막입력숫자가 동일할 시 종료
				if(!comCheck || !userCheck ){
					con = false;
					break;
				}
			}
			userCheck = userInput();
			//유저입력
			if(currentNumber == lastNumber){
				//현재숫자와 마지막입력숫자가 동일할 시 종료
				if(!comCheck || !userCheck ){
					con = false;
					break;
				}
			}
			comCheck = comInput();
			//컴퓨터 입력
		}
		if(userCheck && !comCheck ){
			//조건값에 의해 승패 결정
			sResult = "\n당신이 이겼습니다. \n";
		}else if(!userCheck && comCheck ){
			sResult ="\n컴퓨터가 이겼습니다. \n";
		}
		return sResult;
	}
	
	public String comStart(){
		//컴퓨터가 먼저 시작시(거의 동일하지만 아래부분이 다름)
		String sResult = null;
		boolean con = true;
		boolean userCheck = true;
		boolean comCheck = true;
		print("[ 마지막 숫자 ] : " + lastNumber + "  [ 1회입력가능수 ] : "+ count + "\n");
		while(con){
			if(currentNumber == lastNumber){
				if(!comCheck || !userCheck ){
					con = false;
					break;
				}
			}
			//사용자가 먼저 시작하는 부분과 다른 부분
			//컴퓨터가 먼저 입력할시 무조건 이기는 조건으로 실행이 되도록 하였지만,
			//베스킨의 특성상 먼저 시작할경우 이길수 없는 조건이 존재하기 때문에 그부분에 
			//따라서 다른 수행하도록 해줌
			if((lastNumber-1)%(count+1) ==0){
				//이길수 없는 조건 일시 컴퓨터 자동입력부분을 실행
				comCheck = comInput();
			}else{
				//아닐경우 컴퓨터가 무조건 이기는 메서드 실행
				comCheck = comWinInput();
			}
			if(currentNumber == lastNumber){
				if(!comCheck || !userCheck ){
					con = false;
					break;
				}
			}
			userCheck = userInput();
		}
		if(userCheck && !comCheck ){
			sResult = "\n당신이 이겼습니다. \n";
		}else if(!userCheck && comCheck ){
			sResult ="\n컴퓨터가 이겼습니다. \n";
		}
		return sResult;
	}
	
	public boolean userInput(){
		//사용자 입력부분
		boolean check = true;
		boolean con = true;
		String num = null;
		while(con){
			if(currentNumber != lastNumber){
				//처음 조건은 현재 숫자와 마지막 숫자가 같지 않을경우
				//같을경우는 게임종료이기 때문에
				print(" Input : ");
				num = input();
				if((lastNumber - currentNumber) >= Integer.parseInt(num) && count >=Integer.parseInt(num)){
					//마지막 숫자와 현재숫자 그리고 입력받은 숫자를 통해 유저 입력 수행
					print("현재까지 숫자 : ");
					for(int j=0; j<Integer.parseInt(num); j++){
						currentNumber++; //현재까지 입력받아진 숫자를 출력해줌
						print(currentNumber + "   ");
					}
					print("\n");
					if(currentNumber == lastNumber){
						check = false;
					}
					con = false;
				}else{
					print("잘못입력하셨습니다. 다시 입력해 주세요\n");
				}
			}
		}
		return check;
	}
	
	public boolean comInput(){
		//컴퓨터 자동입력부분
		boolean check = true;
		Random ra = new Random();
		int comSelect = 0;
		if((lastNumber - currentNumber) > count){
			//조건 만족시 자동입력
			print(" Com Input : ");
			comSelect = ra.nextInt(count)+1;
			//카운트값 내에서 자동으로 숫자 입력
			print(comSelect + "\n");
			print("현재까지 숫자 : ");
			for(int j=0; j<comSelect; j++)
			{
				currentNumber++; //현재 숫자 증가
				print(currentNumber + "   ");
			}	
			print("\n");
		}else if((lastNumber-currentNumber) == 1){
			//1만 입력가능할시 1만 입력하도록 해줌
			print(" Com Input : ");
			comSelect = 1;
			print(comSelect + "\n");
			print("현재까지 숫자 : ");
			currentNumber++;
			print(currentNumber+"");
			check = false;
		}else{
			//두가지 조건 다 만족하지 않을 경우
			//컴퓨터가 마지막숫자 -1 값을 부를수 있는 상태에선
			//이길수 있는 숫자를 부르도록 해주는 부분
			print(" Com Input : ");
			comSelect = ra.nextInt((lastNumber-currentNumber)-1)+1;
			print(comSelect + "\n");
			print("현재까지 숫자 : ");
			for(int j=0; j<comSelect; j++)
			{
				currentNumber++;
				print(currentNumber + "   ");
			}	
			print("\n");
		}
		return check;
	}
	
	public boolean comWinInput(){
		//컴퓨터가 무조건 이길수 있는 로직에 따른 메서드
		boolean check = true;
		Random ra = new Random();
		if(currentNumber == 0){
			//처음 시작할때 시작 값을 지정해 주기 위한 부분
			while(comNumber > count){
				comNumber -= (count+1);
			}
			print(" Com Input : ");
			comSelect = comNumber;
			winNumber = comNumber; //winNumber => 무조건 이길수있는 숫자
			print(comSelect + "\n");
			print("현재까지 숫자 : ");
			for(int i=0; i<comSelect; i++){
				currentNumber++; //현재숫자 증가
				print(currentNumber + "   ");
			}
			print("\n");
		}else if((lastNumber-1) - currentNumber >= (count +2)){
			//컴퓨터가 반응해야 하는것은 이기는 숫자가 아니라 사용자가 마지막 입력한 값에
			//따라서 숫자를 선택해야하기 때문에 count + 2를 통해서 조건을 만족
			comNumber = (winNumber + count + 1) - currentNumber;
			//입력값은 이길수 있는 조건에 맞는 숫자를 부르도록 설정
			print(" Com Input : ");
			comSelect = comNumber;
			print(comSelect + "\n");
			print("현재까지 숫자 : ");
			for(int i=0; i<comSelect; i++){
				currentNumber++;
				print(currentNumber + "   ");
			}
			print("\n");
			winNumber += (count + 1); //이길수 있는 값을 조건에 맞게 계속 증가시켜줌
		}else{
			//마지막으로 컴퓨터가 마지막숫자-1 값을 부를수 있도록 해줌
			//마지막 숫자를 초과한 값을 부르면 안되기 때문
			comNumber = (lastNumber -1)- currentNumber;
			print(" Com Input : ");
			comSelect = comNumber;
			print(comSelect + "\n");
			print("현재까지 숫자 : ");
			for(int i=0; i<comSelect; i++){
				currentNumber++;
				print(currentNumber + "   ");
			}
			print("\n");
		}
		return check;
	}
}
