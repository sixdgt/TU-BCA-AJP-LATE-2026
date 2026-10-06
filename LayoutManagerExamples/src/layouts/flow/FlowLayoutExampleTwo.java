package layouts.flow;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

public class FlowLayoutExampleTwo {
	public FlowLayoutExampleTwo() {
		JFrame frame = new JFrame();
		frame.setTitle("Flow Layout Example");
		frame.setBounds(100, 150, 500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.DARK_GRAY);
		frame.setForeground(Color.WHITE);
		
		// setting layouts i.e. FlowLayout: Alignment Left & horizontal gap 10, vertical gap 12
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 12));
		
		JLabel title = new JLabel("Flow Layout Example");
		frame.add(title);
		
		JTextField message = new JTextField();
		frame.add(message);
		
		JButton send = new JButton("Send Message");
		frame.add(send);
		
		JLabel subtitle = new JLabel("BCA Sixth Semester");
		frame.add(subtitle);
		
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		new FlowLayoutExampleTwo();
	}
}
