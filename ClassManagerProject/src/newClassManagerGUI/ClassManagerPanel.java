package newClassManagerGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassManagerPanel extends JPanel {

	private ImageIcon orgimg;
	public ImageIcon img;

	public ClassManagerPanel(ImageIcon img) {
		addMouseListener(new MouseAdapter() {
			int x1;
			int y1;
			int x2;
			int y2;

			@Override
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();

				int[] bounds = new int[4];
				bounds[0] = x1 < x2 ? x1 : x2;
				bounds[1] = y1 < y2 ? y1 : y2;
				bounds[2] = Math.abs(x1 - x2);
				bounds[3] = Math.abs(y1 - y2);

				System.out.printf("setBounds(%d,%d,%d,%d)\n",bounds[0],bounds[1],bounds[2],bounds[3]);
			}

		});
		this.orgimg = img;
		this.img = img;
		Dimension imgsize = new Dimension(img.getIconWidth(), img.getIconHeight());
		this.setLayout(null);
		this.setPreferredSize(imgsize);
		this.setMinimumSize(imgsize);
		this.setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		arg0.drawImage(img.getImage(), 0, 0, null);
		super.paintComponent(arg0);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		Image resultImg = orgimg.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(resultImg); //Image로 ImageIcon 생성
		super.setBounds(x, y, width, height);
		repaint();
	}

	public static void constructGUI(JPanel bgPanel) {
        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        bgPanel.setPreferredSize(new Dimension(400, 750));
        frame.add(bgPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
	
	public static void main(String[] args) {
		ImageIcon img = new ImageIcon("img/001_resize.jpg");
		ClassManagerPanel test = new ClassManagerPanel(img);
		test.setBounds(0,0,300,500);
		ClassManagerPanel.constructGUI(test); 
	}
}
