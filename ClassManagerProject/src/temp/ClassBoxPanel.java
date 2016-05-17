package temp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ClassBoxPanel extends JPanel {
	String[] event = { "커뮤니티", "캘린더", "공지" };

	ClassBoxPanel(String eventContent) {
		setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 6, 34, 26, 10, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 17, 27, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton heart = new JButton("하트");
		GridBagConstraints gbc_heart = new GridBagConstraints();
		gbc_heart.fill = GridBagConstraints.HORIZONTAL;
		gbc_heart.insets = new Insets(0, 0, 5, 5);
		gbc_heart.gridx = 0;
		gbc_heart.gridy = 0;
		add(heart, gbc_heart);

		JLabel nOfHeart = new JLabel("New label");
		GridBagConstraints gbc_nOfHeart = new GridBagConstraints();
		gbc_nOfHeart.insets = new Insets(0, 0, 5, 5);
		gbc_nOfHeart.gridx = 1;
		gbc_nOfHeart.gridy = 0;
		add(nOfHeart, gbc_nOfHeart);

		JButton thunder = new JButton("번개");
		GridBagConstraints gbc_thunder = new GridBagConstraints();
		gbc_thunder.insets = new Insets(0, 0, 5, 5);
		gbc_thunder.gridx = 2;
		gbc_thunder.gridy = 0;
		add(thunder, gbc_thunder);

		JLabel nOfThunder = new JLabel("New label");
		GridBagConstraints gbc_nOfThunder = new GridBagConstraints();
		gbc_nOfThunder.insets = new Insets(0, 0, 5, 5);
		gbc_nOfThunder.gridx = 3;
		gbc_nOfThunder.gridy = 0;
		add(nOfThunder, gbc_nOfThunder);

		JButton sharing = new JButton("공유하기");
		GridBagConstraints gbc_sharing = new GridBagConstraints();
		gbc_sharing.insets = new Insets(0, 0, 5, 0);
		gbc_sharing.gridx = 6;
		gbc_sharing.gridy = 0;
		add(sharing, gbc_sharing);

		JButton in = new JButton("참가");
		in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;//Client Count임
				// 서버에서 처리해야 되는 것: get .. set ..
				// int count = 0; 지역변수이므로 선언X
				// count++;;
				if (count == 0) { //
					nOfHeart.setText( String.valueOf(count) );
					count++;
				} else {
					JOptionPane.showMessageDialog(null, "이미 눌렀습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		GridBagConstraints gbc_in = new GridBagConstraints();
		gbc_in.anchor = GridBagConstraints.EAST;
		gbc_in.insets = new Insets(0, 0, 5, 5);
		gbc_in.gridx = 5;
		gbc_in.gridy = 1;
		add(in, gbc_in);

		JButton out = new JButton("불참");
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;//Client Count임
				// 서버에서 처리해야 되는 것: get .. set ..
				// int count = 0; 지역변수이므로 선언X
				// count++;;
				if (count == 0) { //
					nOfThunder.setText( String.valueOf(count) );
					count++;
				} else {
					JOptionPane.showMessageDialog(null, "이미 눌렀습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_out = new GridBagConstraints();
		gbc_out.anchor = GridBagConstraints.EAST;
		gbc_out.insets = new Insets(0, 0, 5, 0);
		gbc_out.gridx = 6;
		gbc_out.gridy = 1;
		add(out, gbc_out);
				
						JLabel content = new JLabel(eventContent);
						content.setFont(new Font("굴림", Font.PLAIN, 15));
						GridBagConstraints gbc_content = new GridBagConstraints();
						gbc_content.gridheight = 3;
						gbc_content.gridwidth = 4;
						gbc_content.insets = new Insets(0, 0, 5, 5);
						gbc_content.gridx = 1;
						gbc_content.gridy = 3;
						add(content, gbc_content);
	}
	
	public static void main(String[] args) {
		JFrame temp = new JFrame();
//		ClassBoxListPanel classBoxListPanel = new ClassBoxListPanel ();
//		classBoxListPanel.classBoxList.addComponent(new ClassBoxPanel("집에 가고 싶다"));
		ClassBoxPanel classBoxListPanel = new ClassBoxPanel("집에 가고 싶다");
		temp.getContentPane().add(classBoxListPanel);
		
		temp.setVisible(true);
	}
}

class ClassBoxListPanel extends JPanel {
	CMListPanel<ClassBoxPanel> classBoxList;
	ClassBoxListPanel() {
		setLayout(new BorderLayout(0, 0));
		TitlePanel titlePanel = new TitlePanel("CM","이벤트알림","닫기");
		add(titlePanel,BorderLayout.NORTH);//1. title panel 들어감
		classBoxList = new CMListPanel<ClassBoxPanel>();//<T>가 <EventPanel>로 -> EventPanel 배열이 들어가는 폼
		add(classBoxList);//2. eventPanel 배열 폼 들어감
	}

}

