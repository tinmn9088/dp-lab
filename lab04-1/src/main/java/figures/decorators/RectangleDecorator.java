package figures.decorators;

import figures.FigureProperty;
import figures.Rectangle;

public class RectangleDecorator extends FigureDecorator<Rectangle> {
    public RectangleDecorator(Rectangle rectangle, FigureProperty... init) {
        super(rectangle, init);
    }
}
