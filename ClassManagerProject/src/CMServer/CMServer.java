package CMServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;
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
					// System.out.println(message.getContent().toJson());
					returnMsgToClients(message);
				}
			} catch (IOException | ClassNotFoundException e) {
				// removeClient(userID);
				// e.printStackTrace();
			}
		}

		public void refreshToClient(CMMessage message) {
			List<AbstractModel> temp = ((CMResult) message.doMsg().getContent()).getResultList();
			Set<String> destId = new HashSet<String>();
			StringTokenizer token = new StringTokenizer(message.getCommand(), "_");
			String newCommand = token.nextToken() + "_refresh";
			for (AbstractModel model : temp) {
				AbstractModel newContent = message.getContent().setID(model.getID());
				new CMMessage(newCommand, newContent).doMsg().sendMsg(clients.get(model.getID()).writer);
			}
		}

		public void returnMsgToClients(CMMessage msg) {
			CMMessage resultMsg = msg.doMsg();

			if (msg.getCommand().equals("member_login") && ((CMResult) resultMsg.getContent()).getResult() == 1) {
				clients.put(((Member) msg.getContent()).getMID(), client);
			}

			resultMsg.sendMsg(client.writer);

			if (resultMsg.getCommand().contains("add") || resultMsg.getCommand().contains("delete")
					|| resultMsg.getCommand().contains("out")) {

				Iterator<String> it = resultMsg.getDestID().iterator();

				if (((CMResult) resultMsg.getContent()).getResult() > 0) {
					StringTokenizer token = new StringTokenizer(msg.getCommand(), "_");
					String newCommand = token.nextToken() + "_refresh";
					AbstractModel newContent = msg.getContent().setID(null);
					resultMsg = new CMMessage(newCommand, newContent);
//					System.out.println(resultMsg.getCommand());
//					System.out.println(resultMsg.getContent().toJson());
				}
				while (it.hasNext()) {
					String id = it.next();
					if (id == null) {
						resultMsg.sendMsg(client.writer);
					} else if (!clients.containsKey(id))
						continue;
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