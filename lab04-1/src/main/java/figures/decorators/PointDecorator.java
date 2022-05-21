package figures.decorators;

import figures.Figure;
import figures.Point;

public class PointDecorator extends FigureDecorator<Point> {
    public PointDecorator(Point point, Figure... init) {
        super(point, init);
    }
}
