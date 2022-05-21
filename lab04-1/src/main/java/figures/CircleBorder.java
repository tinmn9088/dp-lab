package figures;

import java.awt.*;

public class CircleBorder implements Figure {
	private int x;
	private int y;
	private int diameter;

	public CircleBorder(Point center, int radius) {
		x = center.getX() - radius;
		y = center.getY() - radius;
		diameter = 2 * radius;
	}

	@Override
	public void paint(Graphics2D g) {
		g.drawOval(x, y, diameter, diameter);
	}
}
