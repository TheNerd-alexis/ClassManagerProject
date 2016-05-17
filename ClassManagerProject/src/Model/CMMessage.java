package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.transform.Result;

import Service.MemberService;

public class CMMessage implements Serializable {

	static MemberService memberService;

	private String command;
	private AbstractModel content;
	private String chat;

	public CMMessage(String command, String chat){
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
//
//	public CMMessage doMsg() {
//		CMResult result = new CMResult();
//		if (command.equals("login"))
//			result.setResult(memberService.login(content));
//		CMMessage returnMsg = new CMMessage(command, result);
//		return returnMsg;
//	}
//
//	public static void readResult(CMMessage msg) {
//		String command = msg.getCommand();
//		if (!(msg.getContent() instanceof CMResult))
//			return;
//		CMResult result = (CMResult) msg.getContent();
//		System.out.println(result.toJson());
//	}
}