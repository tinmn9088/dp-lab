package figures;

import java.awt.*;

public class Stroke implements FigureProperty {
	private java.awt.Stroke stroke;

	public Stroke(int width) {
		stroke = new BasicStroke((float)width);
	}

	@Override
	public void set(Graphics2D g) {
		g.setStroke(stroke);
	}
}
