package by.vsu.flat;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FlatXmlBuilder {

    public static List<Flat> readFromFile(String fileName) {
        List<Flat> flats = new ArrayList<>();
        try {
            InputStream stream = FlatXmlBuilder.class.getClassLoader().getResourceAsStream(fileName);
            if (stream == null) {
                throw new FileNotFoundException("Not found: " + fileName);
            }
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            Flat flat = null;
            int elementType;
            String tagName;
            while(reader.hasNext()) {
                elementType = reader.next();
                switch(elementType) {
                    case XMLStreamReader.START_ELEMENT: {
                        tagName = reader.getLocalName();
                        switch(tagName) {
                            case "flat":
                                flat = new Flat();
                                break;
                            case "number":
                                flat.setNumber(reader.getElementText());
                                break;
                            case "entrance":
                                flat.setEntrance(reader.getElementText());
                                break;
                            case "floor":
                                flat.setFloor(reader.getElementText());
                                break;
                            case "owner":
                                flat.setOwner(reader.getElementText());
                                break;
                        }
                        break;
                    }
                    case XMLStreamReader.END_ELEMENT: {
                        tagName = reader.getLocalName();
                        switch(tagName) {
                            case "flat":
                                flats.add(flat);
                                break;
                        }
                        break;
                    }
                }
            }
            reader.close();
        } catch(FileNotFoundException | XMLStreamException e) {
            System.err.println(e);
        }
        return flats;
    }
}
