package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Friend;

public class FriendService {
	static GetDAO dao = GetDAO.getInstance();

	public static CMResult friend_add(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result = new CMResult();
		if (friend.getMID() == null)
			result.setResult(-1);
		if (friend.getFID() == null)
			result.setResult(-2);

		result.setResult(dao.getFriendDao().insertFriend(friend));

		return result;
	}

	public static CMResult friend_delete(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result = new CMResult();
		if (friend.getMID() == null)
			result.setResult(-1);
		if (friend.getFID() == null)
			result.setResult(-2);
		
		result.setResult(1);
		
		return result;
	}

	public static CMResult friend_find(AbstractModel model) {
		Friend friend = (Friend) model;
		CMResult result = new CMResult();
		
		if (friend.getMID() == null)
			result.setResult(-1);
		if (friend.getFID() == null)
			result.setResult(-2);
		
		result.setResult(1);
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for(AbstractModel m :dao.getFriendDao().selectFriend(friend)){
			resultList.add(m);
		}
		result.setResultList(resultList);
		
		return result;
	}

}