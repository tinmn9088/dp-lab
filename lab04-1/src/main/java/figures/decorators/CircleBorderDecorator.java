package figures.decorators;

import figures.CircleBorder;
import figures.FigureProperty;

public class CircleBorderDecorator extends FigureDecorator<CircleBorder> {
    public CircleBorderDecorator(CircleBorder circleBorder, FigureProperty... init) {
        super(circleBorder, init);
    }
}
