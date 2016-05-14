import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI extends JFrame{

	JTextField jtf;
	JTextArea jta;
	
	public void SSetting(){
		jtf = new JTextField(30);
		jta = new JTextArea(20,30);
		
		
		
		setTitle("서버");
		setSize(300, 500);
		setVisible(true);
		
		
		
	}
	
}
