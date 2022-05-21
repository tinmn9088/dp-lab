package figures;

import java.awt.Color;
import java.awt.Graphics2D;

public class Colour implements FigureProperty {
	private Color color;

	public Colour(Color color) {
		this.color = color;
	}

	@Override
	public void set(Graphics2D g) {
		g.setColor(color);
	}
}
