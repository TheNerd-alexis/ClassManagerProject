package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Model.AbstractModel;
import Model.Schedule;

public class Panel015 extends JPanel {
	CMListPanel listPanel;
	List<AbstractModel> scheduleList;
	public Panel015() {
		ImageIcon img = new ImageIcon("img/basic_resize.jpg");

		ClassManagerPanel bgPanel = new ClassManagerPanel(img);

		setLayout(new BorderLayout(0, 0));
		add(bgPanel, BorderLayout.CENTER);

		listPanel = new CMListPanel();
		listPanel.setBounds(10, 58, 375, 682);
		Schedule sch = new Schedule();
		sch.setSchDate(Date.valueOf(LocalDate.now()));
		sch.setSchTitle("제목모모모ㅗ모모모모ㅗ모모모ㅗ모모모ㅗ모모");
		sch.setSch("내용어어어어ㅓ어어어어ㅓ어어어어ㅓ어어어어어어어어어어ㅓ어어어어어ㅓ어어어ㅓ어어어어어ㅓ어어어어ㅓ어어어어ㅓ어어");
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle()));
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle(), sch.getSch()));
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle()));
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle(), sch.getSch()));
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle()));
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle(), sch.getSch()));
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle()));
		listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle(), sch.getSch()));
		bgPanel.add(listPanel);
	}

	class SchedulePanel extends ClassManagerPanel {
		public SchedulePanel(Date date, String title) {
			super(new ImageIcon("img/015single.png"));
			int month = Integer.parseInt(date.toString().substring(5, 7));
			int day = Integer.parseInt(date.toString().substring(8, 10));

			JLabel dateLabel = new JLabel(month + "/" + day);
			JLabel titleLabel = new JLabel(title);

			dateLabel.setBounds(4, 9, 51, 43);
			titleLabel.setBounds(48, 52, 287, 141);
			titleLabel.setOpaque(false);

			dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
			dateLabel.setVerticalAlignment(SwingConstants.CENTER);
			titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
			titleLabel.setVerticalAlignment(SwingConstants.CENTER);
			add(dateLabel);
			add(titleLabel);
			addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					refreshSchedulList(scheduleList);
				}

				@Override
				public void focusLost(FocusEvent arg0) {
					
				}
				
			});
		}

		public SchedulePanel(Date date, String title, String content) {
			super(new ImageIcon("img/015single.png"));
			int month = Integer.parseInt(date.toString().substring(5, 7));
			int day = Integer.parseInt(date.toString().substring(8, 10));
			JLabel dateLabel = new JLabel(month + "/" + day);
			JLabel titleLabel = new JLabel(title);
			JTextArea contentArea = new JTextArea(content);

			dateLabel.setBounds(4, 9, 51, 43);
			titleLabel.setBounds(46, 54, 285, 27);
			contentArea.setBounds(43, 87, 284, 98);

			titleLabel.setOpaque(false);
			contentArea.setLineWrap(true);
			contentArea.setOpaque(false);
			contentArea.setEditable(false);

			dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
			dateLabel.setVerticalAlignment(SwingConstants.CENTER);
			titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
			titleLabel.setVerticalAlignment(SwingConstants.CENTER);

			add(dateLabel);
			add(titleLabel);
			add(contentArea);
		}
	}

	public void refreshSchedulList(List<AbstractModel> list) {
		listPanel.clearList();
		for (AbstractModel model : list) {
			Schedule sch = (Schedule) model;
			if (sch.getSch().isEmpty())
				listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle()));
			else
				listPanel.addComponent(new SchedulePanel(sch.getSchDate(), sch.getSchTitle(), sch.getSch()));
		}
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel015());
	}
}
