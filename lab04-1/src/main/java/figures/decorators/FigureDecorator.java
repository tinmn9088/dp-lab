package figures.decorators;

import figures.Figure;
import figures.FigureProperty;

import java.awt.*;
import java.util.List;

public class FigureDecorator<T extends Figure> implements Figure {
    private T figure;

    private List<FigureProperty> init;

    public FigureDecorator(T figure, FigureProperty... init) {
        this.figure = figure;
        this.init = List.of(init);
    }

    @Override
    public void paint(Graphics2D g) {
        for (FigureProperty property : init) {
            property.set(g);
        }
        figure.paint(g);
    }
}
