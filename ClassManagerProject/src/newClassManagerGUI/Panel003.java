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

import newClassManagerGUI.Panel017.MiniPanel017;

public class Panel003 extends JPanel{
	private ImageIcon img = new ImageIcon("img/003_resize.jpg");
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 25);

	CMButton eventNoticeBtn; // out
	JLabel eventNoticeLabelCount; // out
	JLabel eventTitleLabel; // out
	
	
	public Panel003(){
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel,BorderLayout.CENTER);
					
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
		
		CMListPanel calendarListPanel = new CMListPanel();
		calendarListPanel.setBounds(136,244,245,59);
		calendarListPanel.addComponent(new CalendarminiPanel003("hi1"));
		calendarListPanel.addComponent(new CalendarminiPanel003("hihihi2"));
		bgPanel.add(calendarListPanel);
		
		JLabel communityLabel = new JLabel("커뮤니티");
		communityLabel.setBounds(15,338,121,225);
		communityLabel.setVerticalAlignment(JLabel.TOP);
		communityLabel.setHorizontalAlignment(JLabel.CENTER);
		bgPanel.add(communityLabel);
	}
	CMButton calendarListBtn;
	class CalendarminiPanel003 extends ClassManagerPanel {

		public CalendarminiPanel003(String text) {
			// TODO Auto-generated constructor stub
			super( new ImageIcon("img/ListPanel01.jpg"));
			calendarListBtn = new CMButton(text);
			calendarListBtn.setHorizontalAlignment(JButton.LEFT);
			calendarListBtn.setBounds(0,0,245,15);
			add(calendarListBtn);
		}
	}
	
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel003());
		
	}
}
