package figures.decorators;

import figures.Figure;
import figures.Polygon;
import figures.Polyline;

public class PolygonDecorator extends FigureDecorator<Polygon> {
    public PolygonDecorator(Polygon polygon, Figure... init) {
        super(polygon, init);
    }
}
