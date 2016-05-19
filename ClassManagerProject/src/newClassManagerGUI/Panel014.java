package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Schedule;

public class Panel014 extends JPanel{
	
	CMButton addfbtn;
	CMButton add2;
	JTextArea memomain;
	CMTextField titleField;
	CMTextField timeofsche;
	
	public Panel014(){
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(new ImageIcon("img/014_resize.jpg"));
		add(bgPanel,BorderLayout.CENTER);
		
		ClassManagerPanel titlePanel = new ClassManagerPanel(new ImageIcon("img/blank.jpg"));
		titlePanel.setBounds(20,60,373,48);
		bgPanel.add(titlePanel);
		titlePanel.setLayout(new BorderLayout(0, 0));
		
		titleField = new CMTextField("제목입력");
		titlePanel.add(titleField);
		
		
		JLabel scheduletimeLable = new JLabel("시작");
		scheduletimeLable.setBounds(20,116,370,55);
		bgPanel.add(scheduletimeLable);
		
		
		timeofsche = new CMTextField("YYYY.  MM. DD");
		timeofsche.setBounds(255,132,119,22);
		bgPanel.add(timeofsche);

		
		JLabel addfriendLable = new JLabel("일정공유");
		addfriendLable.setBounds(20,179,369,58);
		bgPanel.add(addfriendLable);
		
		
		
		addfbtn = new CMButton("추가+");
		addfbtn.setBounds(297,193,68,28);
		bgPanel.add(addfbtn);
		
		add2 = new CMButton("추가+");
		add2.setBounds(297,249,68,28);
		bgPanel.add(add2);
		
		
		memomain = new JTextArea();
		memomain.setBounds(21,284,368,461);
		bgPanel.add(memomain);
	

		addListener();
	}

	
	public void addListener() {
		addfbtn.addActionListener(new ActionListener() {
			
			String str;
			Date date;
			
			public void actionPerformed(ActionEvent e) {
				Schedule schedule = new Schedule();
				schedule.setSchTitle(titleField.getText());
				
				this.str = new String(timeofsche.getText());
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date to = transFormat.parse(str);
				
				schedule.setSchDate(to);
				schedule.setSch(memomain.getText());
				
				
			}
		});
	}



	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel014());
	}
}
