package Model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

import Service.MemberService;

public class CMMessage implements Serializable {

	static MemberService memberService = MemberService.getInstance();

	private String command;
	private AbstractModel content;
	private String chat;

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
		CMResult result = new CMResult();
		if (command.contains("login"))
			result = memberService.login(content);
		if (command.contains("join"))
			result = memberService.join(content);
		if (command.contains("check"))
			result = memberService.idCheck(content);
		// System.out.println(content.toJson().toString());
		CMMessage returnMsg = new CMMessage(command, result);

		return returnMsg;
	}
}