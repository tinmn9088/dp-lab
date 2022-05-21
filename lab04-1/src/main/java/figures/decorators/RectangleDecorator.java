package figures.decorators;

import figures.Figure;
import figures.Rectangle;

public class RectangleDecorator extends FigureDecorator<Rectangle> {
    public RectangleDecorator(Rectangle rectangle, Figure... init) {
        super(rectangle, init);
    }
}
