package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import newClassManagerGUI.Panel017.MiniPanel017;

public class Panel018 extends JPanel {
		ImageIcon img = new ImageIcon("img/pw_resize.jpg");
		private CMTextField idField;
		private CMTextField qField;
		private CMTextField aField;
		public CMButton checkBtn;
		private Font defaultFont = new Font("맑은 고딕", Font.PLAIN, 15);
		ObjectOutputStream writer;
		
		public Panel018(){
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
				
				JLabel heart = new JLabel("n");
				heart.setBounds(22,16,81,34);
				heart.setHorizontalAlignment(SwingConstants.RIGHT);
				heart.setVerticalAlignment(SwingConstants.CENTER);
				add(heart);
						
				JLabel thunder = new JLabel("n");
				thunder.setBounds(110,17,78,34);
				thunder.setHorizontalAlignment(SwingConstants.RIGHT);
				thunder.setVerticalAlignment(SwingConstants.CENTER);
				add(thunder);
				
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
			ClassManagerPanel.constructGUI(new Panel018());
		}
}