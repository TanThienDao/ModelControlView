import java.awt.Point;
import java.util.Stack;
import java.util.Vector;

public class Student implements Runnable{
	private int id;
	public Student(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	boolean isTrue = true;
	while(isTrue) {
		Line line;
		Stack<Point> points = Repository.getInstance().getPoints();
		Stack<Line> lines = Repository.getInstance().getLines();
		Vector<Double> distanceVal2 = new Vector<Double>();
		if(points.size() == 1) {
		}
		else {
			if(Repository.getInstance().isTrue() == true) {

				for(int j = 0; j < points.size(); j++) {

					int x = (int) points.get(j).getX();
					int y = (int) points.get(j).getY();
					int topX = (int) points.peek().getX();
					int topY = (int) points.peek().getY();
					int Xdiff = (x - topX)*(x - topX);
					int Ydiff = (y - topY)*(y - topY);
					System.out.println("FIRST LOOP");
					double distance = Math.sqrt(Xdiff + Ydiff);
					if(topX == x) {

					}
					else {
					distanceVal2.add(distance);
					}
				}
				double smallest = Integer.MAX_VALUE;
					for(int z = 0; z < distanceVal2.size();z++) {
						if(smallest>distanceVal2.elementAt(z)) {
			                //update smallest
			                smallest=distanceVal2.elementAt(z);
			             }
						System.out.println("Value is: "+ distanceVal2.elementAt(z));
					}
					for(int z = 0; z < distanceVal2.size();z++) {
						if(smallest == distanceVal2.elementAt(z)) {
							int q = (int) points.get(z).getX();
							int y = (int) points.get(z).getY();
							int topX = (int) points.peek().getX();
							int topY = (int) points.peek().getY();
							line = new Line(topX,topY, q, y);
							System.out.println("Adding line");
							Repository.getInstance().addLine(line);
						}

					}
						
					Repository.getInstance().setBool(false);
					
				
		}
		}
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
	}
	}

}
