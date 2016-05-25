package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Model.CMMessage;
import Model.Member;

public class Panel018 extends JPanel {
	ImageIcon img = new ImageIcon("img/pw_resize.jpg");
	public CMTextField idField;
	public CMComboBox qCombo;
	public CMTextField aField;
	public CMButton checkBtn;
	public CMButton confirmBtn;
	public CMButton changeBtn;
	private CMPasswordField passwordField;
	private CMPasswordField passwordField2;
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	public TitlePanel titlePanel;
	ObjectOutputStream writer;

	private String[] PWQ = { "비밀번호 힌트 질문", "----------------------------------", "당신의 이름은 무엇입니까?", "당신의 고향은 어디입니까?",
			"당신의 출신 초등학교는 어디입니까?", "가장 선호하는 색깔은 무엇입니까?" };
	public boolean idcheckstate;
	public boolean pwcheckstate;

	public Panel018(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("CM", "비밀번호 찾기", "닫기");

		titlePanel.setBounds(0, 0, 410, 40);
		bgPanel.add(titlePanel);

		checkBtn = new CMButton("  ");
		checkBtn.setFont(defaultFont);
		checkBtn.setBounds(309, 166, 67, 35);
		bgPanel.add(checkBtn);

		idField = new CMTextField("ID 입력");
		idField.setBounds(75, 165, 200, 39);
		idField.setFont(defaultFont);
		bgPanel.add(idField);

		qCombo = new CMComboBox(PWQ);
		qCombo.setBounds(73, 303, 295, 30);
		qCombo.setFont(defaultFont);
		bgPanel.add(qCombo);

		aField = new CMTextField();
		aField.setBounds(72, 386, 298, 24);
		aField.setFont(defaultFont);
		bgPanel.add(aField);

		confirmBtn = new CMButton("  ");
		confirmBtn.setFont(defaultFont);
		confirmBtn.setBounds(166, 439, 59, 33);
		bgPanel.add(confirmBtn);

		passwordField = new CMPasswordField();
		passwordField.setBounds(140, 573, 200, 39);
		passwordField.setFont(defaultFont);
		bgPanel.add(passwordField);

		passwordField2 = new CMPasswordField();
		passwordField2.setBounds(140, 628, 200, 39);
		passwordField2.setFont(defaultFont);
		bgPanel.add(passwordField2);

		changeBtn = new CMButton("  ");
		changeBtn.setFont(defaultFont);
		changeBtn.setBounds(170, 700, 56, 33);
		bgPanel.add(changeBtn);

		addListener();

	}

	public void addListener() {
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
				if (source.getText().isEmpty()) {
					source.setText("ID 입력");
				}
			}
		});
		
		aField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getForeground().equals(Color.RED)) {
					source.setText("");
					source.setForeground(Color.BLACK);
				}
			}
		});

		
		passwordField.addFocusListener(new FocusAdapter() {
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
				if (!String.valueOf(source.getPassword()).equals(String.valueOf(passwordField.getPassword()))) {
					source.setText("입력하신 비밀번호가 일치하지 않습니다");
					source.setForeground(Color.RED);
					source.setEchoChar((char) 0);
				}
			}
		});

		checkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (idField.getText() == null || idField.getText().equals("ID 입력")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					idField.requestFocus();
				} else {
					Member member = new Member();
					member.setMID(idField.getText());
					new CMMessage("member_idcheck", member).sendMsg(writer);
				}
			}
		});

		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (qCombo.getSelectedIndex() < 2) {
					JOptionPane.showMessageDialog(null, "비밀번호 힌트 질문을 선택해주세요.");
					qCombo.requestFocus();
				} else if (aField.getText() == null) {
					JOptionPane.showMessageDialog(null, "비밀번호 힌트 답변을 입력해주세요.");
					idField.requestFocus();
				} else {
					Member member = new Member();
					member.setMID(idField.getText());
					member.setPWQ(qCombo.getSelectedIndex());
					member.setPWA(aField.getText());

					new CMMessage("member_pwcheck", member).sendMsg(writer);
				}
			}
		});

		changeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!idcheckstate) {
					JOptionPane.showMessageDialog(null, "계정을 확인해주세요.");
					idField.requestFocus();
				} else if (!pwcheckstate) {
					JOptionPane.showMessageDialog(null, "비밀번호 찾기 질문과 답변을 확인해주세요.");
					qCombo.requestFocus();
				} else if (passwordField.getPassword().length < 1 || passwordField.getEchoChar() == (char) 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
					passwordField.requestFocus();
				} else if (passwordField2.getPassword().length < 1 || passwordField2.getEchoChar() == (char) 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
					passwordField2.requestFocus();
				} else {
					Member member = new Member();
					member.setMID(idField.getText());
					member.setPW(String.valueOf(passwordField2.getPassword()));
					new CMMessage("member_pwchange", member).sendMsg(writer);
				}
			}

		});
		this.addComponentListener(new ComponentAdapter(){

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				refreshPanel();
			}
			
		});
	}

	public void refreshPanel() {
		idField.setText("ID 입력");
		idField.setEditable(true);
		passwordField.setText("");
		passwordField2.setText("");
		qCombo.setSelectedIndex(0);
		aField.setText("");
		aField.setEditable(true);
		idcheckstate = false;
		pwcheckstate = false;
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel018(null));
	}
}