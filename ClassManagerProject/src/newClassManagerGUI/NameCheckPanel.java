package newClassManagerGUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class NameCheckPanel extends ClassManagerPanel {
	JLabel nameLabel;
	JCheckBox checkBox;

	// ImageIcon checkBoxIcon = new ImageIcon("img/CheckBox.png");

	public NameCheckPanel() {

		super(new ImageIcon("img/ListPanel01.jpg"));

		Image resizeImg01 = new ImageIcon("img/check_unchecked.png").getImage().getScaledInstance(35, 35,
				Image.SCALE_SMOOTH);
		Image resizeImg02 = new ImageIcon("img/check_checked.png").getImage().getScaledInstance(35, 35,
				Image.SCALE_SMOOTH);

		ImageIcon checkBoxRactImg = new ImageIcon(resizeImg01);
		ImageIcon checkBoxSelectImg = new ImageIcon(resizeImg02);

		nameLabel = new JLabel();
		nameLabel.setBounds(10, 0, 337, 57);
		add(nameLabel);

		checkBox = new JCheckBox();
		checkBox.setBounds(310, 11, 35, 35);
		checkBox.setOpaque(false);
		checkBox.setIcon(checkBoxRactImg);
		checkBox.setSelectedIcon(checkBoxSelectImg);
		add(checkBox);
	}

	public NameCheckPanel(String name) {
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
