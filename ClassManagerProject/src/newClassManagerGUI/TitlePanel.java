package newClassManagerGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TitlePanel extends JPanel {

	private Color titleColor = new Color(108, 108, 108);
	private Color whiteColor = new Color(239, 239, 239);
	private Font font = new Font("맑은 고딕", Font.BOLD, 15);

	public TitleButton closeBtn;
	public TitleButton leftBtn;

	TitlePanel(String first, String second, String third) {
		// setBackground(titleColor);
		setOpaque(false);
		setLayout(new GridLayout(0, 3, 0, 0));

		leftBtn = new TitleButton(first);
		leftBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		leftBtn.setFont(font);
		leftBtn.setForeground(whiteColor);
		leftBtn.setContentAreaFilled(false);
		// leftBtn.setBackground(titleColor);
		leftBtn.setOpaque(false);
		leftBtn.setHorizontalAlignment(SwingConstants.LEFT);
		add(leftBtn);

		JLabel lblTitleJoin = new JLabel(second);
		lblTitleJoin.setFont(font);
		lblTitleJoin.setForeground(whiteColor);
		lblTitleJoin.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitleJoin);

		closeBtn = new TitleButton(third);
		closeBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		closeBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		closeBtn.setFont(font);
		closeBtn.setForeground(whiteColor);
		// closeBtn.setBackground(titleColor);
		closeBtn.setOpaque(false);
		add(closeBtn);
	}

	public class TitleButton extends JButton {
		private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
		private Color defaultColor = Color.BLACK;

		TitleButton() {
			super();
			setOpaque(false);
			setBorder(null);
			setFocusPainted(false);
			setContentAreaFilled(false);
			setFont(defaultFont);
			setForeground(defaultColor);
		}

		TitleButton(String text) {
			this();
			super.setText(text);
		}
	}
}