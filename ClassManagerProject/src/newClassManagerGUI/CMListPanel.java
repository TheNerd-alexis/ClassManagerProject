package newClassManagerGUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CMListPanel extends JPanel {
	
	CMListPanel(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setOpaque(false);
		this.setBorder(null);
	}
	
	public void addComponent(ClassManagerPanel element){
		Dimension size = new Dimension();
		size.width = element.getParent().getWidth()-5;
		size.height = element.img.getIconHeight()/element.img.getIconHeight()*size.width;
		element.setSize(size);		
		add(element);
	}
	
	public void removeComponent(ClassManagerPanel element){
		element.getParent().remove(element);
	}
}