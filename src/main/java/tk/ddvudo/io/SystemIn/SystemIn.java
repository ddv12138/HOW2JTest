package tk.ddvudo.io.SystemIn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SystemIn {
    public static void main(String[] args) throws IOException {
        String fc = "package " + SystemIn.class.getPackage().getName() + ";\r\n"
                + "public class @class@ {\r\n" +
                "    public @type@ @property@;\r\n" +
                "    public @class@() {\r\n" +
                "    }\r\n" +
                "    public void set@Uproperty@(@type@  @property@){\r\n" +
                "        this.@property@ = @property@;\r\n" +
                "    }\r\n" +
                "      \r\n" +
                "    public @type@  get@Uproperty@(){\r\n" +
                "        return this.@property@;\r\n" +
                "    }\r\n" +
                "}";
        String filepath = "./src/tk/ddvudo/SystemIn/@class@.java";
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("请输入类名");
            String classname = s.nextLine();
            System.out.println("请输入成员变量类型");
            String addrtype = s.nextLine();
            System.out.println("请输入成员变量名称");
            String addrname = s.nextLine();
            File f = new File(filepath.replaceAll("@class@", classname));
            if (!f.exists()) {
                f.getParentFile().mkdirs();
            }
            f.createNewFile();
            try (FileWriter fw = new FileWriter(f); BufferedWriter bw = new BufferedWriter(fw)) {
                fc = fc.replaceAll("@class@", classname);
                fc = fc.replaceAll("@type@", addrtype);
                fc = fc.replaceAll("@Uproperty@", addrname.substring(0, 1).toUpperCase() + addrname.substring(1));
                fc = fc.replaceAll("@property@", addrname);
                System.out.println(fc);
                bw.write(fc);
                bw.flush();
            }
        }
    }
}
