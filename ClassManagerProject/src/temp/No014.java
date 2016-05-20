package nam;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class No014 extends JPanel{
	
	private Color background = new Color(255, 254, 239);
	private Color foreground = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	private JTextField textField;

	public No014() {
		setSize(390,740);
		setVisible(true);
		setBackground(background);
		setLayout(new BorderLayout(0, 0));
		
		TitlePanel titlepanel = new TitlePanel("CM", "캘린더", "닫기");
		add(titlepanel, BorderLayout.NORTH);
		
		JPanel panel_body = new JPanel();
		add(panel_body, BorderLayout.CENTER);
		GridBagLayout gbl_panel_body = new GridBagLayout();
		gbl_panel_body.columnWidths = new int[]{0, 343, 20, 0};
		gbl_panel_body.rowHeights = new int[]{21, 64, 76, 75, 421, 29, 0};
		gbl_panel_body.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_body.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_body.setLayout(gbl_panel_body);
		
		panel_body.setBackground(background);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		panel_body.add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setText("제목입력");
		panel.add(textField, BorderLayout.WEST);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		panel_body.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("시작");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		
		JButton btnNewButton = new MyButton("+추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 3;
		panel_body.add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 4;
		panel_body.add(panel_3, gbc_panel_3);
		
	}
}
