package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SchedulePanel extends JPanel {
	TitlePanel titlePanel;
	CalendarPanel calendarPanel;
	ScheduleListPanel scheduleListPanel;
	SearchSchedulePanel searchSchedulePanel;

	private Color bgColor = new Color(255, 254, 239);
	private Color titleColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234, 232, 222);
	private Color whiteColor = new Color(239, 239, 239);

	SchedulePanel() {
		// setSize(297, 435);
		setLayout(new BorderLayout(0, 0));
		setBackground(bgColor);

		titlePanel = new TitlePanel("CM", "캘린더", "닫기");
		add(titlePanel, BorderLayout.NORTH);
		JPanel basePanel = new JPanel();
		basePanel.setBackground(bgColor);
		add(basePanel, BorderLayout.CENTER);
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[] { 30, 150, 30, 0 };
		gbl_basePanel.rowHeights = new int[] { 30, 40, 53, 53, 30, 0 };
		gbl_basePanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_basePanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		basePanel.setLayout(gbl_basePanel);

		searchSchedulePanel = new SearchSchedulePanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		basePanel.add(searchSchedulePanel, gbc_panel_1);

		calendarPanel = new CalendarPanel(searchSchedulePanel.year, searchSchedulePanel.month);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 2;
		basePanel.add(calendarPanel, gbc_panel_2);

		scheduleListPanel = new ScheduleListPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		basePanel.add(scheduleListPanel, gbc_panel_3);
	}

	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.getContentPane().add(new SchedulePanel());
		temp.setSize(400, 750);
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.setVisible(true);
	}

	class SearchSchedulePanel extends JPanel {
		JComboBox yearCombo;
		JComboBox monthCombo;
		JButton btnSearch;
		String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		String[] years = new String[11];
		int month;
		int year;

		SearchSchedulePanel() {
			Calendar defaultMonth = Calendar.getInstance();
			month = defaultMonth.get(Calendar.MONTH);
			year = defaultMonth.get(Calendar.YEAR);
			for (int i = 0; i < 11; i++) {
				years[i] = String.valueOf(year - 5 + i);
			}
			yearCombo = new JComboBox(years);
			yearCombo.setSelectedIndex(5);
			yearCombo.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					calendarPanel.setMonth(yearCombo.getSelectedIndex() + year - 5, monthCombo.getSelectedIndex());
				}
			});
			JLabel yearLabel = new JLabel("년");
			monthCombo = new JComboBox(months);
			monthCombo.setSelectedIndex(month);
			monthCombo.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					calendarPanel.setMonth(yearCombo.getSelectedIndex() + year - 5, monthCombo.getSelectedIndex());
				}
			});
			JLabel monthLabel = new JLabel("월");
			btnSearch = new JButton("검색");
			setBackground(bgColor);
			add(yearCombo);
			add(yearLabel);
			add(monthCombo);
			add(monthLabel);
			add(btnSearch);
		}
	}

	class ScheduleListPanel extends JPanel {
		JTextArea privateScheduleList;
		JTextArea publicScheduleList;
		private Color bgColor = new Color(255, 254, 239);
		private Color titleColor = new Color(108, 108, 108);
		private Color borderColor = new Color(234, 232, 222);
		private Color whiteColor = new Color(239, 239, 239);
		private JPanel panelPrivate;
		private JPanel panelPublic;

		ScheduleListPanel() {
			privateScheduleList = new JTextArea();
			privateScheduleList.setBackground(bgColor);
			privateScheduleList.setFont(new Font("나눔고딕코딩", Font.PLAIN, 15));
			privateScheduleList.setEditable(false);
			publicScheduleList = new JTextArea();
			publicScheduleList.setBackground(bgColor);
			publicScheduleList.setEditable(false);
			setBorder(new LineBorder(borderColor, 1, true));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			panelPrivate = new JPanel();
			add(panelPrivate);
			panelPrivate.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelPrivate.setBackground(bgColor);
			JLabel lblPrivate = new JLabel("개인");
			panelPrivate.add(lblPrivate);
			add(privateScheduleList);

			panelPublic = new JPanel();
			add(panelPublic);
			JLabel lblPublic = new JLabel("전체");
			panelPublic.setBackground(bgColor);
			panelPublic.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelPublic.add(lblPublic);
			add(publicScheduleList);
		}
	}

	class CalendarPanel extends JPanel {
		private JTable calendarTable;
		private JTextField yearField;
		private JComboBox monthBox;
		private JTable table;
		DayButton[][] calendar = new DayButton[7][7];
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

		class DayButton extends JButton {
			int day;
			int month;
			int year;

			private Color bgColor = new Color(255, 254, 239);
			private Color titleColor = new Color(108, 108, 108);
			private Color borderColor = new Color(234, 232, 222);
			private Color whiteColor = new Color(239, 239, 239);
			Border emptyBorder= new EmptyBorder(0, 0, 0, 0);

			List<String> event = new ArrayList<String>();

			DayButton() {
				super();
				setBorder(emptyBorder);
				setFocusPainted(false);
				setContentAreaFilled(false);
				setOpaque(true);
				setForeground(titleColor);
				setBackground(bgColor);
			}

			DayButton(String dayofweek) {
				setText(dayofweek);
				setFocusPainted(false);

				setContentAreaFilled(false);
				setOpaque(true);

				setBorder(emptyBorder);
				setForeground(whiteColor);
				setBackground(titleColor);
			}

			int getDay() {
				return day;
			}

			void setDay(int day) {
				this.day = day;
				if (day < 0) {
					super.setText(null);
					setBorder(emptyBorder);
					setBackground(bgColor);
				} else {
					super.setText(String.valueOf(this.day));
					setBorder(emptyBorder);
					setBackground(bgColor);
				}
			}

			int getMonth() {
				return month;
			}

			void setMonth(int month) {
				this.month = month;
			}

			int getYear() {
				return year;
			}

			void setYear(int year) {
				this.year = year;
			}

			List<String> getEvent() {
				return event;
			}

			void setEvent(List<String> event) {
				this.event = event;
			}
		}

		CalendarPanel(int year, int month) {
			setLayout(new GridLayout(0, 7, 0, 0));
			setBackground(bgColor);
			for (int i = 0; i < 7; ++i) {
				calendar[0][i] = new DayButton(days[i]);
			}
			for (int i = 1; i < 7; ++i) {
				for (int j = 0; j < 7; ++j) {
					calendar[i][j] = new DayButton();
				}
			}
			setMonth(year, month);
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (j == 0)
						calendar[i][j].setForeground(Color.RED);
					if (j == 6)
						calendar[i][j].setForeground(Color.BLUE);
					add(calendar[i][j]);
				}
			}
		}

		public void setMonth(int year, int month) {
			java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
			cal.set(year, month, 1);
			int offset = cal.get(java.util.GregorianCalendar.DAY_OF_WEEK) - 1;
			offset += 7;
			int num = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			for (int i = 0; i < offset - 7; ++i) {
				calendar[1][i].setYear(-1);
				calendar[1][i].setMonth(-1);
				calendar[1][i].setDay(-1);
			}
			for (int i = 0; i < num; ++i) {
				calendar[offset / 7][offset % 7].setYear(year);
				calendar[offset / 7][offset % 7].setMonth(month);
				calendar[offset / 7][offset % 7].setDay(i + 1);
				++offset;
			}
			for (int i = offset; i < 49; i++) {
				calendar[offset / 7][offset % 7].setYear(-1);
				calendar[offset / 7][offset % 7].setMonth(-1);
				calendar[offset / 7][offset % 7].setDay(-1);
				++offset;
			}
		}
	}
}
