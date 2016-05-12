package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.Bounds;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Panel001 extends JPanel{
	ImageIcon img = new ImageIcon("img/001_resize.jpg");
	private JButton loginBtn;
	private JTextField idField;
	private JPasswordField passwordField;
	private JButton joinBtn;
	private JButton idpwBtn;
	
	public Panel001(){
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel,BorderLayout.CENTER);
		
		loginBtn = new JButton("로그인");
		loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		loginBtn.setBounds(55,540,150,80);
		bgPanel.add(loginBtn);
		
		idField = new JTextField();
		idField.setBounds(205,540,150,40);
		bgPanel.add(idField);
		idField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205,580,150,40);
		bgPanel.add(passwordField);
		
		joinBtn = new JButton("join");
		joinBtn.setBounds(55,650,150,40);
		bgPanel.add(joinBtn);
		
		idpwBtn = new JButton("ID & PW 찾기");
		idpwBtn.setBounds(205,650,150,40);
		bgPanel.add(idpwBtn);
	}

	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.getContentPane().add(new Panel001(), BorderLayout.CENTER);
		temp.setVisible(true);
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.pack();
		temp.setLocationRelativeTo(null);
	}
}
