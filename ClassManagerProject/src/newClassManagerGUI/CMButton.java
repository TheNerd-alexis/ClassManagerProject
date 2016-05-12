package newClassManagerGUI;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CMButton extends JButton{
	
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	private Color defaultColor = Color.BLACK;
	
	CMButton(){
		super();
		setOpaque(false);
		setBorder(null);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setFont(defaultFont);
		setForeground(defaultColor);
	}
	
	CMButton(String text){
		this();
		super.setText(text);
	}
}
