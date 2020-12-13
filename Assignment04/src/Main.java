import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;
// View

public class Main extends JFrame {
	
	public Main() {
		Canvas canvas = new Canvas();
		Reporter reporter = new Reporter();
		setLayout(new BorderLayout());
		add(canvas,BorderLayout.CENTER);
		addMouseListener(reporter);
		Repository.getInstance().addObserver(canvas); // add observer.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(500,500);
		main.setVisible(true);
	}

}
