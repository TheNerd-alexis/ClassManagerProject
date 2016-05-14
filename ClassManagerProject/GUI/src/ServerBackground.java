import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	
	ServerSocket serversocket;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	public void Setting(){
		
		try {
		System.out.println("서버 대기중... ");
			serversocket = new ServerSocket(7777);
			socket = serversocket.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			
			System.out.println(socket.getInetAddress() +"서버에 접속되었습니다.");
			
			String msg = in.readUTF();
			System.out.println(msg);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
public static void main(String[] args) {
	ServerBackground sb = new ServerBackground();
	sb.Setting();
}
}
