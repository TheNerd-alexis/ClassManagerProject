package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Model.AbstractModel;
import Model.CMMessage;
import Model.Dch;
import Model.Member;

public class Panel013 extends JPanel {

	JButton btnCheck;
	public TitlePanel titlePanel;

	private Color bgColor = new Color(255, 254, 239);
	Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 20);
	List<AbstractModel> dchList;
	ObjectOutputStream writer;
	Member member;

	public Panel013(ObjectOutputStream writer) {
		this.writer = writer;
		ImageIcon img = new ImageIcon("img/013_resize.jpg");
		setLayout(new BorderLayout(0, 0));

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		LocalDate today = LocalDate.now();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int week = cal.get(Calendar.WEEK_OF_YEAR) - 11;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
		String[] days = { "일", "월", "화", "수", "목", "금", "토" };

		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		titlePanel = new TitlePanel("CM", "출석체크", "닫기");
		titlePanel.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(titlePanel);

		JLabel monthLabel = new JLabel(String.valueOf(month));
		monthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		monthLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		monthLabel.setBounds(115, 86, 42, 29);
		monthLabel.setForeground(Color.ORANGE);
		bgPanel.add(monthLabel);

		JLabel[] btnLabel = new JLabel[2];
		btnLabel[0] = new JLabel("TODAY");
		btnLabel[1] = new JLabel("출석체크");
		for (int i = 0; i < btnLabel.length; i++) {
			btnLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 25));
			btnLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			btnLabel[i].setForeground(new Color(217, 217, 217));
			btnLabel[i].setBounds(145, 275 + 30 * i, 113, 30);
			bgPanel.add(btnLabel[i]);
		}

		JLabel todayLabel = new JLabel(day + "/" + days[dayOfWeek]);
		todayLabel.setBounds(26, 188, 77, 44);
		todayLabel.setFont(defaultFont);
		todayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgPanel.add(todayLabel);

		JLabel weekLabel = new JLabel(String.valueOf(week));
		weekLabel.setBounds(23, 389, 33, 34);
		weekLabel.setFont(defaultFont);
		weekLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgPanel.add(weekLabel);

		JButton checkBtn = new JButton() {
			public boolean contains(int x, int y) {
				Shape shape = null;
				if (shape == null || !shape.getBounds().equals(getBounds())) {
					shape = new Ellipse2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
				}
				return shape.contains(x, y);
			}
		};
		checkBtn.setOpaque(false);
		checkBtn.setBorder(null);
		checkBtn.setFocusPainted(false);
		checkBtn.setContentAreaFilled(false);
		checkBtn.setBounds(135, 237, 143, 138);
		CircularLabel[] dayLabel = new CircularLabel[5];

		checkBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				dayLabel[dayOfWeek - 1].state = !dayLabel[dayOfWeek - 1].state;
				dayLabel[dayOfWeek - 1].convertImg();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				for (JLabel lbl : btnLabel) {
					lbl.setForeground(new Color(217, 217, 217));
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				for (JLabel lbl : btnLabel) {
					lbl.setForeground(Color.ORANGE);
				}
			}
		});
		bgPanel.add(checkBtn);

		JLabel moneyLabel = new JLabel("416000원(미구현)");
		moneyLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		moneyLabel.setBounds(133, 625, 229, 20);
		moneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		bgPanel.add(moneyLabel);
		JTextArea noticeArea = new JTextArea();
		noticeArea.setBounds(31, 671, 342, 62);
		noticeArea.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		noticeArea.append("국비 지원금 계산 방법\r\n1. 80% 이하 출석시 훈련 수당 \r\n2. 하루 식대 5500원");
		noticeArea.setOpaque(false);
		noticeArea.setEditable(false);
		bgPanel.add(noticeArea);
		for (int i = 0; i < 5; i++) {
			dayLabel[i] = new CircularLabel(false);
			dayLabel[i].setText(String.valueOf(day - dayOfWeek + 1 + i));
			dayLabel[i].setBounds(35 + 73 * i, 493, 45, 45);
			bgPanel.add(dayLabel[i]);
		}

		titlePanel.closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Dch dch = dayLabel[dayOfWeek - 1].getDch();
				dch.setATTENDANCE(dayLabel[dayOfWeek - 1].state ? 1 : 0);
				new CMMessage("dch_update", dch).sendMsg(writer);
			}
		});

		this.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				if (dchList == null)
					return;
				for (AbstractModel model : dchList) {
					Dch dch = (Dch) model;
					Calendar cal = Calendar.getInstance();
					cal.setTime(dch.getATTENDDATE());
					dayLabel[cal.get(Calendar.DAY_OF_WEEK) - 2].setDch(dch);
				}
			}
		});
	}

	class CircularLabel extends JLabel {
		ImageIcon checkImg = new ImageIcon(
				new ImageIcon("img/13-checked.png").getImage().getScaledInstance(46, 46, java.awt.Image.SCALE_SMOOTH));
		ImageIcon uncheckImg = new ImageIcon(new ImageIcon("img/13-unchecked.png").getImage().getScaledInstance(46, 46,
				java.awt.Image.SCALE_SMOOTH));
		ImageIcon img;
		Boolean state;
		int day;
		Dch dch;

		CircularLabel(Boolean state) {
			super();
			this.state = state;
			img = state ? checkImg : uncheckImg;
			setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}

		CircularLabel(Dch dch) {
			this(dch.getATTENDANCE() == 1 ? true : false);
			this.dch = dch;
			Calendar cal = Calendar.getInstance();
			cal.setTime(dch.getATTENDDATE());
			this.day = cal.get(Calendar.DAY_OF_MONTH);

			super.setText(String.valueOf(day));
		}

		public void convertImg() {
			img = state ? checkImg : uncheckImg;
			revalidate();
		}

		public Dch getDch() {
			if (dch == null) {
				dch = new Dch();
				dch.setATTENDANCE(state ? 1 : 0);
				dch.setATTENDDATE(java.sql.Date.valueOf(LocalDate.now()));
				dch.setMID(member.getMID());
			}
			return dch;
		}

		public void setDch(Dch dch) {
			this.dch = dch;
			Calendar cal = Calendar.getInstance();
			cal.setTime(dch.getATTENDDATE());
			state = dch.getATTENDANCE() == 1 ? true : false;
			convertImg();
			this.day = cal.get(Calendar.DAY_OF_MONTH);

			super.setText(String.valueOf(day));
		}

		@Override
		protected void paintComponent(Graphics arg0) {
			// TODO Auto-generated method stub
			arg0.drawImage(img.getImage(), 0, 0, null);
			super.paintComponent(arg0);
		}
	}

	public List<AbstractModel> getDchList() {
		return dchList;
	}

	public void setDchList(List<AbstractModel> dchList) {
		this.dchList = dchList;

	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel013(null));
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
