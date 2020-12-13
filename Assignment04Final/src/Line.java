
public class Line {
	
	private double[] line = new double[4];
	public Line(double x1, double y1, double x2, double y2) {
		line[0] = x1;
		line[1] = y1;
		line[2] = x2;
		line[3] = y2;
	}
	public double[] getLine() {
		return line;
	}
	
}
