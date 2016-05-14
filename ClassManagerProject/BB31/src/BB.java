import java.util.Scanner;

public class BB {
	
	public static int random(){
		return (int) (Math.random() * 3) + 1;	
	}
	public static void main(String[] args) {

		int sum =0;
		int p1;

		System.out.println("(((((((베스킨라빈스31)))))))");
		Scanner input = new Scanner(System.in);

		for (;sum<31;) {

			// 플레이어에게 1~3 사이의 수를 입력받는다.
			System.out.println("1~3사이의 수를 입력하세요.");
			p1 = input.nextInt();
			while(Math.abs(sum-p1)>3||p1-sum<=0){
				System.out.println("1~3사이의 수를 입력하세요.");
				p1 = input.nextInt();
			}
			sum = p1;

			System.out.println("당신 : " + p1);

			sum += random();

			System.out.println("컴퓨터 : " + sum);

			if (sum >= 31) {
				System.out.println("먼저 31이상을 부른 사람 졌습니다.");
				break;
			}
		}
	}

}
