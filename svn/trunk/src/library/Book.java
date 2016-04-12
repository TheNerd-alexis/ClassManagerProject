package library;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 책에 해당하는 클래스
 * 
 * @author alexis(nerd09@naver.com)
 * 
 */
public class Book implements Serializable {
	/**
	 * Book 클래스의 serialVersionUID = -186941458956396298L
	 */
	private static final long serialVersionUID = -186941458956396298L;

	/**
	 * 전체 책 보유량
	 */
	static int numberOfBooks = 0;

	/**
	 * 책 제목
	 */
	private String title;
	/**
	 * 책 저자
	 */
	private String author;
	/**
	 * 입고 날짜
	 */
	private Date inputDate;
	/**
	 * 대여 날짜
	 */
	private Date borrowDate;
	
	/**
	 * 장르
	 */
	private String genre;

	/**
	 * 책 고유번호<br>
	 * form: 분류번호(3)-입고순서(4)
	 */
	private String bid;
	/**
	 * 대출 여부<br>
	 * true: 대출 중 false: 대출 중 아님
	 */
	private boolean borrow;

	/**
	 * 책의 생성자 Book(title, author, genre)
	 */
	public Book(String title, String author, String genre) {
		numberOfBooks++;
		this.inputDate = new Date();
		this.borrowDate = null;
		this.title = title;
		this.author = author;
		setGenre(genre);
		this.borrow = false;
	}
	
	public Book(Book book){
		this.inputDate = book.getInputDate();
		this.title = book.getTitle();
		this.borrowDate = book.getBorrowDate();
		this.author = book.getAuthor();
		this.genre = book.getGenre();
		this.borrow = book.isBorrow();
	}

	/**
	 * 책의 장르를 결정하는 메소드
	 * 
	 * @param genre
	 *            0 = 총류, 1 = 인문학, 2 = 종교, 3 = 사회과학, 4 = 자연과학, 5 = 기술과학, 6 = 예술,
	 *            7 = 언어, 8 = 문학, 9 = 역사, 10 = 기타<br>
	 * @see {@link #setBid(int)}
	 */
	public void setGenre(String genre) {
		String[] genreList = { "총류", "인문학", "종교", "사회과학", "자연과학", "기술과학", "예술", "언어", "문학", "역사", "기타" };
		int genreIndex;

		for (genreIndex = 0; genreIndex < genreList.length; genreIndex++) {
			if (genreIndex == genreList.length - 1) {
				break;
			} else if (genreList[genreIndex].equals(genre))
				break;
		}
		setBid(genreIndex);
		this.genre = genreList[genreIndex];
	}

	/**
	 * 책의 분류번호를 결정하는 메소드
	 * 
	 * @param genreIndex
	 *            0 = 총류, 1 = 인문학, 2 = 종교, 3 = 사회과학, 4 = 자연과학, 5 = 기술과학, 6 = 예술,
	 *            7 = 언어, 8 = 문학, 9 = 역사, X = 미분류<br>
	 */
	private void setBid(int genreIndex) {
		String bid;
		if (genreIndex < 10) {
			bid = String.format("%d00-%04d", genreIndex, getNumberOfBooks());
		} else {
			bid = String.format("%s-%04d", "X00", getNumberOfBooks());
		}
		this.bid = bid;
	}

	/**
	 * 책의 대출가능여부를 설정하는 메소드
	 * 
	 * @param borrow
	 *            대출여부<br>
	 *            true: 대출가능 false: 대출불가
	 */
	public void setBorrow(boolean borrow) {
		if(borrow == true) this.borrowDate = new Date();
		if(borrow == false) this.borrowDate = null;
		this.borrow = borrow;
	}

	/**
	 * @return 책의 제목을 반환
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return 책의 저자를 반환
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return 책의 입고시기를 반환
	 */
	public Date getInputDate() {
		return inputDate;
	}
	/**
	 * @return 책의 대여시기를 반환
	 */
	public Date getBorrowDate() {
		return borrowDate;
	}

	/**
	 * @return 책의 장르를 반환
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @return 책의 고유번호를 반환
	 */
	public String getBid() {
		return bid;
	}

	/**
	 * @return 전체 책 보관량을 반환
	 */
	public static int getNumberOfBooks() {
		return numberOfBooks;
	}

	/**
	 * 전체 책 보관량을 설정
	 */
	public static void setNumberOfBooks(int number) {
		numberOfBooks = number;
	}

	/**
	 * @return 책의 대출 가능 여부를 반환
	 */
	public boolean isBorrow() {
		return borrow;
	}

	/**
	 * 책의 속성에 키워드가 들어가는지 확인
	 * 
	 * @param keyword
	 *            검색 키워드
	 * @return true = 있음 false = 없음
	 */
	public boolean equalBook(String keyword) {
		CharSequence key = (CharSequence) keyword;
		if (title.contains(key) || author.contains(key) || genre.contains(key))
			return true;
		else
			return false;
	}

	/**
	 * 화면 출력용 toString
	 * 
	 * @return title author date genre bid borrow
	 */
	public String toTempString() {
		String tTitle = title;
		int limTitle = getCutLength(title,15);

		String tAuthor = author;
		int limAuthor = getCutLength(author,8);
		
		String tDate = new SimpleDateFormat("yyyy-MM-dd").format(inputDate);

		if (title.length() > limTitle){
			tTitle = title.substring(0, limTitle) + "...";
		}
		
		if (author.length() > limAuthor)
			tAuthor = author.substring(0, limAuthor) + "...";

		String tBorrow = borrow ? "대출불가" : "대출가능";
		String str = String.format("%-15s\t%-11s\t%-11s\t%-11s\t%-11s\t%-11s", tTitle, tAuthor, tDate, genre, bid,
				tBorrow);
		return str;
	}

	/**
	 * 출력 길이가 주어졌을 때, 어디서 잘라야하는지 결정하는 메소드
	 * 
	 * @param str 길이를 알고 싶은 문자열
	 * @param byteLength 원하는 출력용 길이
	 * @return 출력해야하는 길이 
	 */
	public int getCutLength(String str, int byteLength) {

		int length = str.length();
		int retLength = 0;
		int tempSize = 0;
		int asc;

		for (int i = 0; i < length; i++) {
			asc = (int) str.charAt(i);
			if (asc > 127) {
				if (byteLength > tempSize) {
					tempSize += 2;
					retLength++;
				}
			} else {
				if (byteLength > tempSize) {
					tempSize++;
					retLength++;
				}
			}
		}

		return retLength;
	}

	@Override
	public String toString() {
		return title + "\t" + author + "\t" + inputDate + "\t" + genre + "\t" + bid + "\t" + borrow;
	}
}