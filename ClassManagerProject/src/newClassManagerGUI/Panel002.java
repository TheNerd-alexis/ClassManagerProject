package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Model.CMMessage;
import Model.Member;
import Service.MemberService;

public class Panel002 extends JPanel {
	private ObjectOutputStream writer;
	private ImageIcon img = new ImageIcon("img/002_resize.jpg");
	public CMTextField idField;
	private CMPasswordField passwordField1;
	private CMPasswordField passwordField2;
	private CMComboBox pwCombo;
	private CMComboBox classCombo;
	private CMTextField pwaField;
	private CMButton confirmBtn;
	private CMButton idCheckBtn;
	public TitlePanel title;
	public Boolean idcheckstate = false;

	private String[] PWQ = { "비밀번호 힌트 질문", "----------------------------------", "당신의 이름은 무엇입니까?", "당신의 고향은 어디입니까?",
			"당신의 출신 초등학교는 어디입니까?", "가장 선호하는 색깔은 무엇입니까?" };

	private String[] BAN = { "과정명", "----------------------------------", "IOT기반 응용SW개발자", "안드로이드", "SCSA", "기타" };

	// public Panel002() {
	public Panel002(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		title = new TitlePanel("CM", "회원가입", "닫기");

		title.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(title);

		idField = new CMTextField();
		idField.setText("ID 입력");
		idField.setBounds(37, 134, 240, 40);
		bgPanel.add(idField);

		idCheckBtn = new CMButton("중복확인");
		idCheckBtn.setBounds(284, 136, 105, 40);
		bgPanel.add(idCheckBtn);

		passwordField1 = new CMPasswordField();
		passwordField1.setEchoChar((char) 0);
		passwordField1.setBounds(130, 269, 240, 29);
		bgPanel.add(passwordField1);

		passwordField2 = new CMPasswordField();
		passwordField2.setEchoChar((char) 0);
		passwordField2.setBounds(130, 323, 240, 29);
		bgPanel.add(passwordField2);

		pwCombo = new CMComboBox(PWQ);
		pwCombo.setBounds(73, 453, 298, 30);
		bgPanel.add(pwCombo);

		pwaField = new CMTextField();
		pwaField.setBounds(75, 532, 290, 28);
		bgPanel.add(pwaField);

		classCombo = new CMComboBox(BAN);
		classCombo.setBounds(116, 616, 257, 32);
		bgPanel.add(classCombo);

		confirmBtn = new CMButton("등록완료");
		confirmBtn.setBounds(137, 687, 134, 44);
		bgPanel.add(confirmBtn);
		addListener();
	}

	public void addListener() {
		idCheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (idField.getText().equals("ID 입력"))
					return;

				Member member = new Member();
				member.setMID(idField.getText());
				new CMMessage("member_check", member).sendMsg(writer);
			}
		});

		idField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().equals("ID 입력") || source.getForeground().equals(Color.RED)) {
					source.setText("");
					source.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().length() < 4 || source.getText().length() > 15) {
					source.setText("양식에 맞지 않습니다");
					source.setForeground(Color.RED);
				}
			}
		});

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
				if (source.getPassword().length < 4 || source.getPassword().length > 15) {
					source.setText("양식에 맞지 않습니다");
					source.setForeground(Color.RED);
					source.setEchoChar((char) 0);
				}
			}
		});

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

		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (idField.getText() == null || idField.getText().equals("ID 입력")) {
					JOptionPane.showMessageDialog(null, "입력하신 정보를 확인해주세요.");
					idField.requestFocus();
				} else if (idcheckstate == false) {
					JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
					idCheckBtn.requestFocus();
				} else if (passwordField1.getPassword().length < 1 || passwordField1.getEchoChar() == (char) 0) {
					JOptionPane.showMessageDialog(null, "암호란을 확인해주세요.");
					passwordField1.requestFocus();
				} else if (passwordField2.getPassword().length < 1 || passwordField2.getEchoChar() == (char) 0) {
					JOptionPane.showMessageDialog(null, "암호 확인란을 확인해주세요.");
					passwordField2.requestFocus();
				} else if (pwCombo.getSelectedIndex() < 2) {
					JOptionPane.showMessageDialog(null, "비밀번호 질문을 선택해주세요.");
					pwCombo.requestFocus();
				} else if (pwaField.getText().length() < 1) {
					JOptionPane.showMessageDialog(null, "비밀번호 질문의 답변을 입력해주세요.");
					pwaField.requestFocus();
				} else if (classCombo.getSelectedIndex() < 2) {
					JOptionPane.showMessageDialog(null, "교육과정을 선택해주세요.");
					classCombo.requestFocus();
				} else {
					Member member = new Member();
					member.setMID(idField.getText());
					member.setPW(String.valueOf(passwordField1.getPassword()));
					member.setMCL(classCombo.getSelectedIndex());
					member.setPWQ(pwCombo.getSelectedIndex());
					member.setPWA(pwaField.getText());
//					System.out.println(member.toJson().toString());
					new CMMessage("member_join", member).sendMsg(writer);
				}
			}
		});
		this.setFocusable(true);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				refreshPanel();
			}
		});
	}

	public void refreshPanel() {
		idField.setText("ID 입력");
		passwordField1.setText("");
		passwordField2.setText("");
		pwCombo.setSelectedIndex(0);
		pwaField.setText("");
		classCombo.setSelectedIndex(0);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel002(null));
	}
}
