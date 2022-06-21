package by.vsu.request;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RequestCsvBuilder {

    public static List<Request> readFromFile(String fileName) {
        List<Request> requests = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            InputStream stream = RequestCsvBuilder.class.getClassLoader().getResourceAsStream(fileName);
            if (stream == null) {
                throw new FileNotFoundException("Not found: " + fileName);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                reader.lines()
                        .map(line -> {
                            Request request = new Request();
                            String[] values = line.split("\\s*,\\s*");
                            request.setFlatNumber(values[0]);
                            request.setDate(LocalDate.parse(values[1], formatter));
                            request.setDescription(values[2]);
                            request.setHours(Integer.parseInt(values[3]));
                            return request;
                        })
                        .forEach(requests::add);
            }
        } catch(IOException e) {
            System.err.println(e);
        }
        return requests;
    }
}
