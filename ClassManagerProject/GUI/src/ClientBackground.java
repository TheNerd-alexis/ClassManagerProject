import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	public void connect(){
	
		try {
			socket = new Socket("127.0.0.1", 7777);
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			out.writeUTF("안녕 나는 클라라야 ");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static void main(String[] args) {
	ClientBackground cb = new ClientBackground();
	cb.connect();
}
}
