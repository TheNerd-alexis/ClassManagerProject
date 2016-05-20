package Client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.AbstractModel;
import Model.CMMessage;
import Model.CMResult;
import Model.Chat;
import Model.Dch;
import Model.Event;
import Model.Friend;
import Model.Member;
import Model.Schedule;
import newClassManagerGUI.Panel001;
import newClassManagerGUI.Panel002;
import newClassManagerGUI.Panel003;
import newClassManagerGUI.Panel004;
import newClassManagerGUI.Panel006;
import newClassManagerGUI.Panel008;
import newClassManagerGUI.Panel012;
import newClassManagerGUI.Panel013;
import newClassManagerGUI.Panel018;

public class ClassManagerGui extends JFrame implements Runnable {
	private Panel001 loginPanel;
	private Panel002 joinPanel;
	private Panel004 chatPanel;
	private Panel006 friendPanel;
	private Panel018 pwFindPanel;
	private Panel003 mainPanel;
	private Panel013 dchPanel;
	private Panel012 schedulePanel;
	private Panel008 newChatPanel;
	
	private CardLayout mainLayout = new CardLayout(0, 0);
	private JPanel basePanel = new JPanel();

	private List<AbstractModel> chatList;
	private List<AbstractModel> scheduleList;
	private List<AbstractModel> friendList;
	private List<AbstractModel> dchList;
	private List<AbstractModel> eventList;
	private List<AbstractModel> multiList;
	private Member member;
	private Client receiver;
	

	public ClassManagerGui(Client receiver) {
		this.receiver = receiver;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420, 790);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

		getContentPane().setLayout(mainLayout);
		loginPanel = new Panel001(this.receiver.writer);
		joinPanel = new Panel002(this.receiver.writer);
		chatPanel = new Panel004(this.receiver.writer);
		friendPanel = new Panel006(this.receiver.writer);
		pwFindPanel = new Panel018(this.receiver.writer);
		dchPanel = new Panel013(this.receiver.writer);
		mainPanel = new Panel003();
		schedulePanel = new Panel012();
		newChatPanel = new Panel008(receiver.writer);

		getContentPane().add(loginPanel, "loginPanel");
		getContentPane().add(friendPanel, "friendPanel");
		getContentPane().add(mainPanel, "mainPanel");
		getContentPane().add(joinPanel, "joinPanel");
		getContentPane().add(chatPanel, "chatPanel");
		getContentPane().add(pwFindPanel, "pwFindPanel");
		getContentPane().add(dchPanel, "dchPanel");
		getContentPane().add(schedulePanel, "schedulePanel");
		getContentPane().add(newChatPanel, "newChatPanel");

		loginPanel.joinBtn.addActionListener(new PanelConverter("joinPanel"));
		loginPanel.idpwBtn.addActionListener(new PanelConverter("pwFindPanel"));
		joinPanel.title.closeBtn.addActionListener(new PanelConverter("loginPanel"));
		chatPanel.title.closeBtn.addActionListener(new PanelConverter("mainPanel"));
		chatPanel.friendbtn.addActionListener(new PanelConverter("friendPanel"));
		friendPanel.title.closeBtn.addActionListener(new PanelConverter("chatPanel"));
		pwFindPanel.title.closeBtn.addActionListener(new PanelConverter("loginPanel"));
		mainPanel.title.closeBtn.addActionListener(new PanelConverter("dchPanel"));
		dchPanel.titlePanel.closeBtn.addActionListener(new PanelConverter("mainPanel"));
		mainPanel.chatButton.addActionListener(new PanelConverter("chatPanel"));
		mainPanel.schButton.addActionListener(new PanelConverter("schedulePanel"));
		schedulePanel.title.closeBtn.addActionListener(new PanelConverter("mainPanel"));
		friendPanel.title.closeBtn.addActionListener(new PanelConverter("mainPanel"));
		chatPanel.newChatBtn.addActionListener(new PanelConverter("newChatPanel"));
		newChatPanel.title.closeBtn.addActionListener(new PanelConverter("chatPanel"));
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
				System.out.println(msg.getCommand());
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
		if (!(content instanceof CMResult))
			return;

		if (command.equals("member_login")) {
			if (((CMResult) content).getResult() == 1) {
				// JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
				mainLayout.show(getContentPane(), "mainPanel");
				member = new Member().setID(loginPanel.idField.getText());
				friendPanel.setMember(member);
				chatPanel.setMember(member);
				// System.out.println(new
				// Friend().setID(member.getID()).toJson());
				new CMMessage("multi_refresh").sendMsg(receiver.writer);
				new CMMessage("friend_refresh", new Friend().setID(member.getID())).sendMsg(receiver.writer);//
				new CMMessage("event_refresh", new Event().setID(member.getID())).sendMsg(receiver.writer);
				new CMMessage("schedule_refresh", new Schedule().setID(member.getID())).sendMsg(receiver.writer);
				new CMMessage("chat_refresh", new Chat().setID(member.getID())).sendMsg(receiver.writer);
				new CMMessage("dch_refresh", new Dch().setID(member.getID())).sendMsg(receiver.writer);
			} else
				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
		}
		if (command.equals("friend_add")) {
			if (((CMResult) content).getResult() == 1) {
				// JOptionPane.showMessageDialog(null, "친구 추가를 성공했습니다.");
				new CMMessage("friend_refresh", new Friend().setID(member.getID())).sendMsg(receiver.writer);
			} else
				JOptionPane.showMessageDialog(null, "친구 추가를 실패했습니다.");
		}
		if (command.equals("friend_delete")) {
			if (((CMResult) content).getResult() == 1) {
				// JOptionPane.showMessageDialog(null, "친구 삭제를 성공했습니다.");
				new CMMessage("friend_refresh", new Friend().setID(member.getID())).sendMsg(receiver.writer);
			} else
				JOptionPane.showMessageDialog(null, "친구 삭제를 실패했습니다.");
		}

		if (command.equals("member_check")) {
			if (((CMResult) content).getResult() == 2) {
				joinPanel.idField.setText("중복된 아이디입니다");
				joinPanel.idField.setForeground(Color.RED);
				joinPanel.idcheckstate = false;
			} else
				joinPanel.idcheckstate = true;
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
		if (command.contains("refresh")) {
			if (content == null)
				msg.sendMsg(receiver.writer);
			else {
				if (command.contains("friend")) {
					friendPanel.setFriendList(((CMResult) content).getResultList());
					friendPanel.refreshMemberList();
					friendPanel.refreshFriendList();
				}
				if (command.contains("multi")) {
					mainPanel.setMultiList(((CMResult) content).getResultList());
				}
			}
		}
	}
}
