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
import newClassManagerGUI.Panel001;
import newClassManagerGUI.Panel002;
import newClassManagerGUI.Panel004;

public class ClassManagerGui extends JFrame implements Runnable {
	private Panel001 loginPanel;
	private Panel002 joinPanel;
	private Panel004 chatPanel;
	private CardLayout mainLayout = new CardLayout(0, 0);
	private JPanel basePanel = new JPanel();

	private List<AbstractModel> chatList;
	private List<AbstractModel> scheduleList;
	private List<AbstractModel> friendList;
	private List<AbstractModel> dchList;
	private List<AbstractModel> eventList;
	private List<AbstractModel> multiList;
	private AbstractModel member;
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

		getContentPane().add(loginPanel, "loginPanel");
		getContentPane().add(joinPanel, "joinPanel");
		getContentPane().add(chatPanel, "chatPanel");

		loginPanel.joinBtn.addActionListener(new PanelConverter("joinPanel"));
		joinPanel.title.closeBtn.addActionListener(new PanelConverter("loginPanel"));
		chatPanel.title.closeBtn.addActionListener(new PanelConverter("loginPanel"));
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
				readResult(msg);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void readResult(CMMessage msg) {
		String command = msg.getCommand();
		AbstractModel content = msg.getContent();

		if (!(content instanceof CMResult))
			return;

		if (command.equals("login")) {
			if (((CMResult) content).getResult() == 1) {
				JOptionPane.showMessageDialog(null, "로그인에 성공했습니다.");
				mainLayout.show(getContentPane(), "chatPanel");
			} else
				JOptionPane.showMessageDialog(null, "로그인에 실패했습니다.");
		}

		if (command.equals("check")) {
			if (((CMResult) content).getResult() == 2) {
				joinPanel.idField.setText("중복된 아이디입니다");
				joinPanel.idField.setForeground(Color.RED);
				joinPanel.idcheckstate = false;
			} else
				joinPanel.idcheckstate = true;
		}
		
		if (command.equals("join")) {
			if (((CMResult) content).getResult() == 1) {
				JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.");
				mainLayout.show(getContentPane(), "loginPanel");
			} else
				JOptionPane.showMessageDialog(null, "회원가입에 실패했습니다.");
		}
	}
}
