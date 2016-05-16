package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import newClassManagerGUI.Panel006.miniPanel006;

public class Panel006 extends JPanel {
	// ImageIcon listImg = new ImageIcon("img/6-1.jpg"); // in // need list img

	CMTextField searchTextField; // out
	JPanel resultFriendPanel; // out

	CMListPanel listPanel006;

	public Panel006() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(new ImageIcon("img/006_resize.jpg"));
		add(bgPanel, BorderLayout.CENTER);

		searchTextField = new CMTextField("이름, 아이디 검색");
		searchTextField.setBounds(38, 49, 322, 36);
		searchTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(searchTextField);

		// resultFriendPanel = new JPanel();
		// resultFriendPanel.setBounds(44,120,317,587);
		// resultFriendPanel.setLayout(null);
		// bgPanel.add(resultFriendPanel);

		listPanel006 = new CMListPanel();
		listPanel006.setBounds(31, 118, 340, 587);

		listPanel006.addComponent(new miniPanel006("김현우 천재"));
		listPanel006.addComponent(new miniPanel006("김진호 빈수레"));
		listPanel006.addComponent(new miniPanel006("김진호 빈수레"));
		listPanel006.addComponent(new miniPanel006("김진호 빈수레"));
		listPanel006.addComponent(new miniPanel006("김진호 빈수레"));
		listPanel006.addComponent(new miniPanel006("김진호 빈수레"));
		listPanel006.addComponent(new miniPanel006("김진호 빈수레"));
		

		bgPanel.add(listPanel006);

		// listPanel = new ClassManagerPanel(listImg);
		// listPanel.setBounds(20,118,359,65);
		// bgPanel.add(listPanel);
	}
	class miniPanel006 extends ClassManagerPanel {
		JLabel nameLabel;
		JCheckBox checkBox;

//		ImageIcon checkBoxIcon = new ImageIcon("img/CheckBox.png");
				
		
		
		
		public miniPanel006() {
			
			super( new ImageIcon("img/ListPanel01.jpg") );
			
			Image resizeImg01 = new ImageIcon("img/CheckBox.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
			Image resizeImg02 = new ImageIcon("img/sel_CheckBox.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
			
			ImageIcon checkBoxRactImg = new ImageIcon(resizeImg01);
			ImageIcon checkBoxSelectImg = new ImageIcon(resizeImg02);
			
			nameLabel = new JLabel();
			nameLabel.setBounds(10, 0, 337, 57);
			add(nameLabel);

			checkBox = new JCheckBox();
			checkBox.setBounds(294, 11, 35, 35);
			checkBox.setOpaque(false);
			checkBox.setIcon(checkBoxRactImg);
			checkBox.setSelectedIcon(checkBoxSelectImg);
			add(checkBox);
		}

		public miniPanel006(String name) {
			this();
			nameLabel.setText(name);
		}

		public JLabel getJLabelByBox() {
			if (checkBox.isSelected()) {
				return nameLabel;
			} else {
				return null;
			}
		}

	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel006());
	}
}