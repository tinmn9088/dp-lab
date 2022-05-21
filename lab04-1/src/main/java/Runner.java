import figures.*;
import figures.decorators.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Runner {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		int height = 350;
		int width = 550;
		Collection<Figure> figures = new ArrayList<>();

		// a sky full of stars
		figures.add(new RectangleDecorator(new Rectangle(new Point(mul(width, 0.5), mul(height, 0.5)), width, height),
				new Colour(Color.BLACK)));
		for (int x = 0; x < width; x += width / 7) {
			for (int y = 0; y < height; y += height / 7) {
				figures.add(new PointDecorator(new Point(x + (int) (Math.random() * 30), y + (int) (Math.random() * 30)),
						new Colour(Color.WHITE)));
			}
		}

		// ship
		{
			Point center = new Point(mul(width, 0.13), mul(height, 0.57));
			figures.add(new CircleDecorator(new Circle(center, mul(height, 0.03)),
					new RadialGradient(new Circle(center, mul(height, 0.02)), Color.WHITE, Color.CYAN)));
			center = new Point(mul(width, 0.12), mul(height, 0.62));
			figures.add(new CircleDecorator(new Circle(center, mul(height, 0.025)),
					new RadialGradient(new Circle(center, mul(height, 0.018)), Color.WHITE, Color.CYAN)));
		}
		figures.add(new PolygonDecorator(new Polygon(
				new Point(mul(width, 0.15), mul(height, 0.5)),
				new Point(mul(width, 0.5),  mul(height, 0.55)),
				new Point(mul(width, 0.10), mul(height, 0.7))),
				new Colour(Color.LIGHT_GRAY)));
		figures.add(new RectangleDecorator(new Rectangle(new Point(mul(width, 0.15), mul(height, 0.5)), mul(width, 0.05), mul(height, 0.1)),
				new Colour(Color.LIGHT_GRAY)));

		// asteroids
		figures.add(new PolylineDecorator(new Polyline(
				new Point(mul(width, 0.8),  mul(height, 0.8)),
				new Point(mul(width, 0.85), mul(height, 0.85)),
				new Point(mul(width, 0.83), mul(height, 0.88)),
				new Point(mul(width, 0.79), mul(height, 0.89)),
				new Point(mul(width, 0.77), mul(height, 0.86)),
				new Point(mul(width, 0.8),  mul(height, 0.8))),
				new Colour(Color.WHITE),
				new Stroke(2)));
		figures.add(new PolylineDecorator(new Polyline(
				new Point(mul(width, 0.83),  mul(height, 0.75)),
				new Point(mul(width, 0.89),  mul(height, 0.72)),
				new Point(mul(width, 0.88),  mul(height, 0.69)),
				new Point(mul(width, 0.86),  mul(height, 0.695)),
				new Point(mul(width, 0.855), mul(height, 0.71)),
				new Point(mul(width, 0.83),  mul(height, 0.75))),
				new Colour(Color.WHITE),
				new Stroke(2)));

		// fires
		figures.add(new LineDecorator(new Line(
				new Point(mul(width, 0.5), mul(height, 0.7)),
				new Point(mul(width, 0.58), mul(height, 0.72))),
				new Colour(Color.GREEN),
				new Stroke(2)));
		figures.add(new LineDecorator(new Line(
				new Point(mul(width, 0.7), mul(height, 0.73)),
				new Point(mul(width, 0.78), mul(height, 0.745))),
				new Colour(Color.GREEN),
				new Stroke(2)));

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new MainFrame("Космический корабль", width, height, new Picture(figures));
	}

	private static int mul(double number, double coeff) {
		return (int) (number * coeff);
	}
}
