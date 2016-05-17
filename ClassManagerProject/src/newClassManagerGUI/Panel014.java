package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel014 extends JPanel{
	
	ImageIcon img = new ImageIcon("img/014_resize.jpg");
	private JTextField msgTextField;
	private CMButton add1
	
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
		
		add1 = new CMButton("추가");
		add1.setBounds(301,134,61,29);
		addfriendLable.add(add1);
		
		CMTextField memomain = new CMTextField();
		memomain.setBounds(20,250,370,495);
		bgPanel.add(memomain);
		
	}
	

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel014());
	}

}
