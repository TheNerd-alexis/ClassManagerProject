package ClassManagerGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class LoginPanel extends JPanel {
	JTextField txtId;
	JPasswordField passwordField;
	JButton btnJoin = new MyButton("회원가입");
	JButton btnFindIdPw = new MyButton();
	JButton btnLogin = new MyButton("로그인");
	private Color background = new Color(255, 254, 239);
	private Color foreground = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	
	public LoginPanel() {
		this.setSize(400 - 10, 750 - 10);
		setBackground(background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 60, 280, 60, 0 };
		gridBagLayout.rowHeights = new int[] { 500, 70, 70, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel loginTitlePanel = new JPanel();
		loginTitlePanel.setBackground(background);
		GridBagConstraints gbc_loginTitlePanel = new GridBagConstraints();
		gbc_loginTitlePanel.fill = GridBagConstraints.BOTH;
		gbc_loginTitlePanel.insets = new Insets(0, 0, 5, 5);
		gbc_loginTitlePanel.gridx = 1;
		gbc_loginTitlePanel.gridy = 0;
		add(loginTitlePanel, gbc_loginTitlePanel);
		loginTitlePanel.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblClass = new JLabel("Class        ");
		lblClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblClass.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 48));
		lblClass.setVerticalAlignment(SwingConstants.BOTTOM);
		loginTitlePanel.add(lblClass);

		JLabel lblManager = new JLabel("    Manager");
		lblManager.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 48));
		lblManager.setVerticalAlignment(SwingConstants.TOP);
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		loginTitlePanel.add(lblManager);

		JPanel loginIdPwpanel = new JPanel();
		loginIdPwpanel.setBackground(background);
		GridBagConstraints gbc_loginIdPwpanel = new GridBagConstraints();
		gbc_loginIdPwpanel.fill = GridBagConstraints.BOTH;
		gbc_loginIdPwpanel.insets = new Insets(0, 0, 5, 5);
		gbc_loginIdPwpanel.gridx = 1;
		gbc_loginIdPwpanel.gridy = 1;
		add(loginIdPwpanel, gbc_loginIdPwpanel);
		btnLogin.setBorderPainted(true);

		btnLogin.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		loginIdPwpanel.setLayout(new GridLayout(0, 2, 0, 0));
		loginIdPwpanel.add(btnLogin);

		JPanel panelIdPw = new JPanel();
		loginIdPwpanel.add(panelIdPw);
		panelIdPw.setLayout(new GridLayout(2, 0, 0, 0));

		txtId = new JTextField();
		txtId.setFont(new Font("나눔고딕코딩", Font.PLAIN, 20));
		txtId.setBorder(new LineBorder(borderColor));
		panelIdPw.add(txtId);
		txtId.setToolTipText("user ID");
		txtId.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setAutoscrolls(false);
		passwordField.setFont(new Font("나눔고딕코딩", Font.PLAIN, 20));
		passwordField.setBorder(new LineBorder(borderColor));
		panelIdPw.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setToolTipText("password");
		passwordField.setEchoChar('*');

		JPanel loginBtnPanel = new JPanel();
		loginBtnPanel.setBackground(background);
		GridBagConstraints gbc_loginBtnPanel = new GridBagConstraints();
		gbc_loginBtnPanel.insets = new Insets(0, 0, 0, 5);
		gbc_loginBtnPanel.fill = GridBagConstraints.BOTH;
		gbc_loginBtnPanel.gridx = 1;
		gbc_loginBtnPanel.gridy = 2;
		add(loginBtnPanel, gbc_loginBtnPanel);
		loginBtnPanel.setLayout(new GridLayout(0, 2, 0, 0));

		btnJoin.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		loginBtnPanel.add(btnJoin);
		
		
		btnFindIdPw.setLayout(new GridLayout(2, 0, 0, 0));
		JLabel label_1 = new JLabel("아이디 &");
		label_1.setForeground(new Color(105, 105, 105));
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label_2 = new JLabel("패스워드 찾기");
		label_2.setForeground(foreground);
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("나눔고딕코딩", Font.BOLD, 17));
		label_2.setFont(new Font("나눔고딕코딩", Font.BOLD, 17));
		btnFindIdPw.add(label_1);
		btnFindIdPw.add(label_2);

		loginBtnPanel.add(btnFindIdPw);
	}
}
