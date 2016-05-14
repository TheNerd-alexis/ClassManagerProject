import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame{
	
	JButton btn1;
	JPanel panel;
	JLabel lable;
	
	MyFrame(){
		btn1 = new JButton("button");
		panel = new JPanel();
		lable = new JLabel("click button!");
		
		setTitle("practice");
		setSize(600, 490);
		setVisible(true);
		setBackground(Color.BLACK);
		
		panel.add(lable);
		panel.add(btn1);
		
		add(panel);
		btn1.addActionListener(new ButtonListener());
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			btn1.setText("버튼이 눌렸다!");
		}
		
	}
	
	
	
}


public class GUIEX {
public static void main(String[] args) {
	MyFrame m = new MyFrame();
}
}
