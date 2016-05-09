package ClassManagerGUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

public class JListForm<T> extends JList<T> {
	static DefaultListModel model= new DefaultListModel();
	
	public JListForm() {
		super(model);
		super.setCellRenderer(new ListCellRenderer<T>(){
			@Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        JPanel renderer = (JPanel) value;
		        return renderer;
		    }
		});
	}
	
	public void addComponent(T element){
		model.addElement(element);
	}
}

class EventPanel extends JPanel {
	String[] event = { "커뮤니티", "캘린더", "공지" };

	EventPanel(int eventType, String eventContent) {
		setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblType = new JLabel(event[eventType]);
		lblType.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(lblType);
		JLabel lblContent = new JLabel(eventContent);
		add(lblContent);
	}
}