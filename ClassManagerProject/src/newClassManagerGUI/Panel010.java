package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Model.AbstractModel;
import Model.CMMessage;
import Model.Chat;
import Model.Member;

public class Panel010 extends JPanel {

	ImageIcon img = new ImageIcon("img/011_resize.jpg");
	private CMTextField msgTextField;
	public TitlePanel titlePanel;
	JLabel chatMemberLabel;
	ObjectOutputStream writer;
	String title;
	Member member;
	Set<String> joinIdSet = new HashSet<String>();
	JScrollPane scrollBar;
	public JTextArea chatTextArea;
	public Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);

	private CMListPanel friendListPanel;
	public List<AbstractModel> friendList = null;
	public List<NameCheckPanel> friendComponentList = new ArrayList<NameCheckPanel>();

	public Panel010(ObjectOutputStream writer, String title, Member member) {
		this.title = title;
		this.writer = writer;
		this.member = member;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("CM", this.title, "닫기");
		titlePanel.setBounds(0, 0, 410, 40);
		bgPanel.add(titlePanel);

		chatMemberLabel = new JLabel("참여인원   ");
		chatMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chatMemberLabel.setBounds(175, 59, 133, 36);
		chatMemberLabel.setFont(defaultFont);
		bgPanel.add(chatMemberLabel);

		CMButton inviteBtn = new CMButton("+초대");
		inviteBtn.setBounds(315, 64, 71, 34);
		inviteBtn.setFont(defaultFont);
		inviteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (friendListPanel.isVisible()) {
					inviteBtn.setText("+초대");
					friendListPanel.setVisible(false);
					chatTextArea.setVisible(true);
					scrollBar.setVisible(true);
					List<CMMessage> msgList = new ArrayList<CMMessage>();
					String inviteId = new String();
					for (NameCheckPanel panel : friendComponentList) {
						if (panel.checkBox.isSelected()) {
							Chat chat = new Chat();
							chat.setRtitle(title);
							chat.setJid(panel.nameLabel.getText());
							inviteId += panel.nameLabel.getText() + " ";
							msgList.add(new CMMessage("chat_invite", chat));
						}
					}
					if (!inviteId.isEmpty())
						if (JOptionPane.showConfirmDialog(null, "아래 친구를 " + title + "로 초대하시겠습니까?\n" + inviteId) == 0) {
							for (CMMessage msg : msgList)
								msg.sendMsg(writer);
						}
				} else {
					inviteBtn.setText("확인");
					friendListPanel.setVisible(true);
					chatTextArea.setVisible(false);
					scrollBar.setVisible(false);
				}
			}
		});

		bgPanel.add(inviteBtn);

		CMButton sendBtn = new CMButton("전송");
		sendBtn.setBounds(320, 711, 59, 28);
		sendBtn.setFont(defaultFont);
		bgPanel.add(sendBtn);

		msgTextField = new CMTextField();
		// msgTextField.setOpaque(true);
		msgTextField.setBounds(45, 705, 269, 30);
		bgPanel.add(msgTextField);
		// msgTextField.setColumns(10);
		msgTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
					sendBtn.doClick();
			}
		});

		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (msgTextField.getText().equals(""))
					return;
				Chat chat = new Chat();
				chat.setRtitle(title);
				chat.setJid(member.getMID());
				chat.setChat(member.getMID() + " : " + msgTextField.getText() + "\n");
				new CMMessage("chat_log", chat).sendMsg(writer);
				msgTextField.setText("");
			}
		});

		chatTextArea = new JTextArea();
		chatTextArea.setEditable(false);
		chatTextArea.setLineWrap(true);
		chatTextArea.setBackground(new Color(254, 246, 223));
		chatTextArea.setForeground(Color.BLACK);
		chatTextArea.setFont(defaultFont);
		chatTextArea.setBorder(null);

		scrollBar = new JScrollPane(chatTextArea);
		scrollBar.setBounds(35, 122, 338, 550);
		scrollBar.setBackground(Color.RED);
		scrollBar.setBorder(null);
		scrollBar.setOpaque(true);
		bgPanel.add(scrollBar);

		friendListPanel = new CMListPanel();
		// friendListPanel.setOpaque(true);
		friendListPanel.setBounds(14, 101, 384, 590);
		friendListPanel.setVisible(false);
		bgPanel.add(friendListPanel);

		this.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent arg0) {
				refreshPanel();
			}
		});
		friendListPanel.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				refreshFriendComponentList();
				refreshFriendListPanel();
			}
		});
	}

	public Set<String> getJoinIdSet() {
		return joinIdSet;
	}

	public void refreshPanel() {
		refreshFriendComponentList();
		refreshFriendListPanel();
		friendListPanel.setVisible(false);
	}

	public void setFriendList(List<AbstractModel> friendList) {
		if (friendList == null || friendList.size() < 1)
			return;

		this.friendList = friendList;
		chatMemberLabel.setText(String.format("참여인원 %02d", joinIdSet.size()));
		if (joinIdSet.isEmpty())
			chatMemberLabel.setToolTipText(null);
		else {
			Iterator<String> it = joinIdSet.iterator();
			String joinId = new String();
			while (it.hasNext())
				joinId += " " + it.next();

			chatMemberLabel.setToolTipText(joinId);
		}

		refreshFriendComponentList();
	}

	public void refreshFriendComponentList() {
		List<NameCheckPanel> tempComponentList = new ArrayList<NameCheckPanel>();
		for (AbstractModel friend : friendList) {
			if (!joinIdSet.contains(friend.getID()))
				tempComponentList.add(new NameCheckPanel(friend.getID()));
		}
		friendComponentList = tempComponentList;
	}

	public void refreshFriendListPanel() {
		friendListPanel.clearList();

		List<NameCheckPanel> tempComponentList = friendComponentList;
		for (NameCheckPanel panel : tempComponentList)
			friendListPanel.addComponent(panel);
		friendListPanel.revalidate();
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel010(null, null, null));
	}
}
