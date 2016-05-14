package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel001 extends JPanel{
	ImageIcon img = new ImageIcon("img/001_resize.jpg");
	private CMButton loginBtn;
	private CMTextField idField;
	private CMPasswordField passwordField;
	private CMButton joinBtn;
	private CMButton idpwBtn;
	
	public Panel001(){
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel,BorderLayout.CENTER);
		
		loginBtn = new CMButton("로그인");
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		loginBtn.setBounds(54,533,145,78);
		bgPanel.add(loginBtn);
		
		idField = new CMTextField();
		idField.setBounds(200,533,145,39);
		bgPanel.add(idField);
		
		passwordField = new CMPasswordField();
		passwordField.setBounds(200,571,145,39);
		bgPanel.add(passwordField);
		
		joinBtn = new CMButton("join");
		joinBtn.setBounds(54,638,145,40);
		bgPanel.add(joinBtn);
		
		idpwBtn = new CMButton("ID & PW 찾기");
		idpwBtn.setBounds(200,638,145,40);
		bgPanel.add(idpwBtn);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel001());
	}
}
