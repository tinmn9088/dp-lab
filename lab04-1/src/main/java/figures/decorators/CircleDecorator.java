package figures.decorators;

import figures.Circle;
import figures.FigureProperty;

public class CircleDecorator extends FigureDecorator<Circle> {
    public CircleDecorator(Circle circle, FigureProperty... init) {
        super(circle, init);
    }
}
