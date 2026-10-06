package layouts.border;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExampleTwo extends JFrame{
	public BorderLayoutExampleTwo() {
		setTitle("Border Layout Example");
		setBounds(100, 150, 350, 450); // x, y, width & height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton north = new JButton("NORTH");
		JButton south = new JButton("SOUTH");
		JButton east = new JButton("EAST");
		JButton west = new JButton("WEST");
		JButton center = new JButton("CENTER");
		// setting border layout with horizontal & vertical gap
		setLayout(new BorderLayout(10, 12)); // hgap & vgap
		// adding button to frame with border layout
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
	
		setVisible(true);
	}
	public static void main(String args[]) {
		new BorderLayoutExampleTwo();
	}
}
