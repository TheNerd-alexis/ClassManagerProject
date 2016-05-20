package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.Box;

	
public class Panel012 extends JPanel{
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	public TitlePanel title;
	CalendarPanel calendarPanel; 
	SearchSchedulePanel searchSchedulePanel;
	ScheduleListPanel scheduleListPanel;
	
	public Panel012(){
		ImageIcon img = new ImageIcon("img/012_resize.jpg");
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setLayout(new BorderLayout(0,0));
		add(bgPanel, BorderLayout.CENTER);
		
		title = new TitlePanel("CM", "캘린더", "닫기");
		title.setBounds(0,0,410,40);
		bgPanel.add(title);
		
		searchSchedulePanel = new SearchSchedulePanel();
		calendarPanel = new CalendarPanel(searchSchedulePanel.year, searchSchedulePanel.month);
		scheduleListPanel = new ScheduleListPanel();
		searchSchedulePanel.setBounds(35,69,340,39);
		calendarPanel.setBounds(30,125,347,270);
		scheduleListPanel.setBounds(38,416,333,309);
		bgPanel.add(searchSchedulePanel);
		bgPanel.add(scheduleListPanel);
		bgPanel.add(calendarPanel);
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel012());
	}
	
	class CalendarPanel extends JPanel {
		private JTable calendarTable;
		private JTextField yearField;
		private CMComboBox monthBox;
		private JTable table;
		DayButton[][] calendar = new DayButton[7][7];
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

		class DayButton extends JButton {
			int day;
			int month;
			int year;

			private Color bgColor = new Color(255, 254, 239);
			private Color titleColor = new Color(108, 108, 108);
			private Color whiteColor = new Color(239, 239, 239);
			Border emptyBorder= new EmptyBorder(0, 0, 0, 0);

			List<String> event = new ArrayList<String>();

			DayButton() {
				super();
				setBorder(emptyBorder);
				setFocusPainted(false);
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
					setEnabled(false);
				} else {
					super.setText(String.valueOf(this.day));
					setBorder(emptyBorder);
					setBackground(bgColor);
					setEnabled(true);
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
			setOpaque(false);
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
	
	class SearchSchedulePanel extends JPanel {
		CMComboBox yearCombo;
		CMComboBox monthCombo;
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
			yearCombo = new CMComboBox(years);
			yearCombo.setSelectedIndex(5);
			yearCombo.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					calendarPanel.setMonth(yearCombo.getSelectedIndex() + year - 5, monthCombo.getSelectedIndex());
				}
			});
			JLabel yearLabel = new JLabel("년");
			monthCombo = new CMComboBox(months);
			monthCombo.setSelectedIndex(month);
			monthCombo.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					calendarPanel.setMonth(yearCombo.getSelectedIndex() + year - 5, monthCombo.getSelectedIndex());
				}
			});
			JLabel monthLabel = new JLabel("월");
			monthLabel.setFont(defaultFont);
			setOpaque(false);
			add(yearCombo);
			add(yearLabel);
			Component horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setBounds(12, 23, 20, 1);
			add(horizontalStrut);
			add(monthCombo);
			add(monthLabel);
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
			publicScheduleList.setEditable(false);
			setBorder(new LineBorder(borderColor, 1, true));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			panelPrivate = new JPanel();
			add(panelPrivate);
			panelPrivate.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel lblPrivate = new JLabel("개인");
			panelPrivate.add(lblPrivate);
			add(privateScheduleList);

			panelPublic = new JPanel();
			add(panelPublic);
			JLabel lblPublic = new JLabel("전체");
			panelPublic.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelPublic.add(lblPublic);
			add(publicScheduleList);
		}
	}
}
