package newClassManagerGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TitlePanel extends JPanel {

	private Color titleColor = new Color(108, 108, 108);
	private Color whiteColor = new Color(239, 239, 239);
	private Font font = new Font("나눔고딕코딩", Font.BOLD, 15);

	public CMButton btnTitle;
	public CMButton btnTitleCM;

	TitlePanel(String first, String second, String third) {
		setBackground(titleColor);
		setLayout(new GridLayout(0, 3, 0, 0));

		btnTitleCM = new CMButton(first);
		btnTitleCM.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTitleCM.setFont(font);
		btnTitleCM.setForeground(whiteColor);
		btnTitleCM.setBackground(titleColor);
		add(btnTitleCM);

		JLabel lblTitleJoin = new JLabel(second);
		lblTitleJoin.setFont(font);
		lblTitleJoin.setForeground(whiteColor);
		lblTitleJoin.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitleJoin);

		btnTitle = new CMButton(third);
		btnTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		btnTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
		btnTitle.setFont(font);
		add(btnTitle);
	}
}
