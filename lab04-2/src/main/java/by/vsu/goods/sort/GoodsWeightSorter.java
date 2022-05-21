package by.vsu.goods.sort;

import by.vsu.goods.Good;
import by.vsu.goods.GoodDao;
import by.vsu.goods.GoodDecorator;
import by.vsu.goods.Tradable;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.signum;

@RequiredArgsConstructor
public class GoodsWeightSorter implements Sorter {

    @NonNull private GoodDao dao;

    @Getter
    private int timesCompared = 0;

    @Override
    public void run() {
        List<Decorator> decorators = decorate(dao.getAll());
        Collections.sort(decorators, (g1, g2) ->
                (int) signum(g1.getCount() * g1.getWeight() - g2.getCount() * g2.getWeight()));

        System.out.println("Sorted by sum weight:");
        timesCompared = 0;
        for (Decorator decorator : decorators) {
            System.out.printf(" %10.2f | ", decorator.getCount() * decorator.getWeight());
            System.out.println(decorator);
            timesCompared += decorator.getTimesCompared();
        }
    }

    private List<Decorator> decorate(List<Good> goods) {
        return goods.stream().map(Decorator::new).collect(Collectors.toList());
    }

    public static class Decorator extends GoodDecorator {

        @Getter
        private int timesCompared = 0;

        public Decorator(Tradable tradable) {
            super(tradable);
        }

        @Override
        public double getWeight() {
            timesCompared++;
            return super.getWeight();
        }
    }
}
