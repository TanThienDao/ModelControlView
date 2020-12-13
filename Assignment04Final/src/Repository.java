import java.util.Observable;
import java.util.Stack;
import java.awt.Point;

public class Repository extends Observable{
	private Point coordinate;
	private Line line;
	private double totalDistance;
	private static Repository Repo;
	private Stack<Point> points;
	private Stack<Line> lines;
	private boolean isTrue = true;
	private int count = 0;
	private boolean ProfBool = false;
	
	private Repository() {
		points = new Stack<Point>();
		lines = new Stack<Line>();
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
		points.add(new Point(x,y));
		isTrue = true;
		setChanged();
		notifyObservers();
	}
	public void addLine(Line line) {
		lines.add(line);
		setChanged();
		notifyObservers();
	}
	public boolean isTrue() {
		return isTrue;
	}
	public void setBool(boolean isTrue) {
		this.isTrue = isTrue;
	}
	public void setProfBool(boolean val) {
		this.ProfBool = val;
	}
	public boolean getProfBool() {
		return this.ProfBool;
	}
}
