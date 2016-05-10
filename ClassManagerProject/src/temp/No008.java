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
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class No008 extends JFrame{
	private final JPanel panel_invite = new JPanel();
	private final JTextField textField = new JTextField();
	private JTextField textField_1;
	private final JList list = new JList();
	private Color background = new Color(255, 254, 239);
	private Color foreground = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	
	public No008() {
		
		setVisible(true);
		setSize(450, 700);
		
		JPanel panel_base = new JPanel();
		panel_base.setSize(450,700);
		panel_base.setLayout(new BorderLayout(0, 0));
		getContentPane().add(panel_base);	
		panel_base.setBackground(background);
		
		
		
		TitlePanel titlePanel = new TitlePanel("CM","이벤트알림","닫기");
		
		panel_base.add(titlePanel, BorderLayout.NORTH); //
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(background);	
		panel_base.add(panel, BorderLayout.WEST); //
		
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{52, 343, 86, 0};
		gbl_panel.rowHeights = new int[]{25, 56, 61, 408, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		
		panel.setLayout(gbl_panel);
		
		
		
		
		
		
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
		
		JTextArea textArea = new JTextArea();
		textArea.setText("개설할 채팅방의 제목입력");
		textArea.setBounds(12, 18, 229, 24);
		panel_1.add(textArea);
		
		JButton btnNewButton = new MyButton("+초대");
		btnNewButton.setBounds(240, 10, 66, 38);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setBackground(background);
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(borderColor));
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 318, 68);
		panel_2.add(panel_3);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("아이디 이메일주소 검색");
		textArea_1.setBounds(12, 18, 211, 38);
		panel_3.add(textArea_1);
		panel_3.setBackground(background);
		JButton button = new MyButton("검색아이콘");
		button.setBounds(235, 6, 66, 46);
		panel_3.add(button);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 3;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setBackground(background);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		
		panel_4.add( new EventPanel(0, "123123") );
		panel_4.setVisible(true);
		
	}
}
