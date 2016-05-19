package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel007 extends JPanel {
	public TitlePanel title;
	CMTextField inputFriendTextField; // out
	CMButton searFriendListBtn; // in
	
	JPanel friendListPanel; // out
	JPanel searchFriendListPanel; // out
	CMListPanel listPanel007; // out

	public Panel007() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel( new ImageIcon("img/007_resize.jpg") );
		add(bgPanel, BorderLayout.CENTER);
		
		title = new TitlePanel("CM", "회원가입", "닫기");
		title.setBounds(0,0,410,40);
		bgPanel.add(title);
		
		inputFriendTextField = new CMTextField("아이디, 이메일 주소 검 색");
		inputFriendTextField.setBounds(85,62,171,26);
		inputFriendTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(inputFriendTextField);
		
		
		Image resizeImg01 = new ImageIcon("img/searchIcon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon searchIconBtnImg = new ImageIcon(resizeImg01);
		
		JLabel searchImgLabel = new JLabel();
		searchImgLabel.setIcon(searchIconBtnImg);
		searchImgLabel.setBounds(268,59,52,33);
		searchImgLabel.setVerticalAlignment(JLabel.CENTER);
		searchImgLabel.setHorizontalAlignment(JLabel.CENTER);
		bgPanel.add(searchImgLabel);
		
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
		
		listPanel007 = new CMListPanel();
		listPanel007.setBounds(20,118,359,610);
		listPanel007.addComponent( new miniPanel007("내용 없음1") );
		listPanel007.addComponent( new miniPanel007("내용 없음2") );
		listPanel007.addComponent( new miniPanel007("내용 없음3") );
		listPanel007.addComponent( new miniPanel007("내용 없음4") );
		listPanel007.addComponent( new miniPanel007("내용 없음5") );
		listPanel007.addComponent( new miniPanel007("내용 없음6") );
		bgPanel.add(listPanel007);
		
		
	}
	
	class miniPanel007 extends ClassManagerPanel {
		
		JLabel ListNameJLabel;
		CMButton addFriendBtn;
		
		
		
		public miniPanel007() {
			super( new ImageIcon("img/ListPanel01.jpg"));
			
			
			ListNameJLabel = new JLabel("name");
			ListNameJLabel.setBounds(10,0,273,60);
			ListNameJLabel.setVerticalAlignment(JLabel.CENTER);
			ListNameJLabel.setHorizontalAlignment(JLabel.LEFT);
			add(ListNameJLabel);
			
			addFriendBtn = new CMButton("+ 추가");
			addFriendBtn.setBounds(280,12,60,38);
			addFriendBtn.setVerticalAlignment(JButton.CENTER);
			addFriendBtn.setHorizontalAlignment(JButton.CENTER);
			add(addFriendBtn);
			
			
			Image resizeImg01 = new ImageIcon("img/AddBtn.png").getImage().getScaledInstance(60, 38, Image.SCALE_SMOOTH);
			ImageIcon addBtnImg = new ImageIcon(resizeImg01);
			
			JLabel addImgLabel = new JLabel();
			addImgLabel.setIcon(addBtnImg);
			addImgLabel.setBounds(280,12,60,38);
			addImgLabel.setVerticalAlignment(JLabel.CENTER);
			addImgLabel.setHorizontalAlignment(JLabel.CENTER);
			add(addImgLabel);
			
		}
		
		public miniPanel007(String text) {
			this();
			ListNameJLabel.setText(text);
		}
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel007());
	}

}
