package figures.decorators;

import figures.CircleBorder;
import figures.Figure;

public class CircleBorderDecorator extends FigureDecorator<CircleBorder> {
    public CircleBorderDecorator(CircleBorder circleBorder, Figure... init) {
        super(circleBorder, init);
    }
}
