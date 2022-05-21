package figures.decorators;

import figures.Figure;
import figures.Line;

public class LineDecorator extends FigureDecorator<Line> {
    public LineDecorator(Line line, Figure... init) {
        super(line, init);
    }
}
