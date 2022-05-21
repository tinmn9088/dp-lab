package figures.decorators;

import figures.Figure;

import java.awt.*;
import java.util.List;

public class FigureDecorator<T extends Figure> implements Figure {
    private T figure;

    private List<Figure> init;

    public FigureDecorator(T figure, Figure...init) {
        this.figure = figure;
        this.init = List.of(init);
    }

    @Override
    public void paint(Graphics2D g) {
        for (Figure i : init) {
            i.paint(g);
        }
        figure.paint(g);
    }
}
