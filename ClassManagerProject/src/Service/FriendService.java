package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Friend;

public class FriendService {
	static GetDAO dao = GetDAO.getInstance();

	/*
	 * Null Type: -100: MID (외래키) MID (PK) -101: FID (외래키) MID (PK)
	 */

	public static CMResult friend_add(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result1 = new CMResult();
		CMResult result2 = new CMResult();

		if (friend.getMID() == null)
			return result1.setResult(-100);

		if (friend.getFID() == null)
			return result1.setResult(-101);

		Friend newFriend = new Friend();
		newFriend.setMID(friend.getFID());
		newFriend.setFID(friend.getMID());
		result1.setResult(dao.getFriendDao().insertFriend(friend));
		result2.setResult(dao.getFriendDao().insertFriend(newFriend));

		if (result1.getResult() < 1)
			return result1;
		if (result2.getResult() < 1)
			return result2;
		return result1;
	}

	public static CMResult friend_delete(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result1 = new CMResult();
		CMResult result2 = new CMResult();

		if (friend.getMID() == null)
			return result1.setResult(-100);

		if (friend.getFID() == null)
			return result1.setResult(-101);

		Friend newFriend = new Friend();
		newFriend.setMID(friend.getFID());
		newFriend.setFID(friend.getMID());
		result1.setResult(dao.getFriendDao().deleteFriend(friend));
		result2.setResult(dao.getFriendDao().deleteFriend(newFriend));
		
		if (result1.getResult() < 1)
			return result1;
		if (result2.getResult() < 1)
			return result2;
		return result1;
	}

	public static CMResult friend_find(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result = new CMResult();

		List<Friend> listFriend = dao.getFriendDao().selectFriend(friend);
		if (listFriend.size() < 1)
			return result.setResult(-2);

		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for (AbstractModel m : listFriend) {
			resultList.add(m);
		}
		result.setResultList(resultList);
		return result.setResult(1);
	}

}