package by.nikita.data;

import java.io.Serializable;
import java.util.Map;

/**
 * Interface to access data stored in classes as a map.
 */
public interface DataHolder extends Serializable {

    Map<String, String> getData();
}
