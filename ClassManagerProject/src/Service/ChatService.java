package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Chat;


public class ChatService {
	
	static GetDAO dao = GetDAO.getInstance();

	public static CMResult chat_in(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
		if(chat.getJid() == null)
			return result.setResult(-2);
		
		if(chat.getRtitle() == null)
			return result.setResult(-3);
		
		return result.setResult(dao.getChatDao().insertChat(chat));
	}


	public static CMResult chat_out(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
		if(chat.getJid() == null)
			return result.setResult(-2);
		if(chat.getRtitle() == null)
			return result.setResult(-3);
		
		return result.setResult(dao.getChatDao().deleteChat(chat));
	}


	public static CMResult chat_refresh(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
		
		if(chat.getJid() == null)
			return result.setResult(-2);//채팅방 id값이 없을 경우 refresh 실패.
		
		Chat temp = new Chat();
		temp.setJid(chat.getJid());
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for(AbstractModel m : dao.getChatDao().selectChat(temp)){
			resultList.add(m);
		}
		result.setResultList(resultList);
		return result.setResult(1);
	}

	public static CMResult chat_invited(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
		if(chat.getRtitle() == null)
			result.setResult(-2);//채팅방 제목값이 없을 경우 invited 실패.
		
		
		Chat temp = new Chat();
		temp.setJid(chat.getRtitle());
	
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for(AbstractModel m : dao.getChatDao().selectChat(chat)){
			resultList.add(m);
		}
		result.setResultList(resultList);
		return result.setResult(1);
		
	}	
}
