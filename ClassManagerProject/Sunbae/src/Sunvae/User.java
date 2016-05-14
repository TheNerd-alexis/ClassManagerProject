package Sunvae;

import java.util.Scanner;
import java.util.ArrayList;

public class User {

	Scanner scan = new Scanner(System.in);

	int id; // 고유번호
	int toeic;// 토익점수
	int certi1;// 자격중 - 직무관련 (유무판단)
	String certi2;// 자격중 - 직무비관련(카운팅)
	double score; // 학점
	int school; // (switch 사용) 1.서울상위/2.인서울/3.지거국/4.지방/5.외국대

	double result;

	void Sdata() {

		while (true) {
			System.out.println("toeic점수(IBT 점수만 입력해주시기 바랍니다.) : ");
			toeic = scan.nextInt();
			if (toeic < 0 || toeic > 990) {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			} else {
				if (toeic <= 700) {
					result = result +0;
				} else if (toeic <= 800) {
					result = result +5;
				} else if (toeic <= 900) {
					result = result +10;
				} else if (toeic <= 950) {
					result = result= +15;
				} else if (toeic <= 990) {
					result = (result +25);
				}
				
			}
			break;
		}
		System.out.println(result);

		System.out.println("직무관련 작격증 : " + "\n 보유개수를 입력해주시기 바랍니다.");
		certi1 = scan.nextInt();
		if (certi1 != 0 && certi1 > 0) {
			result = result +5;
		}

		System.out.println("직무비관련 자격증 : ");
		certi2 = scan.nextLine();
		System.out.println(result);

		while (true) {
			System.out.println("학점 : ");
			score = scan.nextDouble();

			if (score < 0 || score > 4.5) {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			} else {
				if (score >= 0 && score < 3.0) {
					result = result -10;
				} else if (score >= 3.0 && score < 3.5) {
					result = result +10;
				} else if (score >= 3.5 && score < 4.0) {
					result = result +20;
				} else if (score >= 4.0 && score < 4.2) {
					result = result +30;
				} else if (score >= 4.2 && score < 4.5) {
					result = result +50;
				}
				break;
			}

			

		}
		System.out.println(result);


		System.out.println("최종학력 : " + "\n 다음과 같이 입력해주세요" + "\n 1.서울상위/2.인서울/3.지거국/4.지방/5.외국대");
		school = scan.nextInt();

		switch (school) {
		case 1:
			result = result +25;

			break;
		case 2:
			result = result +20;

			break;

		case 3:
			result = result + 20;

			break;
		case 4:
			result = result + 15;

			break;

		case 5:

			result = result + 25;
			break;

		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}

		System.out.println("당신의 스펙점수는 "+result);
	}
}
