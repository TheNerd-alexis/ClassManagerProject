package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel006 extends JPanel {
	// ImageIcon listImg = new ImageIcon("img/6-1.jpg"); // in // need list img

	CMTextField searchTextField; // out
	JPanel resultFriendPanel; // out
	public TitlePanel title;
	CMListPanel listPanel006;

	public Panel006() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(new ImageIcon("img/007_resize.jpg"));
		add(bgPanel, BorderLayout.CENTER);

		title = new TitlePanel("CM", "회원가입", "닫기");

		title.setBounds(0, 0,410, 40);
		bgPanel.add(title);
		searchTextField = new CMTextField("이름, 아이디 검색");
		searchTextField.setBounds(84, 62, 181, 30);
		searchTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(searchTextField);
		
		CMButton searchBtn;
		searchBtn = new CMButton();
		searchBtn.setIcon(new ImageIcon(
				new ImageIcon("img/searchIcon.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		searchBtn.setBounds(275,62,51,28);
		bgPanel.add(searchBtn);

		// resultFriendPanel = new JPanel();
		// resultFriendPanel.setBounds(44,120,317,587);
		// resultFriendPanel.setLayout(null);
		// bgPanel.add(resultFriendPanel);

		listPanel006 = new CMListPanel();
		listPanel006.setBounds(10, 110, 380, 630);

		listPanel006.addComponent(new NameCheckPanel("김현우 천재"));
		listPanel006.addComponent(new NameCheckPanel("김진호 빈수레"));
		listPanel006.addComponent(new NameCheckPanel("김진호 빈수레"));

		bgPanel.add(listPanel006);

		// listPanel = new ClassManagerPanel(listImg);
		// listPanel.setBounds(20,118,359,65);
		// bgPanel.add(listPanel);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel006());
	}
}