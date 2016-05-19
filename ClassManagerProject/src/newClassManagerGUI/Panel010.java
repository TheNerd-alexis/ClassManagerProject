package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Panel010 extends JPanel {
	
	ImageIcon img = new ImageIcon("img/011_resize.jpg");
	private JTextField msgTextField;
	public TitlePanel title;
	
	public Panel010() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		add(bgPanel,BorderLayout.CENTER);
		
		title = new TitlePanel("CM", "회원가입", "닫기");
		title.setBounds(0,0,410,40);
		bgPanel.add(title);
		
		JLabel chatMemberLable = new JLabel("대화상대");
		chatMemberLable.setBounds(171,60,99,36);
		bgPanel.add(chatMemberLable);
		
		JLabel countLable = new JLabel("New label");
		countLable.setBounds(235,61,64,33);
		bgPanel.add(countLable);
		
		CMButton inviteBtn = new CMButton("+ 초대");
		inviteBtn.setBounds(302,60,72,33);
		bgPanel.add(inviteBtn);
		
		CMButton sendBtn = new CMButton("New button");
		sendBtn.setText("");
		sendBtn.setBounds(309,694,53,32);
		bgPanel.add(sendBtn);
		
		msgTextField = new JTextField();
		msgTextField.setBounds(37,693,261,32);
		bgPanel.add(msgTextField);
		msgTextField.setColumns(10);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setBounds(35,122,338,540);
		bgPanel.add(chatTextArea);
		
	}
	
	
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel010());
	}
}
