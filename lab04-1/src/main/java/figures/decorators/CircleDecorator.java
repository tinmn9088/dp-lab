package figures.decorators;

import figures.Circle;
import figures.Figure;

public class CircleDecorator extends FigureDecorator<Circle> {
    public CircleDecorator(Circle circle, Figure... init) {
        super(circle, init);
    }
}
