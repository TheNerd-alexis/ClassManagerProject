package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TitlePanel extends JPanel {
	
	TitlePanel(){
		setBackground(fontColor);
		setLayout(new BorderLayout(0, 0));

		JLabel btnTitleCM = new JLabel("CM");
		btnTitleCM.setBorder(new EmptyBorder(10, 5, 10, 5));
		btnTitleCM.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		btnTitleCM.setForeground(whiteColor);
		btnTitleCM.setBackground(fontColor);
		joinTitlePanel.add(btnTitleCM, BorderLayout.WEST);

		JLabel lblTitleJoin = new JLabel("회원가입");
		lblTitleJoin.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		lblTitleJoin.setForeground(whiteColor);
		lblTitleJoin.setHorizontalAlignment(SwingConstants.CENTER);
		joinTitlePanel.add(lblTitleJoin, BorderLayout.CENTER);

		btnTitleClose = new TitleButton("닫기");
		btnTitleClose.setBorder(new EmptyBorder(10, 0, 10, 10));
		btnTitleClose.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		joinTitlePanel.add(btnTitleClose, BorderLayout.EAST);

	}
}
