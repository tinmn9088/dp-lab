package by.vsu.flat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlatCsvBuilder {

    public static List<Flat> readFromFile(String fileName) {
        List<Flat> flats = new ArrayList<>();
        try {
            InputStream stream = FlatCsvBuilder.class.getClassLoader().getResourceAsStream(fileName);
            if (stream == null) {
                throw new FileNotFoundException("Not found: " + fileName);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                reader.lines()
                        .map(line -> {
                            Flat flat = new Flat();
                            String[] values = line.split("\\s*,\\s*");
                            flat.setNumber(values[0]);
                            flat.setEntrance(values[1]);
                            flat.setFloor(values[2]);
                            flat.setOwner(values[3]);
                            return flat;
                        })
                        .forEach(flats::add);
            }
        } catch(IOException e) {
            System.err.println(e);
        }
        return flats;
    }
}
