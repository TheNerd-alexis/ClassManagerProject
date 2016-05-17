package temp;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class EventPanel extends JPanel {
	String[] event = { "커뮤니티", "캘린더", "공지" };

	EventPanel(int eventType, String eventContent) {
		
		setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{107, 202, 0};
		gridBagLayout.rowHeights = new int[]{20, 27, 0, 112, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		JLabel lblType = new JLabel(event[eventType]);//
		lblType.setFont(new Font("굴림", Font.PLAIN, 15));
		lblType.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.WEST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 0;
		add(lblType, gbc_lblType);
		
		JButton btnNewButton = new JButton(eventContent);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
	}
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		EventListPanel eventListPanel = new EventListPanel();
		eventListPanel.eventList.addComponent(new EventPanel(1,"집에 가고 싶다"));
		eventListPanel.eventList.addComponent(new EventPanel(0,"너는 가기 싫으니?"));
		temp.getContentPane().add(eventListPanel);
		
		temp.setVisible(true);
	}
}

 class EventListPanel extends JPanel {
	CMListPanel<EventPanel> eventList;
	EventListPanel() {
		setLayout(new BorderLayout(0, 0));
		TitlePanel titlePanel = new TitlePanel("CM","이벤트알림","닫기");
		add(titlePanel,BorderLayout.NORTH);//1. title panel 들어감
		eventList = new CMListPanel<EventPanel>();//<T>가 <EventPanel>로 -> EventPanel 배열이 들어가는 폼
		add(eventList);//2. eventPanel 배열 폼 들어감
	}


}
