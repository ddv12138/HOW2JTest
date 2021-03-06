package tk.ddvudo.io.ObjectStream;

import java.io.*;
import java.util.ArrayList;

public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("./src/java.tk/tk.ddvudo/ObjectStream/TestFile");
        ArrayList<TestObject> toarr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestObject to = new TestObject(i + "", 18, 0);
            toarr.add(to);
        }
        try (FileOutputStream fos = new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fi = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fi)) {
            oos.writeObject(toarr.toArray(new TestObject[toarr.size()]));
            oos.flush();
            TestObject[] to1 = (TestObject[]) ois.readObject();
            for (TestObject to : to1) {
                System.out.println(to.toString());
            }
        }
    }

}
