package ClassManagerGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newClassManagerGUI.CMListPanel;

import java.awt.BorderLayout;

public class EventListPanel extends JPanel {
	CMListPanel<EventPanel> eventList;
	EventListPanel() {
		setLayout(new BorderLayout(0, 0));
		TitlePanel titlePanel = new TitlePanel("CM","이벤트알림","닫기");
		add(titlePanel,BorderLayout.NORTH);
		eventList = new CMListPanel<EventPanel>();
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
