package CMServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;
import Model.Chat;
import Model.Event;
import Model.Member;

public class CMServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		CMServerManager manager = CMServerManager.getInstance();
		try {
			server = new ServerSocket(7777);
			while (true) {
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				manager.addClient(socket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class CMServerManager {
	static Map<String, ServerClient> clients = new ConcurrentHashMap<String, ServerClient>();

	private static CMServerManager instance;

	public static CMServerManager getInstance() {
		if (instance == null)
			instance = new CMServerManager();
		return instance;
	}

	public void addClient(Socket socket) throws IOException {
		ServerClient tempClient = new ServerClient(socket);
		ServerReceiver receiver = new ServerReceiver(tempClient);
		Thread thread = new Thread(receiver);
		thread.start();
	}

	class ServerReceiver implements Runnable {
		ServerClient client;

		public ServerReceiver(ServerClient client) {
			this.client = client;
		}

		public void run() {
			try {
				while (true) {
					CMMessage message = (CMMessage) client.reader.readObject();
					// System.out.println(message.getCommand());
					// if (message.getContent() != null)
					// System.out.println(message.getContent().toJson());
					returnMsgToClients(message);
				}
			} catch (IOException | ClassNotFoundException e) {
				// removeClient(userID);
				// e.printStackTrace();
			}
		}

		public void returnMsgToClients(CMMessage msg) {
			CMMessage resultMsg = msg.doMsg();

			if (msg.getCommand().equals("member_login") && ((CMResult) resultMsg.getContent()).getResult() == 1) {
				client.userId = ((Member) msg.getContent()).getMID();
				clients.put(client.userId, client);
			}

			if (client.userId == null || client.userId.isEmpty()) {
				resultMsg.sendMsg(client.writer);
				return;
			}

			if (resultMsg.getCommand().contains("add") || resultMsg.getCommand().contains("delete")
					|| resultMsg.getCommand().contains("out")|| resultMsg.getCommand().contains("invite")) {
				resultMsg.sendMsg(client.writer);
				if (((CMResult) resultMsg.getContent()).getResult() > 0) {
					StringTokenizer token = new StringTokenizer(msg.getCommand(), "_");
					String newCommand = token.nextToken() + "_refresh";
					AbstractModel newContent = msg.getContent().setID(null);
					resultMsg = new CMMessage(newCommand, newContent);
					// System.out.println(resultMsg.getCommand());
					// System.out.println(resultMsg.getContent().toJson());
					if(!(msg.getContent()).getID().equals(client.userId)){
						AbstractModel content = msg.getContent();
						String command = msg.getCommand();
						Event event = new Event();
						event.setMid(content.getID());
						switch(command){
						case "friend_add":
							event.setEtype(0);
							event.setEtitle(client.userId+"님이 친구에 추가 되었습니다.");
							break;
						case "friend_delete":
							event.setEtype(0);
							event.setEtitle(client.userId+"님이 친구에서 삭제 되었습니다.");
							break;
						case "chat_invite":
							event.setEtype(0);
							event.setEtitle(((Chat)content).getRtitle()+" 채팅에 초대 되었습니다.");
							break;
						case "schedule_add":
							event.setEtype(2);
							event.setEtitle(client.userId+"님이 일정을 공유하였습니다.");
							break;
						}
						event.setEstatus(null);
						new CMMessage("event_add", event).doMsg();
					}
				}
			}
			// System.out.println(client.userId);
			resultMsg.getDestID().add(client.userId);

			Iterator<String> it = resultMsg.getDestID().iterator();
			while (it.hasNext()) {
				String id = it.next();
				if (id == null) {
					resultMsg.sendMsg(client.writer);
				} else if (clients.containsKey(id)) {
					System.out.println(id + " : " + resultMsg.getCommand() + " " + resultMsg.getContent().toJson());
					resultMsg.sendMsg(clients.get(id).writer);
				}
			}
		}
	}
}

class ServerClient {
	String userId;
	Socket socket;
	ObjectOutputStream writer;
	ObjectInputStream reader;

	ServerClient(Socket socket) throws IOException {
		this.socket = socket;
		writer = new ObjectOutputStream(socket.getOutputStream());
		reader = new ObjectInputStream(socket.getInputStream());
	}
}