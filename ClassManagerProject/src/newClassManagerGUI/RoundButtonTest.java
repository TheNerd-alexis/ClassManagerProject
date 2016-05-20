
package newClassManagerGUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;

class RoundButton extends CMButton {
	
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	private Color defaultColor = Color.WHITE;
	
	Graphics gg;
	
	public RoundButton() {
		setBorder(null);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(true);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (contains(e.getPoint())) {
					System.out.println("들어감");
				}
			}
		});
	}

	public boolean contains(int x, int y) {
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
//		g.setColor(g.getColor());
		g.setColor(defaultColor);
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		super.paintComponent(g);
	}
}

public class RoundButtonTest {
	
	public static void main(String[] args) {
		RoundButton button = new RoundButton("재애애애!");
		button.setBackground(null);
		
		button.setBounds(20,118,120,120); // 원의 크기

		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		frame.setSize(400, 750);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}