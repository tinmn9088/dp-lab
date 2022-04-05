package by.nikita.data;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Prints to console data from DataHolders.
 */
public class DataTablePrinter {

    /**
     * Stores all maps received from getData().
     */
    private List<Map<String, String>> dataList;

    private Map<String, Integer> columnNameAndWidths;

    /**
     * @param dataHolders non-empty array of instances of the same class
     *
     * @implNote Field set will be taken from first array element.
     */
    public DataTablePrinter(DataHolder[] dataHolders)
            throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(dataHolders);
        if (dataHolders.length == 0) {
            throw new IllegalArgumentException("dataHolders is empty");
        }
        Class<?> cl = dataHolders[0].getClass();
        for (DataHolder dh : dataHolders) {
            if (!dh.getClass().equals(cl)) {
                throw new IllegalArgumentException("dataHolder contains different classes");
            }
        }

        // initialize cache
        this.dataList = new ArrayList<>(dataHolders.length);
        for (DataHolder dh : dataHolders) {
            dataList.add(dh.getData());
        }

        this.columnNameAndWidths = new HashMap<>();
        for (String columnName : dataList.get(0).keySet()) {
            columnNameAndWidths.put(columnName, countColumnWidth(columnName));
        }
    }

    public void print() {
        String horizontalLine = buildHorizontalBorder();

        // top border
        System.out.println(horizontalLine);

        // column names
        {
            StringBuilder row = new StringBuilder(horizontalLine.length());
            row.append("|");
            for (Map.Entry<String, Integer> columnNameAndWidth : columnNameAndWidths.entrySet()) {
                String value = columnNameAndWidth.getKey();
                int columnWidth = columnNameAndWidth.getValue();
                row.append(StringUtils.leftPad(value, columnWidth));
                row.append("|");
            }
            System.out.println(row);
            System.out.println(horizontalLine);
        }

        for (Map<String, String> data : dataList) {
            StringBuilder row = new StringBuilder(horizontalLine.length());
            row.append("|");
            for (Map.Entry<String, String> entry : data.entrySet()) {
                if (columnNameAndWidths.containsKey(entry.getKey())) {
                    String value = entry.getValue();
                    int columnWidth = columnNameAndWidths.get(entry.getKey());
                    row.append(StringUtils.leftPad(value, columnWidth));
                    row.append("|");
                }
            }
            System.out.println(row);

            // bottom border
            System.out.println(horizontalLine);
        }
    }

    private int countColumnWidth(String columnName) {
        int maxLength = columnName.length();

        for (Map<String, String> data : dataList) {
            int currentDataLength = Optional.ofNullable(data.get(columnName))
                    .orElseGet(() -> "").length();
            if (currentDataLength > maxLength) {
                maxLength = currentDataLength;
            }
        }

        return maxLength;
    }

    private int countRowWidth() {
        int rowWidth = 1;

        for (int columnWidth : columnNameAndWidths.values()) {
            rowWidth += columnWidth + 1; // +1 is for column delimiter symbol
        }

        return rowWidth;
    }

    private String buildHorizontalBorder() {
        StringBuilder horizontalLine = new StringBuilder();
        horizontalLine.append("|");
        for (Map.Entry<String, Integer> columnNameAndWidth : columnNameAndWidths.entrySet()) {
            horizontalLine.append(StringUtils.repeat('-', columnNameAndWidth.getValue()));
            horizontalLine.append("|");
        }
        return horizontalLine.toString();
    }
}
