import figures.*;
import figures.decorators.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Runner {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Collection<Figure> figures = new ArrayList<>();
		figures.add(new RectangleDecorator(new Rectangle(new Point(275, 300), 550, 100),
				new LinearGradient(new Line(new Point(0, 250), new Point(0, 350)), new Color(0, 128, 255), new Color(0, 0, 128))));
		figures.add(new CircleDecorator(new Circle(new Point(450, 50), 25),
				new Colour(Color.YELLOW)));
		figures.add(new LineDecorator(new Line(new Point(200, 25), new Point(200, 125)),
				new Colour(Color.ORANGE),
				new Stroke(2)));
		figures.add(new LineDecorator(new Line(new Point(175, 50), new Point(225, 50)),
				new Colour(Color.ORANGE),
				new Stroke(2)));
		figures.add(new PolylineDecorator(new Polyline(new Point(50, 200), new Point(200, 50), new Point(500, 200)),
				new Colour(Color.BLACK),
				new Stroke(2)));
		figures.add(new RectangleDecorator(new Rectangle(new Point(225, 175), 150, 50),
				new Colour(new Color(255, 200, 200))));
		figures.add(new RectangleBorderDecorator(new RectangleBorder(new Point(225, 175), 150, 50),
				new Colour(Color.RED),
				new Stroke(1)));
		figures.add(new RectangleDecorator(new Rectangle(new Point(212, 137), 75, 25),
				new Colour(new Color(255, 200, 200))));
		figures.add(new RectangleBorderDecorator(new RectangleBorder(new Point(212, 137), 75, 25),
				new Colour(Color.RED),
				new Stroke(1)));
		figures.add(new PointDecorator(new Point(175, 175),
				new Colour(new Color(0, 128, 0))));
		figures.add(new PointDecorator(new Point(200, 175),
				new Colour(new Color(0, 128, 0))));
		figures.add(new PointDecorator(new Point(225, 175),
				new Colour(new Color(0, 128, 0))));
		figures.add(new PointDecorator(new Point(250, 175),
				new Colour(new Color(0, 128, 0))));
		figures.add(new PointDecorator(new Point(275, 175),
				new Colour(new Color(0, 128, 0))));
		figures.add(new PolygonDecorator(new Polygon(new Point(50, 200), new Point(500, 200), new Point(400, 300), new Point(150, 300)),
				new Colour(Color.LIGHT_GRAY)));
		figures.add(new PolylineDecorator(new Polyline(new Point(50, 200), new Point(500, 200), new Point(400, 300), new Point(150, 300), new Point(50, 200)),
				new Colour(Color.GRAY),
				new Stroke(2)));
		figures.add(new CircleDecorator(new Circle(new Point(175, 250), 25),
				new RadialGradient(new Circle(new Point(175, 250), 25), Color.CYAN, Color.WHITE)));
		figures.add(new CircleBorderDecorator(new CircleBorder(new Point(175, 250), 25),
				new Colour(Color.MAGENTA),
				new Stroke(3)));
		figures.add(new CircleDecorator(new Circle(new Point(275, 250), 25),
				new RadialGradient(new Circle(new Point(275, 250), 25), Color.CYAN, Color.WHITE)));
		figures.add(new CircleBorderDecorator(new CircleBorder(new Point(275, 250), 25),
				new Colour(Color.MAGENTA),
				new Stroke(3)));
		figures.add(new CircleDecorator(new Circle(new Point(375, 250), 25),
				new RadialGradient(new Circle(new Point(375, 250), 25), Color.CYAN, Color.WHITE)));
		figures.add(new CircleBorderDecorator(new CircleBorder(new Point(375, 250), 25),
				new Colour(Color.MAGENTA),
				new Stroke(3)));
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new MainFrame("Рисунок", 550, 350, new Picture(figures));
	}
}
