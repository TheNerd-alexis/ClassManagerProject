package newClassManagerGUI;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class NameCheckPanel extends ClassManagerPanel {
	public JLabel nameLabel;
	public JCheckBox checkBox;
	public Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);

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
		nameLabel.setFont(defaultFont);
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
