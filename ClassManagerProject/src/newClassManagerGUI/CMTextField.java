package newClassManagerGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class CMTextField extends JTextField{

	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	private Color defaultColor = Color.BLACK;
	
	public CMTextField(){
		super();
		setOpaque(false);
		setBorder(null);
		setFont(defaultFont);
		setForeground(defaultColor);
	}
	
	public CMTextField(String text){
		this();
		setText(text);
	}
}