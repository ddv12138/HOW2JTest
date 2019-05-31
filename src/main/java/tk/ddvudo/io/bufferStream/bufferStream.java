package tk.ddvudo.io.bufferStream;

import java.io.*;

public class bufferStream {
    public static void main(String[] args) throws IOException {
//		basicUse();
        removeComments(new File("./src/java.tk/tk.ddvudo/bufferStream/TestFile"));
    }

    public static void basicUse() throws IOException {
        File f = new File("./src/java.tk/tk.ddvudo/bufferStream/TestFile");
        File outf = new File("./src/java.tk/tk.ddvudo/bufferStream/TestFileOutput");
        if (!outf.exists()) {
            outf.getParentFile().mkdirs();
        }
        outf.createNewFile();
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(outf);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String s = null;
            while (null != (s = br.readLine())) {
                System.out.println(s);
                bw.write(s + "\r");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeComments(File javaFile) throws IOException {
        File outf = new File(javaFile.getParent(), javaFile.getName() + "_removed");
        if (!outf.exists()) {
            outf.getParentFile().mkdirs();
        }
        outf.createNewFile();
        try (FileReader fr = new FileReader(javaFile);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(outf);
             BufferedWriter bw = new BufferedWriter(fw)) {
            String s = null;
            while (null != (s = br.readLine())) {
                if (!s.startsWith("//")) {
                    bw.write(s + "\r");
                } else {
                    System.out.println(s + "-removed");
                }
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
