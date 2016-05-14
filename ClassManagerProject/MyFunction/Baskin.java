package gameProject.baskin;

import java.io.IOException;
import java.util.Scanner;

public class Baskin {
	Scanner sc = new Scanner(System.in);
	int inning = 0;
	
	public Baskin(){
	}
	
	public void baskinStart() throws IOException{
		//����Ų ��� ���� �޼���
		boolean check;
		boolean condition = true;
		String title = null;
		String select = null;
		inning++;
		//ȸ���� ���� ���� ����
		while(condition){
			title = getTitle() + baskinInning(inning) + getMenu();
			//Ÿ��Ʋ ���
			print(title);
			select = input();
			switch (select) {
			case "1":
				//1�� ���ý� ���� ����
				BaskinResult re = new BaskinResult(getTitle(), inning);
				check = re.resultStart();
				if(check){
					inning++;
				}
				break;
			case "2":
				//2�� ���ý� ����
				print("�����Ͻðڽ��ϱ�? (y/n)");
				select = input();
				if (select.equals("y") || select.equals("Y")) {
					condition = false;
				}
				break;
			default:
				print("�߸��� ���� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	//����Ų ��� Ÿ��Ʋ ---------------------------------------------------------------
	public String getTitle(){
		String sResult = null;
		StringBuffer sb = new StringBuffer();
		sb.append("\n\n");
		sb.append("********************************************\n");
		sb.append("*                                          *\n");
		sb.append("*          !!    ����Ų ���     !!          *\n");
		sb.append("*                           ������ : ����   *\n");
		sb.append("*                                 ver 1.0  *\n");
		sb.append("********************************************\n");
		sResult = sb.toString();
		return sResult;
	}
	
	public String baskinInning(int idx){
		String sResult = null;
		StringBuffer sb = new StringBuffer();
		sb.append("[ "+ idx + " ] ȸ�� ����Ų��� \n\n");
		sResult = sb.toString();
		return sResult;
	}
	
	public String getMenu(){
		String sResult = null;
		StringBuffer sb = new StringBuffer();
		sb.append("  1. ���� \t 2. ����\n");
		sb.append("--------------------------- ���� : ");
		sResult = sb.toString();
		return sResult;
	}
	
	//------------------------------------------------------------------------------
	
	public String input(){
		//�Է� �޼���
		return sc.next();
	}
	
	public void print(String text){
		//��� �޼���
		System.out.print(text);
	}
}
