package CMServer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class CMServer {

	static ArrayList<Client> clientList = new ArrayList<Client>();

	public void ClientConnect() {
		// TODO Auto-generated method stub
		ServerSocket server;
		try {
			while (true) {
				server = new ServerSocket(5001);
				Socket tempSocket = server.accept();
				Client tempClient = new Client(tempSocket);
				clientList.add(tempClient);
				Thread tempThread = new Thread(new CMReceiver(tempClient));
				tempThread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CMSender(String msg) {
		for (int i = 0; i < clientList.size(); i++) {
			try {
				clientList.get(i).writer.write(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				clientList.remove(i);
			}
		}
	}

	class CMReceiver implements Runnable {
		Client client;

		CMReceiver(Client client) {
			this.client = client;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				String msg = client.reader.readLine();
				CMSender(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Client {
	Socket socket;
	// String userID;
	BufferedReader reader;
	BufferedWriter writer;

	Client(Socket socket) throws IOException {
		this.socket = socket;
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
}