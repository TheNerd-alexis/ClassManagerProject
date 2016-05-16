package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel004 extends JPanel {
	ImageIcon img = new ImageIcon("img/004_resize.jpg");
	Panel004(){
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setLayout(new BorderLayout(0,0));
		add(bgPanel,BorderLayout.CENTER);
		CMButton friendbtn = new CMButton("친구");
		friendbtn.setBounds(8,61,190,49);
		bgPanel.add(friendbtn);
		CMListPanel list = new CMListPanel();
		list.setBounds(8,122,393,613);
		ClassManagerPanel temp = new ClassManagerPanel(new ImageIcon("img/7-1.jpg"));
		list.addComponent(temp);
		CMButton chatOutBtn = new CMButton("나가기");
		temp.add(chatOutBtn);
		chatOutBtn.setBounds(316,13,64,32);
		list.addComponent(new ClassManagerPanel(new ImageIcon("img/7-1.jpg")));
		list.addComponent(new ClassManagerPanel(new ImageIcon("img/7-1.jpg")));
		bgPanel.add(list);
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel004());
	}
}