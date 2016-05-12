package newClassManagerGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

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
		
		addActionListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				setOpaque(false);
			}
		});
	}
	
	CMButton(String text){
		this();
		super.setText(text);
	}
}
