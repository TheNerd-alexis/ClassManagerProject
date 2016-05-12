package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Panel002 extends JPanel {

	ImageIcon img = new ImageIcon("img/002_resize.jpg");
	private final JLabel lblTitle = new JLabel("회원가입");
	private JTextField idField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	
	public Panel002() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);
		
		JLabel lblCm = new JLabel("CM");
		lblCm.setBounds(0, 0, 57, 15);
		bgPanel.add(lblCm);
		lblTitle.setBounds(0, 0, 0, 0);
		bgPanel.add(lblTitle);
		
		JButton btnClose = new JButton("닫기");
		btnClose.setBounds(0, 0, 116, 23);
		bgPanel.add(btnClose);
		
		idField = new JTextField();
		idField.setText("id");
		idField.setBounds(0, 0, 116, 21);
		idField.setBounds(24,125,360,43);
		bgPanel.add(idField);
		idField.setColumns(10);
		
		passwordField1 = new JPasswordField();
		passwordField1.setEchoChar('*');
		passwordField1.setBounds(25,241,257,43);
		bgPanel.add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setEchoChar('*');
		passwordField2.setBounds(0, 0, 116, 21);
		bgPanel.add(passwordField2);
		
		JComboBox pwCombo = new JComboBox();
		pwCombo.setBounds(0, 0, 116, 21);
		bgPanel.add(pwCombo);
		
		JComboBox classCombo = new JComboBox();
		classCombo.setBounds(0, 0, 30, 21);
		bgPanel.add(classCombo);

	}
	
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.getContentPane().add(new Panel002(), BorderLayout.CENTER);
		temp.setVisible(true);
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.pack();
		temp.setLocationRelativeTo(null);
	}
}
