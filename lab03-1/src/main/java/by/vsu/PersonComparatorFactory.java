package by.vsu;

import java.util.Calendar;
import java.util.Comparator;

public class PersonComparatorFactory {

    public Comparator<Person> create(String type) {
        switch(type) {
            case "по дате": return (Person p1, Person p2) -> {
                Calendar c1 = Calendar.getInstance();
                c1.setTime(p1.getBirthday());
                Calendar c2 = Calendar.getInstance();
                c2.setTime(p2.getBirthday());
                return c1.compareTo(c2);
            };
            case "по дню недели": return (Person p1, Person p2) -> {
                Calendar c1 = Calendar.getInstance();
                c1.setTime(p1.getBirthday());
                Calendar c2 = Calendar.getInstance();
                c2.setTime(p2.getBirthday());
                return Integer.compare(c1.get(Calendar.DAY_OF_WEEK), c2.get(Calendar.DAY_OF_WEEK));
            };
            case "по месяцу": return (Person p1, Person p2) -> {
                Calendar c1 = Calendar.getInstance();
                c1.setTime(p1.getBirthday());
                Calendar c2 = Calendar.getInstance();
                c2.setTime(p2.getBirthday());
                return Integer.compare(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
            };
        }
        throw new IllegalArgumentException("Illegal type: " + type);
    }
}
