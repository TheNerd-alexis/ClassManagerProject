package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import newClassManagerGUI.CMListPanel;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;

public class EventPanel extends JPanel {
	String[] event = { "커뮤니티", "캘린더", "공지" };

	EventPanel(int eventType, String eventContent) {
		setMaximumSize(new Dimension(400, 80));
		setBackground(new Color(255,254,239));
		setBorder(new LineBorder(new Color(108, 108, 108), 1, true));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.NORTH);
		JLabel lblType = new JLabel(event[eventType]);
		panel.add(lblType);
		lblType.setHorizontalTextPosition(SwingConstants.LEFT);
		lblType.setForeground(new Color(108, 108, 108));
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setFont(new Font("굴림", Font.PLAIN, 15));
		lblType.setBorder(new LineBorder(new Color(108, 108, 108)));
		
		JLabel lblNewLabel = new JLabel(eventContent);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setForeground(new Color(108, 108, 108));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		add(lblNewLabel);
	}
	
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.setSize(400, 750);
		TitlePanel titlePanel = new TitlePanel("CM", "이벤트 알림", "닫기");
		temp.getContentPane().add(titlePanel,BorderLayout.NORTH);
		CMListPanel eventListPanel = new CMListPanel();
		eventListPanel.add(new EventPanel(1,"오늘 수업끝나고 치맥??"));
		eventListPanel.add(new EventPanel(0,"19일 임재현 생일"));
		eventListPanel.add(new EventPanel(0,"19일 임재현 생일"));
		eventListPanel.add(new EventPanel(0,"19일 임재현 생일"));
		temp.getContentPane().add(eventListPanel, BorderLayout.CENTER);
		
		temp.setVisible(true);
	}
}