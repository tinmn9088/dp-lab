package figures;

import java.awt.*;

public class RectangleBorder implements Figure {
	private int x;
	private int y;
	private int width;
	private int height;

	public RectangleBorder(Point center, int width, int height) {
		x = center.getX() - width / 2;
		y = center.getY() - height / 2;
		this.width = width;
		this.height = height;
	}

	@Override
	public void paint(Graphics2D g) {
		g.drawRect(x, y, width, height);
	}
}
