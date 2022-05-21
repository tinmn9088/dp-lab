package figures;

import java.awt.Color;
import java.awt.Graphics2D;

public class Colour implements Figure {
	private Color color;

	public Colour(Color color) {
		this.color = color;
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(color);
	}
}
