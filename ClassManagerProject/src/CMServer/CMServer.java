package CMServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Model.CMMessage;
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
			String msg = null;
			try {
				while (true) {
					CMMessage message = (CMMessage) client.reader.readObject();
					if (message.getCommand().equals("login"))
						clients.put(((Member) message.getContent()).getMID(), client);
					message.doMsg().sendMsg(client.writer);
				}
			} catch (IOException | ClassNotFoundException e) {
				// removeClient(userID);
				// // e.printStackTrace();
			}
		}

		public void sendMsgToCient(String[] destId, CMMessage msg) {
			for (String id : destId) {
				msg.sendMsg(clients.get(id).writer);
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