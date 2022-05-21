package by.vsu.goods;

import lombok.Data;

@Data
public class Good implements Tradable {
    private String title;
    private double weight;
    private long price;
    private int count;
}
