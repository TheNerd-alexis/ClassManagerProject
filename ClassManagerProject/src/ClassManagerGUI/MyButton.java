package ClassManagerGUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class MyButton extends JButton {
	private Color bgColor = new Color(255, 254, 239);
	private Color fontColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	private Color whiteColor = new Color(239,239,239);

	public MyButton() {
		super();
		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setBorder(new LineBorder(borderColor));
		setForeground(fontColor);
		setBackground(bgColor);
	}

	public MyButton(String text) {
		super(text);
		setText(text);
		setFocusPainted(false);

		setBorder(new LineBorder(borderColor));
		setContentAreaFilled(false);
		setOpaque(true);

		setForeground(fontColor);
		setBackground(bgColor);
	}
}