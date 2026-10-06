package layouts.border;

import java.awt.BorderLayout;
import javax.swing.*;

public class BorderLayoutExampleOne extends JFrame {
	public BorderLayoutExampleOne() {
		setTitle("Border Layout Example");
		setBounds(100, 150, 350, 450); // x, y, width & height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// border layout without horizontal and vertical gap between components
		JButton north = new JButton("NORTH");
		JButton south = new JButton("SOUTH");
		JButton east = new JButton("EAST");
		JButton west = new JButton("WEST");
		JButton center = new JButton("CENTER");
		// adding button to frame with border layout
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
	
		setVisible(true);
	}
	public static void main(String args[]) {
		new BorderLayoutExampleOne();
	}
}
