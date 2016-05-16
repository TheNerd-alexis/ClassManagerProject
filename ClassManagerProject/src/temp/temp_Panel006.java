package temp;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class temp_Panel006 extends JPanel {
//	ImageIcon listImg = new ImageIcon("img/6-1.jpg"); // in // need list img
	
	CMTextField searchTextField; // out
	JPanel resultFriendPanel; // out

	public temp_Panel006() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel( new ImageIcon("img/006_resize.jpg") );
		add(bgPanel, BorderLayout.CENTER);
		
		searchTextField = new CMTextField("이름, 아이디 검색");
		searchTextField.setBounds(38,49,322,36);
		searchTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(searchTextField);
		
		
		resultFriendPanel = new JPanel();
		resultFriendPanel.setBounds(44,120,317,587);
		resultFriendPanel.setLayout(null);
		bgPanel.add(resultFriendPanel);

		
//		listPanel = new ClassManagerPanel(listImg);
//		listPanel.setBounds(20,118,359,65);
//		bgPanel.add(listPanel);
		
		
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new temp_Panel006());
	}
}
