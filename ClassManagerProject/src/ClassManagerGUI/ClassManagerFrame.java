package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassManagerFrame extends JFrame {
	JoinPanel joinPanel = new JoinPanel();
	LoginPanel loginPanel = new LoginPanel();
	CardLayout mainLayout= new CardLayout(2, 2);
	JPanel basePanel = new JPanel();
	
	public ClassManagerFrame() {
		setSize(400, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().add(basePanel, BorderLayout.CENTER);
		basePanel.setLayout(mainLayout);
		
		basePanel.add(joinPanel, "joinPanel");
		basePanel.add(loginPanel, "loginPanel");
		joinPanel.titlePanel.btnTitle.addActionListener(new PanelConverter("loginPanel"));
		loginPanel.btnJoin.addActionListener(new PanelConverter("joinPanel"));
		joinPanel.btnJoin.addActionListener(new PanelConverter("loginPanel"));
//		getContentPane().add(new MainPanel(), "mainPanel");
//		getContentPane().add(new CommunityPanel(), "communityoPanel");
//		getContentPane().add(new FriendPanel("add"), "addFriendPanel");
//		getContentPane().add(new FriendPanel("delete"), "deleteFriendPanel");
//		getContentPane().add(new FriendPanel("invite"), "inviteFriendPanel");
//		getContentPane().add(new ChatPanel("chatTitle"), "chatPanel");
//		getContentPane().add(new CalendarPanel(), "CalendarFriendPanel");
//		getContentPane().add(new DailyCheckPanel(), "dailyCheckPanel");
//		getContentPane().add(new CreateEventPanel("Calendar"), "addCalendarEventPanel");
//		getContentPane().add(new EventPanel(), "EventPanel");
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ClassManagerFrame();
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
				mainLayout.show(basePanel, dest);
			else
				mainLayout.show(basePanel, ((JButton) arg0.getSource()).getText() + "Panel");
		}
	}
}
