package by.vsu;

import by.vsu.goods.GoodDao;
import by.vsu.goods.sort.GoodsPriceSorter;
import by.vsu.goods.sort.GoodsWeightSorter;
import by.vsu.goods.sort.Sorter;

import java.io.File;

public class Main {

    private static final String SOURCE_FILE_PATH = "goods.json";

    public static void main(String[] args) {
        {
            Sorter sorter = new GoodsWeightSorter(new GoodDao(getSource()));
            sorter.run();
            System.out.printf("Compare times: %d\n\n", sorter.getTimesCompared());
        }

        {
            Sorter sorter = new GoodsPriceSorter(new GoodDao(getSource()));
            sorter.run();
            System.out.printf("Compare times: %d\n\n", sorter.getTimesCompared());
        }
    }

    private static File getSource() {
        return new File(Main.class.getClassLoader().getResource(SOURCE_FILE_PATH).getFile());
    }

}
