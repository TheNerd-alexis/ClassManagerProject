package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel013 extends JPanel {

	JButton btnCheck;
	TitlePanel titlePanel;

	private Color bgColor = new Color(255, 254, 239);
	private Color fontColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234, 232, 222);
	private Color whiteColor = new Color(239, 239, 239);
	Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 20);

	private String[] MONTH = { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" };

	public Panel013() {
		ImageIcon img = new ImageIcon("img/013_resize.jpg");
		setBackground(bgColor);
		setLayout(new BorderLayout(0, 0));

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int week = cal.get(Calendar.WEEK_OF_YEAR)-11;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
		String[] days = { "일", "월", "화", "수", "목", "금", "토" };
		System.out.println(year + "  " + week + "  " + day + "  " + days[dayOfWeek - 1]);

		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("CM", "출석체크", "닫기");
		titlePanel.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(titlePanel);

		JLabel monthLabel = new JLabel(String.valueOf(month));
		monthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		monthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		monthLabel.setBounds(115, 86, 42, 29);
		monthLabel.setForeground(Color.ORANGE);
		bgPanel.add(monthLabel);

		JLabel todayLabel = new JLabel(cal.get(Calendar.MONTH) + "/" + days[dayOfWeek]);
		todayLabel.setBounds(26,188,77,44);
		todayLabel.setFont(defaultFont);
		todayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgPanel.add(todayLabel);
		
		JLabel weekLabel = new JLabel(String.valueOf(week));
		weekLabel.setBounds(23,389,33,34);
		weekLabel.setFont(defaultFont);
		weekLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgPanel.add(weekLabel);
		
		JLabel[] dayLabel = new JLabel[5];
		dayLabel[0] = new JLabel(String);
		// JLabel label = new JLabel("5주차");
		// label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		// label.setForeground(fontColor);
		// GridBagConstraints gbc_label = new GridBagConstraints();
		// gbc_label.insets = new Insets(0, 0, 5, 5);
		// gbc_label.gridx = 1;
		// gbc_label.gridy = 6;
		// joinContentPanel.add(label, gbc_label);
		//
		//
		// JLabel lblNewLabel_3 = new JLabel("- 한주 모두 출석하면(액수?)");
		// lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		// lblNewLabel_3.setForeground(fontColor);
		// GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		// gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		// gbc_lblNewLabel_3.gridwidth = 5;
		// gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_3.gridx = 2;
		// gbc_lblNewLabel_3.gridy = 6;
		// joinContentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		//
		// JLabel label_1 = new JLabel("월");
		// GridBagConstraints gbc_label_1 = new GridBagConstraints();
		// gbc_label_1.insets = new Insets(0, 0, 5, 5);
		// gbc_label_1.gridx = 1;
		// gbc_label_1.gridy = 7;
		// joinContentPanel.add(label_1, gbc_label_1);
		//
		// JLabel lblNewLabel_2 = new JLabel("화");
		// GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		// gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_2.gridx = 2;
		// gbc_lblNewLabel_2.gridy = 7;
		// joinContentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		//
		// JLabel lblNewLabel_5 = new JLabel("수");
		// GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		// gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_5.gridx = 3;
		// gbc_lblNewLabel_5.gridy = 7;
		// joinContentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		//
		// JLabel lblNewLabel_6 = new JLabel("목");
		// GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		// gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_6.gridx = 4;
		// gbc_lblNewLabel_6.gridy = 7;
		// joinContentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		//
		// JLabel lblNewLabel_7 = new JLabel("금");
		// GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		// gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_7.gridx = 5;
		// gbc_lblNewLabel_7.gridy = 7;
		// joinContentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		//
		// JLabel lblNewLabel_8 = new JLabel("토");
		// GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		// gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_8.gridx = 6;
		// gbc_lblNewLabel_8.gridy = 7;
		// joinContentPanel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		//
		// JLabel lblNewLabel_9 = new JLabel("일");
		// GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		// gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_9.gridx = 7;
		// gbc_lblNewLabel_9.gridy = 7;
		// joinContentPanel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		//
		// JButton button = new JButton("25");
		// GridBagConstraints gbc_button = new GridBagConstraints();
		// gbc_button.insets = new Insets(0, 0, 5, 5);
		// gbc_button.gridx = 1;
		// gbc_button.gridy = 8;
		// joinContentPanel.add(button, gbc_button);
		//
		// JButton btnNewButton = new JButton("26");
		// GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		// gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		// gbc_btnNewButton.gridx = 2;
		// gbc_btnNewButton.gridy = 8;
		// joinContentPanel.add(btnNewButton, gbc_btnNewButton);
		//
		// JButton button_1 = new JButton("26");
		// GridBagConstraints gbc_button_1 = new GridBagConstraints();
		// gbc_button_1.insets = new Insets(0, 0, 5, 5);
		// gbc_button_1.gridx = 3;
		// gbc_button_1.gridy = 8;
		// joinContentPanel.add(button_1, gbc_button_1);
		//
		// JButton btnNewButton_1 = new JButton("27");
		// GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		// gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		// gbc_btnNewButton_1.gridx = 4;
		// gbc_btnNewButton_1.gridy = 8;
		// joinContentPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		//
		// JButton btnNewButton_2 = new JButton("28");
		// GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		// gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		// gbc_btnNewButton_2.gridx = 5;
		// gbc_btnNewButton_2.gridy = 8;
		// joinContentPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		//
		// JButton btnNewButton_3 = new JButton("29");
		// GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		// gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		// gbc_btnNewButton_3.gridx = 6;
		// gbc_btnNewButton_3.gridy = 8;
		// joinContentPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		//
		// JButton btnNewButton_4 = new JButton("30");
		// GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		// gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		// gbc_btnNewButton_4.gridx = 7;
		// gbc_btnNewButton_4.gridy = 8;
		// joinContentPanel.add(btnNewButton_4, gbc_btnNewButton_4);
		//
		// JLabel lblNewLabel_10 = new JLabel("* 매주 토요일 일요일은 출석체크를 하지 않습니다.");
		// GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		// gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		// gbc_lblNewLabel_10.gridwidth = 7;
		// gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_10.gridx = 1;
		// gbc_lblNewLabel_10.gridy = 9;
		// joinContentPanel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		//
		// JLabel lblNewLabel_12 = new JLabel("이번달 받을 예상 국비 지원금");
		// GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		// gbc_lblNewLabel_12.gridwidth = 4;
		// gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_12.gridx = 4;
		// gbc_lblNewLabel_12.gridy = 10;
		// joinContentPanel.add(lblNewLabel_12, gbc_lblNewLabel_12);
		//
		// JLabel lblNewLabel_13 = new JLabel("316000 원");
		// GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		// gbc_lblNewLabel_13.anchor = GridBagConstraints.NORTH;
		// gbc_lblNewLabel_13.gridwidth = 2;
		// gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_13.gridx = 6;
		// gbc_lblNewLabel_13.gridy = 11;
		// joinContentPanel.add(lblNewLabel_13, gbc_lblNewLabel_13);
		//
		// JLabel lblNewLabel_11 = new JLabel("1. 하루 결석시 \r\n2. 지각 3번은 결석 1번
		// \r\n3. 지각 시 ");
		// lblNewLabel_11.setForeground(SystemColor.activeCaptionBorder);
		// GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		// gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		// gbc_lblNewLabel_11.gridwidth = 7;
		// gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		// gbc_lblNewLabel_11.gridx = 1;
		// gbc_lblNewLabel_11.gridy = 12;
		// joinContentPanel.add(lblNewLabel_11, gbc_lblNewLabel_11);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel013());
	}
}
