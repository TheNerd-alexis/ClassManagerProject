package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Model.AbstractModel;
import Model.Chat;
import Model.Event;
import Model.Multi;
import Model.Schedule;
import Service.Weather;

public class Panel003 extends JPanel {
	private ImageIcon img = new ImageIcon("img/003_resize.jpg");
	private ImageIcon listImg = new ImageIcon("img/ListPanel01.jpg");
	private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 25);
	private Font font1 = new Font("맑은 고딕", Font.PLAIN, 13);
	private Font font2 = new Font("맑은 고딕", Font.PLAIN, 10);

	private JPanel weatherImg; // out
	private JLabel tempLabel; // out

	private CMButton eventNoticeBtn; // out
	private JLabel eventNoticeLabelCount; // out
	private JLabel eventTitleLabel; // out

	public TitlePanel title;
	private JLabel[][] multiMenu;
	private CMButton[] chatListBtn;
	private JTextArea schArea;
	public CMButton schButton;
	public CMButton chatButton;

	private ClassManagerPanel bgPanel;
	private List<AbstractModel> eventList = null;
	private List<AbstractModel> todaySchList = null;
	private List<AbstractModel> chatList = null;
	private List<AbstractModel> multiList = null;

	public Panel003() {
		setLayout(new BorderLayout(0, 0));
		bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		title = new TitlePanel("CM", "", "출석체크");

		title.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(title);

		Weather weather = new Weather("126.98", "37.57", 0);
		String temp = String.format("%.2f도", weather.temp);
		weatherImg = new ClassManagerPanel(new ImageIcon(weather.image));
		weatherImg.setBounds(54, 81, 82, 60);
		bgPanel.add(weatherImg);

		tempLabel = new JLabel(temp);
		tempLabel.setBounds(213, 90, 153, 37);
		tempLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgPanel.add(tempLabel);

		eventNoticeBtn = new CMButton(null);
		eventNoticeBtn.setLayout(null);
		eventNoticeBtn.setBounds(15, 178, 386, 47);
		bgPanel.add(eventNoticeBtn);

		JLabel eventNoticeLabel = new JLabel("이벤트 알림");
		eventNoticeLabel.setFont(font1);
		eventNoticeLabel.setBounds(-10, -2, 122, 49);
		eventNoticeLabel.setVerticalAlignment(JLabel.CENTER);
		eventNoticeLabel.setHorizontalAlignment(JLabel.CENTER);
		eventNoticeBtn.add(eventNoticeLabel);

		eventNoticeLabelCount = new JLabel();
		eventNoticeLabelCount.setFont(font1);
		eventNoticeLabelCount.setBounds(90, -2, 122, 49);
		eventNoticeLabelCount.setVerticalAlignment(JLabel.CENTER);
		eventNoticeLabelCount.setHorizontalAlignment(JLabel.LEFT);
		eventNoticeBtn.add(eventNoticeLabelCount);

		eventTitleLabel = new JLabel();
		eventTitleLabel.setBounds(126, -2, 255, 49);
		eventTitleLabel.setFont(font1);
		eventTitleLabel.setVerticalAlignment(JLabel.CENTER);
		eventTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		eventNoticeBtn.add(eventTitleLabel);

		schButton = new CMButton();
		schButton.setBounds(15, 240, 385, 78);
		schButton.setLayout(null);
		bgPanel.add(schButton);

		schArea = new JTextArea();
		schArea.setBounds(132, 16, 231, 45);
		schArea.setEditable(false);
		schArea.setFont(font1);
		schArea.setOpaque(false);
		schButton.add(schArea);

		JLabel cal = new JLabel("캘린더");
		cal.setFont(font1);
		cal.setHorizontalAlignment(SwingConstants.CENTER);
		cal.setVerticalAlignment(SwingConstants.TOP);
		cal.setBounds(4, 15, 116, 60);
		schButton.add(cal);

		chatButton = new CMButton();
		chatButton.setLayout(null);
		chatButton.setBounds(15, 335, 386, 223);
		bgPanel.add(chatButton);

		JLabel commu = new JLabel("커뮤니티");
		commu.setFont(font1);
		commu.setHorizontalAlignment(SwingConstants.CENTER);
		commu.setVerticalAlignment(SwingConstants.TOP);
		commu.setBounds(4, 15, 116, 60);
		chatButton.add(commu);

		ChatListPanel chatListPanel = new ChatListPanel();
		chatListPanel.setBounds(135, 15, 225, 189);
		chatButton.add(chatListPanel);

		MultiPanel multiPanel = new MultiPanel();
		multiPanel.setBounds(26, 580, 364, 160);
		bgPanel.add(multiPanel);
	}

	class ChatListPanel extends JPanel {
		ChatListPanel() {
			setLayout(new GridLayout(0, 1, 20, 20));
			setOpaque(false);

			chatListBtn = new CMButton[3];
			for (int i = 0; i < chatListBtn.length; i++) {
				chatListBtn[i] = new CMButton();
				chatListBtn[i].setBorder(null);
				chatListBtn[i].setOpaque(false);
				chatListBtn[i].setFont(font1);
				// chatBtn[i].setBackground(Color.BLACK);
				chatListBtn[i].setFocusPainted(false);
				chatListBtn[i].setContentAreaFilled(false);
				chatListBtn[i].setHorizontalAlignment(SwingConstants.LEFT);
				add(chatListBtn[i]);
			}
		}
	}

	class MultiPanel extends JPanel {
		MultiPanel() {
			setLayout(new GridLayout(0, 2));
			setOpaque(false);
			multiMenu = new JLabel[8][2];
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 2; j++) {
					multiMenu[i][j] = new JLabel();
					multiMenu[i][j].setFont(font2);
					multiMenu[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					add(multiMenu[i][j]);
				}
		}
	}

	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel003());
	}

	public void setMultiList(List<AbstractModel> resultList) {
		this.multiList = resultList;
		int zero = 'a';
		multiMenu[0][0].setText("A코스");
		multiMenu[0][0].setFont(new Font("맑은 고딕", Font.BOLD, 11));
		multiMenu[0][1].setText("B코스");
		multiMenu[0][1].setFont(new Font("맑은 고딕", Font.BOLD, 11));
		for (AbstractModel model : multiList) {
			Multi multi = (Multi) model;
			multiMenu[multi.getFTYPE().charAt(0) - zero + 1][multi.getFCOURSE().charAt(0) - zero]
					.setText(multi.getFMENU());
		}
	}

	public void setEventList(List<AbstractModel> eventList) {
		this.eventList = eventList;
		eventNoticeLabelCount.setText(eventList.size() + "");
		eventTitleLabel.setText(((Event) eventList.get(eventList.size())).getEtitle());
	}

	public void setTodaySchList(List<AbstractModel> todaySchList) {
		this.todaySchList = todaySchList;
		schArea.setText("");
		for (int i = 0; i < 3; i++) {
			schArea.append(((Schedule) todaySchList.get(i)).getSch() + "\n");
		}
	}

	public void setChatList(List<AbstractModel> chatList) {
		this.chatList = chatList;
		for (int i = 0; i < chatListBtn.length; i++) {
			chatListBtn[i].setText(((Chat) chatList.get(chatList.size() - i)).getRtitle());
		}
	}
}
