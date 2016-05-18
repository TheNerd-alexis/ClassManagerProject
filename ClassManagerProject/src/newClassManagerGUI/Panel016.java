package newClassManagerGUI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel016 extends JPanel {
	ImageIcon img = new ImageIcon("img/basic_resize.jpg");
	CMListPanel list;

	public Panel016() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		// bgPanel.setBackground();
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);
		list = new CMListPanel();
		list.setBounds(8, 122, 393, 613);
		list.addComponent(new MiniPanel016());
		list.addComponent(new MiniPanel016(1, "요란한 빈수레 김진호ㅋㅋㅋㅋ"));
		bgPanel.add(list, BorderLayout.CENTER);
	}

	class MiniPanel016 extends ClassManagerPanel {
		JLabel eventTypeLabel;
		CMButton eventContentBtn;

		public MiniPanel016() {
			super(new ImageIcon("img/16.jpg"));
			eventContentBtn = new CMButton();
			eventContentBtn.setBounds(1, 1, 391, 117);
			add(eventContentBtn);

			eventTypeLabel = new JLabel();
			eventTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			eventTypeLabel.setVerticalAlignment(SwingConstants.CENTER);
			eventTypeLabel.setBounds(8, 8, 86, 33);
			eventContentBtn.setLayout(null);
			eventContentBtn.add(eventTypeLabel);
		}

		public MiniPanel016(int eventType, String event) {
			this();
			String[] typeName = { "커뮤니티", "공지", "캘린더" };
			eventTypeLabel.setText(typeName[eventType - 1]);
			eventContentBtn.setText(event);
		}
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel016());
	}
}
