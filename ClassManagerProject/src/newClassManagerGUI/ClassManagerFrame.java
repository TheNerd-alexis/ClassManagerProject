package newClassManagerGUI;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Client.ClientReceiver;
import Model.CMMessage;
import Model.Member;

public class ClassManagerFrame extends JFrame {
	public Panel001 loginPanel;
	public Panel002 joinPanel;
	public CardLayout mainLayout = new CardLayout(0, 0);
	JPanel basePanel = new JPanel();

	public ClassManagerFrame(ClientReceiver receiver) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(mainLayout);
		loginPanel = new Panel001(receiver.writer);
		joinPanel = new Panel002(receiver.writer);
		getContentPane().add(loginPanel, "loginPanel");
		getContentPane().add(joinPanel, "joinPanel");
		setSize(420,790);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);

		loginPanel.joinBtn.addActionListener(new PanelConverter("joinPanel"));

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
				mainLayout.show(getContentPane(), ((JButton) arg0.getSource()).getText() + "Panel");
		}
	}
}
