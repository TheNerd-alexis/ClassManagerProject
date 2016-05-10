package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EventSearchPanel extends JPanel {
	private JTextField textField;
	JListForm listPanel;

	public EventSearchPanel() {
		setMaximumSize(new Dimension(400-10, 750-10));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		panel.setBackground(Color.GRAY);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("검색");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("닫기");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 254, 249));
		panel_1.setBackground(new Color(255, 254, 249));
		panel_2.setPreferredSize(new Dimension(10, 50));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setPreferredSize(new Dimension(300, 50));
		textField.setMaximumSize(new Dimension(300, 50));
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		panel_2.add(textField);
		textField.setColumns(24);
		
		listPanel = new JListForm();
		panel_1.add(listPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		EventSearchPanel eventSearch = new EventSearchPanel();
		temp.setSize(400, 750);
		eventSearch.textField.setText("2016년 5월 10일(화)");
		eventSearch.listPanel.add(new ScheduleSearchResultPanel("상현오빠 영화 보러 가는 날"));
		temp.getContentPane().add(eventSearch);
		temp.setVisible(true);
	}
}

class ScheduleSearchResultPanel extends JPanel {
	ImageIcon link = new ImageIcon("img/linkImg.gif");
	ScheduleSearchResultPanel(String scheduleContent) {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		setBackground(new Color(255, 254, 249));
		JLabel lblNewLabel = new JLabel(link);
		
		lblNewLabel.setPreferredSize(new Dimension(50, 50));
		add(lblNewLabel);
		JTextField schedule = new JTextField(scheduleContent);
		schedule.setEditable(false);
		schedule.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		schedule.setPreferredSize(new Dimension(300, 50));
		schedule.setMaximumSize(new Dimension(400, 50));
		add(schedule);
	}
}
