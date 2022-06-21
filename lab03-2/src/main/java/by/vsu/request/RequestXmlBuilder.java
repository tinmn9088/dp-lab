package by.vsu.request;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestXmlBuilder {

    public static List<Request> readFromFile(String fileName) {
        List<Request> requests = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            InputStream stream = RequestXmlBuilder.class.getClassLoader().getResourceAsStream(fileName);
            if (stream == null) {
                throw new FileNotFoundException("Not found: " + fileName);
            }
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            Request request = null;
            int elementType;
            String tagName;
            while(reader.hasNext()) {
                elementType = reader.next();
                switch(elementType) {
                    case XMLStreamReader.START_ELEMENT: {
                        tagName = reader.getLocalName();
                        switch(tagName) {
                            case "request":
                                request = new Request();
                                break;
                            case "flat-number":
                                request.setFlatNumber(reader.getElementText());
                                break;
                            case "date":
                                String date = reader.getElementText();
                                request.setDate(LocalDate.parse(date, formatter));
                                break;
                            case "description":
                                request.setDescription(reader.getElementText());
                                break;
                            case "hours":
                                request.setHours(Integer.parseInt(reader.getElementText()));
                                break;
                        }
                        break;
                    }
                    case XMLStreamReader.END_ELEMENT: {
                        tagName = reader.getLocalName();
                        switch(tagName) {
                            case "request":
                                requests.add(request);
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
        return requests;
    }
}
