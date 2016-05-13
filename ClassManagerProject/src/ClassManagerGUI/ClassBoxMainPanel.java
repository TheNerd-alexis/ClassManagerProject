package ClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newClassManagerGUI.CMListPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ClassBoxMainPanel extends JPanel{
	TitlePanel titlePanel;
	CMListPanel classBoxListPanel;
	
	ClassBoxMainPanel(){
		setLayout(new BorderLayout(0, 0));		
		titlePanel = new TitlePanel("CM", "Class Box", "닫기");
		this.add(titlePanel,BorderLayout.NORTH);
		JPanel basePanel = new JPanel();
		basePanel.setBackground(Color.WHITE);
		this.add(basePanel,BorderLayout.CENTER);
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[]{20, 150, 20, 0};
		gbl_basePanel.rowHeights = new int[]{20, 219, 20, 0};
		gbl_basePanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_basePanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		basePanel.setLayout(gbl_basePanel);
		
		classBoxListPanel = new CMListPanel();
		GridBagConstraints gbc_classBoxListPanel = new GridBagConstraints();
		gbc_classBoxListPanel.fill = GridBagConstraints.BOTH;
		gbc_classBoxListPanel.insets = new Insets(0, 0, 5, 5);
		gbc_classBoxListPanel.gridx = 1;
		gbc_classBoxListPanel.gridy = 1;
		basePanel.add(classBoxListPanel, gbc_classBoxListPanel);
	}
	public static void main(String[] args) {
		JFrame temp = new JFrame();
		temp.setSize(400, 750);		
		ClassBoxMainPanel classBoxMainPanel = new ClassBoxMainPanel(); 
		classBoxMainPanel.classBoxListPanel.add(new ClassBoxPanel("오늘 수업끝나고 치맥??"));
		classBoxMainPanel.classBoxListPanel.add(new ClassBoxPanel("19일 임재현 생일"));

		temp.getContentPane().add(classBoxMainPanel, BorderLayout.CENTER);
		
		temp.setVisible(true);
	}
}
