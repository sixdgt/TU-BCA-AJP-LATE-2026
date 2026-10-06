package layouts.box;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoxLayoutExampleOne extends JFrame{
	public BoxLayoutExampleOne() {
		setTitle("Box Layout Example");
		setBounds(100, 150, 350, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		// setting box layout X axis
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		// initializing swing components and adding them to panel
		JLabel lbl_message = new JLabel("Enter message");
		panel.add(lbl_message);
		
		JTextField txt_message = new JTextField();
		panel.add(txt_message);
		
		JButton send = new JButton("Send Message");
		panel.add(send);
		// adding panel to frame
		add(panel);
		setVisible(true);
	}
	public static void main(String args[]) {
		new BoxLayoutExampleOne();
	}
}
