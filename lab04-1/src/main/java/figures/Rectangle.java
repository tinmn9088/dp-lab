package figures;

import java.awt.*;

public class Rectangle implements Figure {
	private int x;
	private int y;
	private int width;
	private int height;

	public Rectangle(Point center, int width, int height) {
		x = center.getX() - width / 2;
		y = center.getY() - height / 2;
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(Graphics2D g) {
		g.fillRect(x, y, width, height);
	}
}
