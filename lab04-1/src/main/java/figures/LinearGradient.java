package figures;

import java.awt.*;

public class LinearGradient implements FigureProperty {
	private MultipleGradientPaint gradient;

	public LinearGradient(Line line, Color beginColor, Color endColor) {
		gradient = new LinearGradientPaint(line.getBegin().getX(), line.getBegin().getY(), line.getEnd().getX(), line.getEnd().getY(), new float[] {0, 1}, new Color[] {beginColor, endColor});
	}

	@Override
	public void set(Graphics2D g) {
		g.setPaint(gradient);
	}
}
