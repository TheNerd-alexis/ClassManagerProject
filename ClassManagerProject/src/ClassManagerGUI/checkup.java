package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class checkup extends JPanel{
	
	TitlePanel titlepanel= new TitlePanel("CM", "", "출석체크");
	
	private JPanel tpanel;
	private JPanel climatepanel;
	private JPanel climateiconpanel;
	private JPanel degreeiconpanel;
	private JPanel eventpanel;
	private JPanel eventcont;
	private JPanel calendarpan;
	private JPanel comcon;
	private JPanel comupan;
	private JPanel panel;
	private JPanel roompanel2;
	private JPanel evntrpan2;
	
	private JLabel evntlable;
	private JLabel roomlable;
	private JLabel comlable;

	
	
	private Color bgColor = new Color(255, 254, 239);
	private Color fontColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	private Color whiteColor = new Color(239,239,239);
	

	public checkup(){
		
		setBackground(bgColor);
		setSize(400-10, 750-10);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{183, 0};
		gridBagLayout.rowHeights = new int[]{43, 121, 67, 84, 194, 224, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		tpanel = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		add(tpanel, gbc_panel_6);
		tpanel.setLayout(new BorderLayout(0, 0));
		tpanel.add(titlepanel);
		tpanel.setBackground(bgColor);
		
		climatepanel = new JPanel();
		GridBagConstraints gbc_climatepanel = new GridBagConstraints();
		gbc_climatepanel.insets = new Insets(0, 0, 5, 0);
		gbc_climatepanel.fill = GridBagConstraints.BOTH;
		gbc_climatepanel.gridx = 0;
		gbc_climatepanel.gridy = 1;
		add(climatepanel, gbc_climatepanel);
		GridBagLayout gbl_climatepanel = new GridBagLayout();
		gbl_climatepanel.columnWidths = new int[]{217, 0, 0};
		gbl_climatepanel.rowHeights = new int[]{0, 0};
		gbl_climatepanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_climatepanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		climatepanel.setLayout(gbl_climatepanel);
		climatepanel.setBackground(bgColor);
		
		climateiconpanel = new JPanel();
		climateiconpanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagConstraints gbc_climateiconpanel = new GridBagConstraints();
		gbc_climateiconpanel.insets = new Insets(0, 0, 0, 5);
		gbc_climateiconpanel.fill = GridBagConstraints.BOTH;
		gbc_climateiconpanel.gridx = 0;
		gbc_climateiconpanel.gridy = 0;
		climatepanel.add(climateiconpanel, gbc_climateiconpanel);
		climateiconpanel.setLayout(new GridLayout(1, 0, 0, 0));
		climateiconpanel.setBackground(bgColor);
		
		degreeiconpanel = new JPanel();
		GridBagConstraints gbc_degreeiconpanel = new GridBagConstraints();
		gbc_degreeiconpanel.fill = GridBagConstraints.BOTH;
		gbc_degreeiconpanel.gridx = 1;
		gbc_degreeiconpanel.gridy = 0;
		climatepanel.add(degreeiconpanel, gbc_degreeiconpanel);
		degreeiconpanel.setBackground(bgColor);
		
		eventpanel = new JPanel();
		GridBagConstraints gbc_eventpanel = new GridBagConstraints();
		gbc_eventpanel.insets = new Insets(0, 0, 5, 0);
		gbc_eventpanel.fill = GridBagConstraints.BOTH;
		gbc_eventpanel.gridx = 0;
		gbc_eventpanel.gridy = 2;
		add(eventpanel, gbc_eventpanel);
		GridBagLayout gbl_eventpanel = new GridBagLayout();
		gbl_eventpanel.columnWidths = new int[]{135, 244, 0};
		gbl_eventpanel.rowHeights = new int[]{77, 0};
		gbl_eventpanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_eventpanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		eventpanel.setLayout(gbl_eventpanel);
		eventpanel.setBackground(bgColor);
		
		evntlable = new JLabel("이벤트알람");
		GridBagConstraints gbc_evntlable = new GridBagConstraints();
		gbc_evntlable.insets = new Insets(0, 0, 0, 5);
		gbc_evntlable.gridx = 0;
		gbc_evntlable.gridy = 0;
		eventpanel.add(evntlable, gbc_evntlable);
		
		eventcont = new JPanel();
		GridBagConstraints gbc_eventcont = new GridBagConstraints();
		gbc_eventcont.fill = GridBagConstraints.BOTH;
		gbc_eventcont.gridx = 1;
		gbc_eventcont.gridy = 0;
		eventpanel.add(eventcont, gbc_eventcont);
		eventcont.setBackground(bgColor);
		
		calendarpan = new JPanel();
		GridBagConstraints gbc_calendarpan = new GridBagConstraints();
		gbc_calendarpan.insets = new Insets(0, 0, 5, 0);
		gbc_calendarpan.fill = GridBagConstraints.BOTH;
		gbc_calendarpan.gridx = 0;
		gbc_calendarpan.gridy = 3;
		add(calendarpan, gbc_calendarpan);
		GridBagLayout gbl_calendarpan = new GridBagLayout();
		gbl_calendarpan.columnWidths = new int[]{137, 0, 0};
		gbl_calendarpan.rowHeights = new int[]{0, 0};
		gbl_calendarpan.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_calendarpan.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		calendarpan.setLayout(gbl_calendarpan);
		calendarpan.setBackground(bgColor);
		
		comlable = new JLabel("커뮤니티");
		GridBagConstraints gbc_comlable = new GridBagConstraints();
		gbc_comlable.insets = new Insets(0, 0, 0, 5);
		gbc_comlable.gridx = 0;
		gbc_comlable.gridy = 0;
		calendarpan.add(comlable, gbc_comlable);
		
		comcon = new JPanel();
		GridBagConstraints gbc_comcon = new GridBagConstraints();
		gbc_comcon.fill = GridBagConstraints.BOTH;
		gbc_comcon.gridx = 1;
		gbc_comcon.gridy = 0;
		calendarpan.add(comcon, gbc_comcon);
		comcon.setBackground(bgColor);
		
		comupan = new JPanel();
		GridBagConstraints gbc_comupan = new GridBagConstraints();
		gbc_comupan.insets = new Insets(0, 0, 5, 0);
		gbc_comupan.fill = GridBagConstraints.BOTH;
		gbc_comupan.gridx = 0;
		gbc_comupan.gridy = 4;
		add(comupan, gbc_comupan);
		GridBagLayout gbl_comupan = new GridBagLayout();
		gbl_comupan.columnWidths = new int[]{138, 0, 0};
		gbl_comupan.rowHeights = new int[]{0, 0, 0, 0};
		gbl_comupan.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_comupan.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		comupan.setLayout(gbl_comupan);
		comupan.setBackground(bgColor);
		
		roomlable = new JLabel("커뮤니티");
		GridBagConstraints gbc_roomlable = new GridBagConstraints();
		gbc_roomlable.insets = new Insets(0, 0, 5, 5);
		gbc_roomlable.gridx = 0;
		gbc_roomlable.gridy = 0;
		comupan.add(roomlable, gbc_roomlable);
		
		roompanel2 = new JPanel();
		GridBagConstraints gbc_roompanel2 = new GridBagConstraints();
		gbc_roompanel2.insets = new Insets(0, 0, 5, 0);
		gbc_roompanel2.fill = GridBagConstraints.BOTH;
		gbc_roompanel2.gridx = 1;
		gbc_roompanel2.gridy = 0;
		comupan.add(roompanel2, gbc_roompanel2);
		roompanel2.setLayout(new BorderLayout(0, 0));
		
		JButton frstroom = new MyButton("채팅방이름");
		roompanel2.add(frstroom);
		
		evntrpan2 = new JPanel();
		GridBagConstraints gbc_evntrpan2 = new GridBagConstraints();
		gbc_evntrpan2.insets = new Insets(0, 0, 5, 0);
		gbc_evntrpan2.fill = GridBagConstraints.BOTH;
		gbc_evntrpan2.gridx = 1;
		gbc_evntrpan2.gridy = 1;
		comupan.add(evntrpan2, gbc_evntrpan2);
		evntrpan2.setLayout(new BorderLayout(0, 0));
		
		JButton scndroom = new MyButton("채팅방이름");
		evntrpan2.add(scndroom);
		
		JPanel addroompanel = new JPanel();
		GridBagConstraints gbc_addroompanel = new GridBagConstraints();
		gbc_addroompanel.fill = GridBagConstraints.BOTH;
		gbc_addroompanel.gridx = 1;
		gbc_addroompanel.gridy = 2;
		comupan.add(addroompanel, gbc_addroompanel);
		addroompanel.setLayout(new BorderLayout(0, 0));
		
		JButton addroombutton = new MyButton("+새로운 채팅방 개설");
		addroompanel.add(addroombutton);
		
		JPanel lunpan = new JPanel();
		GridBagConstraints gbc_lunpan = new GridBagConstraints();
		gbc_lunpan.insets = new Insets(0, 0, 5, 0);
		gbc_lunpan.fill = GridBagConstraints.BOTH;
		gbc_lunpan.gridx = 0;
		gbc_lunpan.gridy = 5;
		add(lunpan, gbc_lunpan);
		GridBagLayout gbl_lunpan = new GridBagLayout();
		gbl_lunpan.columnWidths = new int[]{163, 218, 0};
		gbl_lunpan.rowHeights = new int[]{0, 188, 0};
		gbl_lunpan.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_lunpan.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		lunpan.setLayout(gbl_lunpan);
		
		JLabel menulable = new JLabel("오늘의 점심");
		menulable.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_menulable = new GridBagConstraints();
		gbc_menulable.gridwidth = 2;
		gbc_menulable.insets = new Insets(0, 0, 5, 0);
		gbc_menulable.gridx = 0;
		gbc_menulable.gridy = 0;
		lunpan.add(menulable, gbc_menulable);
		
		JPanel menupan = new JPanel();
		GridBagConstraints gbc_menupan = new GridBagConstraints();
		gbc_menupan.gridwidth = 2;
		gbc_menupan.insets = new Insets(0, 0, 0, 5);
		gbc_menupan.fill = GridBagConstraints.BOTH;
		gbc_menupan.gridx = 0;
		gbc_menupan.gridy = 1;
		lunpan.add(menupan, gbc_menupan);
		GridBagLayout gbl_menupan = new GridBagLayout();
		gbl_menupan.columnWidths = new int[]{382, 0};
		gbl_menupan.rowHeights = new int[]{201, 0};
		gbl_menupan.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_menupan.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		menupan.setLayout(gbl_menupan);
		
		JButton menubutton = new MyButton("멀티캠퍼스 메뉴");
		GridBagConstraints gbc_menubutton = new GridBagConstraints();
		gbc_menubutton.fill = GridBagConstraints.BOTH;
		gbc_menubutton.gridx = 0;
		gbc_menubutton.gridy = 0;
		menupan.add(menubutton, gbc_menubutton);
		
		
		
	}
	
	public static void main(String[] args) {
	JFrame temp = new JFrame();
	temp.getContentPane().add(new checkup());
	temp.setVisible(true);
	}
	

}
