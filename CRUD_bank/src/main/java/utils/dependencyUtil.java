package utils;

import java.util.HashMap;
import java.util.Map;

public class dependencyUtil {
    private static final Map<String, Object> dependencyMap = new HashMap<>();

    public static void addDependency(String name, Object obj) {
        dependencyMap.put(name, obj);
    }

    public static Object getDependency(String name) {
        return dependencyMap.get(name);
    }
}
