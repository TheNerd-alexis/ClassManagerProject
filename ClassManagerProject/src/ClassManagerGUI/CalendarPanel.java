package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CalendarPanel extends JFrame {
	JPanel calendarPanel;
	private JTable calendarTable;
	private JTextField yearField;
	private JComboBox monthBox;
	private JTable table;
	DayButton[][] calendar =  new DayButton[7][7];
	String[] days = {"Sun", "Mon", "Tue", "Wed","Thu","Fri","Sat"};
	
	class DayButton extends JButton {
		GregorianCalendar cal;
		int day;
		int month;
		int year;
		
		List<String> event = new ArrayList<String>();

		DayButton() {
			super();
			super.setEnabled(false);
		}
		
		DayButton(String dayofweek){
			super(dayofweek);
			super.setEnabled(false);
		}

		DayButton(int year, int month, int day) {
			cal = new GregorianCalendar();
			this.day = day;
			this.month = month;
			this.year = year;
			super.setText(String.valueOf(this.day));
		}
	}

	CalendarPanel() {
		setSize(297, 435);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		calendarPanel = new JPanel();
		getContentPane().add(calendarPanel, BorderLayout.NORTH);
		calendarPanel.setLayout(new GridLayout(0, 7, 0, 0));
		
		Calendar defaultMonth = Calendar.getInstance();
		for (int i = 0; i < 7; ++i) {
			calendar[0][i] = new DayButton(days[i]);
		}
		int month = defaultMonth.get(Calendar.MONTH);
		int year = defaultMonth.get(Calendar.YEAR);
		setMonth(year, month);
		for(int i = 0;i<7;i++)
			for(int j = 0;j<7;j++)
					calendarPanel.add(calendar[i][j]);
		setVisible(true);
	}

	public void setMonth(int year, int month) {
		java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
		cal.set(year, month, 1);
		int offset = cal.get(java.util.GregorianCalendar.DAY_OF_WEEK) - 1;
		offset += 7;
		int num = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 0; i < num; ++i) {
			calendar[offset / 7][offset % 7] = new DayButton(year,month,i+1);
			++offset;
		}
		for(int i = 0;i<7;i++)
			for(int j = 0;j<7;j++)
				if(calendar[i][j]==null)
					calendar[i][j] = new DayButton();
	}
	
	public static void main(String[] args) {
		new CalendarPanel();
	}
}