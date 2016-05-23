package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Service.ChatService;
import Service.DchService;
import Service.FriendService;
import Service.MemberService;
import Service.MultiService;
import Service.ScheduleService;

public class CMMessage implements Serializable {

	private String command;
	private AbstractModel content = null;
	private List<AbstractModel> contentList;
	private Set<String> destID;
	private String chat;

	public CMMessage(String command) {
		this.command = command;
	}

	public CMMessage(String command, String chat) {
		this.command = command;
		this.chat = chat;
	}

	public CMMessage(String command, AbstractModel content) {
		this.command = command;
		this.content = content;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public AbstractModel getContent() {
		return content;
	}

	public void setContent(AbstractModel content) {
		this.content = content;
	}

	public List<AbstractModel> getContentList() {
		return contentList;
	}

	public void setContentList(List<AbstractModel> contentList) {
		this.contentList = contentList;
	}

	@Override
	public String toString() {
		return command + "  " + content.toJson().toString();
	}

	public void sendMsg(ObjectOutputStream writer) {
		CMMessage message = new CMMessage(this.command, this.content);
		try {
			writer.writeObject(message);
			writer.flush();
		} catch (IOException e) {
		}
	}

	public CMMessage doMsg() {
		destID = new HashSet<String>();
		CMResult result = new CMResult();
		if (command.equals("member_login")) {
			result = MemberService.member_login(content);
			destID.add(content.getID());
		}
		if (command.equals("member_join")) {
			result = MemberService.member_join(content);
			destID.add(content.getID());
		}
		if (command.equals("member_pwchange")) {
			result = MemberService.member_pwchange(content);
			destID.add(content.getID());
		}
		if (command.equals("member_pwcheck")) {
			result = MemberService.member_pwcheck(content);
			destID.add(content.getID());
		}
		if (command.equals("member_check")) {
			result = MemberService.member_idcheck(content);
			destID.add(content.getID());
		}
		if (command.equals("member_idcheck")) {
			result = MemberService.member_idcheck(content);
			destID.add(content.getID());
		}
		if (command.equals("member_search")) {
			result = MemberService.member_show(content);
			destID.add(content.getID());
		}
		if (command.equals("friend_add")) {
			result = FriendService.friend_add(content);
			destID.add(((Friend) content).getFID());
		}
		if (command.equals("friend_delete")) {
			result = FriendService.friend_delete(content);
			destID.add(((Friend) content).getFID());
		}
		if (command.equals("friend_refresh")) {
			result = FriendService.friend_show(content);
			destID.add(((Friend) content).getMID());
		}
		if (command.equals("multi_refresh")) {
			int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1;
			if (day < 1 || day > 5)
				day = 1;
			result = MultiService.multi_refresh(day);
		}
		if (command.equals("dch_refresh")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date());
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int firstDay = day - cal.get(Calendar.DAY_OF_WEEK);
			int lastDay = firstDay + 4;
			// int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
			// int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

			Date startDate = Date.valueOf(String.format("%4d-%02d-%02d", year, month, firstDay));
			Date endDate = Date.valueOf(String.format("%4d-%02d-%02d", year, month, lastDay));

			result = DchService.getDchList(new Dch().setID(content.getID()), startDate, endDate);
		}
		if (command.equals("dch_update")) {
			result = DchService.dch_add(content);
			if (result.getResult() < 1)
				result = DchService.dch_update(content, content);
		}
		if (command.equals("schedule_refresh")) {
			result = ScheduleService.PrivateSchdule_show(content);
		}
		if (command.equals("chat_refresh")) {
			result = ChatService.chat_refresh((Chat) content);
		}
		if (command.equals("chat_out")) {
			CMResult temp = ChatService.chat_invited(content);
			result = ChatService.chat_out(content);
			for (AbstractModel m : temp.getResultList()) {
				destID.add(((Chat)m).getJid());
			}
		}
		CMMessage returnMsg = new CMMessage(command, result);
		returnMsg.setDestID(destID);
		return returnMsg;
	}

	public void addToDestIdList(String id) {
		this.destID.add(id);
	}

	public Set<String> getDestID() {
		return destID;
	}

	public void setDestID(Set<String> destID) {
		this.destID = destID;
	}
}