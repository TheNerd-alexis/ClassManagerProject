package ClassManagerGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyButton extends JButton {
	private Color pressedColor = new Color(255, 222, 173);
	private Color normalColor = new Color(255, 228, 196);
	private Color fontColor = new Color(105, 105, 105);

	public MyButton() {
		super();
		setBorderPainted(false);
		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setBorder(new LineBorder(pressedColor));
		setForeground(fontColor);
		setBackground(normalColor);

		addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				if (getModel().isRollover()) {
					setBackground(pressedColor);
				} else {
					setBackground(normalColor);
				}
			}
		});
	}

	public MyButton(String text) {
		super(text);
		setText(text);
		setBorderPainted(false);
		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setForeground(fontColor);
		setBackground(normalColor);

		addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				if (getModel().isPressed()) {
					setBackground(pressedColor);
				} else {
					setBackground(normalColor);
				}
			}
		});
	}
}