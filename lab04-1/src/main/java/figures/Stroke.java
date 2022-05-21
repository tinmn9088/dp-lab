package figures;

import java.awt.*;

public class Stroke implements Figure {
	private java.awt.Stroke stroke;

	public Stroke(int width) {
		stroke = new BasicStroke((float)width);
	}

	@Override
	public void paint(Graphics2D g) {
		g.setStroke(stroke);
	}
}
