package temp;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;

public class No011 extends JPanel{
	private JTextField textField;
	private Color background = new Color(255, 254, 239);
	private Color foreground = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	public No011() {
		JFrame frame = new JFrame();
		
		frame.setVisible(true);
		frame.setSize(400, 750);
		
		JPanel panel_base = new JPanel();
		
		panel_base.setSize(400,750);
		frame.getContentPane().add(panel_base);
		panel_base.setBackground(background);
				panel_base.setLayout(new BorderLayout(0, 0));
				
				JPanel panel = new JPanel();
				panel_base.add(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{21, 293, 14, 0};
				gbl_panel.rowHeights = new int[]{40, 51, 484, 57, 0};
				gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				panel.setBackground(background);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new LineBorder(borderColor));
				panel_1.setLayout(null);
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.insets = new Insets(0, 0, 5, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 1;
				panel.add(panel_1, gbc_panel_1);
				panel_1.setBackground(background);
				JLabel lblNewLabel = new JLabel("대화상대 12명");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(12, 14, 108, 29);
				panel_1.add(lblNewLabel);
				
				JButton btnNewButton = new MyButton("+초대");
				btnNewButton.setBounds(127, 10, 63, 36);
				panel_1.add(btnNewButton);
				
				JPanel panel_2 = new JPanel();
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.insets = new Insets(0, 0, 5, 5);
				gbc_panel_2.fill = GridBagConstraints.BOTH;
				gbc_panel_2.gridx = 1;
				gbc_panel_2.gridy = 2;
				panel.add(panel_2, gbc_panel_2);
				panel_2.setLayout(new BorderLayout(0, 0));
				panel_2.setBackground(background);
				JTextArea textArea = new JTextArea();
				panel_2.add(textArea);
				textArea.setBackground(new Color(253, 245, 230));
				
				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				GridBagConstraints gbc_panel_3 = new GridBagConstraints();
				gbc_panel_3.insets = new Insets(0, 0, 0, 5);
				gbc_panel_3.fill = GridBagConstraints.BOTH;
				gbc_panel_3.gridx = 1;
				gbc_panel_3.gridy = 3;
				panel.add(panel_3, gbc_panel_3);
				panel_3.setBackground(background);
				textField = new JTextField();
				textField.setBounds(0, 10, 236, 33);
				panel_3.add(textField);
				textField.setColumns(10);
				textArea.setEditable(false);
				
				JButton btnNewButton_1 = new MyButton("전송");
				btnNewButton_1.setBounds(259, 10, 48, 33);
				panel_3.add(btnNewButton_1);
			
				TitlePanel titlePanel = new TitlePanel("CM","웹개발친구채팅방","닫기");
				panel_base.add(titlePanel, BorderLayout.NORTH);
		
		
		
		
	}
	
}
