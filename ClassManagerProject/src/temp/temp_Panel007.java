package temp;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class temp_Panel007 extends JPanel {
	
	CMTextField inputFriendTextField; // out
	CMButton searFriendListBtn; // in
	
	JPanel friendListPanel; // out
	JPanel searchFriendListPanel; // out
	ClassManagerPanel listPanel; // out

	public temp_Panel007() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel( new ImageIcon("img/007_resize.jpg") );
		add(bgPanel, BorderLayout.CENTER);
		
		inputFriendTextField = new CMTextField("아이디, 이메일 주소 검 색");
		inputFriendTextField.setBounds(85,62,171,26);
		inputFriendTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(inputFriendTextField);
		
		searFriendListBtn = new CMButton(null);
		searFriendListBtn.setBounds(268,59,52,33);
		bgPanel.add(searFriendListBtn);
		
		
//		friendListPanel = new JPanel();
//		friendListPanel.setBounds(20,118,359,610);
//		friendListPanel.setLayout(null);
//		bgPanel.add(friendListPanel);
//		
//		searchFriendListPanel = new JPanel();
//		searchFriendListPanel.setBounds(20,118,359,610);
//		searchFriendListPanel.setLayout(null);
//		bgPanel.add(searchFriendListPanel);
		
		listPanel = new ClassManagerPanel( new ImageIcon("img/7-1.jpg") );
		listPanel.setBounds(20,118,359,65);
		bgPanel.add(listPanel);
		
		
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new temp_Panel007());
	}
}
