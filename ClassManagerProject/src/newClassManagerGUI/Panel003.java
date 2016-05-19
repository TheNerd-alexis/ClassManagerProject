package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import newClassManagerGUI.Panel017.MiniPanel017;

public class Panel003 extends JPanel{
	private ImageIcon img = new ImageIcon("img/003_resize.jpg");
	private ImageIcon listImg = new ImageIcon("img/ListPanel01.jpg");
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 25);

	JPanel todayWeatherPanel; // out
	JPanel TemperaturePanel; // out
	
	CMButton eventNoticeBtn; // out
	JLabel eventNoticeLabelCount; // out
	JLabel eventTitleLabel; // out
	
	CMListPanel calendarListPanel; // out
	CMListPanel communityChatListPanel; // out
	JTextArea foodMenuTextArea; // out
	
	// 리스트 글자들 Veritical을 기준으로 중앙 정렬이 안됌.
	
	
	public Panel003(){
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel,BorderLayout.CENTER);
			
		//미구현
		todayWeatherPanel = new JPanel();
		todayWeatherPanel.setBounds(15,50,162,115);
		todayWeatherPanel.setLayout(null);
		bgPanel.add(todayWeatherPanel);
		
		TemperaturePanel = new JPanel();
		TemperaturePanel.setBounds(183,50,210,115);
		TemperaturePanel.setLayout(null);
		bgPanel.add(TemperaturePanel);
		//
		
		
		eventNoticeBtn = new CMButton(null);
		eventNoticeBtn.setLayout(null);
		eventNoticeBtn.setBounds(13,175,382,49);
		bgPanel.add(eventNoticeBtn);
		
		JLabel eventNoticeLabel = new JLabel("이벤트 알림");
		eventNoticeLabel.setBounds(-10,0,122,49);
		eventNoticeLabel.setVerticalAlignment(JLabel.CENTER);
		eventNoticeLabel.setHorizontalAlignment(JLabel.CENTER);
		eventNoticeBtn.add(eventNoticeLabel);
		
		eventNoticeLabelCount = new JLabel("00");
		eventNoticeLabelCount.setBounds(90,0,122,49);
		eventNoticeLabelCount.setVerticalAlignment(JLabel.CENTER);
		eventNoticeLabelCount.setHorizontalAlignment(JLabel.LEFT);
		eventNoticeBtn.add(eventNoticeLabelCount);
		
		eventTitleLabel = new JLabel("오늘 치맥 콜 ?");
		eventTitleLabel.setBounds(126,0,255,49);
		eventTitleLabel.setVerticalAlignment(JLabel.CENTER);
		eventTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		eventNoticeBtn.add(eventTitleLabel);
		
		JLabel calendarLabel = new JLabel("캘린더");
		calendarLabel.setBounds(13,236,116,78);
		calendarLabel.setVerticalAlignment(JLabel.CENTER);
		calendarLabel.setHorizontalAlignment(JLabel.CENTER);
		bgPanel.add(calendarLabel);
		
		calendarListPanel = new CMListPanel();
		calendarListPanel.setBounds(136,244,245,59);
		calendarListPanel.addComponent(new CalendarminiPanel003("- 자료구조 공부 D-1"));
		calendarListPanel.addComponent(new CalendarminiPanel003("- 프로그래밍 실습"));
		bgPanel.add(calendarListPanel);
		
		JLabel communityLabel = new JLabel("커뮤니티");
		communityLabel.setBounds(15,338,121,225);
		communityLabel.setVerticalAlignment(JLabel.TOP);
		communityLabel.setHorizontalAlignment(JLabel.CENTER);
		bgPanel.add(communityLabel);
		
		communityChatListPanel = new CMListPanel();
		communityChatListPanel.setBounds(153,334,230,204);
		communityChatListPanel.addComponent(new CommunityChatminiPanel003("채팅방01"));
		communityChatListPanel.addComponent(new CommunityChatminiPanel003("채팅방02"));
		communityChatListPanel.addComponent(new CommunityChatminiPanel003("채팅방03"));
		communityChatListPanel.addComponent(new CommunityChatminiPanel003("채팅방04"));
		communityChatListPanel.addComponent(new CreateChatRoomPanel("채팅방 개설"));
		bgPanel.add(communityChatListPanel);
		
		
		foodMenuTextArea = new JTextArea();
		foodMenuTextArea.setBounds(25,597,353,132);
		bgPanel.add(foodMenuTextArea);
	}
	
	class CalendarminiPanel003 extends ClassManagerPanel {
		CMButton calendarListBtn;
		public CalendarminiPanel003(String text) {
			// TODO Auto-generated constructor stub
			super( listImg );
			calendarListBtn = new CMButton(text);
			calendarListBtn.setVerticalAlignment(SwingConstants.CENTER);
			calendarListBtn.setHorizontalAlignment(SwingConstants.LEFT);
			calendarListBtn.setBounds(0,0,245,25);
			//calendarListBtn.setBounds(0,0,245,17);
			add(calendarListBtn);
			
		}
	}
	
	
	class CommunityChatminiPanel003 extends ClassManagerPanel {
		CMButton communityChatListBtn;
		public CommunityChatminiPanel003(String text) {
			super( listImg );
			// TODO Auto-generated constructor stub
			communityChatListBtn = new CMButton(text);
			communityChatListBtn.setBounds(0,0,260,50);
			communityChatListBtn.setVerticalAlignment(SwingConstants.CENTER);
			communityChatListBtn.setHorizontalAlignment(SwingConstants.LEFT);
			add(communityChatListBtn);
		}		
	}
	
	class CreateChatRoomPanel extends ClassManagerPanel {
		CMButton CreateChatRoomBtn;
		public CreateChatRoomPanel(String text) {
			super( listImg );
			// TODO Auto-generated constructor stub
			CreateChatRoomBtn = new CMButton(text);
			CreateChatRoomBtn.setBounds(0,0,260,50);
			CreateChatRoomBtn.setVerticalAlignment(SwingConstants.CENTER);
			CreateChatRoomBtn.setHorizontalAlignment(SwingConstants.CENTER);
			add(CreateChatRoomBtn);
		}		
	}
	
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel003());
		
	}
}
