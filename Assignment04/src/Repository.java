import java.util.Observable;
import java.util.Stack;
import java.awt.Point;
// model black board and observable
//singleton !!!
public class Repository extends Observable{
	private Point coordinate;
	private Line line;
	private double totalDistance;
	private static Repository Repo;
	private Stack<Point> points;
	private Stack<Line> lines;
	
	private Repository() {
		points = new Stack<Point>();

		
	}
	
	public static Repository getInstance() {
		if(Repo == null) {
		
			Repo = new Repository();
		}
		return Repo;
	}
	public Stack<Point> getPoints(){
		return points;
	}
	public Stack<Line> getLines(){
		return lines;
	}

	public void add(int x, int y) {
		setChanged();
		notifyObservers();
		points.add(new Point(x,y));
	}
}
