package by.vsu.goods;

import java.util.List;

public interface TradableDao {

    List<? extends Tradable> getAll() throws RuntimeException;
}
