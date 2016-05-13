package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Panel002 extends JPanel {

	ImageIcon img = new ImageIcon("img/002_resize.jpg");
	public CMTextField idField;
	public CMPasswordField passwordField1;
	public CMPasswordField passwordField2;
	public CMComboBox pwCombo;
	public CMComboBox classCombo;
	public CMTextField pwaField;
	public CMButton confirmBtn;

	private String[] PWQ = { "비밀번호 힌트 질문", "----------------------------------","당신의 이름은 무엇입니까?", "당신의 고향은 어디입니까?", "당신의 출신 초등학교는 어디입니까?",
			"가장 선호하는 색깔은 무엇입니까?" };

	private String[] BAN = { "과정명", "----------------------------------", "IOT기반 응용SW개발자", "안드로이드", "SCSA", "기타" };

	public Panel002() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		idField = new CMTextField();
		idField.setText("ID 또는 이메일 입력");
		idField.setBounds(35, 158, 242, 37);
		idField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().equals("ID 또는 이메일 입력")||source.getText().isEmpty()) {
					source.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().isEmpty()) {
					source.setText("ID 또는 이메일 입력");
				}
			}
		});
		bgPanel.add(idField);

		passwordField1 = new CMPasswordField();
		passwordField1.setEchoChar((char) 0);
		passwordField1.setBounds(125, 285, 240, 35);
		passwordField1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getSource();
				if (source.getEchoChar() == (char) 0) {
					source.setForeground(Color.BLACK);
					source.setText("");
					source.setEchoChar('*');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getSource();
				if (source.getPassword().length<4||source.getPassword().length>15) {
					source.setText("양식에 맞지 않습니다");
					source.setForeground(Color.RED);
					source.setEchoChar((char) 0);
				}
			}
		});
		
		bgPanel.add(passwordField1);

		passwordField2 = new CMPasswordField();
		passwordField2.setEchoChar((char) 0);
		passwordField2.setBounds(125, 338, 240, 35);
		passwordField2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getComponent();
				if (source.getEchoChar() == (char) 0) {
					source.setForeground(Color.BLACK);
					source.setText("");
					source.setEchoChar('*');
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				JPasswordField source = (JPasswordField) e.getComponent();
				if (!String.valueOf(source.getPassword()).equals(String.valueOf(passwordField1.getPassword()))) {
					source.setText("비밀번호가 일치하지 않습니다");
					source.setForeground(Color.RED);
					source.setEchoChar((char) 0);
				}
			}
		});
		
		bgPanel.add(passwordField2);

		pwCombo = new CMComboBox(PWQ);
		pwCombo.setBounds(69, 471, 292, 29);
		bgPanel.add(pwCombo);

		pwaField = new CMTextField();
		pwaField.setBounds(75, 550, 292, 28);
		bgPanel.add(pwaField);

		classCombo = new CMComboBox(BAN);
		classCombo.setBounds(112, 630, 251, 33);
		bgPanel.add(classCombo);
		
		confirmBtn = new CMButton("등록완료");
		confirmBtn.setBounds(145,700,109,29);
		bgPanel.add(confirmBtn);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel002());
	}
}
