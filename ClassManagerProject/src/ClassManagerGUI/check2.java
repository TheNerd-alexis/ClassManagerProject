package lastgui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class check2 extends JPanel{
	
	TitlePanel titlepanel= new TitlePanel("CM", "", "출석체크");
	private JPanel panel;

	
	
	private Color bgColor = new Color(255, 254, 239);
	private Color fontColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	private Color whiteColor = new Color(239,239,239);
	
	
	private JPanel body;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel label;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel label_1;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel label_2;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel label_3;
	private JPanel panel_13;
	private MyButton myButton_1;
	private MyButton myButton_2;
	private MyButton myButton_3;
	private MyButton myButton;
	

	public check2(){
		
		setBackground(bgColor);
		setSize(400-10, 750-10);
		setLayout(new BorderLayout(0, 0));
		add(titlepanel, BorderLayout.NORTH);
		
		body = new JPanel();
		add(body, BorderLayout.CENTER);
		GridBagLayout gbl_body = new GridBagLayout();
		gbl_body.columnWidths = new int[]{20, 360, -7, 0};
		gbl_body.rowHeights = new int[]{40, 75, 54, 100, 306, 0, 0};
		gbl_body.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_body.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		body.setLayout(gbl_body);
		body.setBackground(bgColor);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(234, 232, 222), 2));
		panel_1.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		body.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{116, 0, 0};
		gbl_panel_1.rowHeights = new int[]{36, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(234, 232, 222), 2));
		panel_4.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		body.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{116, 244, 0};
		gbl_panel_4.rowHeights = new int[]{93, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		label = new JLabel("이벤트알람");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_4.add(label, gbc_label);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(234, 232, 222), 2));
		panel_6.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 2;
		body.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{115, 137, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		label_1 = new JLabel("  캘린더");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_6.add(label_1, gbc_label_1);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 0;
		panel_6.add(panel_7, gbc_panel_7);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(234, 232, 222), 2));
		panel_8.setBackground(new Color(255, 254, 239));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 3;
		body.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{100, 187, 0};
		gbl_panel_8.rowHeights = new int[]{45, 33, 58, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		label_2 = new JLabel("커뮤니티");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.gridheight = 3;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 0;
		panel_8.add(label_2, gbc_label_2);
		
		panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 0;
		panel_8.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		myButton_1 = new MyButton("채팅방이름");
		panel_9.add(myButton_1, BorderLayout.CENTER);
		
		panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 1;
		panel_8.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		myButton_2 = new MyButton("채팅방이름");
		myButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_10.add(myButton_2, BorderLayout.CENTER);
		
		panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 2;
		panel_8.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		myButton_3 = new MyButton("+새로운 채팅방 개설");
		panel_11.add(myButton_3, BorderLayout.CENTER);
		
		panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(234, 232, 222), 2));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 1;
		gbc_panel_12.gridy = 4;
		body.add(panel_12, gbc_panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{265, 0};
		gbl_panel_12.rowHeights = new int[]{0, 240, 0};
		gbl_panel_12.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_12.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_12.setLayout(gbl_panel_12);
		panel_12.setBackground(bgColor);
		
		
		
		label_3 = new JLabel("오늘의 점심");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		panel_12.add(label_3, gbc_label_3);
		
		panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 1;
		panel_12.add(panel_13, gbc_panel_13);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[]{0, 382, 0, 0, -69, 0};
		gbl_panel_13.rowHeights = new int[]{201, 0};
		gbl_panel_13.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_13.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_13.setLayout(gbl_panel_13);
		panel_13.setBackground(bgColor);
		
		myButton = new MyButton("멀티캠퍼스 메뉴");
		GridBagConstraints gbc_myButton = new GridBagConstraints();
		gbc_myButton.insets = new Insets(0, 0, 0, 5);
		gbc_myButton.gridx = 1;
		gbc_myButton.gridy = 0;
		panel_13.add(myButton, gbc_myButton);
		
		
		
	}
	
	public static void main(String[] args) {
	JFrame temp = new JFrame();
	temp.getContentPane().add(new check2());
	temp.setVisible(true);
	}
	

}
