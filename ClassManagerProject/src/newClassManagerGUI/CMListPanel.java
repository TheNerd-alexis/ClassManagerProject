package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CMListPanel extends JPanel {

	CMList panel;
	
	CMListPanel() {
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);
		setBorder(null);
		panel = new CMList();
		JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getViewport().setOpaque(false);
		scroll.getVerticalScrollBar().setOpaque(false);
//		scroll.getVerticalScrollBar().addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//			}
//		});
		scroll.setOpaque(false);
		scroll.setBorder(null);
		add(scroll, BorderLayout.CENTER);
	}
	class CMList extends JPanel{
		CMList(){
//			JPanel panel = new JPanel();
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			setOpaque(false);
			setBorder(null);
		}
	}

	public void addComponent(ClassManagerPanel element) {
		int width = this.getBounds().width - 20;
		int height = (int) ((double) element.getOrgimg().getIconHeight() / (double) element.getOrgimg().getIconWidth()
				* (double) width);
		Dimension size = new Dimension(width, height);
		element.setMaximumSize(size);
		element.setMinimumSize(size);
		element.setPreferredSize(size);
		panel.add(element);
		Component verticalStrut = Box.createVerticalStrut(5);
		panel.add(verticalStrut);
	}

	public void removeComponent(ClassManagerPanel element) {
		element.getParent().remove(element);
	}
	
	public void clearList() {
		panel.removeAll();
	}
}