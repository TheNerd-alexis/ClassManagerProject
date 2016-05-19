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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Schedule;

public class Panel014 extends JPanel{
	
	CMButton addfbtn;
	CMButton addevent;
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
		
		addevent = new CMButton("추가+");
		addevent.setBounds(297,249,68,28);
		bgPanel.add(addevent);
		
		
		memomain = new JTextArea();
		memomain.setBounds(21,284,368,461);
		bgPanel.add(memomain);
	

		addListener();
	}

	
	public void addListener() {
		
		
		String str;
		Date date = new Date();
		
		String pattern = "(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		Pattern p = Pattern.compile(pattern);
		
		addfbtn.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//위치이동
			}
		});
		
		addevent.addActionListener(new ActionListener() {
			
			
			
			
			public void actionPerformed(ActionEvent arg0) {
				if (timeofsche.getText() == null || timeofsche.getText().equals("YYYY.  MM. DD")){
					JOptionPane.showMessageDialog(null, "시간을 입력해주세요");
					timeofsche.requestFocus();
					
				}else if(timeofsche.getText().length()!=8 || p.matcher((CharSequence) timeofsche).find()==false){
					JOptionPane.showMessageDialog(null, "8자리로 맞춰서 써주시기 바립니다.");
					timeofsche.requestFocus();
					
				}else if(memomain.getText() ==null || memomain.getText().equals(null)){
					JOptionPane.showMessageDialog(null, "8자리로 맞춰서 써주시기 바립니다.");
					memomain.requestFocus();
					
					
				}else {
					
					Schedule schedule = new Schedule();
					schedule.setSchTitle(titleField.getText());
					
					this.str = new String(timeofsche.getText());
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
					date = transFormat.parse("textfield");
					transFormat.format(date);
//					Date to = transFormat.parse(str);
					schedule.setSchDate(date);
					schedule.setSch(memomain.getText());
					
					
				}
			}
		});
	}



	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel014());
	}
}
