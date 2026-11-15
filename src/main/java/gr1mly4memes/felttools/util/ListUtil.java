package gr1mly4memes.felttools.util;

import java.util.ArrayList;
import java.util.Collections;

public class ListUtil {
    @SafeVarargs
    public static <T> ArrayList<T> asMutableList(T... o) {
        var result = new ArrayList<T>();
        Collections.addAll(result, o);
        return result;
    }
}
