package tk.ddvudo.io.mutilCall4IO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Sample {
    public static void main(String... args) {
        Logger logger = LoggerFactory.getLogger(Sample.class.getName());
        File f = new File("./src/main/java/tk/ddvudo/io/mutilCall4IO/TestFile");
        logger.info(f.getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            logger.info(br.readLine());
            logger.info("-------------");
            FunctionB(br, logger);
        } catch (FileNotFoundException e) {
            logger.error("文件未找到", e);
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    public static void FunctionB(BufferedReader br, Logger logger) throws IOException {
        String tmp = null;
        while (null != (tmp = br.readLine())) {
            logger.info(tmp);
        }
    }
}
