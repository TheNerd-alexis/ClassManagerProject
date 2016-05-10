package ClassManagerGUI;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
public class JListForm extends JPanel {
	
	JListForm(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setOpaque(false);
		this.setBorder(null);
	}
	
	public void addComponent(Component element){
		add(element);
	}
}