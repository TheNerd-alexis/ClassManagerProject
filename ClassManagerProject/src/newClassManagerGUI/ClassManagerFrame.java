package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassManagerFrame extends JFrame {
	public Panel001 loginPanel = new Panel001();
	public Panel002 joinPanel = new Panel002();
	public CardLayout mainLayout= new CardLayout(2, 2);
	JPanel basePanel = new JPanel();
	
	public ClassManagerFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(mainLayout);
        getContentPane().add(loginPanel, "loginPanel");
        getContentPane().add(joinPanel, "joinPanel");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
	}
}
