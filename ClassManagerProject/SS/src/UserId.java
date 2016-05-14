
public class UserId {

	String userID;
	
	boolean canBorrow;
	
	int numberOfRentBook;
	
	public void User(String s, boolean b, int i)
	{
		userID = s;
	}

	@Override
	public String toString() {
		return userID ;
	}
	
	
}

