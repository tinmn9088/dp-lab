package by.vsu.goods;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GoodDao implements TradableDao {

    private final File source;

    public GoodDao(File source) throws IllegalArgumentException {
        if (!source.exists() || !source.canRead()) {
            throw new IllegalArgumentException("Illegal source: " + source);
        }
        this.source = source;
    }

    @Override
    public List<Good> getAll() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(source, new TypeReference<List<Good>>() {});
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
