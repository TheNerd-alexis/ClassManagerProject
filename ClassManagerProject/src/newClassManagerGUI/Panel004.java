package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.AbstractModel;
import Model.Chat;

public class Panel004 extends JPanel {
	ImageIcon img = new ImageIcon("img/004_resize.jpg");
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	public TitlePanel title;
	CMListPanel listPanel;
	List<AbstractModel> list;
	ObjectOutputStream writer;
	
	public Panel004(ObjectOutputStream writer){
		this.writer = writer;
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setLayout(new BorderLayout(0,0));
		add(bgPanel,BorderLayout.CENTER);
		
		title = new TitlePanel("CM", "회원가입", "닫기");
		title.setBounds(0,0,410,40);
		bgPanel.add(title);
		
		CMButton friendbtn = new CMButton("친구");
		friendbtn.setBounds(8,64,194,49);
		bgPanel.add(friendbtn);
		
		CMButton newChatBtn = new CMButton("채팅방 개설");
		newChatBtn.setBounds(205,64,194,49);
		bgPanel.add(newChatBtn);
		
		listPanel = new CMListPanel();
		listPanel.setBounds(-2,130,412,613);
//		listPanel.addComponent(new ChatPanel("채팅방제목"));
		bgPanel.add(listPanel);

		addFocusListener(new FocusListener(){
			@Override
			public void focusGained(FocusEvent arg0) {
				refreshChatList(list);
			}

			@Override
			public void focusLost(FocusEvent arg0) {
			}
		});
	}

	class ChatPanel extends ClassManagerPanel{
		CMButton chatContentBtn;
		JLabel chatTitle;
		CMButton chatOutBtn;
		ChatPanel(String title){
			super(new ImageIcon("img/blank_2.jpg"));
			chatOutBtn = new CMButton("나가기");
			chatOutBtn.setBounds(305,10,77,40);
			chatContentBtn = new CMButton();
			chatContentBtn.setBounds(0,0,400,60);
			chatContentBtn.setLayout(null);
			chatTitle = new JLabel(title);
			chatTitle.setFont(defaultFont);
			chatContentBtn.add(chatTitle);
			chatTitle.setBounds(10,12,290,40);
			chatContentBtn.add(chatOutBtn);
			add(chatContentBtn);
		}
	}
	
	public void refreshChatList(List<AbstractModel> list) {
		listPanel.clearList();
		for (AbstractModel model : list) {
			Chat chat = (Chat) model;
			listPanel.addComponent(new ChatPanel(chat.getRtitle()));
		}
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel004(null));
	}
}