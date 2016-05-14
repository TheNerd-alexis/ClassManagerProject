import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.Box;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class No011 extends JFrame{
	private final JPanel panel_1 = new JPanel();
	private final JButton btnNewButton = new JButton("나가기");
	private final JLabel lblNewLabel = new JLabel("웹개발 친구 채팅방");
	private final JLabel lblNewLabel_1 = new JLabel("CM");
	private final JTextArea textArea = new JTextArea();
	private JTextField textField_1;
	private final JTextField textField_2 = new JTextField();
	private final JButton button = new JButton("전송");
	private final JButton button_1 = new JButton("초대");
	private final JPanel panel_2 = new JPanel();
	private final JLabel label = new JLabel("대화상대 12명");
	public No011() {
		getContentPane().setBackground(new Color(255, 250, 240));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel_1.setBackground(new Color(105, 105, 105));
		panel_1.setBounds(0, 0, 400, 29);
		panel.add(panel_1);
		panel_1.setLayout(null);
		btnNewButton.setForeground(new Color(105, 105, 105));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(316, 0, 84, 29);
		panel_1.add(btnNewButton);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(136, 0, 99, 29);
		panel_1.add(lblNewLabel);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 99, 29);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 239, 213));
		panel_3.setBounds(24, 41, 356, 664);
		panel.add(panel_3);
		textArea.setBackground(new Color(255, 239, 213));
		textArea.setBounds(6, 41, 344, 554);
		panel_3.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(22, 466, 130, 26);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		textField_2.setBounds(6, 618, 255, 29);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		button.setBounds(262, 619, 88, 29);
		
		panel_3.add(button);
		panel_2.setBackground(new Color(255, 245, 238));
		panel_2.setBounds(6, 6, 205, 29);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		button_1.setBounds(110, 0, 89, 30);
		panel_2.add(button_1);
		button_1.setBackground(new Color(255, 245, 238));
		label.setBounds(6, 6, 92, 16);
		
		panel_2.add(label);
		setSize(400, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setBackground(new Color(255, 250, 240));
		setBackground(new Color(255, 250, 240));
	}
}
