package ClassManagerGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class JListForm extends JPanel {
	
	JListForm(){
		setLayout(new GridLayout(0,1,0,0));
		this.setOpaque(false);
		this.setBorder(null);
	}
	
	public void addComponent(Component element){
		add(element);
	}
	
}