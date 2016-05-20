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
	 * Null Type:
	 * -100: MID (외래키) MID (PK)
	 * -101: FID (외래키) MID (PK)
	 */

	public static CMResult friend_add(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result = new CMResult();
		
		if (friend.getMID() == null)
			return result.setResult(-100);
		
		if (friend.getFID() == null)
			return result.setResult(-101);

		return result.setResult(dao.getFriendDao().insertFriend(friend));
	}

	public static CMResult friend_delete(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result = new CMResult();
		
		if (friend.getMID() == null)
			return result.setResult(-100);
		
		if (friend.getFID() == null)
			return result.setResult(-101);
		
		return result.setResult( dao.getFriendDao().deleteFriend(friend) );
	}

	public static CMResult friend_find(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result = new CMResult();
		
		
		List<Friend> listFriend = dao.getFriendDao().selectFriend(friend);
		if (listFriend.size() < 1)
			return result.setResult(-2);
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for(AbstractModel m : listFriend){
			resultList.add(m);
		}
		result.setResultList(resultList);
		return result.setResult(1);
	}

}