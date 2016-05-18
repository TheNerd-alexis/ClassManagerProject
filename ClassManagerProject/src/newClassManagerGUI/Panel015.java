package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Panel015 extends JPanel {

	public Panel015() {
		ImageIcon img = new ImageIcon("img/basic_resize.jpg");
		ImageIcon img2 = new ImageIcon("img/015single.png");
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		ClassManagerPanel datePanel = new ClassManagerPanel(img2);

		setLayout(new BorderLayout(0, 0));
		add(bgPanel, BorderLayout.CENTER);
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setBounds(3,2,368,36);
		
//		datePanel.setBounds(21,113,371,180);
//		datePanel.add(lblNewLabel);
//		bgPanel.add(datePanel);
		
		CMListPanel list = new CMListPanel();
		list.setBounds(18,58,371,682);
		list.addComponent(new ClassManagerPanel(img2));
		list.addComponent(new ClassManagerPanel(img2));
		list.addComponent(new ClassManagerPanel(img2));
		list.addComponent(new ClassManagerPanel(img2));
		bgPanel.add(list);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel015());
	} 
}
