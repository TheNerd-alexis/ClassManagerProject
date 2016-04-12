package library;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	/**
	 * User 클래스의 serialVersionUID = 2274626298624892578L;
	 */
	private static final long serialVersionUID = 2274626298624892578L;

	String userID;
	
	boolean canBorrow;
	
	int numberOfRentBook;
	
	ArrayList<Book> myBookList;
	
	public User(String s, boolean b, int i)
	{
		userID = s;
		canBorrow = b;
		numberOfRentBook = i;
		myBookList = new ArrayList<Book>();
	}

	public ArrayList<Book> getMyBookList() {
		return myBookList;
	}

	@Override
	public String toString() {
		String str = "";
		for(Book book:myBookList){
			if(book.isBorrow()) str+=book.getBid()+"\t"+book.getBorrowDate()+"\t";
		}
		return userID + "\t" + canBorrow + "\t" + numberOfRentBook + "\t"+str;
	}
}