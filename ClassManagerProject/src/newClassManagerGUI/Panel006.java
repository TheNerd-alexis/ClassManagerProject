package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.AbstractModel;
import Model.CMMessage;
import Model.Friend;
import Model.Member;

public class Panel006 extends JPanel {
	// ImageIcon listImg = new ImageIcon("img/6-1.jpg"); // in // need list img

	private CMTextField searchTextField; // out
	public TitlePanel titlePanel;
	private CMListPanel memberListPanel;
	private CMListPanel friendListPanel;
	public List<AbstractModel> memberList = null;
	public List<AbstractModel> friendList = null;
	private Set<String> friendSet;
	public List<NameCheckPanel> memberComponentList = null;
	public List<NameCheckPanel> friendComponentList = null;
	private CMButton searchBtn;
	private ObjectOutputStream writer;
	private Member member = new Member();
	private CardLayout mainLayout;

	public Panel006(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(new ImageIcon("img/007_resize.jpg"));
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("관리", "친구", "-삭제");

		titlePanel.setBounds(0, 0, 410, 40);
		bgPanel.add(titlePanel);
		searchTextField = new CMTextField("아이디 검색");
		searchTextField.setBounds(84, 62, 181, 30);
		searchTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(searchTextField);

		searchBtn = new CMButton();
		searchBtn.setIcon(new ImageIcon(
				new ImageIcon("img/searchIcon.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		searchBtn.setBounds(275, 62, 51, 28);
		bgPanel.add(searchBtn);

		memberListPanel = new CMListPanel();
		memberListPanel.setBounds(10, 110, 390, 630);
		bgPanel.add(memberListPanel);
		memberListPanel.setVisible(false);

		friendListPanel = new CMListPanel();
		friendListPanel.setBounds(10, 110, 390, 630);
		bgPanel.add(friendListPanel);
		memberListPanel.setVisible(true);

		addListener();
	}

	public void addListener() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				refreshMemberList();
				refreshFriendList();
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				while (!titlePanel.closeBtn.getText().equals("닫기"))
					titlePanel.leftBtn.doClick();
			}
		});

		searchTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().equals("아이디 검색") || source.getForeground().equals(Color.RED)) {
					source.setText("");
					source.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().isEmpty()) {
					source.setText("아이디 검색");
				}
			}
		});

		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String keyword = searchTextField.getText();
				if (keyword.equals("아이디 검색"))
					keyword = "";
				if (searchTextField.getText().isEmpty())
					return;
				if (titlePanel.closeBtn.getText().equals("+추가")) {
					memberListPanel.clearList();
					Member member = new Member();
					if (!searchTextField.getText().equals("아이디 검색"))
						member.setMID(searchTextField.getText());
					new CMMessage("member_search", member).sendMsg(writer);
				} else {
					friendListPanel.clearList();
					friendComponentList = new ArrayList<NameCheckPanel>();
					for (AbstractModel friend : friendList) {
						if (friend.getID().contains(keyword)) {
							friendComponentList.add(new NameCheckPanel(friend.getID()));
						}
					}
					refreshFriendListPanel();
				}
			}
		});

		titlePanel.leftBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (titlePanel.closeBtn.getText().equals("닫기")) {
					titlePanel.closeBtn.setText("-삭제");
					if (friendComponentList == null)
						return;
					for (int i = 0; i < friendComponentList.size(); i++) {
						friendComponentList.get(i).checkBox.setVisible(true);
						friendComponentList.get(i).checkBox.setEnabled(true);
					}
				} else if (titlePanel.closeBtn.getText().equals("-삭제")) {
					titlePanel.closeBtn.setText("+추가");
					friendListPanel.setVisible(false);
					memberListPanel.setVisible(true);
					memberListPanel.clearList();
				} else if (titlePanel.closeBtn.getText().equals("+추가")) {
					titlePanel.closeBtn.setText("닫기");
					memberListPanel.setVisible(false);
					friendListPanel.setVisible(true);
					if (friendComponentList == null)
						return;
					for (int i = 0; i < friendComponentList.size(); i++) {
						friendComponentList.get(i).checkBox.setVisible(false);
					}
				}
			}
		});

//		title.closeBtn.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				if (title.closeBtn.getText().equals("-삭제")) {
//					for (NameCheckPanel name : friendComponentList) {
//						if (name.checkBox.isSelected() && name.checkBox.isVisible()) {
//							Friend friend = new Friend();
//							friend.setFID(name.nameLabel.getText());
//							friend.setMID(member.getMID());
//							new CMMessage("friend_delete", friend).sendMsg(writer);
//						}
//					}
//				} else if (title.closeBtn.getText().equals("+추가")) {
//					if(memberComponentList==null||memberComponentList.isEmpty())
//						return;
//					for (NameCheckPanel mem : memberComponentList) {
//						if (mem.checkBox.isSelected()) {
//							Friend friend = new Friend();
//							friend.setFID(mem.nameLabel.getText());
//							friend.setMID(member.getMID());
//							new CMMessage("friend_add", friend).sendMsg(writer);
//						}
//					}
//				}
//			}
//		});
	}

	public void refreshFriendListPanel() {
		friendListPanel.clearList();
		if (titlePanel.closeBtn.getText().equals("닫기"))
			for (NameCheckPanel panel : friendComponentList)
				panel.checkBox.setVisible(false);

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

	public void refreshMemberList() {
		memberListPanel.clearList();
		if (memberList == null)
			return;
		memberComponentList = null;
		memberComponentList = new ArrayList<NameCheckPanel>();

		if (titlePanel.closeBtn.getText().equals("+추가")) {
			for (AbstractModel m : memberList) {
				String name = ((Member) m).getMID();
				if (!friendSet.contains(name) && !member.getID().equals(name)) {
					memberComponentList.add(new NameCheckPanel(name));
				}
			}
		}
		for (NameCheckPanel panel : memberComponentList)
			memberListPanel.addComponent(panel);
		memberListPanel.revalidate();
	}

	public void setMemberList(List<AbstractModel> memberList) {
		this.memberList = memberList;
	}

	public void setFriendList(List<AbstractModel> friendList) {
		this.friendList = friendList;

		friendSet = new HashSet<String>();
		for (AbstractModel f : this.friendList) {
			friendSet.add(f.getID());
		}
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}