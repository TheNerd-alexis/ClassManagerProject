package newClassManagerGUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;

public class CMListPanel extends JPanel {

	CMListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setOpaque(false);
		this.setBorder(null);
	}

	public void addComponent(ClassManagerPanel element) {
		System.out.println(this.getBounds().width+"  "+this.getBounds().height);
		int width = this.getBounds().width;
		int height = (int)((double)element.getOrgimg().getIconHeight() / (double)element.getOrgimg().getIconWidth() * (double)width);
		Dimension size = new Dimension(width, height);
		element.setMaximumSize(size);
		element.setMinimumSize(size);
		add(element);
		Component verticalStrut = Box.createVerticalStrut(5);
		add(verticalStrut);
	}

	public void removeComponent(ClassManagerPanel element) {
		element.getParent().remove(element);
	}
}