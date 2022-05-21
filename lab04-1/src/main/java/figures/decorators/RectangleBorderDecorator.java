package figures.decorators;

import figures.Figure;
import figures.RectangleBorder;

public class RectangleBorderDecorator extends FigureDecorator<RectangleBorder> {
    public RectangleBorderDecorator(RectangleBorder rectangleBorder, Figure... init) {
        super(rectangleBorder, init);
    }
}
