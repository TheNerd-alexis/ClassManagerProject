package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.AbstractModel;
import Model.CMMessage;
import Model.Chat;
import Model.Member;

public class Panel004 extends JPanel {
	ImageIcon img = new ImageIcon("img/004_resize.jpg");
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	public TitlePanel titlePanel;
	CMListPanel listPanel;
	List<AbstractModel> chatList;
	Set<String> chatSet;
	private List<ChatPanel> chatComponentList;
	ObjectOutputStream writer;
	private Member member;
	public CMButton friendbtn;
	public CMButton newChatBtn;

	public Panel004(ObjectOutputStream writer) {
		this.writer = writer;
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setLayout(new BorderLayout(0, 0));
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("CM", "커뮤니티", "닫기");
		titlePanel.setBounds(0, 0, 410, 40);
		bgPanel.add(titlePanel);

		friendbtn = new CMButton("친구");
		friendbtn.setBounds(8, 64, 194, 49);
		bgPanel.add(friendbtn);

		newChatBtn = new CMButton("채팅방 개설");
		newChatBtn.setBounds(205, 64, 194, 49);
		bgPanel.add(newChatBtn);

		listPanel = new CMListPanel();
		listPanel.setBounds(-2, 130, 415, 613);
		// listPanel.addComponent(new ChatPanel("채팅방제목"));
		bgPanel.add(listPanel);
		addComponentListener(new ComponentAdapter() {

		});
	}

	public class ChatPanel extends ClassManagerPanel {
		CMButton chatContentBtn;
		JLabel chatTitle;
		CMButton chatOutBtn;

		ChatPanel(String title) {
			super(new ImageIcon("img/blank_2.jpg"));
			chatOutBtn = new CMButton("나가기");
			chatOutBtn.setBounds(305, 10, 77, 40);
			chatContentBtn = new CMButton();
			chatContentBtn.setBounds(0, 0, 400, 60);
			chatContentBtn.setLayout(null);
			chatTitle = new JLabel(title);
			chatTitle.setFont(defaultFont);
			chatContentBtn.add(chatTitle);
			chatTitle.setBounds(10, 12, 290, 40);
			chatContentBtn.add(chatOutBtn);
			add(chatContentBtn);

			chatOutBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (JOptionPane.showConfirmDialog(null, title + "에서 나가시겠습니까?") == 0) {
						Chat chat = new Chat();
						chat.setJid(member.getID());
						chat.setRtitle(title);
						// System.out.println(chat.toJson());
						new CMMessage("chat_out", chat).sendMsg(writer);
					}
				}
			});
		}

		public JLabel getChatTitle() {
			return chatTitle;
		}

		public void setChatTitle(JLabel chatTitle) {
			this.chatTitle = chatTitle;
		}
	}

	public void setChatList(List<AbstractModel> list) {
		chatSet = new HashSet<String>();
		setChatComponentList(new ArrayList<ChatPanel>());
		for (AbstractModel model : list) {
			if (chatSet.add(((Chat) model).getRtitle()))
				getChatComponentList().add(new ChatPanel(((Chat) model).getRtitle()));
		}
		refreshChatList();
	}

	public void refreshChatList() {
		listPanel.clearList();
		List<ChatPanel> tempList = getChatComponentList();
		for (ChatPanel panel : tempList) {
			listPanel.addComponent(panel);
		}

		listPanel.revalidate();
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel004(null));
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<ChatPanel> getChatComponentList() {
		return chatComponentList;
	}

	public void setChatComponentList(List<ChatPanel> chatComponentList) {
		this.chatComponentList = chatComponentList;
	}
}