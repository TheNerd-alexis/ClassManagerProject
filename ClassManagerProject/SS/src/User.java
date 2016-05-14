package library;
import java.io.Serializable;

public class User implements Serializable {

	/**
	 * User 클래스의 serialVersionUID = 2274626298624892578L;
	 */
	private static final long serialVersionUID = 2274626298624892578L;

	String userID;
	
	boolean canBorrow;
	
	int numberOfRentBook;
	
	public User(String s, boolean b, int i)
	{
		userID = s;
		canBorrow = b;
		numberOfRentBook = i;
	}

	@Override
	public String toString() {
		return userID +"\t" + canBorrow + "\t" + numberOfRentBook;
	}
	
	
}