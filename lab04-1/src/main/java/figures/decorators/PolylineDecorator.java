package figures.decorators;

import figures.FigureProperty;
import figures.Polyline;

public class PolylineDecorator extends FigureDecorator<Polyline> {
    public PolylineDecorator(Polyline polyline, FigureProperty... init) {
        super(polyline, init);
    }
}
