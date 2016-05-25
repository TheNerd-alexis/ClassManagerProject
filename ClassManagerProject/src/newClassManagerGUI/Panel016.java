package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Model.AbstractModel;
import Model.Event;
import Model.Member;

public class Panel016 extends JPanel {
	ImageIcon img = new ImageIcon("img/basic_resize.jpg");
	CMListPanel listPanel;
	ClassManagerPanel bgPanel;
	JLabel eventTypeLabel;
	public TitlePanel titlePanel;
	List<ClassManagerPanel> eventComponentList;
	List<AbstractModel> eventList;

	private CMListPanel friendListPanel;
	public List<AbstractModel> friendList = null;
	public List<NameCheckPanel> friendComponentList = null;

	JButton addEventBtn;
	ObjectOutputStream writer;
	Member member;

	public Panel016(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("CM", "이벤트", "닫기");
		titlePanel.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(titlePanel);

		ImageIcon plusIcon = new ImageIcon(
				new ImageIcon("img/plusIcon.png").getImage().getScaledInstance(44, 44, java.awt.Image.SCALE_SMOOTH));
		addEventBtn = new JButton(plusIcon) {
			public boolean contains(int x, int y) {
				Shape shape = null;
				if (shape == null || !shape.getBounds().equals(getBounds())) {
					shape = new Ellipse2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
				}
				return shape.contains(x, y);
			}
		};
		addEventBtn.setOpaque(false);
		addEventBtn.setBorder(null);
		addEventBtn.setFocusPainted(false);
		addEventBtn.setContentAreaFilled(false);
		addEventBtn.setBounds(343, 695, 44, 44);
		// addEventBtn.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// MiniPanel017 tempPanel = new MiniPanel017();
		// tempPanel.convertVisible(2);
		// listPanel.addComponent(tempPanel);
		// }
		// });
		bgPanel.add(addEventBtn);

		listPanel = new CMListPanel();
		listPanel.setBounds(11, 52, 390, 692);

		bgPanel.add(listPanel, BorderLayout.CENTER);

		this.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				refreshEventListPanel();
			}

		});
	}

	public void refreshEventListPanel() {
		listPanel.clearList();
		if (eventComponentList == null || eventComponentList.isEmpty())
			return;
		for (ClassManagerPanel m : eventComponentList) {
			listPanel.addComponent(m);
		}
		listPanel.revalidate();
		listPanel.repaint();
	}

	public void setEventList(List<AbstractModel> eventList) {
		this.eventList = eventList;
		eventComponentList = new ArrayList<ClassManagerPanel>();
		for (AbstractModel m : eventList) {
			Event event = (Event) m;
			// if (event.getEtype() == 0)
			// eventComponentList.add(new MiniPanel017(event.getEtitle()));
			// else {
			eventComponentList.add(new MiniPanel016(event.getEtype(), event.getEtitle()));
			// }
		}
	}

	class MiniPanel016 extends ClassManagerPanel {
		CMButton eventContentBtn;
		int eventType;
		String event;

		public MiniPanel016(int eventType, String event) {
			super(new ImageIcon("img/16.jpg"));
			this.eventType = eventType;
			this.event = event;
			eventContentBtn = new CMButton();
			eventContentBtn.setBounds(1, 1, 391, 117);
			add(eventContentBtn);

			eventTypeLabel = new JLabel();
			eventTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			eventTypeLabel.setVerticalAlignment(SwingConstants.CENTER);
			eventTypeLabel.setBounds(8, 8, 86, 33);
			eventContentBtn.setLayout(null);
			eventContentBtn.add(eventTypeLabel);
			String[] typeName = { "커뮤니티", "공지", "캘린더" };
			eventTypeLabel.setText(typeName[this.eventType]);
			eventContentBtn.setText(this.event);
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
		CMButton eventContentBtn;
		CMTextField eventContent;
		ImageIcon icon1 = new ImageIcon("img/16.jpg");
		ImageIcon icon2 = new ImageIcon("img/17.jpg");

		public MiniPanel017() {
			super(new ImageIcon("img/17.jpg"));
			ImageIcon hearts = new ImageIcon("img/hearts.png");
			heart = new JLabel(hearts);
			heart.setBounds(23, 15, 40, 32);
			add(heart);
			nOfHeart = new JLabel("00");
			nOfHeart.setBounds(60, 19, 35, 24);
			nOfHeart.setHorizontalAlignment(SwingConstants.LEFT);
			nOfHeart.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			nOfHeart.setVerticalAlignment(SwingConstants.TOP);
			add(nOfHeart);

			ImageIcon lightening = new ImageIcon("img/lightening.png");
			thunder = new JLabel(lightening);
			thunder.setBounds(105, 20, 29, 24);
			add(thunder);
			nOfThunder = new JLabel("00");
			nOfThunder.setBounds(135, 19, 35, 24);
			nOfThunder.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			nOfThunder.setHorizontalAlignment(SwingConstants.LEFT);
			nOfThunder.setVerticalAlignment(SwingConstants.TOP);
			add(nOfThunder);

			sharing = new CMButton("공유하기");
			sharing.setBounds(266, 41, 66, 25);
			add(sharing);

			eventContentBtn = new CMButton();
			eventContentBtn.setBounds(21, 81, 324, 95);
			eventContentBtn.setHorizontalAlignment(SwingConstants.CENTER);
			eventContentBtn.setVerticalAlignment(SwingConstants.CENTER);
			add(eventContentBtn);

			eventContentBtn.setLayout(null);
			join = new CMButton("참가");
			join.setBounds(193, 8, 55, 20);
			notJoin = new CMButton("불참");
			notJoin.setBounds(256, 8, 55, 20);
			eventContentBtn.add(join);
			eventContentBtn.add(notJoin);
			eventTypeLabel = new JLabel("커뮤니티");
			eventTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			eventTypeLabel.setVerticalAlignment(SwingConstants.CENTER);
			eventTypeLabel.setBounds(8, 8, 86, 33);
			eventContentBtn.add(eventTypeLabel);
			eventContent = new CMTextField();
			eventContent.setBounds(12, 35, 300, 20);
			eventContent.setOpaque(true);
			eventContent.setVisible(false);
			eventContentBtn.add(eventContent);
			eventContent.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
						eventContent.setVisible(false);
						eventContentBtn.setText(eventContent.getText());
					}
				}
			});

			convertVisible(0);
			eventContentBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					convertVisible(heart.isVisible() ? 0 : 1);
				}
			});
		}

		public MiniPanel017(String eventContent) {
			this();
			eventContentBtn.setText(eventContent);
		}

		public void convertVisible(int count) {
			boolean state = count == 0 ? false : true;

			heart.setVisible(state);
			nOfHeart.setVisible(state);
			thunder.setVisible(state);
			nOfThunder.setVisible(state);
			sharing.setVisible(state);
			join.setVisible(state);
			notJoin.setVisible(state);
			eventTypeLabel.setVisible(!state);
			if (state) {
				setBorder(new LineBorder(Color.ORANGE));
				setOrgimg(icon2);
				int width = getBounds().width;
				int height = (int) ((double) getOrgimg().getIconHeight() / (double) getOrgimg().getIconWidth()
						* (double) width);
				Dimension size = new Dimension(width, height);
				setMaximumSize(size);
				setMinimumSize(size);
				setPreferredSize(size);
				eventContentBtn.setBounds(21, 81, 324, 95);
			} else {
				setBorder(null);
				setOrgimg(icon1);
				int width = getBounds().width;
				int height = (int) ((double) getOrgimg().getIconHeight() / (double) getOrgimg().getIconWidth()
						* (double) width);
				Dimension size = new Dimension(width, height);
				setMaximumSize(size);
				setMinimumSize(size);
				setPreferredSize(size);
				eventContentBtn.setBounds(1, 1, 391, 117);
			}

			if (count == 2) {
				eventContent.setVisible(true);
				eventContent.setText(eventContentBtn.getText());
			}
		}
	}

	public void setFriendList(List<AbstractModel> friendList) {
		this.friendList = friendList;

		if (friendList == null || friendList.size() < 1)
			return;

		List<NameCheckPanel> tempComponentList = new ArrayList<NameCheckPanel>();
		for (AbstractModel friend : friendList) {
			tempComponentList.add(new NameCheckPanel(friend.getID()));
		}
		friendComponentList = tempComponentList;
	}

	public void refreshFriendListPanel() {
		friendListPanel.clearList();

		List<NameCheckPanel> tempComponentList = friendComponentList;
		for (NameCheckPanel panel : tempComponentList)
			friendListPanel.addComponent(panel);
		friendListPanel.revalidate();
	}

	public void setMember(Member member) {
		// TODO Auto-generated method stub
		this.member = member;
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel016(null));
	}
}
