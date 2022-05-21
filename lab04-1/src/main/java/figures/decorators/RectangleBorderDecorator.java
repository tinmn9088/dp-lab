package figures.decorators;

import figures.FigureProperty;
import figures.RectangleBorder;

public class RectangleBorderDecorator extends FigureDecorator<RectangleBorder> {
    public RectangleBorderDecorator(RectangleBorder rectangleBorder, FigureProperty... init) {
        super(rectangleBorder, init);
    }
}
