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

	ImageIcon img = new ImageIcon("img/008_resize.jpg");

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
		joinBtn.setBounds(308, 65, 51, 31);
		bgPanel.add(joinBtn);
		searchBtn.setBounds(306, 133, 49, 26);
		bgPanel.add(searchBtn);
		listPanel.setBounds(28, 178, 346, 558);
		bgPanel.add(listPanel);
		ClassManagerPanel miniPanel = new ClassManagerPanel(new ImageIcon("img/CheckBoxList.jpg"));
		listPanel.addComponent(miniPanel);
		
		nametxt.setBounds(16, 10, 85, 30);
		miniPanel.add(nametxt);
		
		check.setBounds(309, 17, 23, 20);
		
		miniPanel.add(check);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel008());
	}
}
