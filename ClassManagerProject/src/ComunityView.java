package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ClassManagerGUI.MyButton;
import ClassManagerGUI.TitlePanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ComunityView extends JPanel{
	JButton btnCheck;
	TitlePanel titlePanel;

	private Color bgColor = new Color(255, 254, 239);
	private Color fontColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234, 232, 222);
	private Color whiteColor = new Color(239, 239, 239);
	
	private String[] MONTH = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" };

	public ComunityView() {
		this.setSize(400 - 10, 750 - 10);
		setBackground(bgColor);
		setLayout(new BorderLayout(0, 0));

		titlePanel = new TitlePanel("CM", "커뮤니티", "닫기");
		add(titlePanel, BorderLayout.NORTH);
		
		JPanel joinContentPanel = new JPanel();
		joinContentPanel.setBackground(bgColor);
		add(joinContentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_joinContentPanel = new GridBagLayout();
		gbl_joinContentPanel.columnWidths = new int[] { 140, 60, 121, 55 };
		gbl_joinContentPanel.rowHeights = new int[] { 78, 60, 70, 70, 70, 70, 70, 70, 70, 70, 70, 5, 0 };
		gbl_joinContentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_joinContentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		joinContentPanel.setLayout(gbl_joinContentPanel);
		
		JLabel label = new JLabel("친구");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		joinContentPanel.add(label, gbc_label);
		
		JLabel lblNewLabel = new JLabel("채팅방 개설");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		joinContentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IoT 개발자");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		joinContentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("00명");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		joinContentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton = new MyButton("나가기");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		joinContentPanel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel label_1 = new JLabel("웹 개발 친구");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		joinContentPanel.add(label_1, gbc_label_1);
		
		JLabel lblNewLabel_3 = new JLabel("00명");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		joinContentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton_1 = new MyButton("나가기");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 3;
		joinContentPanel.add(btnNewButton_1, gbc_btnNewButton_1);
	
	}
}
