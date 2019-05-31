package tk.ddvudo.io.fileCutting;

import java.io.*;
import java.util.ArrayList;

public class FileCut {
    public static void main(String[] args) {
        File inf = new File("./src/java.tk/tk.ddvudo/fileCutting/TestFile");
        try (FileInputStream fi = new FileInputStream(inf)) {
            byte[] buffer = new byte[(int) inf.length()];
            fi.read(buffer);
            long tmpsize = 40 * 1024;
            int num = (int) Math.ceil((double) buffer.length / (double) tmpsize);
            ArrayList<File> fileList = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                FileOutputStream fo = null;
                try {
                    int startindex = (int) (i * tmpsize);
                    int readlength = (int) tmpsize;
                    if (startindex + readlength > buffer.length) {
                        readlength = buffer.length - startindex;
                    }
                    File outf = new File("./src/java.tk/tk.ddvudo/fileCutting/OutPut/TestFileOutput" + i);
                    fo = new FileOutputStream(outf);
                    if (!outf.exists()) {
                        outf.getParentFile().mkdirs();
                        outf.createNewFile();
                    } else {
                        outf.createNewFile();
                    }
                    fileList.add(outf);
                    fo.write(buffer, startindex, readlength);
                    fo.flush();
                } finally {
                    fo.close();
                }
            }
            ArrayList<byte[]> filebuffer = new ArrayList<>();
            for (int i = 0; i < fileList.size(); i++) {
                FileInputStream tmpif = null;
                try {
                    tmpif = new FileInputStream(fileList.get(i));
                    byte[] tmpbuffer = new byte[(int) fileList.get(i).length()];
                    tmpif.read(tmpbuffer);
                    filebuffer.add(tmpbuffer);
                } finally {
                    tmpif.close();
                }
            }
            FileOutputStream allInOneFo = null;
            try {
                File allInOneFile = new File("./src/java.tk/tk.ddvudo/fileCutting/OutPut/TestFileAllInOneOutput");
                if (!allInOneFile.exists()) {
                    allInOneFile.getParentFile().mkdirs();
                    allInOneFile.createNewFile();
                } else {
                    allInOneFile.createNewFile();
                }
                allInOneFo = new FileOutputStream(allInOneFile);
                for (byte[] bytebuff : filebuffer) {
                    allInOneFo.write(bytebuff);
                }
                allInOneFo.flush();
            } finally {
                allInOneFo.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
