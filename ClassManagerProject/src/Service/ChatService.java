package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Chat;


public class ChatService {
	
	static GetDAO dao = GetDAO.getInstance();
	
	/* Null Type:
	 * -100: JID 외래키(MID)
	 * -101: RTITLE(PK)
	 * -102: COME
	 * */
	
	/**
	 * 채팅방 개설 서비스
	 * @param model = Chat
	 * @return 1: 채팅방 개설 성공<br>
	 *         0: 채팅방 개설 실패(INSERT 실패)<br>
	 *        -1: SQL Exception<br>
	 *        -100: JID - NULL<br>
	 *        -101: RTITLE - NULL
	 *        -102: COME - NULL
	 */
	public static CMResult chat_in(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
		
		if(chat.getJid() == null)
			return result.setResult(-100);
		
		if(chat.getRtitle() == null)
			return result.setResult(-101);
		
		if(chat.getCome() == null)
			return result.setResult(-102);

		return result.setResult(dao.getChatDao().insertChat(chat));
	}

	/**
	 * 채팅방 삭제 서비스
	 * @param model = Chat
	 * @return 1: 채팅방 삭제 성공<br>
	 *         0: 채팅방 삭제 실패(DELETE 실패)<br>
	 *        -1: SQL Exception<br>
	 *        -2: List<Chat> 조회 실패<br>
	 *        -100: JID - NULL<br>
	 *        -101: RTITLE - NULL
	 */
	public static CMResult chat_out(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
		
		if(chat.getJid() == null)
			return result.setResult(-100);
		
		if(chat.getRtitle() == null)
			return result.setResult(-101);
		
		return result.setResult(dao.getChatDao().deleteChat(chat));
	}

	/**
	 * 채팅방 새로고침 서비스
	 * @param model = Chat
	 * @return 1: 채팅방 새로고침 성공<br>
	 *         0: 채팅방 새로고침 실패(SELECT 실패)<br>
	 *        -1: Query Exception<br>
	 *        -2: List<Chat> 조회 실패<br>
	 */
	public static CMResult chat_refresh(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
				
		List<Chat> listChat = dao.getChatDao().selectChat(chat);
		
		if(listChat.size() < 1)
			return result.setResult(-2);
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for(AbstractModel m : listChat){
			resultList.add(m);
		}
		result.setResultList(resultList);
		return result.setResult(1);
	}
	
	/**
	 * 채팅방 접속자 조회 서비스
	 * @param model = Chat
	 * @return 1: 채팅방 접속자 조회 성공<br>
	 *         0: 채팅방 접속자 조회 실패(SELECT 실패)<br>
	 *        -1: SQL Exception<br>
	 *        -2: List<Chat> 조회 실패<br>
	*/

	public static CMResult chat_invited(AbstractModel model){
		Chat chat = (Chat) model;
		CMResult result = new CMResult();
				
		List<Chat> listChat = dao.getChatDao().selectChat(chat );
		
		if(chat.getRtitle() == null)
			return result.setResult(-101);
		
		if (listChat.size() < 1)
			return result.setResult(-2);
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for(AbstractModel m : listChat){
			resultList.add(m);
		}
		result.setResultList(resultList);
		return result.setResult(1);
		
	}	
}
