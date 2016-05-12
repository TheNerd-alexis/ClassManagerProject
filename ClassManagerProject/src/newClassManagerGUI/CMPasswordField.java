package newClassManagerGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;

public class CMPasswordField extends JPasswordField{
	
	private Color defaultColor = Color.BLACK;
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	
	public CMPasswordField(){
		super();
		setOpaque(false);
		setBorder(null);
		setEchoChar('*');
		setFont(defaultFont);
		setForeground(defaultColor);
	}
	
	public CMPasswordField(String defaultMsg){
		this();
		setText(defaultMsg);
		setEchoChar((char) 0);
	}
}
