package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel008 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ImageIcon img = new ImageIcon("img/08_hwon.jpg");

	private CMTextField jointxt;
	private CMTextField searchtxt;
	private CMButton joinBtn;
	private CMButton searchBtn;
	private CMListPanel listPanel;
	private CMTextField nametxt;
	private JCheckBox check;
	
	public Panel008() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);
		listPanel = new CMListPanel();
		jointxt = new CMTextField("test");
		searchtxt = new CMTextField("test1");
		joinBtn = new CMButton();
		searchBtn = new CMButton();
		nametxt = new CMTextField("남공환");
		check = new JCheckBox();
		
		jointxt.setBounds(48, 66, 238, 29);
		searchtxt.setBounds(48, 131, 238, 29);
		bgPanel.add(jointxt);
		bgPanel.add(searchtxt);
		//여기까지 텍스트 붙임
		
		joinBtn.setBounds(308, 65, 51, 31);
		bgPanel.add(joinBtn);
		searchBtn.setBounds(306, 133, 49, 26);
		bgPanel.add(searchBtn);
		//여기까지 버튼 붙임
		
		
		listPanel.setBounds(48, 178, 313, 54);	//리스트 패널 소환 바운드 정함
		bgPanel.add(listPanel);	//비지패널에 리스트패널 붙임
		ClassManagerPanel miniPanel = new ClassManagerPanel(new ImageIcon("img/CheckBoxList.jpg"));//이미지올림
		listPanel.addComponent(miniPanel);
		
		nametxt.setBounds(16, 10, 85, 30);
		miniPanel.add(nametxt);
		
		check.setBounds(279, 17, 19, 14);
		
		miniPanel.add(check);
		
		
		
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel008());
	}
}
