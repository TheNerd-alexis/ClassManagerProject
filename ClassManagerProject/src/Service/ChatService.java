package Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DAO.ChatDao;
import Model.AbstractModel;
import Model.Chat;


public class ChatService {
	private Connection connection;
	private ChatDao chatDao = ChatDao.getInstance(connection);
	private Chat chat;
	
	public int chat_in(AbstractModel model){
		Chat chat = (Chat)model;
		return chatDao.insertChat(chat);			
	}

	public int chat_out(AbstractModel model){
		Chat chat = (Chat)model;
		return chatDao.deleteChat(chat);			
	}
		
	public List<Chat> chat_refresh(AbstractModel model){
		Chat chat = (Chat)model;
		return chatDao.selectChat(chat);		
	}
	
	public List<String> chat_invited(AbstractModel model){
		Chat chat = (Chat)model;
		List<Chat> chatList = chatDao.selectChat(chat);
		List<String> invitedList = new ArrayList<String>();
		for(int i = 0; i < chatList.size(); i++){
			String invitedId = chatList.get(i).getJid();
			invitedList.add(invitedId);
		}
		return invitedList;			
	}
	
}

