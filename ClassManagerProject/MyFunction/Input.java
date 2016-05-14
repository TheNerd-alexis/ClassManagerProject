package gameProject.baskin;

public class Input extends BaskinResult{
	boolean[] check;
	String title;
	int inning;
	
	public Input(String title, int inning){
		//������ ���� �ʱ�ȭ
		check = new boolean[2];
		this.title = title;
		this.inning = inning;
	}
	
	public boolean inputStart(){
		//ȯ�漳�� �Է��� �ޱ� ���� �޼���
		String data = null;
		boolean con = true;
		boolean checkNumber;
		while(con){
			print(this.title + baskinInning(this.inning));
			print("1. ����������    2. 1ȸ�Է°���Ƚ��   B.����ȭ��\n");
			print("---------------------------- select : ");
			data = input();
			switch (data) {
			case "1":
				//1�� ���ý� ����������(��Ģ����) �Է�
				checkNumber = true;
				while(checkNumber){
					print("������ ���ڸ� �Է��ϼ��� : ");
					data = input();	
					if(integerOrNot(data)){
						//�������� �������� �Ǻ�
						lastNumber = Integer.parseInt(data);
						//�Ǻ��� ���� => ����ƽ���� ������ ���� ����
						checkNumber = false;
					}else{
						print("���ڸ� �Է°����մϴ�. �ٽ� �Է��� �ּ���");
					}
				}
				if(lastNumber !=0){
					check[0]=true;
					//���߿� ȯ�漳���� ���� �Է¹޵��� �ϱ� ���� boolean �迭�� ����
				}
				break;
			case "2":
				//2�� �Է½� �ѹ��� �Է°����� ���� �Է�
				checkNumber = true;
				while(checkNumber){
					print("�ѹ��� �Է°����� �ִ�Ƚ���� �Է��ϼ��� : ");
					data = input();
					if(integerOrNot(data)){
						//����üũ�� ����
						count = Integer.parseInt(data);
						checkNumber = false;
					}else{
						print("���ڸ� �Է°����մϴ�. �ٽ� �Է��� �ּ���");
					}
				}
				if(count !=0){
					check[1]=true;
					//���߿� ȯ�漳���� ���� �Է¹޵��� �ϱ� ���� boolean �迭�� ����
				}
				break;
			case "b": case "B":
				if(check[0]&&check[1]){
					confCheck = true;
					//2���� ��� �ԷµǾ��� ��� ���ӽ����� �Ҽ� �ִ� boolean�� ����
				}
				con = false;
				break;
			default:
				print("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���\n");
			}
		}
		return confCheck;
	}
	
	public boolean integerOrNot(String strData){ // �Է°��� �������� �������� �Ǻ� : 
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
