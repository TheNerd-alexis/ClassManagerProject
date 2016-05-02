package Client;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender implements Runnable {

	private Socket socket;
	private BufferedWriter bw;

	public Sender(Socket socket) {
		this.socket = socket;
		
	}

	public void run() {

		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				String msg = null;
				bw.write( msg + "\n");
				bw.flush();
			}

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		finally {
			try {
				if (socket != null && socket.isClosed())
					socket.close();

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();

			}

		}

	}

}