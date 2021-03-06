package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.CMMessage;
import Model.Member;

public class Panel001 extends JPanel {
	private ImageIcon img = new ImageIcon("img/001_resize.jpg");
	private CMButton loginBtn;
	public CMButton joinBtn;
	public CMButton idpwBtn;
	public CMTextField idField;
	private CMPasswordField passwordField;
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	ObjectOutputStream writer;

	public Panel001(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		loginBtn = new CMButton("로그인");
		loginBtn.setFont(defaultFont);
		loginBtn.setBounds(56, 542, 150, 79);
		bgPanel.add(loginBtn);

		idField = new CMTextField();
		idField.setBounds(213, 540, 140, 39);
		idField.setFont(defaultFont);
		bgPanel.add(idField);

		passwordField = new CMPasswordField();
		passwordField.setBounds(213, 583, 140, 39);
		passwordField.setFont(defaultFont);
		bgPanel.add(passwordField);

		joinBtn = new CMButton("회원가입");
		joinBtn.setBounds(52, 648, 153, 40);
		joinBtn.setFont(defaultFont);
		bgPanel.add(joinBtn);

		idpwBtn = new CMButton("비밀번호 찾기");
		idpwBtn.setBounds(207, 647, 149, 38);
		idpwBtn.setFont(defaultFont);
		bgPanel.add(idpwBtn);

		addListener();
	}

	public void addListener() {
		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				idField.setText("");
				passwordField.setText("");
			}
		});

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (idField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					idField.requestFocus();
					return;
				}
				if (passwordField.getPassword().length < 1) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
					passwordField.requestFocus();
					return;
				}
				Member member = new Member();
				member.setMID(idField.getText());
				member.setPW(String.valueOf(passwordField.getPassword()));
				System.out.println(member.toJson().toString());
				new CMMessage("member_login", member).sendMsg(writer);
			}
		});
	}

	public static void main(String[] args) {
		// ClassManagerPanel.constructGUI(new Panel001(null));
		System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
	}
}
