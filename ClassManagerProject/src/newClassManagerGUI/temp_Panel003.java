package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class temp_Panel003 extends JPanel {
	ImageIcon img = new ImageIcon("img/003_resize.jpg");
	
	JPanel todayWeatherPanel; // out
	JPanel TemperaturePanel; // out
	
	JLabel eventNoticeLabel; // out
	CMButton eventListBtn01; // out
	
	JLabel calendarTitleLabel; // in
	
	CMButton calendarListBtn01; // out
	CMButton calendarListBtn02; // out
	CMButton calendarListBtn03; // out
	
	JLabel communityTitleLabel; // in
	
	CMButton communityChatListBtn01; // out
	CMButton communityChatListBtn02; // out
	CMButton communityChatListBtn03; // out
	
	CMButton newCreateChatRoomBtn; // in
	
	JPanel foodMenuPanel; // out
	

	public temp_Panel003() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);
		
		todayWeatherPanel = new JPanel();
		todayWeatherPanel.setBounds(19,53,154,108);
		todayWeatherPanel.setLayout(null);
		bgPanel.add(todayWeatherPanel);
		
		TemperaturePanel = new JPanel();
		TemperaturePanel.setBounds(185,53,203,107);
		TemperaturePanel.setLayout(null);
		bgPanel.add(TemperaturePanel);
		
		eventNoticeLabel = new JLabel("이벤트 알림");
		eventNoticeLabel.setBounds(18,181,112,34);
		eventNoticeLabel.setHorizontalAlignment(JLabel.CENTER);
		bgPanel.add(eventNoticeLabel);
		
		eventNoticeLabel = new JLabel("00");
		eventNoticeLabel.setBounds(110,181,112,34);
		eventNoticeLabel.setHorizontalAlignment(JLabel.LEFT);
		bgPanel.add(eventNoticeLabel);
		
		eventListBtn01 = new CMButton("오늘 저녁 치맥 콜 ?");
		eventListBtn01.setBounds(137,178,255,45);
		eventListBtn01.setHorizontalAlignment(JButton.CENTER);
		bgPanel.add(eventListBtn01);
		
		calendarTitleLabel = new JLabel("캘린더");
		calendarTitleLabel.setHorizontalAlignment(JButton.CENTER);
		calendarTitleLabel.setBounds(22,242,105,62);
		bgPanel.add(calendarTitleLabel);
		
		calendarListBtn01 = new CMButton("- 정보처리 기사 시험 D-4");
		calendarListBtn01.setBounds(137,248,240,17);
		calendarListBtn01.setHorizontalAlignment(JButton.LEFT);
		bgPanel.add(calendarListBtn01);
		
		calendarListBtn02 = new CMButton("- 프로젝트 스토리보드 작성 D-3 남았습니다.");
		calendarListBtn02.setBounds(137,265,240,17);
		calendarListBtn02.setHorizontalAlignment(JButton.LEFT);
		bgPanel.add(calendarListBtn02);
	
		calendarListBtn03 = new CMButton("- GUI 제작 예정");
		calendarListBtn03.setBounds(137,282,240,17);
		calendarListBtn03.setHorizontalAlignment(JButton.LEFT);
		bgPanel.add(calendarListBtn03);
		
		communityTitleLabel = new JLabel("커뮤니티");
		communityTitleLabel.setBounds(21,333,106,212);
		communityTitleLabel.setVerticalAlignment(JLabel.TOP);
		communityTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		bgPanel.add(communityTitleLabel);
		
		
		communityChatListBtn01 = new CMButton("우리반 IOT");
		communityChatListBtn01.setBounds(136,343,241,58);
		//setBounds(144,349,227,48);
		communityChatListBtn01.setVerticalAlignment(JButton.CENTER);
		communityChatListBtn01.setHorizontalAlignment(JButton.LEFT);
		bgPanel.add(communityChatListBtn01);
		
		communityChatListBtn02 = new CMButton("웹 클래스 친구네 방");
		communityChatListBtn02.setBounds(136,410,241,58);
		//setBounds(144,415,227,48);
		communityChatListBtn02.setVerticalAlignment(JButton.CENTER);
		communityChatListBtn02.setHorizontalAlignment(JButton.LEFT);
		bgPanel.add(communityChatListBtn02);
		
		newCreateChatRoomBtn = new CMButton("+ 새로운 채팅방 개설");
		newCreateChatRoomBtn.setBounds(136,478,241,58);
		//setBounds(144,484,227,48);
		newCreateChatRoomBtn.setVerticalAlignment(JButton.CENTER);
		newCreateChatRoomBtn.setHorizontalAlignment(JButton.CENTER);
		bgPanel.add(newCreateChatRoomBtn);
		
		
		foodMenuPanel = new JPanel();
		foodMenuPanel.setBounds(32,600,338,120);
		foodMenuPanel.setLayout(null);
		bgPanel.add(foodMenuPanel);
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new temp_Panel003());
		
	}
}
