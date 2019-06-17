package tk.ddvudo.io.finalTest;

import java.io.*;
import java.util.ArrayList;

public class Answer {
    private static Answer answer = new Answer();

    private Answer() {
    }

    public static void main(String... args) throws IOException {
//		Answer.getInstance().fileFolderCopy(new File("./src/java.tk/tk.ddvudo/io/finalTest/source"),
//				new File("./src/java.tk/tk.ddvudo/io/finalTest/target"));
        ArrayList<File> res = new ArrayList<>();
        Answer.getInstance().filesearch(new File("E:\\workspace-myself\\HOW2JTest\\src"), "ddv", res);
        for (File f : res) {
            System.out.println(f.getAbsolutePath());
        }
    }

    public static Answer getInstance() {
        return answer;
    }

    public void filesearch(File f, String keyword, ArrayList<File> res) throws IOException {
        File[] tmplist = f.listFiles();
        for (File file : tmplist) {
            if (file.isDirectory()) {
                filesearch(file, keyword, res);
            } else {
                if (singleFileSearch(file, keyword)) {
                    res.add(file);
                }
            }
        }
    }

    private boolean singleFileSearch(File file, String keyword) throws IOException {
        if (file.getName().split("\\.").length > 1
                && file.getName().split("\\.")[file.getName().split("\\.").length - 1].toLowerCase().equals("java")) {
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                String tmp = "";
                while (null != (tmp = br.readLine())) {
                    if (tmp.toLowerCase().contains(keyword.toLowerCase())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean fileCopy(File source, File target) throws IOException {
        if (!source.exists()) {
            throw new IOException("源文件不存在");
        }
        FileCheck(target, source.isDirectory());
        try (FileInputStream fis = new FileInputStream(source);
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(target);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] buffer = new byte[1 * 10240];
            while (bis.read(buffer) > 0) {
                bos.write(buffer);
            }
            bos.flush();
        }
        return true;
    }

    public boolean fileFolderCopy(File source, File target) throws IOException {
        if (!source.exists()) {
            throw new IOException("源文件不存在");
        }
        while (!source.isDirectory()) {
            source = source.getParentFile();
        }
        FileCheck(target, source.isDirectory());
        File[] list = source.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                return fileFolderCopy(f, new File(target, f.getName()));
            } else {
                return fileCopy(f, new File(target, f.getName()));
            }
        }
        return false;
    }

    public boolean FileCheck(File f, boolean isdir) throws IOException {
        if (!f.exists() || (f.exists() && f.isDirectory())) {
            if (isdir) {
                return f.mkdirs();
            } else {
                f.getParentFile().mkdirs();
                return f.createNewFile();
            }
        }
        return false;
    }
}
