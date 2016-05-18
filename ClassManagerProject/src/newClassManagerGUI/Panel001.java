package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.CMMessage;
import Model.Member;

public class Panel001 extends JPanel{
	private ImageIcon img = new ImageIcon("img/001_resize.jpg");
	private CMButton loginBtn;
	CMButton joinBtn;
	private CMButton idpwBtn;
	private CMTextField idField;
	private CMPasswordField passwordField;
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 25);
	
	public Panel001(ObjectOutputStream writer) {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel,BorderLayout.CENTER);
		
		loginBtn = new CMButton("로그인");
		loginBtn.setFont(defaultFont);
		loginBtn.setBounds(56,542,150,79);
		bgPanel.add(loginBtn);
		
		idField = new CMTextField();
		idField.setBounds(200,533,145,39);
		bgPanel.add(idField);
		
		passwordField = new CMPasswordField();
		passwordField.setBounds(200,571,145,39);
		bgPanel.add(passwordField);
		
		joinBtn = new CMButton("join");
		joinBtn.setBounds(52,648,153,40);
		bgPanel.add(joinBtn);
		
		idpwBtn = new CMButton("ID & PW 찾기");
		idpwBtn.setBounds(207,647,149,38);
		bgPanel.add(idpwBtn);
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Member member = new Member();
				member.setMID(idField.getText());
				member.setPW(String.valueOf(passwordField.getPassword()));
				System.out.println(member.toJson().toString());
				new CMMessage("login", member).sendMsg(writer);
			}
		});
	}

//
//	public static void main(String[] args) {
//		ClassManagerPanel.constructGUI(new Panel001());
//	}
}
