package nam;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

public class NameCheckPanel extends JPanel{
	private Color borderColor = new Color(234,232,222);
	private Color background = new Color(255, 254, 239);
	private Color foreground = new Color(108, 108, 108);
	
	NameCheckPanel(String name){
		setMaximumSize(new Dimension(400, 50));
		setBorder(new LineBorder(borderColor, 1, true));
		setBackground(background);
		setForeground(foreground);
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameLabel.setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		add(nameLabel, BorderLayout.CENTER);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(5, 0));
		add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 5));
		add(verticalStrut, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		JCheckBox checkBox = new JCheckBox();
		panel.add(checkBox);
		checkBox.setOpaque(false);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(5, 0));
		horizontalStrut_1.setMinimumSize(new Dimension(5, 0));
		panel.add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 5));
		add(verticalStrut_1, BorderLayout.SOUTH);
	}
}