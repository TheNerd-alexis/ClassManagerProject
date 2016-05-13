package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newClassManagerGUI.CMListPanel;

public class EventMainPanel extends JPanel {
	TitlePanel titlePanel;
	CMListPanel eventListPanel;
	
	EventMainPanel(){
		setLayout(new BorderLayout(0, 0));		
		titlePanel = new TitlePanel("CM", "이벤트 알림", "닫기");
		this.add(titlePanel,BorderLayout.NORTH);
		JPanel basePanel = new JPanel();
		basePanel.setBackground(Color.WHITE);
		this.add(basePanel,BorderLayout.CENTER);
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[]{20, 150, 20, 0};
		gbl_basePanel.rowHeights = new int[]{20, 219, 20, 0};
		gbl_basePanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_basePanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		basePanel.setLayout(gbl_basePanel);
		
		eventListPanel = new CMListPanel();
		GridBagConstraints gbc_eventListPanel = new GridBagConstraints();
		gbc_eventListPanel.fill = GridBagConstraints.BOTH;
		gbc_eventListPanel.insets = new Insets(0, 0, 5, 5);
		gbc_eventListPanel.gridx = 1;
		gbc_eventListPanel.gridy = 1;
		basePanel.add(eventListPanel, gbc_eventListPanel);
	}
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.setSize(400, 750);		
		EventMainPanel eventMainPanel = new EventMainPanel(); 
		eventMainPanel.eventListPanel.add(new EventPanel(0,"오늘 수업끝나고 치맥??"));
		eventMainPanel.eventListPanel.add(new EventPanel(1,"19일 임재현 생일"));

		temp.getContentPane().add(eventMainPanel, BorderLayout.CENTER);
		
		temp.setVisible(true);
	}
}
