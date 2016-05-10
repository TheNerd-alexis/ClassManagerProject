package nam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class No008_004 extends JPanel{
	private Color background = new Color(255, 254, 239);
	private Color foreground = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	private final JTextField textField = new JTextField();
	private JTextField textField_1;
	JListForm list;
	
	No008_004(){
		setBackground(background);
		setVisible(true);
		setSize(390, 740);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{403, 0};
		gridBagLayout.rowHeights = new int[]{58, 11, 48, 53, 541, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		panel.setBackground(background);
		
		JPanel panel_base = new JPanel();
		panel_base.setSize(400-10,750-10);
		panel_base.setBackground(background);
		panel.setLayout(new BorderLayout(0, 0));
		
		TitlePanel titlepanel = new TitlePanel("CM", "채팅방개설", "나가기");
		panel.add(titlepanel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		textField.setBounds(12, 10, 264, 28);
		panel_2.add(textField);
		textField.setColumns(10);
		
		panel_2.setBackground(background);
		
		
		JButton btnNewButton = new MyButton("+초대");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(291, 12, 87, 23);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 12, 264, 31);
		panel_3.add(textField_1);
		
		panel_3.setBackground(background);
		
		MyButton myButton = new MyButton("+초대");
		myButton.setText("찾기");
		myButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		myButton.setBounds(291, 12, 87, 23);
		panel_3.add(myButton);
		
		list = new JListForm();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		add(list, gbc_panel_1);
		list.setBackground(background);
	}
	
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.setVisible(true);
		temp.setSize(400, 750);
		No008_004 testpanel = new No008_004();
		testpanel.list.add(new NameCheckPanel("남궁훤"));
		testpanel.list.add(new NameCheckPanel("최새롬"));
		testpanel.list.add(new NameCheckPanel("최새롬"));
		testpanel.list.add(new NameCheckPanel("최새롬"));
		testpanel.list.add(new NameCheckPanel("최새롬"));
		temp.getContentPane().add(testpanel);
	}
}