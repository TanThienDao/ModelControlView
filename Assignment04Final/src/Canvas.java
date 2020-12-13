import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import javax.swing.JPanel;
import java.awt.Point;


public class Canvas extends JPanel implements Observer {
	public Canvas() {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		Stack<Point> points = Repository.getInstance().getPoints();
		for(int i = 0; i < points.size(); i++) {
			int x = (int) points.get(i).getX();
			int y = (int) points.get(i).getY();
			g.fillOval(x-5, y-25, 10,10);
		}
		System.out.println("Size of stack: "+points.size());
		Stack<Line> lines = Repository.getInstance().getLines();			
		System.out.println("Size of line: "+lines.size());
		for(int i = 0; i < lines.size(); i++) {
			g.drawLine((int)lines.get(i).getLine()[0],(int)lines.get(i).getLine()[1] -20,(int)lines.get(i).getLine()[2],(int)lines.get(i).getLine()[3] -20);
		}
		}
	@Override
	public void update(Observable o, Object arg) {		
		repaint();
	}
}
