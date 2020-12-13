import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public Main() {
		Canvas canvas = new Canvas();
		Reporter reporter = new Reporter();
		setLayout(new BorderLayout());
		add(canvas,BorderLayout.CENTER);
		addMouseListener(reporter);
		Repository.getInstance().addObserver(canvas);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(500,500);
		Thread thread1 = new Thread(new Student(1));
		Thread thread2 = new Thread(new Professor());
		thread1.start();
		thread2.start();
		main.setVisible(true);
		
	}

}
