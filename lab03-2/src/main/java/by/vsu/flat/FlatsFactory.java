package by.vsu.flat;

import java.util.List;

public enum FlatsFactory {

    INSTANCE;

    public List<Flat> create(String ext, String name) {
        String fileName = name + "." + ext;
        switch (ext) {
            case "csv":
                return FlatCsvBuilder.readFromFile(fileName);
            case "xml":
                return FlatXmlBuilder.readFromFile(fileName);
            default:
                throw new IllegalArgumentException("Illegal extension: " + ext);
        }
    }
}
