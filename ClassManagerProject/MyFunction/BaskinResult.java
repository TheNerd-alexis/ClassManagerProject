package gameProject.baskin;

import java.io.IOException;

public class BaskinResult extends Baskin{
	//����Ų ���
	String title;
	int inning;
	static int lastNumber, count;
	boolean confCheck;
	
	public BaskinResult(){
		
	}
	public BaskinResult(String temp, int inning){
		//�����ڿ��� ���� �ʱ�ȭ
		title = temp;
		this.inning = inning;
		lastNumber = 0;
		count = 0;
		confCheck = false;
	}
	
	public boolean resultStart() throws IOException {
		//�߰��޼���
		boolean bResult = false;
		int end = 0;
		String data = null;
		String result = null;
		boolean condition = true;
		while(condition){
			print(this.title + baskinInning(this.inning));
			print("1. ȯ�漳��   2. ���ӽ���  3. ���� \n");
			print("------------------------select : ");
			data = input();
			switch(data){	
			case "1":
				//1�� ���ý� ȯ�漳������ ��
				Input ip = new Input(this.title, this.inning);
				confCheck = ip.inputStart();
				break;
			case "2":
				if(confCheck){
					//ȯ�漳���� �ԷµǾ��� ��츸 ������ ���۵ǵ��� ����
					BaskinGame bg = new BaskinGame(this.title, this.inning);
					result = bg.bgStart();
					print(result);
					bResult = true;
					print("\n����Ϸ��� ����Ű�� �Է��ϼ���.");
					end = System.in.read();
				}else{ //�ƴҰ�� �����޽��� ���
					print("ȯ�漳���� ���� ���ּ���\n");
				}
				condition = false;
				break;
			case "3":
				//3�� ���ý� ���� (���� �޴��� �Ѿ)
				print("�����Ͻðڽ��ϱ�? (y/n)");
				data = input();
				if(data.equals("y")||data.equals("Y")){
					condition = false;
				}
				break;
			default:
				print("�߸��� ��ȣ�� �Է��ϼ̽��ϴ�.\n");
			}
		}
		return bResult;
	}
}
