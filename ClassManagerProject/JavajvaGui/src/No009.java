import java.awt.*;

import javax.swing.*;
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

public class No009 extends JFrame{
	private final JPanel panel_1 = new JPanel();
	private final JButton btnNewButton = new JButton("나가기");
	private final JLabel lblNewLabel = new JLabel("채팅방 초대하기");
	private final JLabel lblNewLabel_1 = new JLabel("CM");
	private final JPanel panel_2 = new JPanel();
	private final JTextField textField = new JTextField();
	private final JTextArea textArea = new JTextArea();
	private final JButton button = new JButton("초대");
	private final JPanel panel_4 = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("남궁훤1");
	private final JPanel panel_5 = new JPanel();
	private final JCheckBox checkBox = new JCheckBox("+초대");
	private final JPanel panel_6 = new JPanel();
	private final JLabel label = new JLabel("가나다라마바사2");
	private final JTextArea textArea_1 = new JTextArea();
	private final JPanel panel_7 = new JPanel();
	private final JCheckBox checkBox_1 = new JCheckBox("+초대");
	private final JPanel panel_8 = new JPanel();
	private final JLabel label_1 = new JLabel("가나다라마바사아자3");
	private final JTextArea textArea_2 = new JTextArea();
	private final JPanel panel_9 = new JPanel();
	private final JCheckBox checkBox_2 = new JCheckBox("+초대");
	private final JPanel panel_10 = new JPanel();
	private final JLabel label_2 = new JLabel("남궁훤4");
	private final JTextArea textArea_3 = new JTextArea();
	private final JPanel panel_11 = new JPanel();
	private final JCheckBox checkBox_3 = new JCheckBox("+초대");
	private final JPanel panel_12 = new JPanel();
	private final JLabel label_3 = new JLabel("남궁훤5");
	private final JTextArea textArea_4 = new JTextArea();
	private final JPanel panel_13 = new JPanel();
	private final JCheckBox checkBox_4 = new JCheckBox("+초대");
	private final JPanel panel_14 = new JPanel();
	private final JLabel label_4 = new JLabel("남궁훤6");
	private final JTextArea textArea_5 = new JTextArea();
	private final JPanel panel_15 = new JPanel();
	private final JCheckBox checkBox_5 = new JCheckBox("+초대");
	private final JPanel panel_16 = new JPanel();
	private final JLabel label_5 = new JLabel("남궁훤7");
	private final JTextArea textArea_6 = new JTextArea();
	private final JPanel panel_17 = new JPanel();
	private final JCheckBox checkBox_6 = new JCheckBox("+초대");
	private final JPanel panel_18 = new JPanel();
	private final JLabel label_6 = new JLabel("남궁훤8");
	private final JTextArea textArea_7 = new JTextArea();
	private final JPanel panel_19 = new JPanel();
	private final JCheckBox checkBox_7 = new JCheckBox("+초대");
	private final JPanel panel_20 = new JPanel();
	private final JLabel label_7 = new JLabel("남궁훤9");
	private final JTextArea textArea_8 = new JTextArea();
	private final JPanel panel_21 = new JPanel();
	private final JCheckBox checkBox_8 = new JCheckBox("+초대");
	private final JPanel panel_22 = new JPanel();
	private final JLabel label_8 = new JLabel("남궁훤10");
	private final JTextArea textArea_9 = new JTextArea();
	private final JPanel panel_23 = new JPanel();
	private final JCheckBox checkBox_9 = new JCheckBox("+초대");
	public No009() {
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
		panel_2.setBackground(new Color(255, 239, 213));
		panel_2.setBounds(24, 41, 356, 43);
		panel.add(panel_2);
		panel_2.setLayout(null);
		textField.setBounds(6, 7, 231, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("찾기아이콘");
		btnNewButton_1.setBackground(new Color(255, 245, 238));
		btnNewButton_1.setBounds(249, 5, 90, 36);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 239, 213));
		panel_3.setBounds(24, 111, 356, 567);
		panel.add(panel_3);
		panel_4.setBackground(new Color(255, 239, 213));
		panel_4.setBounds(6, 6, 344, 47);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(6, 6, 113, 35);
		panel_4.add(lblNewLabel_2);
		textArea.setBounds(-225, -98, 344, 506);
		panel_4.add(textArea);
		textArea.setBackground(new Color(255, 239, 213));
		panel_5.setBackground(new Color(255, 228, 181));
		panel_5.setForeground(new Color(255, 245, 238));
		panel_5.setBounds(231, 6, 107, 35);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		checkBox.setBounds(0, 6, 107, 23);
		panel_5.add(checkBox);
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		button.setBounds(181, 497, 169, 47);
		
		panel_3.add(button);
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 239, 213));
		panel_6.setBounds(6, 53, 344, 47);
		
		panel_3.add(panel_6);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label.setBounds(6, 6, 213, 35);
		
		panel_6.add(label);
		textArea_1.setBackground(new Color(255, 239, 213));
		textArea_1.setBounds(-225, -98, 344, 506);
		
		panel_6.add(textArea_1);
		panel_7.setLayout(null);
		panel_7.setForeground(new Color(255, 245, 238));
		panel_7.setBackground(new Color(255, 228, 181));
		panel_7.setBounds(231, 6, 107, 35);
		
		panel_6.add(panel_7);
		checkBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_1.setBounds(0, 6, 107, 23);
		
		panel_7.add(checkBox_1);
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 239, 213));
		panel_8.setBounds(6, 99, 344, 47);
		
		panel_3.add(panel_8);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_1.setBounds(6, 6, 213, 35);
		
		panel_8.add(label_1);
		textArea_2.setBackground(new Color(255, 239, 213));
		textArea_2.setBounds(-225, -98, 344, 506);
		
		panel_8.add(textArea_2);
		panel_9.setLayout(null);
		panel_9.setForeground(new Color(255, 245, 238));
		panel_9.setBackground(new Color(255, 228, 181));
		panel_9.setBounds(231, 6, 107, 35);
		
		panel_8.add(panel_9);
		checkBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_2.setBounds(0, 6, 107, 23);
		
		panel_9.add(checkBox_2);
		panel_10.setLayout(null);
		panel_10.setBackground(new Color(255, 239, 213));
		panel_10.setBounds(6, 145, 344, 47);
		
		panel_3.add(panel_10);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_2.setBounds(6, 6, 113, 35);
		
		panel_10.add(label_2);
		textArea_3.setBackground(new Color(255, 239, 213));
		textArea_3.setBounds(-225, -98, 344, 506);
		
		panel_10.add(textArea_3);
		panel_11.setLayout(null);
		panel_11.setForeground(new Color(255, 245, 238));
		panel_11.setBackground(new Color(255, 228, 181));
		panel_11.setBounds(231, 6, 107, 35);
		
		panel_10.add(panel_11);
		checkBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_3.setBounds(0, 6, 107, 23);
		
		panel_11.add(checkBox_3);
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(255, 239, 213));
		panel_12.setBounds(6, 193, 344, 47);
		
		panel_3.add(panel_12);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_3.setBounds(6, 6, 113, 35);
		
		panel_12.add(label_3);
		textArea_4.setBackground(new Color(255, 239, 213));
		textArea_4.setBounds(-225, -98, 344, 506);
		
		panel_12.add(textArea_4);
		panel_13.setLayout(null);
		panel_13.setForeground(new Color(255, 245, 238));
		panel_13.setBackground(new Color(255, 228, 181));
		panel_13.setBounds(231, 6, 107, 35);
		
		panel_12.add(panel_13);
		checkBox_4.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_4.setBounds(0, 6, 107, 23);
		
		panel_13.add(checkBox_4);
		panel_14.setLayout(null);
		panel_14.setBackground(new Color(255, 239, 213));
		panel_14.setBounds(6, 240, 344, 47);
		
		panel_3.add(panel_14);
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_4.setBounds(6, 6, 113, 35);
		
		panel_14.add(label_4);
		textArea_5.setBackground(new Color(255, 239, 213));
		textArea_5.setBounds(-225, -98, 344, 506);
		
		panel_14.add(textArea_5);
		panel_15.setLayout(null);
		panel_15.setForeground(new Color(255, 245, 238));
		panel_15.setBackground(new Color(255, 228, 181));
		panel_15.setBounds(231, 6, 107, 35);
		
		panel_14.add(panel_15);
		checkBox_5.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_5.setBounds(0, 6, 107, 23);
		
		panel_15.add(checkBox_5);
		panel_16.setLayout(null);
		panel_16.setBackground(new Color(255, 239, 213));
		panel_16.setBounds(6, 287, 344, 47);
		
		panel_3.add(panel_16);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_5.setBounds(6, 6, 113, 35);
		
		panel_16.add(label_5);
		textArea_6.setBackground(new Color(255, 239, 213));
		textArea_6.setBounds(-225, -98, 344, 506);
		
		panel_16.add(textArea_6);
		panel_17.setLayout(null);
		panel_17.setForeground(new Color(255, 245, 238));
		panel_17.setBackground(new Color(255, 228, 181));
		panel_17.setBounds(231, 6, 107, 35);
		
		panel_16.add(panel_17);
		checkBox_6.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_6.setBounds(0, 6, 107, 23);
		
		panel_17.add(checkBox_6);
		panel_18.setLayout(null);
		panel_18.setBackground(new Color(255, 239, 213));
		panel_18.setBounds(6, 334, 344, 47);
		
		panel_3.add(panel_18);
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_6.setBounds(6, 6, 113, 35);
		
		panel_18.add(label_6);
		textArea_7.setBackground(new Color(255, 239, 213));
		textArea_7.setBounds(-225, -98, 344, 506);
		
		panel_18.add(textArea_7);
		panel_19.setLayout(null);
		panel_19.setForeground(new Color(255, 245, 238));
		panel_19.setBackground(new Color(255, 228, 181));
		panel_19.setBounds(231, 6, 107, 35);
		
		panel_18.add(panel_19);
		checkBox_7.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_7.setBounds(0, 6, 107, 23);
		
		panel_19.add(checkBox_7);
		panel_20.setLayout(null);
		panel_20.setBackground(new Color(255, 239, 213));
		panel_20.setBounds(6, 381, 344, 47);
		
		panel_3.add(panel_20);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_7.setBounds(6, 6, 113, 35);
		
		panel_20.add(label_7);
		textArea_8.setBackground(new Color(255, 239, 213));
		textArea_8.setBounds(-225, -98, 344, 506);
		
		panel_20.add(textArea_8);
		panel_21.setLayout(null);
		panel_21.setForeground(new Color(255, 245, 238));
		panel_21.setBackground(new Color(255, 228, 181));
		panel_21.setBounds(231, 6, 107, 35);
		
		panel_20.add(panel_21);
		checkBox_8.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_8.setBounds(0, 6, 107, 23);
		
		panel_21.add(checkBox_8);
		panel_22.setLayout(null);
		panel_22.setBackground(new Color(255, 239, 213));
		panel_22.setBounds(6, 428, 344, 47);
		
		panel_3.add(panel_22);
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		label_8.setBounds(6, 6, 113, 35);
		
		panel_22.add(label_8);
		textArea_9.setBackground(new Color(255, 239, 213));
		textArea_9.setBounds(-225, -98, 344, 506);
		
		panel_22.add(textArea_9);
		panel_23.setLayout(null);
		panel_23.setForeground(new Color(255, 245, 238));
		panel_23.setBackground(new Color(255, 228, 181));
		panel_23.setBounds(231, 6, 107, 35);
		
		panel_22.add(panel_23);
		checkBox_9.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_9.setBounds(0, 6, 107, 23);
		
		panel_23.add(checkBox_9);
		setSize(400, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setBackground(new Color(255, 250, 240));
		setBackground(new Color(255, 250, 240));
	}
}
