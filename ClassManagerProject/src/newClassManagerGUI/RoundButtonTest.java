
package newClassManagerGUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;

class RoundButton extends JButton {
	
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	private Color defaultColor = Color.BLACK;
	
	Graphics gg;
	
	public RoundButton() {
		
		Dimension size = getPreferredSize();
		//size.width = size.height = Math.max(size.width, size.height);
		
		setOpaque(false);
		setBorder(null);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setFont(defaultFont);
		setForeground(defaultColor);
		
		setPreferredSize(size);
		setContentAreaFilled(false); // 버튼의 배경을 채울 것인지 ..
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if (contains(e.getPoint())) {
					System.out.println("들어감");
					gg.setColor(defaultColor);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				setOpaque(false);
				
			}
		});
	}
		
	

	public boolean contains(int x, int y) {
		// If the button has changed size,
		// make a new shape object.
		Shape shape = null;
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth()-1, getHeight()-1);
		}
		return shape.contains(x, y);
	}
	
	
	public RoundButton(String label) {
		this();
		super.setText(label);
	}
	
	

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		super.paintComponent(g);
		gg = g;
	}

//	protected void paintBorder(Graphics g) {
//		g.setColor(getForeground());
//		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
//		gg = g;
//	}	
}

public class RoundButtonTest {
	
	public static void main(String[] args) {
		RoundButton button = new RoundButton("재애애애애액팟입니다!!!");
		button.setBackground(Color.YELLOW);
		
		button.setBounds(20,118,120,120); // 원의 크기

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		frame.setSize(400, 750);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}