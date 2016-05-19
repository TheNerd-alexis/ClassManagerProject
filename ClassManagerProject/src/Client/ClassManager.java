package Client;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

import newClassManagerGUI.ClassManagerFrame;

public class ClassManager {

	public Client receiver = null;
	Thread sender = null;
	Socket socket = null;

	public ClassManager() {
		try {
			socket = new Socket("127.0.0.1", 7777);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "서버와의 접속이 불가능합니다.\n프로그램을 종료합니다.");
			System.exit(0);
		}
		receiver = new Client(socket);
		ClassManagerGui gui = new ClassManagerGui(receiver);
		Thread tempThread = new Thread(gui);
		tempThread.start();
		try {
			tempThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClassManager();
	}
}
