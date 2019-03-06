package tk.ddvudo.multiThread.ThreadPool;

import tk.ddvudo.multiThread.MultiThreadFileSearch.ThreadClass;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFileSearch {
    public static void main(String... args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        File f = new File("./");
        FileMutliThreadSearch(f, "public", tpe);
    }

    private static void FileMutliThreadSearch(File file, String keyword, ThreadPoolExecutor tpe) {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File f : list) {
                if (f.isDirectory()) {
                    FileMutliThreadSearch(f, keyword, tpe);
                } else {
                    tpe.execute(new ThreadClass(f, keyword));
                }
            }
        } else {
            tpe.execute(new ThreadClass(file, keyword));
        }
    }
}
