package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class JoinPanel extends JPanel {
	JTextField textUserID;
	JTextField textUserName;
	JPasswordField passwordField1;
	JPasswordField passwordField2;
	JTextField pwAnsField;
	JComboBox classCombo;
	JButton btnJoin;
	TitlePanel titlePanel;

	private Color bgColor = new Color(255, 254, 239);
	private Color fontColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234, 232, 222);
	private Color whiteColor = new Color(239, 239, 239);

	private String[] PWQ = { "비밀번호 힌트 질문", "당신의 이름은 무엇입니까?", "당신의 고향은 어디입니까?", "당신의 출신 초등학교는 어디입니까?",
			"가장 선호하는 색깔은 무엇입니까?" };

	private String[] BAN = { "과정명", "IOT기반 응용SW개발자", "안드로이드", "SCSA", "기타" };

	public JoinPanel() {
		this.setSize(400 - 10, 750 - 10);
		setBackground(bgColor);
		setLayout(new BorderLayout(0, 0));

		titlePanel = new TitlePanel("ClassManager", "회원가입", "닫기");
		add(titlePanel, BorderLayout.NORTH);

		JPanel joinContentPanel = new JPanel();
		joinContentPanel.setBackground(bgColor);
		add(joinContentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_joinContentPanel = new GridBagLayout();
		gbl_joinContentPanel.columnWidths = new int[] { 30, 450, 30 };
		gbl_joinContentPanel.rowHeights = new int[] { 100, 50, 20, 50, 40, 50, 50, 20, 50, 50, 20, 50, 20, 50, 0 };
		gbl_joinContentPanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_joinContentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		joinContentPanel.setLayout(gbl_joinContentPanel);

		JLabel lblContentTitle = new JLabel("CM 계정 만들기");
		lblContentTitle.setFont(new Font("나눔고딕코딩", Font.BOLD, 20));
		lblContentTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblContentTitle = new GridBagConstraints();
		gbc_lblContentTitle.fill = GridBagConstraints.BOTH;
		gbc_lblContentTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblContentTitle.gridx = 1;
		gbc_lblContentTitle.gridy = 0;
		joinContentPanel.add(lblContentTitle, gbc_lblContentTitle);

		JPanel IdPanel = new JPanel();
		IdPanel.setBackground(bgColor);
		GridBagConstraints gbc_IdPanel = new GridBagConstraints();
		gbc_IdPanel.fill = GridBagConstraints.BOTH;
		gbc_IdPanel.insets = new Insets(0, 0, 5, 5);
		gbc_IdPanel.gridx = 1;
		gbc_IdPanel.gridy = 1;
		joinContentPanel.add(IdPanel, gbc_IdPanel);
		GridBagLayout gbl_IdPanel = new GridBagLayout();
		gbl_IdPanel.columnWidths = new int[] { 220, 103, 0 };
		gbl_IdPanel.rowHeights = new int[] { 50, 0 };
		gbl_IdPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_IdPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		IdPanel.setLayout(gbl_IdPanel);

		textUserID = new JTextField();
		textUserID.setForeground(fontColor);
		textUserID.setBorder(new LineBorder(borderColor));
		textUserID.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
		GridBagConstraints gbc_textUserID = new GridBagConstraints();
		gbc_textUserID.fill = GridBagConstraints.BOTH;
		gbc_textUserID.insets = new Insets(0, 0, 0, 5);
		gbc_textUserID.gridx = 0;
		gbc_textUserID.gridy = 0;
		IdPanel.add(textUserID, gbc_textUserID);
		textUserID.setText("ID 또는 이메일");
		textUserID.setColumns(20);

		JButton btnIdCheck = new MyButton("중복확인");
		btnIdCheck.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		GridBagConstraints gbc_btnIdCheck = new GridBagConstraints();
		gbc_btnIdCheck.fill = GridBagConstraints.BOTH;
		gbc_btnIdCheck.gridx = 1;
		gbc_btnIdCheck.gridy = 0;
		IdPanel.add(btnIdCheck, gbc_btnIdCheck);

		textUserName = new JTextField();
		textUserName.setForeground(fontColor);
		textUserName.setBorder(new LineBorder(borderColor));
		textUserName.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
		GridBagConstraints gbc_textUserName = new GridBagConstraints();
		gbc_textUserName.fill = GridBagConstraints.BOTH;
		gbc_textUserName.insets = new Insets(0, 0, 5, 5);
		gbc_textUserName.gridx = 1;
		gbc_textUserName.gridy = 3;
		joinContentPanel.add(textUserName, gbc_textUserName);
		textUserName.setText("이름");
		textUserName.setColumns(20);

		JLabel labelPW = new JLabel("4-15자의 영문 대소문자 및 숫자만 가능합니다.");
		labelPW.setFont(new Font("나눔고딕코딩", Font.PLAIN, 14));
		labelPW.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelPW = new GridBagConstraints();
		gbc_labelPW.anchor = GridBagConstraints.SOUTHWEST;
		gbc_labelPW.insets = new Insets(0, 0, 5, 5);
		gbc_labelPW.gridx = 1;
		gbc_labelPW.gridy = 4;
		joinContentPanel.add(labelPW, gbc_labelPW);

		JPanel PWPanel1 = new JPanel();
		GridBagConstraints gbc_PWPanel1 = new GridBagConstraints();
		gbc_PWPanel1.fill = GridBagConstraints.BOTH;
		gbc_PWPanel1.insets = new Insets(0, 0, 5, 5);
		gbc_PWPanel1.gridx = 1;
		gbc_PWPanel1.gridy = 5;
		joinContentPanel.add(PWPanel1, gbc_PWPanel1);
		PWPanel1.setLayout(new BorderLayout(0, 0));

		passwordField1 = new JPasswordField();
		passwordField1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				passwordField1.setText("");
				passwordField1.setEchoChar('*');
			}

			@Override
			public void focusLost(FocusEvent e) {
//				if (String)passwordField1.getPassword()) {
//					passwordField1.setEchoChar((char) 0);
//					passwordField1.setText("비밀번호 입력");
//				}
			}
		});
		passwordField1.setText("비밀번호 입력");
		passwordField1.setEchoChar((char) 0);
		PWPanel1.add(passwordField1);

		passwordField1.setForeground(fontColor);
		passwordField1.setBorder(new LineBorder(borderColor));
		passwordField1.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
		PWPanel1.add(passwordField1, BorderLayout.CENTER);

		JPanel PWPanel2 = new JPanel();
		GridBagConstraints gbc_PWPanel2 = new GridBagConstraints();
		gbc_PWPanel2.fill = GridBagConstraints.BOTH;
		gbc_PWPanel2.insets = new Insets(0, 0, 5, 5);
		gbc_PWPanel2.gridx = 1;
		gbc_PWPanel2.gridy = 6;
		joinContentPanel.add(PWPanel2, gbc_PWPanel2);
		PWPanel2.setLayout(new BorderLayout(0, 0));

		passwordField2 = new JPasswordField();
		PWPanel2.add(passwordField2, BorderLayout.CENTER);

		JTextField lblTextField2 = new JTextField("비밀번호 재입력");
		lblTextField2.setForeground(fontColor);
		lblTextField2.setBorder(new LineBorder(borderColor));
		lblTextField2.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
		PWPanel2.add(lblTextField2, BorderLayout.CENTER);
		JComboBox pwHintCombo = new JComboBox(PWQ);
		pwHintCombo.setBorder(new LineBorder(borderColor));
		pwHintCombo.setBackground(bgColor);
		pwHintCombo.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
		GridBagConstraints gbc_pwHintCombo = new GridBagConstraints();
		gbc_pwHintCombo.fill = GridBagConstraints.BOTH;
		gbc_pwHintCombo.insets = new Insets(0, 0, 5, 5);
		gbc_pwHintCombo.gridx = 1;
		gbc_pwHintCombo.gridy = 8;
		joinContentPanel.add(pwHintCombo, gbc_pwHintCombo);

		pwAnsField = new JTextField();
		pwAnsField.setForeground(fontColor);
		pwAnsField.setBorder(new LineBorder(bgColor));
		pwAnsField.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
		pwAnsField.setText("비밀번호 힌트 답변");
		GridBagConstraints gbc_pwAnsField = new GridBagConstraints();
		gbc_pwAnsField.fill = GridBagConstraints.BOTH;
		gbc_pwAnsField.insets = new Insets(0, 0, 5, 5);
		gbc_pwAnsField.gridx = 1;
		gbc_pwAnsField.gridy = 9;
		joinContentPanel.add(pwAnsField, gbc_pwAnsField);
		pwAnsField.setColumns(10);

		classCombo = new JComboBox(BAN);
		classCombo.setBorder(new LineBorder(borderColor));
		classCombo.setBackground(bgColor);
		classCombo.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
		GridBagConstraints gbc_classCombo = new GridBagConstraints();
		gbc_classCombo.fill = GridBagConstraints.BOTH;
		gbc_classCombo.insets = new Insets(0, 0, 5, 5);
		gbc_classCombo.gridx = 1;
		gbc_classCombo.gridy = 11;
		joinContentPanel.add(classCombo, gbc_classCombo);

		btnJoin = new MyButton("등록 완료");
		btnJoin.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		GridBagConstraints gbc_btnJoin = new GridBagConstraints();
		gbc_btnJoin.insets = new Insets(0, 0, 0, 5);
		gbc_btnJoin.fill = GridBagConstraints.BOTH;
		gbc_btnJoin.gridx = 1;
		gbc_btnJoin.gridy = 13;
		joinContentPanel.add(btnJoin, gbc_btnJoin);
	}
}
