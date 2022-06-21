package by.vsu.request;

import java.util.List;

public enum RequestsFactory {

    INSTANCE;

    public List<Request> create(String ext, String name) {
        String fileName = name + "." + ext;
        switch (ext) {
            case "csv":
                return RequestCsvBuilder.readFromFile(fileName);
            case "xml":
                return RequestXmlBuilder.readFromFile(fileName);
            default:
                throw new IllegalArgumentException("Illegal extension: " + ext);
        }
    }
}
