package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Model.AbstractModel;
import Model.CMMessage;
import Model.Chat;
import Model.Member;

public class Panel008 extends JPanel {
	private static final long serialVersionUID = 1L;

	ImageIcon img = new ImageIcon("img/008_resize.jpg");

	private CMTextField jointxt;
	private CMTextField searchtxt;
	private CMButton joinBtn;
	private CMButton searchBtn;
	private CMTextField nametxt;
	private JCheckBox check;
	private ObjectOutputStream writer;
	public TitlePanel titlePanel;
	private Set<String> friendSet;
	private CMListPanel friendListPanel;
	public List<AbstractModel> friendList = null;
	public List<NameCheckPanel> friendComponentList = null;
	private Member member;

	public Panel008(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("CM", "채팅방 개설", "닫기");

		titlePanel.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(titlePanel);
		
		jointxt = new CMTextField("개설할 채팅방 제목 입력");
		searchtxt = new CMTextField("추가할 사람의 아이디 입력");
		joinBtn = new CMButton("개설");
		searchBtn = new CMButton();
		searchBtn.setIcon(new ImageIcon(
				new ImageIcon("img/searchIcon.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		check = new JCheckBox();

		jointxt.setBounds(48,60,246,30);
		searchtxt.setBounds(48,125,244,30);
		bgPanel.add(jointxt);
		bgPanel.add(searchtxt);

		joinBtn.setBounds(312,57,54,32);
		bgPanel.add(joinBtn);
		searchBtn.setBounds(312,123,54,32);
		bgPanel.add(searchBtn);
		
		friendListPanel = new CMListPanel();
		friendListPanel.setBounds(25,195,364,535);
		// listPanel.addComponent(new ChatPanel("채팅방제목"));
		bgPanel.add(friendListPanel);

		addListener();
	}

	public void addListener() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				refreshFriendList();
				refreshPanel();
			}
		});

		jointxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().equals("개설할 채팅방 제목 입력") || source.getForeground().equals(Color.RED)) {
					source.setText("");
					source.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().isEmpty()) {
					source.setText("개설할 채팅방 제목 입력");
				}
			}
		});

		searchtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().equals("추가할 사람의 아이디 입력")) {
					source.setText("");
					source.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().isEmpty()) {
					source.setText("추가할 사람의 아이디 입력");
				}
			}
		});

		joinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (jointxt.getText().equals("개설할 채팅방 제목 입력") || jointxt.getForeground().equals(Color.RED)) {
					jointxt.setForeground(Color.RED);
					return;
				}

				String title = jointxt.getText();
				Chat mychat = new Chat();
				mychat.setJid(member.getMID());
				mychat.setRtitle(title);
				new CMMessage("chat_add", mychat).sendMsg(writer);
				for (NameCheckPanel panel : friendComponentList) {
					if(panel.checkBox.isSelected()){
						Chat chat = new Chat();
						chat.setJid(panel.nameLabel.getText());
						chat.setRtitle(title);
//						System.out.println(chat.toJson());
						new CMMessage("chat_invite", chat).sendMsg(writer);
					}
				}
			}
		});
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String keyword = searchtxt.getText();
				if (keyword.equals("추가할 사람의 아이디 입력"))
					keyword = "";
				if (searchtxt.getText().isEmpty())
					return;

				friendListPanel.clearList();
				friendComponentList = new ArrayList<NameCheckPanel>();
				for (AbstractModel friend : friendList) {
					if (friend.getID().contains(keyword)) {
						friendComponentList.add(new NameCheckPanel(friend.getID()));
					}
				}
				refreshFriendListPanel();
			}
		});
	}

	public void setFriendList(List<AbstractModel> friendList) {
		this.friendList = friendList;

		friendSet = new HashSet<String>();
		for (AbstractModel f : this.friendList) {
			friendSet.add(f.getID());
		}
	}

	public void refreshFriendListPanel() {
		friendListPanel.clearList();

		List<NameCheckPanel> tempComponentList = friendComponentList;
		for (NameCheckPanel panel : tempComponentList)
			friendListPanel.addComponent(panel);
		friendListPanel.revalidate();
	}

	public void refreshFriendList() {
		if (friendList == null || friendList.size() < 1)
			return;

		List<NameCheckPanel> tempComponentList = new ArrayList<NameCheckPanel>();
		for (AbstractModel friend : friendList) {
			tempComponentList.add(new NameCheckPanel(friend.getID()));
		}
		friendComponentList = tempComponentList;

		refreshFriendListPanel();
	}

	public void refreshPanel() {
		jointxt.setText("개설할 채팅방 제목 입력");
		jointxt.setForeground(Color.BLACK);
		searchtxt.setText("추가할 사람의 아이디 입력");
	}
	

	public void setMember(Member member) {
		this.member = member;
	}
	
	 public static void main(String[] args) {
	 ClassManagerPanel.constructGUI(new Panel008(null));
	 }
}
