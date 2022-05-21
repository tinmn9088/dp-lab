package figures.decorators;

import figures.FigureProperty;
import figures.Point;

public class PointDecorator extends FigureDecorator<Point> {
    public PointDecorator(Point point, FigureProperty... init) {
        super(point, init);
    }
}
