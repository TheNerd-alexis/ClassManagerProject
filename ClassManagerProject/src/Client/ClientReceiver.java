package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;

class ClientReceiver implements Runnable {
	ObjectInputStream reader = null;
	ObjectOutputStream writer = null;
	
	ClientReceiver(Socket socket){
		try {
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println(reader);
				CMMessage msg = (CMMessage) reader.readObject();
				doMsg(msg);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String command, AbstractModel model) {
		CMMessage message = new CMMessage(command, model);
		try {
			writer.writeObject(message);
			writer.flush();
		} catch (IOException e) {
		}
	}

	public void doMsg(CMMessage message) {
		if (message.getCommand().equals("login")) {
			if(((CMResult)message.getContent()).getResult()==1)
				JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
			else 
				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
		}
		
		if (message.getCommand().equals("join")) {
			if(((CMResult)message.getContent()).getResult()==1)
				JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
			else 
				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
		}
	}
}