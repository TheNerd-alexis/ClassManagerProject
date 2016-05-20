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
		
		addMouseListener(new MouseAdapter() {
			int x1;
			int y1;
			int x2;
			int y2;

			@Override
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();

				int[] bounds = new int[4];
				bounds[0] = x1 < x2 ? x1 : x2;
				bounds[1] = y1 < y2 ? y1 : y2;
				bounds[2] = Math.abs(x1 - x2);
				bounds[3] = Math.abs(y1 - y2);

				System.out.printf("setBounds(%d,%d,%d,%d)\n",bounds[0],bounds[1],bounds[2],bounds[3]);
			}
		});
		setOpaque(false);
		setBorder(null);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setFont(defaultFont);
		setForeground(defaultColor);
		
//		addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				setOpaque(true);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				super.mouseExited(e);
//				setOpaque(false);
//			}
//		});
	}
	
	CMButton(String text){
		this();
		super.setText(text);
	}
}
