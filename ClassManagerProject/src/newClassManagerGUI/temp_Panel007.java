package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class temp_Panel007 extends JPanel {
	ImageIcon img = new ImageIcon("img/007_resize.jpg"); // in
	ImageIcon listImg = new ImageIcon("img/7-1.jpg"); // in // need resize img 7-1.jpg
	
	CMTextField inputFriendTextField; // out
	CMButton searFriendListBtn; // in
	
	JPanel friendListPanel; // out
	JPanel searchFriendListPanel; // out
	ClassManagerPanel listPanel; // out

	public temp_Panel007() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);
		
		inputFriendTextField = new CMTextField("아이디, 이메일 주소 검 색");
		inputFriendTextField.setBounds(85,62,171,26);
		inputFriendTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(inputFriendTextField);
		
		searFriendListBtn = new CMButton("");
		searFriendListBtn.setBounds(268,59,52,33);
		bgPanel.add(searFriendListBtn);
		
		
//		friendListPanel = new JPanel();
//		friendListPanel.setBounds(20,118,359,610);
//		friendListPanel.setLayout(null);
//		bgPanel.add(friendListPanel);
		
//		searchFriendListPanel = new JPanel();
//		searchFriendListPanel.setBounds(20,118,359,610);
//		searchFriendListPanel.setLayout(null);
//		bgPanel.add(searchFriendListPanel);
		
		listPanel = new ClassManagerPanel(listImg);
		listPanel.setBounds(20,118,359,65);
		bgPanel.add(listPanel);
		
		
	}
	
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.getContentPane().add(new temp_Panel007(), BorderLayout.CENTER);
		temp.setVisible(true);
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.pack();
		temp.setLocationRelativeTo(null);
	}

}
