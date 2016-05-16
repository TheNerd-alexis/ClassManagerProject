package temp;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Panel006 extends JPanel {
//	ImageIcon listImg = new ImageIcon("img/6-1.jpg"); // in // need list img
	
	CMTextField searchTextField; // out
	JPanel resultFriendPanel; // out
	
	
	CMListPanel listPanel;
	

	public Panel006() {
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel( new ImageIcon("img/006_resize.jpg") );
		add(bgPanel, BorderLayout.CENTER);
		
		searchTextField = new CMTextField("이름, 아이디 검색");
		searchTextField.setBounds(38,49,322,36);
		searchTextField.setHorizontalAlignment(JTextField.LEFT);
		bgPanel.add(searchTextField);
		
		
//		resultFriendPanel = new JPanel();
//		resultFriendPanel.setBounds(44,120,317,587);
//		resultFriendPanel.setLayout(null);
//		bgPanel.add(resultFriendPanel);
		
		
		listPanel = new CMListPanel();
		listPanel.setBounds(31,118,340,587);
		
		
		listPanel.addComponent(new miniPanel006("김현우 천재"));
		listPanel.addComponent(new miniPanel006("김진호 빈수레"));	
				
		bgPanel.add(listPanel);
		
//		listPanel = new ClassManagerPanel(listImg);
//		listPanel.setBounds(20,118,359,65);
//		bgPanel.add(listPanel);			
	}
	
	class miniPanel006 extends ClassManagerPanel{
		JLabel nameLabel;
		JCheckBox checkBox;
		public miniPanel006(){
			super(new ImageIcon("img/CheckBoxList.jpg"));
			nameLabel = new JLabel();
			nameLabel.setBounds(1,0,337,57);
			add(nameLabel);
			
			checkBox = new JCheckBox();
			checkBox.setBounds(302,16,23,21);
			add(checkBox);
		}
		public miniPanel006(String name){
			this();
			nameLabel.setText(name);
		}
		
		public JLabel getJLabelByBox(){
			if(checkBox.isSelected()){
				return nameLabel;
			}else{
				return null;
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel006());
	}
}
