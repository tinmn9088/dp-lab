package figures.decorators;

import figures.FigureProperty;
import figures.Polygon;

public class PolygonDecorator extends FigureDecorator<Polygon> {
    public PolygonDecorator(Polygon polygon, FigureProperty... init) {
        super(polygon, init);
    }
}
