package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel014 extends JPanel{
	
	ImageIcon img = new ImageIcon("img/014_resize.jpg");
	CMButton add1;
	CMButton add2;
	JTextArea memomain;
	
	public Panel014(){
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		add(bgPanel,BorderLayout.CENTER);
		
		CMTextField schetitleLable = new CMTextField("제목입력");
		schetitleLable.setBounds(16,60,373,48);
		bgPanel.add(schetitleLable);
		
		
		JLabel scheduletimeLable = new JLabel("시작");
		scheduletimeLable.setBounds(19,116,370,55);
		bgPanel.add(scheduletimeLable);
		
		JLabel addfriendLable = new JLabel("일정공유");
		addfriendLable.setBounds(20,179,369,58);
		bgPanel.add(addfriendLable);
		
		add1 = new CMButton("추가+");
		add1.setBounds(303,133,60,30);
		bgPanel.add(add1);
		
		add2 = new CMButton("추가+");
		add2.setBounds(297,193,68,28);
		bgPanel.add(add2);
		
		memomain = new JTextArea();
		memomain.setBounds(20,250,370,495);
		bgPanel.add(memomain);
		
	}
	

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel014());
	}

}
