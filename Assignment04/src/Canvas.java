import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;
import javax.swing.JPanel;
import java.awt.Point;

// view link to main observer
public class Canvas extends JPanel implements Observer {

	public Canvas() {
		
	}

	public void paintComponent(Graphics g) {
		// draw points
		g.setColor(Color.BLUE);
		Stack<Point> points = Repository.getInstance().getPoints(); // get point in repository
		for(int i = 0; i < points.size(); i++) {
			int x = (int) points.get(i).getX();
			int y = (int) points.get(i).getY();
			g.fillOval(x-5, y-25, 10,10);
		}
		// draw line
		System.out.println("Size of stack: "+points.size());

		for(int j = 0; j < points.size(); j++) {
			int x = (int) points.get(j).getX();
			int y = (int) points.get(j).getY();
			if(j != 0) {
				int x1 = (int) points.get(j - 1).getX();
				int y2 = (int) points.get(j - 1).getY();
				g.drawLine(x1 ,y2 -20, x, y - 20);
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
