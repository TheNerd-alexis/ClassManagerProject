package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ClassBoxPanel extends JPanel {
	String[] event = { "커뮤니티", "캘린더", "공지" };
	Color gray = new Color(108, 108, 108);
	Color yellow = new Color(255, 254, 239);
	int count = 0;// Test용! 원래는 서버에서 처리해야 되는 count: get .. set ..써서 값 받아와야 함
	JLabel nOfHeart;
	JLabel nOfThunder;
	Boolean isChecked = false;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	ClassBoxPanel(String eventContent) {
		setPreferredSize(new Dimension(400, 100));
		setMaximumSize(new Dimension(400, 150));	
		
		setBackground(yellow);
		setBorder(new LineBorder(gray, 1, true));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(400, 20));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(gray));
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		ImageIcon hearts = new ImageIcon("img/hearts.png");
		JLabel heart = new JLabel(hearts);
		//heart.setPreferredSize(new Dimension(10,10));
		heart.setBackground(yellow);
		panel_2.add(heart);

		nOfHeart = new JLabel("n");
		nOfHeart.setFont(new Font("굴림", Font.BOLD, 12));
		panel_2.add(nOfHeart);
		nOfHeart.setForeground(gray);
		nOfHeart.setBackground(yellow);
		nOfHeart.setBorder(null);

		ImageIcon lightening = new ImageIcon("img/lightening.png");
		JLabel thunder = new JLabel(lightening);
//		thunder.setPreferredSize(new Dimension(10,10));
		thunder.setBackground(yellow);
		panel_2.add(thunder);

		nOfThunder = new JLabel("n");
		nOfThunder.setFont(new Font("굴림", Font.BOLD, 12));
		panel_2.add(nOfThunder);
		nOfThunder.setForeground(gray);
		nOfThunder.setBackground(yellow);
		nOfThunder.setBorder(null);

		Component horizontalGlue = Box.createHorizontalGlue();
		panel_2.add(horizontalGlue);

		JButton sharing = new JButton("공유하기");
		sharing.setForeground(gray);
		sharing.setBackground(yellow);
		panel_2.add(sharing);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(yellow);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_3);

		JButton in = new JButton("참가");
		in.setForeground(gray);
		in.setBackground(yellow);
		panel_3.add(in);

		JButton out = new JButton("불참");
		out.setForeground(gray);
		out.setBackground(yellow);
		panel_3.add(out);
		
		in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Client Count임				
				if (isChecked == false) { //
					++count;
					nOfHeart.setText(String.valueOf(count));
					isChecked = true;
				} else {
					
					JOptionPane.showMessageDialog(null, "이미 눌렀습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Client Count임
				if (isChecked == false) { //
					++count;
					nOfThunder.setText(String.valueOf(count));
					isChecked = true;
				} else {
					JOptionPane.showMessageDialog(null, "이미 눌렀습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JLabel content = new JLabel(eventContent);
		content.setMaximumSize(new Dimension(400, 60));
		content.setForeground(gray);
		content.setFont(new Font("굴림", Font.BOLD, 20));
		add(content);
	}
}
