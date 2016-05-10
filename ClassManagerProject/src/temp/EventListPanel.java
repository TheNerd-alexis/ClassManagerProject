package temp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class EventListPanel extends JPanel {
	JListForm<EventPanel> eventList;
	EventListPanel() {
		setLayout(new BorderLayout(0, 0));
		TitlePanel titlePanel = new TitlePanel("CM","이벤트알림","닫기");
		add(titlePanel,BorderLayout.NORTH);
		eventList = new JListForm<EventPanel>();
		add(eventList);
	}

	public static void main(String[] args) {
		JFrame temp = new JFrame();
		EventListPanel event = new EventListPanel();
		event.eventList.addComponent(new EventPanel(1,"집에 가고 싶다"));
		event.eventList.addComponent(new EventPanel(0,"너는 가기 싫으니?"));
		temp.getContentPane().add(event);
		
		temp.setVisible(true);
	}
}
