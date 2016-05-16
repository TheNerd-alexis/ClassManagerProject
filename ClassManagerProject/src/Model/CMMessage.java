package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.json.simple.JSONObject;

import Service.MemberService;

public class CMMessage {
	private static Map<String, AbstractModel> protocol = new HashMap<String, AbstractModel>();
	static MemberService memberService;

	private CMMessage() {
		memberService = MemberService.getInstance();
		protocol.put("t01", new Member());
		protocol.put("t02", new Chat());
		protocol.put("t03", new Dch());
		protocol.put("t04", new Event());
		protocol.put("t05", new Friend());
		protocol.put("t06", new Multi());
		protocol.put("t07", new Schedule());
	}

	public static JSONObject sendMsg(String command, AbstractModel model) {
		JSONObject returnMsg = new JSONObject();
		StringTokenizer token = new StringTokenizer(command, "_");
		String service = token.nextToken();
		String modeltype = token.nextToken();

		switch (service) {
		case "login":
			returnMsg.put("result", memberService.login(model));
			break;
		case "join":
			returnMsg.put("result", memberService.join(model));
			break;
		}
		return returnMsg;
	}

	public static AbstractModel readMsg(String command, JSONObject json) {
		StringTokenizer token = new StringTokenizer(command, "_");
		String service = token.nextToken();
		String modeltype = token.nextToken();
	}
}