package tk.ddvudo.DeepCopy;

import tk.ddvudo.Mybatis.JavaBeans.Category;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class deepCopyTest {
    public static void main(String... args) {
        Map<String, Map<String, Category>> dateMap = new LinkedHashMap<>();

        HashMap<String, Category> motmap = new HashMap<>();

        for (int i = 0; i < 1; i++) {
            Category c = new Category();
            c.setId(String.valueOf(i));
            c.setName(String.valueOf(i));

            motmap.put(c.getId(), c);
            Map<String, Category> clone = (Map<String, Category>) motmap.clone();
            System.out.println(clone.get(c.getId()).getName());
            motmap.get(c.getId()).setName("123");
            System.out.println(clone.get(c.getId()).getName());
            dateMap.put(c.getId(), clone);
        }
        System.out.println(motmap);
    }
}
