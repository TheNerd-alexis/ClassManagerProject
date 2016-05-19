package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel017 extends JPanel {
	ImageIcon img = new ImageIcon("img/basic_resize.jpg");
	CMListPanel list;
	
	public Panel017(){
		setLayout(new BorderLayout(0, 0));
		ClassManagerPanel bgPanel = new ClassManagerPanel(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		add(bgPanel,BorderLayout.CENTER);
		list = new CMListPanel();
		list.setBounds(8,122,393,613);
		list.addComponent(new MiniPanel017());
		list.addComponent(new MiniPanel017("오늘 치맥 ㄱㄱ?"));
		bgPanel.add(list,BorderLayout.CENTER);
		
		
	}
	
	class MiniPanel017 extends ClassManagerPanel {
		private JLabel eventContentLbl;
		
		public MiniPanel017(){
			super(new ImageIcon("img/17.jpg"));
			
			ImageIcon hearts = new ImageIcon("img/hearts.png");
			JLabel heart = new JLabel(hearts);
			heart.setBounds(26,17,40,32);
			add(heart);
			JLabel nOfHeart = new JLabel("n");
			nOfHeart.setBounds(22,16,81,34);
			nOfHeart.setHorizontalAlignment(SwingConstants.RIGHT);
			nOfHeart.setVerticalAlignment(SwingConstants.CENTER);
			add(nOfHeart);
			
			ImageIcon lightening = new ImageIcon("img/lightening.png");
			JLabel thunder = new JLabel(lightening);
			thunder.setBounds(108,18,44,33);
			add(thunder);
			JLabel nOfThunder = new JLabel("n");
			nOfThunder.setBounds(110,17,78,34);
			nOfThunder.setHorizontalAlignment(SwingConstants.RIGHT);
			nOfThunder.setVerticalAlignment(SwingConstants.CENTER);
			add(nOfThunder);
			
			CMButton sharing = new CMButton("공유하기");
			sharing.setBounds(280,44,74,31);
			add(sharing);
			
			eventContentLbl = new JLabel();
			eventContentLbl.setBounds(23,86,346,102);
			eventContentLbl.setHorizontalAlignment(SwingConstants.CENTER);
			eventContentLbl.setVerticalAlignment(SwingConstants.CENTER);
			add(eventContentLbl);
			
			CMButton join = new CMButton("참가");
			join.setBounds(225,93,63,24);
			CMButton notJoin = new CMButton("불참");
			notJoin.setBounds(292,92,62,25);
			add(join);
			add(notJoin);
		}
		
		public MiniPanel017(String content){
			this();
			eventContentLbl.setText(content);
		}
	}
	
	public static void main(String[] args) {
		ClassManagerPanel.constructGUI(new Panel017());
	}
}
