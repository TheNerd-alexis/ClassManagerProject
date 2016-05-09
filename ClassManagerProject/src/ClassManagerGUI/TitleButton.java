package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TitleButton extends JButton {
	private Color normalColor = new Color(108, 108, 108);
	private Color fontColor = new Color(239,239,239);

	public TitleButton() {
		super();
		setBorderPainted(false);
		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setBorder(new LineBorder(normalColor));
		setForeground(fontColor);
		setBackground(normalColor);
	}

	public TitleButton(String text) {
		super(text);
		setText(text);
		setBorderPainted(false);
		setFocusPainted(false);

		setContentAreaFilled(false);
		setOpaque(true);

		setBorder(new LineBorder(normalColor));
		setForeground(fontColor);
		setBackground(normalColor);
	}
}