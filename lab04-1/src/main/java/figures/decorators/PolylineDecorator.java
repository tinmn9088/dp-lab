package figures.decorators;

import figures.Figure;
import figures.Polyline;

public class PolylineDecorator extends FigureDecorator<Polyline> {
    public PolylineDecorator(Polyline polyline, Figure... init) {
        super(polyline, init);
    }
}
