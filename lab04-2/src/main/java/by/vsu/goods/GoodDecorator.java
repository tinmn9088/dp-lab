package by.vsu.goods;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GoodDecorator implements Tradable {

    private Tradable tradable;

    @Override
    public String getTitle() {
        return tradable.getTitle();
    }

    @Override
    public double getWeight() {
        return tradable.getWeight();
    }

    @Override
    public long getPrice() {
        return tradable.getPrice();
    }

    @Override
    public int getCount() {
        return tradable.getCount();
    }

    @Override
    public String toString() {
        return tradable.toString();
    }
}
