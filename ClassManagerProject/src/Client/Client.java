package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;

public class Client{
	ObjectInputStream reader = null;
	public ObjectOutputStream writer = null;
	
	Client(Socket socket){
		try {
			reader = new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}