package tk.ddvudo.Reflection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionSample {
    public static void main(String... args) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("./src/java.tk/tk.ddvudo/Reflection/ClassConfig.conf")))) {
            String classname = br.readLine();
            Class test = Class.forName(classname);
            Constructor con = test.getConstructor();
            TestClass tc = (TestClass) con.newInstance();
            Method setName = tc.getClass().getMethod("setName", String.class);
            setName.invoke(tc, "aaa");
            System.out.println(tc.getName());
//            System.out.println(tc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
