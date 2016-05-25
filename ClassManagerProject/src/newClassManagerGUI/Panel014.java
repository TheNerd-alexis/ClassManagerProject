package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Model.AbstractModel;
import Model.CMMessage;
import Model.Member;
import Model.Schedule;

public class Panel014 extends JPanel {

	CMButton addEventBtn;
	CMButton addFriendBtn;
	JTextArea memomain;
	CMTextField titleField;
	Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
	int month;
	int year;
	int day;
	CMTextField monthField;
	CMTextField yearField;
	CMTextField dayField;
	public TitlePanel titlePanel;
	JLabel memoCharLabel;
	JLabel friendLabel;
	ObjectOutputStream writer;
	Member member;
	JLabel memoLabel;

	private Set<String> friendSet;
	private CMListPanel friendListPanel;
	public List<AbstractModel> friendList = null;
	public List<NameCheckPanel> friendComponentList = new ArrayList<NameCheckPanel>();

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Panel014(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(new ImageIcon("img/014.jpg"));
		add(bgPanel, BorderLayout.CENTER);

		Calendar defaultDay = Calendar.getInstance();
		month = defaultDay.get(Calendar.MONTH) + 1;
		year = defaultDay.get(Calendar.YEAR);
		day = defaultDay.get(Calendar.DAY_OF_MONTH);

		titlePanel = new TitlePanel("CM", "일정 추가", "닫기");
		titlePanel.setBounds(0, 0, 410, 40);
		bgPanel.add(titlePanel);

		JLabel titleLabel = new JLabel("일정 제목");
		titleLabel.setFont(defaultFont);
		titleLabel.setBounds(30, 65, 70, 38);
		bgPanel.add(titleLabel);

		titleField = new CMTextField();
		titleField.setBounds(120, 65, 350, 38);
		bgPanel.add(titleField);

		JLabel scheduletimeLabel = new JLabel("일정 날짜");
		scheduletimeLabel.setBounds(30, 127, 70, 38);
		scheduletimeLabel.setFont(defaultFont);
		bgPanel.add(scheduletimeLabel);

		yearField = new CMTextField(String.valueOf(year));
		yearField.setHorizontalAlignment(SwingConstants.RIGHT);
		yearField.setBounds(105, 127, 50, 38);
		bgPanel.add(yearField);

		JLabel yearLabel = new JLabel("년");
		yearLabel.setBounds(165, 125, 50, 38);
		yearLabel.setFont(defaultFont);
		bgPanel.add(yearLabel);

		monthField = new CMTextField(String.valueOf(month));
		monthField.setBounds(210, 127, 20, 38);
		monthField.setHorizontalAlignment(SwingConstants.RIGHT);
		bgPanel.add(monthField);

		JLabel monthLabel = new JLabel("월");
		monthLabel.setBounds(235, 125, 50, 38);
		monthLabel.setFont(defaultFont);
		bgPanel.add(monthLabel);

		dayField = new CMTextField(String.valueOf(day));
		dayField.setHorizontalAlignment(SwingConstants.RIGHT);
		dayField.setBounds(280, 127, 20, 38);
		bgPanel.add(dayField);

		JLabel dayLabel = new JLabel("일");
		dayLabel.setBounds(305, 125, 50, 38);
		dayLabel.setFont(defaultFont);
		bgPanel.add(dayLabel);

		friendLabel = new JLabel("공유할 친구");
		friendLabel.setBounds(30, 179, 265, 58);
		friendLabel.setFont(defaultFont);
		bgPanel.add(friendLabel);

		addFriendBtn = new CMButton("+추가");
		addFriendBtn.setBounds(303, 192, 60, 31);
		bgPanel.add(addFriendBtn);

		memoLabel = new JLabel("일정 메모");
		memoLabel.setBounds(30, 245, 265, 58);
		memoLabel.setFont(defaultFont);
		bgPanel.add(memoLabel);

		memoCharLabel = new JLabel();
		memoCharLabel.setBounds(110, 245, 265, 58);
		memoCharLabel.setFont(defaultFont);
		bgPanel.add(memoCharLabel);

		addEventBtn = new CMButton("일정 추가");
		addEventBtn.setBounds(148, 707, 113, 38);
		bgPanel.add(addEventBtn);

		memomain = new JTextArea();
		memomain.setBounds(37, 300, 334, 360);
		memomain.setLineWrap(true);
		memomain.setFont(defaultFont);
		memomain.setOpaque(false);
		bgPanel.add(memomain);

		friendListPanel = new CMListPanel();
		friendListPanel.setOpaque(true);
		friendListPanel.setBackground(new Color(254, 246, 223));
		friendListPanel.setBorder(new LineBorder(new Color(225,222,205)));
		friendListPanel.setBounds(19, 230, 371, 452);
		friendListPanel.setVisible(false);
		bgPanel.add(friendListPanel);

		addListener();
	}

	public void addListener() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				titleField.setText("");
				yearField.setText(String.valueOf(year));
				monthField.setText(String.valueOf(month));
				dayField.setText(String.valueOf(day));
				memomain.setText("");
				friendLabel.setText("공유할 친구");
				friendLabel.setToolTipText(null);
				memoCharLabel.setText("");
				refreshFriendList();
			}
		});

		dayField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JTextField s = (JTextField) e.getSource();
				String str = "";
				try {
					str = s.getText();
					if (!s.getText().isEmpty())
						Integer.parseInt(s.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
				}
			}
		});

		monthField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JTextField s = (JTextField) e.getSource();
				String str = "";
				try {
					if (!s.getText().isEmpty())
						Integer.parseInt(s.getText());
					str = s.getText();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
					s.setText(str);
				}
			}
		});

		yearField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JTextField s = (JTextField) e.getSource();
				String str = "";
				try {
					if (!s.getText().isEmpty())
						Integer.parseInt(s.getText());
					str = s.getText();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "숫자만 입력해주세요.");
					s.setText(str);
				}
			}
		});

		addFriendBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (friendListPanel.isVisible()) {
					addFriendBtn.setText("+추가");
					friendListPanel.setVisible(false);
					friendLabel.setText("");
					memomain.setVisible(true);
					memoLabel.setVisible(true);
					memoCharLabel.setText("(" + memomain.getText().length() + "자)");
					for (NameCheckPanel panel : friendComponentList) {
						if (panel.checkBox.isSelected()) {
							friendLabel.setText(friendLabel.getText() + " " + panel.nameLabel.getText());
						}
					}
					friendLabel.setToolTipText(friendLabel.getText());
					if (friendLabel.getText().isEmpty()) {
						friendLabel.setText("공유할 친구");
						friendLabel.setToolTipText(null);
					}
				} else {
					addFriendBtn.setText("완료");
					friendListPanel.setVisible(true);
					friendLabel.setText("공유할 친구");
					memomain.setVisible(false);
					memoLabel.setVisible(false);
					memoCharLabel.setText("");
				}
			}
		});

		addEventBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (titleField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "일정 제목을 입력해주세요.");
					titleField.requestFocus();
					return;
				}
				if (titleField.getText().length() > 30) {
					JOptionPane.showMessageDialog(null, "일정 제목을 30자 이내로 입력해주세요.");
					titleField.requestFocus();
					return;
				}
				if (yearField.getText().length() != 4) {
					JOptionPane.showMessageDialog(null, "년도를 다시 입력해주세요.");
					yearField.requestFocus();
					return;
				}
				if (Integer.parseInt(monthField.getText()) > 13 || Integer.parseInt(monthField.getText()) < 1) {
					JOptionPane.showMessageDialog(null, "월을 다시 입력해주세요.");
					monthField.requestFocus();
					return;
				}
				int month = Integer.parseInt(monthField.getText());
				int year = Integer.parseInt(yearField.getText());
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, year);
				cal.set(Calendar.MONTH, month);
				int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				int min = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
				if (Integer.parseInt(dayField.getText()) > max || Integer.parseInt(dayField.getText()) < min
						|| dayField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "일을 다시 입력해주세요.");
					dayField.requestFocus();
					return;
				}
				if (memomain.getText().length() > 1000) {
					JOptionPane.showMessageDialog(null, "메모를 1000자 이내로 입력해주세요.");
					memomain.requestFocus();
					return;
				}
				Schedule sch = new Schedule();
				sch.setSchID(member.getID());
				Date date = Date
						.valueOf(String.format("%04d-%02d-%02d", year, month, Integer.parseInt(dayField.getText())));
				sch.setSchDate(date);
				sch.setSch(memomain.getText());
				sch.setSchTitle(titleField.getText());

				new CMMessage("schedule_add", sch).sendMsg(writer);

				for (NameCheckPanel panel : friendComponentList) {
					if (panel.checkBox.isSelected()) {
						Schedule tempSch = new Schedule();
						tempSch.setSchID(panel.nameLabel.getText());
						tempSch.setSchTitle(sch.getSchTitle());
						tempSch.setSch(sch.getSch() + "(" + member.getMID() + "님과 공유된 일정)");
						tempSch.setSchDate(sch.getSchDate());
//						System.out.println(tempSch.toJson());
						new CMMessage("schedule_add", tempSch).sendMsg(writer);
					}
				}
			}
		});
		memomain.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				memoCharLabel.setText("(" + memomain.getText().length() + "자)");
			}
		});
	}

	public void setFriendList(List<AbstractModel> friendList) {
		this.friendList = friendList;
	}

	public void refreshFriendListPanel() {
		friendListPanel.clearList();

		List<NameCheckPanel> tempComponentList = friendComponentList;
		for (NameCheckPanel panel : tempComponentList)
			friendListPanel.addComponent(panel);
		friendListPanel.revalidate();
	}

	public void refreshFriendList() {
		if (friendList == null || friendList.size() < 1)
			return;

		List<NameCheckPanel> tempComponentList = new ArrayList<NameCheckPanel>();
		for (AbstractModel friend : friendList) {
			tempComponentList.add(new NameCheckPanel(friend.getID()));
		}
		friendComponentList = tempComponentList;

		refreshFriendListPanel();
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel014(null));
	}
}
