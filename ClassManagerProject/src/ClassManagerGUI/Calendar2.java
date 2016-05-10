package Gui;
//page13

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.CardLayout;


public class Calendar2 extends JFrame{

		
	
	private Color bgColor = new Color(255, 254, 239);
	private Color fontColor = new Color(108, 108, 108);
	private Color borderColor = new Color(234,232,222);
	private Color whiteColor = new Color(239,239,239);
	
	
	private JPanel setting;
	private JPanel title;
	private JTextField memotitle;
	private JPanel setime;
	private JLabel plan;
	private JButton calendar;
	private JButton time;
	private JPanel invitation;
	private JLabel invite;
	private JButton inviteind;
	private JPanel memo;
	private JLabel addmemo;
	private JButton addingmemo;
	private JTextArea contents;
	
	
	
	Calendar2(){
		
		setBackground(bgColor);
		setSize(400, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("캘린더2");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{381, 0};
		gridBagLayout.rowHeights = new int[]{170, 482, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		setting = new JPanel();
		GridBagConstraints gbc_setting = new GridBagConstraints();
		gbc_setting.insets = new Insets(0, 0, 5, 0);
		gbc_setting.fill = GridBagConstraints.HORIZONTAL;
		gbc_setting.gridx = 0;
		gbc_setting.gridy = 0;
		setting.setBackground(bgColor);
		getContentPane().add(setting, gbc_setting);
		GridBagLayout gbl_setting = new GridBagLayout();
		gbl_setting.columnWidths = new int[]{400, 0};
		gbl_setting.rowHeights = new int[]{45, 48, 25, 0};
		gbl_setting.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_setting.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setting.setLayout(gbl_setting);
		
		title = new JPanel();
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.fill = GridBagConstraints.BOTH;
		gbc_title.insets = new Insets(0, 0, 5, 0);
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		setting.add(title, gbc_title);
		title.setBackground(bgColor);
		GridBagLayout gbl_title = new GridBagLayout();
		gbl_title.columnWidths = new int[]{400, 0};
		gbl_title.rowHeights = new int[]{42, 0};
		gbl_title.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_title.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		title.setLayout(gbl_title);
		
		memotitle = new JTextField();
		memotitle.setFont(new Font("굴림", Font.BOLD, 15));
		memotitle.setText(" 재목입력");
		GridBagConstraints gbc_memotitle = new GridBagConstraints();
		gbc_memotitle.fill = GridBagConstraints.BOTH;
		gbc_memotitle.gridx = 0;
		gbc_memotitle.gridy = 0;
		title.add(memotitle, gbc_memotitle);
		memotitle.setColumns(10);
		memotitle.setBackground(bgColor);
		
		setime = new JPanel();
		GridBagConstraints gbc_setime = new GridBagConstraints();
		gbc_setime.fill = GridBagConstraints.BOTH;
		gbc_setime.insets = new Insets(0, 0, 5, 0);
		gbc_setime.gridx = 0;
		gbc_setime.gridy = 1;
		setting.add(setime, gbc_setime);
		GridBagLayout gbl_setime = new GridBagLayout();
		gbl_setime.columnWidths = new int[]{130, 124, 127, 0};
		gbl_setime.rowHeights = new int[]{39, 0};
		gbl_setime.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_setime.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setime.setLayout(gbl_setime);
		setime.setBackground(bgColor);
		
		plan = new JLabel("       예약시간");
		plan.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints gbc_plan = new GridBagConstraints();
		gbc_plan.insets = new Insets(0, 0, 0, 5);
		gbc_plan.fill = GridBagConstraints.BOTH;
		gbc_plan.gridx = 0;
		gbc_plan.gridy = 0;
		setime.add(plan, gbc_plan);
		plan.setBackground(bgColor);
		
		
		calendar = new MyButton("date");
		calendar.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.insets = new Insets(0, 0, 0, 5);
		gbc_calendar.gridx = 1;
		gbc_calendar.gridy = 0;
		setime.add(calendar, gbc_calendar);
		
		
		time = new MyButton("time");
		time.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints gbc_time = new GridBagConstraints();
		gbc_time.fill = GridBagConstraints.BOTH;
		gbc_time.gridx = 2;
		gbc_time.gridy = 0;
		setime.add(time, gbc_time);
		
		invitation = new JPanel();
		GridBagConstraints gbc_invitation = new GridBagConstraints();
		gbc_invitation.fill = GridBagConstraints.BOTH;
		gbc_invitation.gridx = 0;
		gbc_invitation.gridy = 2;
		setting.add(invitation, gbc_invitation);
		GridBagLayout gbl_invitation = new GridBagLayout();
		gbl_invitation.columnWidths = new int[]{288, 85, 0};
		gbl_invitation.rowHeights = new int[]{46, 0};
		gbl_invitation.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_invitation.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		invitation.setLayout(gbl_invitation);
		invitation.setBackground(bgColor);
		
		
		invite = new JLabel("       초대받은사람");
		invite.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints gbc_invite = new GridBagConstraints();
		gbc_invite.insets = new Insets(0, 0, 0, 5);
		gbc_invite.fill = GridBagConstraints.BOTH;
		gbc_invite.gridx = 0;
		gbc_invite.gridy = 0;
		invitation.add(invite, gbc_invite);
		invite.setBackground(bgColor);
		
		inviteind = new MyButton("New button");
		inviteind.setFont(new Font("굴림", Font.PLAIN, 12));
		inviteind.setText("추가+");
		GridBagConstraints gbc_inviteind = new GridBagConstraints();
		gbc_inviteind.fill = GridBagConstraints.BOTH;
		gbc_inviteind.gridx = 1;
		gbc_inviteind.gridy = 0;
		invitation.add(inviteind, gbc_inviteind);
		
		memo = new JPanel();
		GridBagConstraints gbc_memo = new GridBagConstraints();
		gbc_memo.fill = GridBagConstraints.BOTH;
		gbc_memo.gridx = 0;
		gbc_memo.gridy = 1;
		getContentPane().add(memo, gbc_memo);
		GridBagLayout gbl_memo = new GridBagLayout();
		gbl_memo.columnWidths = new int[]{314, 68, 0};
		gbl_memo.rowHeights = new int[]{33, 502, 0};
		gbl_memo.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_memo.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		memo.setLayout(gbl_memo);
		memo.setBackground(bgColor);
		
		addmemo = new JLabel("     메모작성");
		addmemo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_addmemo = new GridBagConstraints();
		gbc_addmemo.fill = GridBagConstraints.BOTH;
		gbc_addmemo.insets = new Insets(0, 0, 5, 5);
		gbc_addmemo.gridx = 0;
		gbc_addmemo.gridy = 0;
		memo.add(addmemo, gbc_addmemo);
		addmemo.setBackground(bgColor);
		
		addingmemo = new MyButton("추가+");
		GridBagConstraints gbc_addingmemo = new GridBagConstraints();
		gbc_addingmemo.fill = GridBagConstraints.BOTH;
		gbc_addingmemo.insets = new Insets(0, 0, 5, 0);
		gbc_addingmemo.gridx = 1;
		gbc_addingmemo.gridy = 0;
		memo.add(addingmemo, gbc_addingmemo);
		
		
		contents = new JTextArea();
		GridBagConstraints gbc_contents = new GridBagConstraints();
		gbc_contents.gridwidth = 2;
		gbc_contents.fill = GridBagConstraints.BOTH;
		gbc_contents.gridx = 0;
		gbc_contents.gridy = 1;
		memo.add(contents, gbc_contents);
		contents.setBackground(bgColor);
		
	}
	public static void main(String[] args) {
		new Calendar2();
	}
}
	
