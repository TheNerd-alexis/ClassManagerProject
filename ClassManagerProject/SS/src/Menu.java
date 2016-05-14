package library;

import java.io.*;
import java.util.*;

public class Menu {
	static Scanner input = new Scanner(System.in);
	/**
	 * 책 목록
	 */
	static ArrayList<Book> bookList = new ArrayList<Book>();
	/**
	 * 사용자 목록
	 */
	static ArrayList<User> userList = new ArrayList<User>();
	/**
	 * 사용자 목록에서 현재 로그인한 사용자의 위치
	 */
	static int currentUserIndex;

	/**
	 * 대여가능한 책 목록
	 */
	static final int BorrowLimit = 5;

	/**
	 * 가입
	 * @author 박상현
	 */
	public static void join() {

		System.out.println("아이디를 입력하세요: ");
		String id = input.nextLine();

		while (id.length() > 10 || id.length() <= 0 || sameID(id)) {
			System.out.println("너무 길어요ㅠ 다시 입력~");
			id = input.nextLine();
		}

		System.out.println("회원가입이 완료되었습니다.");

		User user = new User(id, true, 0);

		userList.add(user);
		printFirstMenu();
	}

	/**
	 * 중복 아이디 확인
	 * @param s
	 * @return
	 */
	public static boolean sameID(String s) {

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).userID.equals(s)) {
				currentUserIndex = i;
				return true;
			}
		}

		return false;
	}

	/**
	 * 로그인
	 */
	public static void logIn() {
		System.out.println("아이디를 입력하세요: ");
		String id = input.nextLine();

		while (!sameID(id)) {
			System.out.println("아이디가 없습니다. 다시 입력! 메뉴로 돌아가시려면 '0'을 누르세요.");
			id = input.nextLine();
			
			if(id.equals("0")) printFirstMenu(); 
		}
		System.out.println("로그인에 성공했습니다!");
	}

	/**
	 * 새로운 책 입고 메뉴
	 */
	public static void newBook() {
		String title, author, genre;
		System.out.println("입고화면입니다.");
		System.out.print("제목: ");
		title = input.nextLine();
		System.out.print("저자: ");
		author = input.nextLine();
		System.out.println("장르 종류: ");
		System.out.println("총류, 인문학, 종교, 사회과학, 자연과학, 기술과학, 예술, 언어, 문학, 역사, 기타");
		System.out.println();
		System.out.print("장르: ");
		genre = input.nextLine();
		Book temp = new Book(title, author, genre);
		bookList.add(temp);
		System.out.println(bookList.get(bookList.size() - 1).toTempString());
		System.out.println("입고가 완료되었습니다.");

		toBeContinue('n');
	}

	/**
	 * 책 검색 메뉴
	 */
	public static void searchBook() {
		int count = 0;
		System.out.print("검색 키워드: ");
		String keyword = input.nextLine();

		printFirstLineOfTable();
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).toString().contains((keyword))) {
				System.out.println(bookList.get(i).toTempString());
				count++;
			}
		}
		if (count == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("검색이 완료되었습니다.");
		}

		toBeContinue('s');
	}

	/**
	 * 책 출고 메뉴
	 */
	public static void removeBook() {
		System.out.println("삭제할 책의 고유번호: ");
		int index = getBookIndex(input.nextLine());

		if (index >= 0) {
			System.out.println("삭제하시겠습니까?(Y/N)");
			char choice;
			do {
				choice = input.nextLine().toLowerCase().charAt(0);
				if (choice == 'y') {
					bookList.remove(index);
					System.out.println("삭제 완료되었습니다.");
				} else if (choice == 'n') {
					System.out.println("삭제를 취소합니다.");
				}
			} while ((choice != 'y') && (choice != 'n'));
		}

		toBeContinue('d');
	}

	/**
	 * 책 대여 메뉴
	 */
	public static void borrowBook() {

		System.out.println("대여할 책의 고유번호: ");

		int index = getBookIndex(input.nextLine());

		if (index >= 0) {
			if (userList.get(currentUserIndex).numberOfRentBook > 4) {
				System.out.println("대여 가능 권 수를 넘겼습니다.");
			} else if (bookList.get(index).isBorrow()) {
				System.out.println("해당 도서는 이미 대여 중입니다.");
			} else {
				System.out.println(
						"남은 대여 가능 권 수: " + (BorrowLimit - userList.get(currentUserIndex).numberOfRentBook) + "권");
				System.out.println("대여하시겠습니까?(Y/N)");

				char choice;
				do {
					choice = input.nextLine().toLowerCase().charAt(0);
					if (choice == 'y') {
						bookList.get(index).setBorrow(true);
						userList.get(currentUserIndex).numberOfRentBook++;
						System.out.println("대여 되었습니다.");
					} else if (choice == 'n') {
						System.out.println("대여를 취소합니다.");
					}
				} while ((choice != 'y') && (choice != 'n'));
			}
		}
		toBeContinue('b');
	}

	/**
	 * 책 반납 메뉴
	 */
	public static void returnBook() {

		System.out.println("반납할 책의 고유번호: ");
		int index = getBookIndex(input.nextLine());

		if (index >= 0) {
			if (!(bookList.get(index).isBorrow())) {
				System.out.println("대여 되지 않은 책입니다. 반납이 불가합니다.");
			} else {
				bookList.get(index).setBorrow(false);
				userList.get(currentUserIndex).numberOfRentBook--;
				System.out.println("반납 되었습니다.");
				System.out.println(
						"남은 대여 가능 권수: " + (BorrowLimit - userList.get(currentUserIndex).numberOfRentBook) + "권");
			}
		}
		toBeContinue('r');
	}

	/**
	 * @param destination 이전 메뉴<BR>
	 * n = 입고, s = 검색, d = 출고, b = 대여, r = 반납
	 */
	public static void toBeContinue(char destination) {
		char choice;
		do {
			System.out.println("계속하시겠습니까?(Y/N)");
			choice = input.nextLine().toLowerCase().charAt(0);
			if (choice == 'y') {
				switch (destination) {
				case 'n':
					newBook();
				case 's':
					searchBook();
				case 'd':
					removeBook();
				case 'b':
					borrowBook();
				case 'r':
					returnBook();
				}
			} else if (choice == 'n') {
				printSecondMenu();
			}
		} while ((choice != 'y') && (choice != 'n'));
	}

	/**
	 * 입력 받은 고유번호에 해당하는 책의 위치를 찾는 메소드
	 * @param destID 찾기 원하는 책 고유번호
	 * @return 찾는 책의 목록에서의 위치
	 */
	public static int getBookIndex(String destID) {
		printFirstLineOfTable();

		int i;
		for (i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBid().equals(destID)) {
				System.out.println(bookList.get(i).toTempString());
				return i;
			}
		}
		System.out.println("해당 책이 존재하지 않습니다.");
		return -1;
	}

	/**
	 * 도서관리 프로그램 시작 메뉴
	 */
	public static void startLibrary() {
		userList = inList("User");
		bookList = inList("Book");
		Book.setNumberOfBooks(bookList.size());
		printStartPage();
	}

	/**
	 * 시작 화면
	 */
	public static void printStartPage() {
		System.out.println("*********************");
		System.out.println("****도서관리시스템****");
		System.out.println("*********************");
		printFirstMenu();
	}

	/**
	 * 첫번째 메뉴
	 */
	public static void printFirstMenu() {
		System.out.println("1. 로그인\t2. 회원가입\t3. 종료");
		try {
			switch (Integer.parseInt(input.nextLine())) {
			case 1:
				logIn();
				// System.out.println("로그인");
				printSecondMenu();
				break;
			case 2:
				join();
				break;
			case 3:
				exitLibrary();
				break;
			case 5:
				for (int i = 0; i < userList.size(); i++) {
					System.out.println(userList.get(i).toString());
				}
				printFirstMenu();
			case 6:
				for (int i = 0; i < bookList.size(); i++) {
					System.out.println(bookList.get(i).toString());
				}
				printFirstMenu();
			default:
				printFirstMenu();
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 두번째 메뉴
	 */
	public static void printSecondMenu() {
		System.out.println("1. 검색 \t2. 대여\t3. 반납\t4. 입고\t5.출고\t6.종료");
		try {
			switch (Integer.parseInt(input.nextLine())) {
			case 1:
				searchBook();
				break;
			case 2:
				borrowBook();
				break;
			case 3:
				returnBook();
				break;
			case 4:
				newBook();
				break;
			case 5:
				removeBook();
				break;
			case 6:
				exitLibrary();
			default:
				printSecondMenu();
			}
		} catch (Exception e) {
			printSecondMenu();
			// e.printStackTrace();
		}
	}

	/**
	 * 프로그램 종료 메소드
	 */
	public static void exitLibrary() {
		System.out.println("프로그램을 종료합니다.");
		outList(userList, "User");
		outList(bookList, "Book");
		outListFile(userList, "User");
		outListFile(bookList, "Book");
		System.out.println();
		printClosing();
		System.exit(1);
	}

	/**
	 * 프로그램 종료시 나오는 글귀
	 */
	public static void printClosing() {
		String[] saying = { "책은 꿈꾸는 걸 가르쳐 주는 진짜 선생이다. - G. 바슐라르",
				"책은 위대한 천재가 인류에게 남겨 주는 유산이며, 아직 태어나지 않은 자손들에게 주는선물로서 한 세대에서 다른 세대로 전달된다. - J. 에디슨",
				"자손에게 만금을 물려준다 해도 그것은 한 권의 책을 주는 것만 못하다. - 한서",
				"사람이 늙어가며 겪는 생활의 가치는 그 사람이 사는 동안에 얼마나 책을 읽었는가에 따라서 달라진다. - 아놀드", "가장 훌륭한 벗은 가장 좋은 책이다. - 체스터필드" };
		int i = (int) (Math.random() * saying.length);

		System.out.println(saying[i]);
	}

	/**
	 * 책 목록의 첫 행
	 */
	public static void printFirstLineOfTable() {
		System.out.println();
		System.out.printf("%-24s\t%-14s\t%-10s\t%-10s\t%-10s\t%-10s\n", "제목", "저자", "입고시기", "장르", "고유번호", "대여가능여부");
		System.out.printf(
				"------------------------------------------------------------------------------------------------------------\n");
	}

	/**
	 * 저장용 파일 출력
	 * @param arrayList 출력하고자 하는 목록
	 * @param objectName 출력 파일 이름
	 */
	public static <T> void outList(ArrayList<T> arrayList, String objectName) {
		String filename = "lib/" + objectName + ".txt";

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));

			out.writeObject(arrayList);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/**
	 * 읽을 수 있는 파일 출력
	 * @param arrayList 출력하고자 하는 목록
	 * @param objectName 출력 파일 이름
	 */
	public static <T> void outListFile(ArrayList<T> arrayList, String objectName) {
		String filename = "lib/" + "readable_" + objectName + ".dat";

		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(filename));

			for (int i = 0; i < arrayList.size(); i++) {
				out.write(arrayList.get(i).toString());
				out.write("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 파일에서 Object를 입력 받아 ArrayList에 저장
	 * @param objectName 입력하고자 하는 파일 이름
	 * @return 입력받은 자료를 ArrayList 타입으로 저장
	 */
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> inList(String objectName) {
		String filename = "lib/" + objectName + ".txt";

		if (!new File(filename).exists()) {
			return new ArrayList<T>();
		}

		ObjectInputStream in = null;
		List<T> list = new ArrayList<T>();
		try {
			in = new ObjectInputStream(new FileInputStream(filename));
			list = (List<T>) in.readObject();
		} catch (FileNotFoundException e) {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return (ArrayList<T>) list;
	}
}