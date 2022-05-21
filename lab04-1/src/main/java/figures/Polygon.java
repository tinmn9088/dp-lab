package figures;

import java.awt.*;

public class Polygon implements Figure {
	private int[] x;
	private int[] y;
	private int n;

	public Polygon(Point... points) {
		n = points.length;
		x = new int[n];
		y = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = points[i].getX();
			y[i] = points[i].getY();
		}
	}

	@Override
	public void paint(Graphics2D g) {
		g.fillPolygon(x, y, n);
	}
}
