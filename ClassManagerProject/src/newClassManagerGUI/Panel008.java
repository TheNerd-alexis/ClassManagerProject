package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import Model.AbstractModel;
import Model.Chat;

public class Panel008 extends JPanel {
	private static final long serialVersionUID = 1L;

	ImageIcon img = new ImageIcon("img/008_resize.jpg");
	
	private CMTextField jointxt;
	private CMTextField searchtxt;
	private CMButton joinBtn;
	private CMButton searchBtn;
	private CMListPanel listPanel;
	private CMTextField nametxt;
	private JCheckBox check;
	ObjectOutputStream writer;

	public TitlePanel title;
	List<AbstractModel> listFriend;

	public Panel008(ObjectOutputStream writer) {
		this.writer = writer;
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(), img.getIconHeight());
		add(bgPanel, BorderLayout.CENTER);

		title = new TitlePanel("CM", "채팅방 개설", "닫기");

		title.setBounds(0, 0, this.getBounds().width + 10, 40);
		bgPanel.add(title);

		listPanel = new CMListPanel();
		jointxt = new CMTextField("개설할 채팅방 제목 입력");
		searchtxt = new CMTextField("추가할 사람의 아이디 입력");
		joinBtn = new CMButton("개설");
		searchBtn = new CMButton();
		searchBtn.setIcon(new ImageIcon(
				new ImageIcon("img/searchIcon.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
		check = new JCheckBox();

		jointxt.setBounds(48, 67, 245, 29);
		searchtxt.setBounds(47, 133, 250, 29);
		bgPanel.add(jointxt);
		bgPanel.add(searchtxt);

		joinBtn.setBounds(313, 64, 56, 31);
		bgPanel.add(joinBtn);
		searchBtn.setBounds(313, 133, 49, 26);
		bgPanel.add(searchBtn);

		listPanel.setBounds(48, 178, 313, 54);
		bgPanel.add(listPanel);

		addListener();
	}

	public void addListener() {
		jointxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().equals("개설할 채팅방 제목 입력") || source.getForeground().equals(Color.RED)) {
					source.setText("");
					source.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().isEmpty()) {
					source.setText("개설할 채팅방 제목 입력");
				}
			}
		});
		searchtxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().equals("추가할 사람의 아이디 입력") || source.getForeground().equals(Color.RED)) {
					source.setText("");
					source.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				CMTextField source = (CMTextField) e.getSource();
				if (source.getText().isEmpty()) {
					source.setText("추가할 사람의 아이디 입력");
				}
			}
		});

		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (jointxt.getText().equals("개설할 채팅방 제목 입력") || jointxt.getForeground().equals(Color.RED))
					return;
				
					Chat chat = new Chat();
					chat.setRtitle(jointxt.getText());
			}
		});
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel008(null));
	}
}
