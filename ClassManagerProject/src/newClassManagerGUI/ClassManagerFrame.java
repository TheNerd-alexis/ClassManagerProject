package newClassManagerGUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Client.Client;
import Model.AbstractModel;

public class ClassManagerFrame extends JFrame {
	private Panel001 loginPanel;
	private Panel002 joinPanel;
	private Panel004 chatPanel;
	private Panel013 dchPanel;
	private CardLayout mainLayout = new CardLayout(0, 0);
	private JPanel basePanel = new JPanel();
	
	private List<AbstractModel> chatList;
	private List<AbstractModel> scheduleList;
	private List<AbstractModel> friendList;
	private List<AbstractModel> dchList;
	private List<AbstractModel> eventList;
	private List<AbstractModel> multiList;
	private AbstractModel member;

	public ClassManagerFrame(Client receiver) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(mainLayout);
		loginPanel = new Panel001(receiver.writer);
		joinPanel = new Panel002(receiver.writer);
		chatPanel = new Panel004(receiver.writer);
		dchPanel = new Panel013(receiver.writer);
		getContentPane().add(chatPanel, "chatPanel");
		getContentPane().add(loginPanel, "loginPanel");
		getContentPane().add(joinPanel, "joinPanel");
		getContentPane().add(dchPanel, "dchPanel");
		
		setSize(420,790);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

		loginPanel.joinBtn.addActionListener(new PanelConverter("joinPanel"));
		joinPanel.title.closeBtn.addActionListener(new PanelConverter("loginPanel"));
		chatPanel.title.closeBtn.addActionListener(new PanelConverter("mainPanel"));	}

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
}
