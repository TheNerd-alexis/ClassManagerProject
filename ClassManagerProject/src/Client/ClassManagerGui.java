package Client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;
import Model.Chat;
import Model.Event;
import Model.Friend;
import Model.Member;
import newClassManagerGUI.NameCheckPanel;
import newClassManagerGUI.Panel001;
import newClassManagerGUI.Panel002;
import newClassManagerGUI.Panel003;
import newClassManagerGUI.Panel004;
import newClassManagerGUI.Panel006;
import newClassManagerGUI.Panel008;
import newClassManagerGUI.Panel010;
import newClassManagerGUI.Panel012;
import newClassManagerGUI.Panel013;
import newClassManagerGUI.Panel014;
import newClassManagerGUI.Panel016;
import newClassManagerGUI.Panel018;

public class ClassManagerGui extends JFrame implements Runnable {
	private Panel001 loginPanel;
	private Panel002 joinPanel;
	private Panel003 mainPanel;
	private Panel004 chatPanel;
	private Panel006 friendPanel;
	private Panel008 newChatPanel;
	private Panel012 schedulePanel;
	private Panel013 dchPanel;
	private Panel014 newSchPanel;
	private Panel016 eventPanel;
	private Panel018 pwFindPanel;

	private CardLayout mainLayout = new CardLayout(0, 0);
	private JPanel basePanel = new JPanel();

	private List<AbstractModel> chatList;
	private List<AbstractModel> scheduleList;
	private List<AbstractModel> friendList;
	private List<AbstractModel> dchList;
	private List<AbstractModel> eventList;
	private List<AbstractModel> multiList;
	private Map<String, Panel010> chatLog;
	private Member member;
	private Client receiver;

	public ClassManagerGui(Client receiver) {
		this.receiver = receiver;
		setTitle("ClassManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420, 790);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

		getContentPane().setLayout(mainLayout);
		loginPanel = new Panel001(this.receiver.writer);
		joinPanel = new Panel002(this.receiver.writer);
		mainPanel = new Panel003(this.receiver.writer);
		chatPanel = new Panel004(this.receiver.writer);
		friendPanel = new Panel006(this.receiver.writer);
		newChatPanel = new Panel008(receiver.writer);
		schedulePanel = new Panel012();
		dchPanel = new Panel013(this.receiver.writer);
		newSchPanel = new Panel014(receiver.writer);
		eventPanel = new Panel016(receiver.writer);
		pwFindPanel = new Panel018(this.receiver.writer);

		getContentPane().add(loginPanel, "loginPanel");
		getContentPane().add(friendPanel, "friendPanel");
		getContentPane().add(mainPanel, "mainPanel");
		getContentPane().add(joinPanel, "joinPanel");
		getContentPane().add(chatPanel, "chatPanel");
		getContentPane().add(pwFindPanel, "pwFindPanel");
		getContentPane().add(dchPanel, "dchPanel");
		getContentPane().add(schedulePanel, "schedulePanel");
		getContentPane().add(newChatPanel, "newChatPanel");
		getContentPane().add(newSchPanel, "newSchPanel");
		getContentPane().add(eventPanel, "eventPanel");

		loginPanel.joinBtn.addActionListener(new PanelConverter("joinPanel"));
		loginPanel.idpwBtn.addActionListener(new PanelConverter("pwFindPanel"));
		joinPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("loginPanel"));
		joinPanel.titlePanel.leftBtn.addActionListener(new PanelConverter("loginPanel"));
		pwFindPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("loginPanel"));
		pwFindPanel.titlePanel.leftBtn.addActionListener(new PanelConverter("loginPanel"));
		mainPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("dchPanel"));
		mainPanel.chatButton.addActionListener(new PanelConverter("chatPanel"));
		mainPanel.schButton.addActionListener(new PanelConverter("schedulePanel"));
		mainPanel.eventNoticeBtn.addActionListener(new PanelConverter("eventPanel"));
		schedulePanel.titlePanel.closeBtn.addActionListener(new PanelConverter("mainPanel"));
		schedulePanel.titlePanel.leftBtn.addActionListener(new PanelConverter("mainPanel"));
		schedulePanel.addSchBtn.addActionListener(new PanelConverter("newSchPanel"));
		chatPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("mainPanel"));
		chatPanel.friendbtn.addActionListener(new PanelConverter("friendPanel"));
		chatPanel.newChatBtn.addActionListener(new PanelConverter("newChatPanel"));
		chatPanel.titlePanel.leftBtn.addActionListener(new PanelConverter("mainPanel"));
		dchPanel.titlePanel.leftBtn.addActionListener(new PanelConverter("mainPanel"));
		dchPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("mainPanel"));
		newChatPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("chatPanel"));
		newChatPanel.titlePanel.leftBtn.addActionListener(new PanelConverter("mainPanel"));
		newSchPanel.titlePanel.leftBtn.addActionListener(new PanelConverter("mainPanel"));
		newSchPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("schedulePanel"));
		eventPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("mainPanel"));

		friendPanel.titlePanel.closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (friendPanel.titlePanel.closeBtn.getText().equals("-삭제")) {
					for (NameCheckPanel name : friendPanel.friendComponentList) {
						if (name.checkBox.isSelected() && name.checkBox.isVisible()) {
							Friend friend = new Friend();
							friend.setFID(name.nameLabel.getText());
							friend.setMID(member.getMID());
							new CMMessage("friend_delete", friend).sendMsg(receiver.writer);
						}
					}
				} else if (friendPanel.titlePanel.closeBtn.getText().equals("+추가")) {
					if (!(friendPanel.memberComponentList == null || friendPanel.memberComponentList.isEmpty()))
						for (NameCheckPanel mem : friendPanel.memberComponentList) {
							if (mem.checkBox.isSelected()) {
								Friend friend = new Friend();
								friend.setFID(mem.nameLabel.getText());
								friend.setMID(member.getMID());
								new CMMessage("friend_add", friend).sendMsg(receiver.writer);
							}
						}
				}
				mainLayout.show(getContentPane(), "chatPanel");
			}
		});
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowOpened(e);
				mainLayout.show(getContentPane(), "mainPanel");
			}
		});
	}

	class PanelConverter implements ActionListener {
		String dest = "";

		PanelConverter() {
			super();
		}

		PanelConverter(String dest) {
			super();
			this.dest = dest;
		}

		public void actionPerformed(ActionEvent arg0) {
			if (!dest.isEmpty())
				mainLayout.show(getContentPane(), dest);
			else
				mainLayout.next(getContentPane());
		}
	}

	public void run() {
		while (true) {
			try {
				CMMessage msg = (CMMessage) receiver.reader.readObject();
				System.out.print(msg.getCommand());
				if (msg.getContent() != null)
					System.out.println(msg.getContent().toJson());
				readResult(msg);
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "서버와의 접속이 종료되었습니다.\n프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}

	public void readResult(CMMessage msg) {
		String command = msg.getCommand();
		AbstractModel content = msg.getContent();

		if (command.equals("member_login")) {
			if (((CMResult) content).getResult() == 1) {
				JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
				mainLayout.show(getContentPane(), "mainPanel");
				member = new Member().setID(loginPanel.idField.getText());
				friendPanel.setMember(member);
				chatPanel.setMember(member);
				newChatPanel.setMember(member);
				dchPanel.setMember(member);
				newSchPanel.setMember(member);
				mainPanel.setMember(member);
				eventPanel.setMember(member);
				chatLog = new ConcurrentHashMap<String, Panel010>();
				// System.out.println(new
				// Friend().setID(member.getID()).toJson());
			} else {
				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
			}
		}
		if (command.equals("friend_add")) {
			if (((CMResult) content).getResult() == 1) {
				// JOptionPane.showMessageDialog(null, "친구 추가를 성공했습니다.");
				while (friendPanel.titlePanel.closeBtn.getText().equals("닫기"))
					friendPanel.titlePanel.leftBtn.doClick();
				mainLayout.show(getContentPane(), "friendPanel");
			} else
				JOptionPane.showMessageDialog(null, "친구 추가를 실패했습니다.");
		}
		if (command.equals("friend_delete")) {
			if (((CMResult) content).getResult() == 1) {
				// JOptionPane.showMessageDialog(null, "친구 삭제를 성공했습니다.");
				while (friendPanel.titlePanel.closeBtn.getText().equals("닫기"))
					friendPanel.titlePanel.leftBtn.doClick();
				mainLayout.show(getContentPane(), "friendPanel");
			} else
				JOptionPane.showMessageDialog(null, "친구 삭제를 실패했습니다.");
		}

		if (command.equals("member_check")) {
			if (((CMResult) content).getResult() == 2) {
				joinPanel.idField.setText("중복된 아이디입니다");
				joinPanel.idField.setForeground(Color.RED);
				joinPanel.idcheckstate = false;
			} else if (((CMResult) content).getResult() == 1) {
				JOptionPane.showMessageDialog(null, "가입이 가능한 아이디입니다.");
				joinPanel.idcheckstate = true;
			} else {
				joinPanel.idField.setText("가입이 불가합니다");
				joinPanel.idField.setForeground(Color.RED);
				joinPanel.idcheckstate = false;
			}
		}
		if (command.equals("member_idcheck")) {
			if (((CMResult) content).getResult() == 1) {
				pwFindPanel.idField.setText("가입되지 않은 아이디입니다");
				pwFindPanel.idField.setForeground(Color.RED);
				pwFindPanel.idcheckstate = false;
			} else {
				JOptionPane.showMessageDialog(null, "계정이 확인 되었습니다.");
				pwFindPanel.idcheckstate = true;
			}
		}
		if (command.equals("member_pwcheck")) {
			if (((CMResult) content).getResult() == 1) {
				pwFindPanel.pwcheckstate = true;
				JOptionPane.showMessageDialog(null, "계정이 확인 되었습니다.");
				pwFindPanel.idField.setEditable(false);
				pwFindPanel.aField.setEditable(false);
			} else {
				pwFindPanel.aField.setText("질문과 답변을 다시 입력해주세요.");
				pwFindPanel.aField.setForeground(Color.RED);
				pwFindPanel.pwcheckstate = false;
			}
		}
		if (command.equals("member_pwchange")) {
			if (((CMResult) content).getResult() == 1) {
				pwFindPanel.pwcheckstate = true;
				JOptionPane.showMessageDialog(null, "비밀번호가 정상적으로 변경 되었습니다.");
				mainLayout.show(getContentPane(), "loginPanel");
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 변경할 수 없습니다.");
			}
		}
		if (command.equals("member_join")) {
			if (((CMResult) content).getResult() == 1) {
				JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.");
				mainLayout.show(getContentPane(), "loginPanel");
			} else
				JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
		}
		if (command.equals("member_search")) {
			if (((CMResult) content).getResult() == 1) {
				friendPanel.setMemberList(((CMResult) content).getResultList());
				friendPanel.refreshMemberList();
			} else {
				JOptionPane.showMessageDialog(null, "검색한 회원을 찾을 수 없습니다.");
			}
		}
		if (command.equals("chat_add")) {
			if (((CMResult) content).getResult() == 1) {
				mainLayout.show(getContentPane(), "chatPanel");
			} else {
				JOptionPane.showMessageDialog(null, "채팅을 개설할 수 없습니다." + ((CMResult) content).getResult());
			}
		}
		if (command.equals("schedule_add")) {
			if (((CMResult) content).getResult() == 1) {
				mainLayout.show(getContentPane(), "schedulePanel");
			} else {
				JOptionPane.showMessageDialog(null, "일정을 추가할 수 없습니다." + ((CMResult) content).getResult());
			}
		}
		if (command.equals("chat_log")) {
			if (((CMResult) content).getResult() == 1) {
				Chat chat = (Chat) (((CMResult) content).getResultList().get(0));
				JTextArea textArea = chatLog.get(chat.getRtitle()).chatTextArea;
				textArea.append(chat.getChat());
				textArea.setCaretPosition(textArea.getDocument().getLength());
			} else {
				JOptionPane.showMessageDialog(null, "채팅을 전송할 수 없습니다." + ((CMResult) content).getResult());
			}
		}

		if (command.contains("refresh")) {
			if (!(content instanceof CMResult)) {
				// System.out.println(command);
				new CMMessage(command, content.setID(member.getID())).sendMsg(receiver.writer);//
			} else {
				if (command.contains("friend")) {
					friendList = ((CMResult) content).getResultList();
					friendPanel.setFriendList(friendList);
					friendPanel.refreshMemberList();
					friendPanel.refreshFriendList();
					newChatPanel.setFriendList(friendList);
					newSchPanel.setFriendList(friendList);
					
					Iterator<String> it = chatLog.keySet().iterator();
					while(it.hasNext()){
						chatLog.get(it.next()).setFriendList(friendList);
					}
				}
				if (command.contains("multi")) {
					multiList = ((CMResult) content).getResultList();
					mainPanel.setMultiList(multiList);
				}
				if (command.contains("dch")) {
					dchList = ((CMResult) content).getResultList();
					dchPanel.setDchList(dchList);
				}
				if (command.contains("schedule")) {
					mainPanel.schArea.setText("");
					int count = 0;
					SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
					scheduleList = ((CMResult) content).getResultList();
					for (AbstractModel model : scheduleList) {
						if (model.toJson().get("SchDate").toString().equals(dateform.format(new Date()))) {
							mainPanel.schArea.append((String) model.toJson().get("SchTitle") + "\n");
							count++;
						}
						if (count == 3)
							break;
					}
					schedulePanel.setCalendarList(scheduleList);
				}
				if (command.contains("event")) {
					eventList = ((CMResult) content).getResultList();
					if(eventList.size()<1)
						return;
					for (AbstractModel model : eventList) {
						Event e = (Event) model;
					}
					mainPanel.eventNoticeLabelCount.setText(String.format("%02d", eventList.size()));
					mainPanel.eventTitleLabel.setText(((Event) eventList.get(eventList.size() - 1)).getEtitle());
					eventPanel.setEventList(((CMResult) content).getResultList());
				}
				if (command.contains("chat")) {
					chatList = ((CMResult) content).getResultList();
					int count = 0;
					for (AbstractModel model : chatList) {
						String title = ((Chat) model).getRtitle();
						String id = ((Chat) model).getJid();
						if (!chatLog.containsKey(title)) {
							Panel010 tempPanel = new Panel010(receiver.writer, title, member);
							tempPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("chatPanel"));
							tempPanel.titlePanel.leftBtn.addActionListener(new PanelConverter("mainPanel"));
							chatLog.put(title, tempPanel);
							getContentPane().add(tempPanel, title);
						}
						chatLog.get(title).getJoinIdSet().add(id);
						chatLog.get(title).setFriendList(friendList);
					}
					mainPanel.setChatList(chatList);
					chatPanel.setChatList(chatList);

					for (JButton chatBtn : mainPanel.chatListBtn) {
						chatBtn.addActionListener(new PanelConverter(chatBtn.getText()));
					}

					for (Panel004.ChatPanel panel : chatPanel.getChatComponentList()) {
						panel.getChatTitle().addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								mainLayout.show(getContentPane(), panel.getChatTitle().getText());
							}
						});
						panel.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								mainLayout.show(getContentPane(), panel.getChatTitle().getText());
							}
						});
					}
				}
			}
		}
	}
}
