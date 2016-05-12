package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class temp_Panel004 extends JPanel {
	ImageIcon img = new ImageIcon("img/004_resize.jpg");
	
	CMButton addfriendBtn; // in
	CMButton createChatRoomBtn; // in
	
	JPanel chatListPanel; // out
	
	
	public temp_Panel004() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel,BorderLayout.CENTER);
		
		addfriendBtn = new CMButton("친구");
		addfriendBtn.setBounds(9,60,190,52);
		bgPanel.add(addfriendBtn);
		
		createChatRoomBtn = new CMButton("채팅방 개설");
		createChatRoomBtn.setBounds(200,60,191,52);
		bgPanel.add(createChatRoomBtn);
		
		// insert img ..
		// list
		chatListPanel = new JPanel();
		chatListPanel.setBounds(9,130,381,610);
		chatListPanel.setLayout(null);
		bgPanel.add(chatListPanel);
		
		
	}
	
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.getContentPane().add(new temp_Panel004(), BorderLayout.CENTER);
		temp.setVisible(true);
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.pack();
		temp.setLocationRelativeTo(null);
	}
}
