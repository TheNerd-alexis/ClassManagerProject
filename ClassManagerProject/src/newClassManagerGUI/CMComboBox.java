package newClassManagerGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

public class CMComboBox extends JComboBox{
	
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	private Color defaultColor = Color.BLACK;
	
	public CMComboBox(Object[] items) {
		super(items);
		setBackground(Color.WHITE);
		setOpaque(false);
		setBorder(null);
		setFont(defaultFont);
		setForeground(defaultColor);
	}
}
