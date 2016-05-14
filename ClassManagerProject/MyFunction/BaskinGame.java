package gameProject.baskin;

import java.util.Random;

public class BaskinGame extends BaskinResult{
	//BaskinResult ���
	String title;
	int inning, currentNumber, comSelect , comNumber, winNumber;
	public BaskinGame(String temp, int inning){
		//�����ڿ��� ���� �ʱ�ȭ
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
			print("[ ���� ���� ] \n");
			print("1. ����           2. ��ǻ��\n");
			print("--------------------select : ");
			data = input();
			switch (data) {
			case "1":
				//���� ���� 1�� ���ý� ����ڰ� ���� �Է� ����
				sResult = userStart();
				condition = false;
				break;
			case "2":
				//���� ���� 2�� ���ý� ��ǻ�Ͱ� ���� �Է� ����
				sResult = comStart();
				condition = false;
				break;
			default:
				print("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���\n");
			}
		}
		return sResult;		
	}
	
	public String userStart(){
		//����ڰ� ���� ���۽�
		String sResult = null;
		boolean con = true;
		boolean userCheck = true;
		boolean comCheck = true;
		print("[ ������ ���� ] : " + lastNumber + "  [ 1ȸ�Է°��ɼ� ] : "+ count + "\n");
		while(con){
			if(currentNumber == lastNumber){
				//������ڿ� �������Է¼��ڰ� ������ �� ����
				if(!comCheck || !userCheck ){
					con = false;
					break;
				}
			}
			userCheck = userInput();
			//�����Է�
			if(currentNumber == lastNumber){
				//������ڿ� �������Է¼��ڰ� ������ �� ����
				if(!comCheck || !userCheck ){
					con = false;
					break;
				}
			}
			comCheck = comInput();
			//��ǻ�� �Է�
		}
		if(userCheck && !comCheck ){
			//���ǰ��� ���� ���� ����
			sResult = "\n����� �̰���ϴ�. \n";
		}else if(!userCheck && comCheck ){
			sResult ="\n��ǻ�Ͱ� �̰���ϴ�. \n";
		}
		return sResult;
	}
	
	public String comStart(){
		//��ǻ�Ͱ� ���� ���۽�(���� ���������� �Ʒ��κ��� �ٸ�)
		String sResult = null;
		boolean con = true;
		boolean userCheck = true;
		boolean comCheck = true;
		print("[ ������ ���� ] : " + lastNumber + "  [ 1ȸ�Է°��ɼ� ] : "+ count + "\n");
		while(con){
			if(currentNumber == lastNumber){
				if(!comCheck || !userCheck ){
					con = false;
					break;
				}
			}
			//����ڰ� ���� �����ϴ� �κа� �ٸ� �κ�
			//��ǻ�Ͱ� ���� �Է��ҽ� ������ �̱�� �������� ������ �ǵ��� �Ͽ�����,
			//����Ų�� Ư���� ���� �����Ұ�� �̱�� ���� ������ �����ϱ� ������ �׺κп� 
			//���� �ٸ� �����ϵ��� ����
			if((lastNumber-1)%(count+1) ==0){
				//�̱�� ���� ���� �Ͻ� ��ǻ�� �ڵ��Էºκ��� ����
				comCheck = comInput();
			}else{
				//�ƴҰ�� ��ǻ�Ͱ� ������ �̱�� �޼��� ����
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
			sResult = "\n����� �̰���ϴ�. \n";
		}else if(!userCheck && comCheck ){
			sResult ="\n��ǻ�Ͱ� �̰���ϴ�. \n";
		}
		return sResult;
	}
	
	public boolean userInput(){
		//����� �Էºκ�
		boolean check = true;
		boolean con = true;
		String num = null;
		while(con){
			if(currentNumber != lastNumber){
				//ó�� ������ ���� ���ڿ� ������ ���ڰ� ���� �������
				//�������� ���������̱� ������
				print(" Input : ");
				num = input();
				if((lastNumber - currentNumber) >= Integer.parseInt(num) && count >=Integer.parseInt(num)){
					//������ ���ڿ� ������� �׸��� �Է¹��� ���ڸ� ���� ���� �Է� ����
					print("������� ���� : ");
					for(int j=0; j<Integer.parseInt(num); j++){
						currentNumber++; //������� �Է¹޾��� ���ڸ� �������
						print(currentNumber + "   ");
					}
					print("\n");
					if(currentNumber == lastNumber){
						check = false;
					}
					con = false;
				}else{
					print("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���\n");
				}
			}
		}
		return check;
	}
	
	public boolean comInput(){
		//��ǻ�� �ڵ��Էºκ�
		boolean check = true;
		Random ra = new Random();
		int comSelect = 0;
		if((lastNumber - currentNumber) > count){
			//���� ������ �ڵ��Է�
			print(" Com Input : ");
			comSelect = ra.nextInt(count)+1;
			//ī��Ʈ�� ������ �ڵ����� ���� �Է�
			print(comSelect + "\n");
			print("������� ���� : ");
			for(int j=0; j<comSelect; j++)
			{
				currentNumber++; //���� ���� ����
				print(currentNumber + "   ");
			}	
			print("\n");
		}else if((lastNumber-currentNumber) == 1){
			//1�� �Է°����ҽ� 1�� �Է��ϵ��� ����
			print(" Com Input : ");
			comSelect = 1;
			print(comSelect + "\n");
			print("������� ���� : ");
			currentNumber++;
			print(currentNumber+"");
			check = false;
		}else{
			//�ΰ��� ���� �� �������� ���� ���
			//��ǻ�Ͱ� ���������� -1 ���� �θ��� �ִ� ���¿���
			//�̱�� �ִ� ���ڸ� �θ����� ���ִ� �κ�
			print(" Com Input : ");
			comSelect = ra.nextInt((lastNumber-currentNumber)-1)+1;
			print(comSelect + "\n");
			print("������� ���� : ");
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
		//��ǻ�Ͱ� ������ �̱�� �ִ� ������ ���� �޼���
		boolean check = true;
		Random ra = new Random();
		if(currentNumber == 0){
			//ó�� �����Ҷ� ���� ���� ������ �ֱ� ���� �κ�
			while(comNumber > count){
				comNumber -= (count+1);
			}
			print(" Com Input : ");
			comSelect = comNumber;
			winNumber = comNumber; //winNumber => ������ �̱���ִ� ����
			print(comSelect + "\n");
			print("������� ���� : ");
			for(int i=0; i<comSelect; i++){
				currentNumber++; //������� ����
				print(currentNumber + "   ");
			}
			print("\n");
		}else if((lastNumber-1) - currentNumber >= (count +2)){
			//��ǻ�Ͱ� �����ؾ� �ϴ°��� �̱�� ���ڰ� �ƴ϶� ����ڰ� ������ �Է��� ����
			//���� ���ڸ� �����ؾ��ϱ� ������ count + 2�� ���ؼ� ������ ����
			comNumber = (winNumber + count + 1) - currentNumber;
			//�Է°��� �̱�� �ִ� ���ǿ� �´� ���ڸ� �θ����� ����
			print(" Com Input : ");
			comSelect = comNumber;
			print(comSelect + "\n");
			print("������� ���� : ");
			for(int i=0; i<comSelect; i++){
				currentNumber++;
				print(currentNumber + "   ");
			}
			print("\n");
			winNumber += (count + 1); //�̱�� �ִ� ���� ���ǿ� �°� ��� ����������
		}else{
			//���������� ��ǻ�Ͱ� ����������-1 ���� �θ��� �ֵ��� ����
			//������ ���ڸ� �ʰ��� ���� �θ��� �ȵǱ� ����
			comNumber = (lastNumber -1)- currentNumber;
			print(" Com Input : ");
			comSelect = comNumber;
			print(comSelect + "\n");
			print("������� ���� : ");
			for(int i=0; i<comSelect; i++){
				currentNumber++;
				print(currentNumber + "   ");
			}
			print("\n");
		}
		return check;
	}
}
