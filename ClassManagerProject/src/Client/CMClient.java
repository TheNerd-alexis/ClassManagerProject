package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;
import Model.Member;
import newClassManagerGUI.ClassManagerFrame;

public class CMClient {

	Thread receiver = null;
	Thread sender = null;
	Socket socket = null;
	ClassManagerFrame gui;

	CMClient() {
		try {
			socket = new Socket("70.12.109.125", 7777);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		receiver = new Thread(new ClientReceiver(socket));
		gui = new ClassManagerFrame();
//		gui.loginPanel.loginBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				Member member = new Member();
//				member.setMID(gui.loginPanel.idField.getText());
//				member.setPW(String.valueOf(gui.loginPanel.passwordField.getPassword()));
//				System.out.println(member.toJson().toString());
//				sendMsg("login", member);
//			}
//		});

	}

	public static void main(String[] args) {
		new CMClient().receiver.start();
	}
}
