package figures.decorators;

import figures.FigureProperty;
import figures.Line;

public class LineDecorator extends FigureDecorator<Line> {
    public LineDecorator(Line line, FigureProperty... init) {
        super(line, init);
    }
}
