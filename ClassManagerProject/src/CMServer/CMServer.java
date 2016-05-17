package CMServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;
import Service.MemberService;

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
	static Map<InetAddress, ServerClient> clients = new ConcurrentHashMap<InetAddress, ServerClient>();

	private static CMServerManager instance;

	public static CMServerManager getInstance() {
		if (instance == null)
			instance = new CMServerManager();
		return instance;
	}

	public void addClient(Socket socket) throws IOException {
		ServerClient tempClient = new ServerClient(socket);
		Thread receiver = new Thread(new ServerReceiver(tempClient));
		clients.put(socket.getInetAddress(), tempClient);
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
					CMResult result = new CMResult();
					if (message.getCommand().contains("login")) {
						System.out.println(message.toString());
						result.setResult(MemberService.getInstance().login(message.getContent()));
					}
					sendMsg(message.getCommand(), result);
				}
			} catch (IOException | ClassNotFoundException e) {
				// removeClient(userID);
				// // e.printStackTrace();
			}
		}

		public void sendMsg(String command, AbstractModel model) {
			CMMessage message = new CMMessage(command, model);
			try {
				System.out.println(message.toString());
				client.writer.writeObject(message);
				client.writer.flush();
			} catch (IOException e) {
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