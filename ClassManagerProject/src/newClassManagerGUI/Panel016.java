package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.AbstractModel;
import Model.Event;

public class Panel016 extends JPanel {
	ImageIcon img = new ImageIcon("img/basic_resize.jpg");
	CMListPanel listPanel;
	ClassManagerPanel bgPanel;
	CMButton eventContentBtn;
	JLabel eventTypeLabel;
	TitlePanel title;
	List<AbstractModel> eventList;

	public Panel016() {
		setLayout(new BorderLayout(0, 0));
		bgPanel = new ClassManagerPanel(img);
		// bgPanel.setBackground();
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);
		
		title = new TitlePanel("CM", "회원가입", "닫기");
		title.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(title);
		
		listPanel = new CMListPanel();
		listPanel.setBounds(11, 52, 390, 692);
		listPanel.clearList();

		bgPanel.add(listPanel, BorderLayout.CENTER);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				listPanel.clearList();
				addToList(eventList);
			}

		});
	}

	public void addToList(List<AbstractModel> list) {
		for (AbstractModel m : eventList) {
			Event event = (Event) m;
			if (event.getEtype() == 0)
				listPanel.addComponent(new MiniPanel017(event.getEtype(), event.getEtitle()));
			else {
				listPanel.addComponent(new MiniPanel016(event.getEtype(), event.getEtitle()));
			}
		}
	}

	class MiniPanel016 extends ClassManagerPanel {
		

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

	class MiniPanel017 extends ClassManagerPanel {
	
		JLabel nOfHeart;
		JLabel nOfThunder;
		CMButton join;
		JLabel heart;
		JLabel thunder;
		CMButton sharing;
		CMButton notJoin;
		JLabel eventTypeLabel;

		public MiniPanel017() {
			super(new ImageIcon("img/17.jpg"));
			ImageIcon hearts = new ImageIcon("img/hearts.png");
			heart = new JLabel(hearts);
			heart.setBounds(26, 17, 40, 32);
			add(heart);
			nOfHeart = new JLabel("n");
			nOfHeart.setBounds(22, 16, 81, 34);
			nOfHeart.setHorizontalAlignment(SwingConstants.RIGHT);
			nOfHeart.setVerticalAlignment(SwingConstants.CENTER);
			add(nOfHeart);

			ImageIcon lightening = new ImageIcon("img/lightening.png");
			thunder = new JLabel(lightening);
			thunder.setBounds(108, 18, 44, 33);
			add(thunder);
			nOfThunder = new JLabel("n");
			nOfThunder.setBounds(110, 17, 78, 34);
			nOfThunder.setHorizontalAlignment(SwingConstants.RIGHT);
			nOfThunder.setVerticalAlignment(SwingConstants.CENTER);
			add(nOfThunder);

			sharing = new CMButton("공유하기");
			sharing.setBounds(266, 41, 66, 25);
			add(sharing);

			eventContentBtn = new CMButton();
			eventContentBtn.setBounds(23, 86, 346, 102);
			eventContentBtn.setHorizontalAlignment(SwingConstants.CENTER);
			eventContentBtn.setVerticalAlignment(SwingConstants.CENTER);
			add(eventContentBtn);

			eventContentBtn.setLayout(null);
			join = new CMButton("참가");
			join.setBounds(186, 4, 55, 18);
			notJoin = new CMButton("불참");
			notJoin.setBounds(262, 5, 58, 18);
			eventContentBtn.add(join);
			eventContentBtn.add(notJoin);
			convertVisible(false);

			eventContentBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					convertVisible(!heart.isVisible());
				}
			});
		}

		public void convertVisible(boolean state) {
			heart.setVisible(state);
			nOfHeart.setVisible(state);
			thunder.setVisible(state);
			nOfThunder.setVisible(state);
			sharing.setVisible(state);
			join.setVisible(state);
			notJoin.setVisible(state);
			eventTypeLabel.setVisible(state);
			if (state) {
				super.setOrgimg(new ImageIcon("img/17.jpg"));
				eventContentBtn.setBounds(23, 86, 346, 102);
				int height = super.getImg().getIconHeight();
				int width = super.getImg().getIconWidth();
				Dimension d = new Dimension(width, height);
				repaint();
				super.setPreferredSize(d);
				super.setMaximumSize(d);
				super.setMinimumSize(d);
			} else {
				super.setOrgimg(new ImageIcon("img/16.jpg"));
				eventContentBtn.setBounds(1, 1, 391, 117);
				int height = super.getImg().getIconHeight();
				int width = super.getImg().getIconWidth();
				Dimension d = new Dimension(width, height);
				repaint();
				super.setPreferredSize(d);
				super.setMaximumSize(d);
				super.setMinimumSize(d);
			}
		}

		public MiniPanel017(int eventType, String eventContent) {
			this();
			//eventTypeLabel.convertVisible(false);
			eventContentBtn.setText(eventContent);
			String[] typeName = { "커뮤니티", "공지", "캘린더" };
			eventTypeLabel.setText(typeName[eventType - 1]);
		}
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel016());
	}
}
