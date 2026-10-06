package layouts.grid;
import java.awt.GridLayout;
import javax.swing.*;

public class GridLayoutExampleOne extends JFrame{
	public GridLayoutExampleOne() {
		// frame size, bounds & titles
		setTitle("GridLayout Example");
		setBounds(100, 150, 350, 450); // x, y, width & height
		setLayout(new GridLayout()); // default grid layout
		
		JButton one = new JButton("Button One");
		JButton two = new JButton("Button Two");
		JButton three = new JButton("Button Three");
		JButton four = new JButton("Button Four");
		
		add(one);
		add(two);
		add(three);
		add(four);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String args[]) {
		new GridLayoutExampleOne();
	}
}
