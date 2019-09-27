package main.java.tk.ddvudo.ThreaSafeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
    public static void main(String[] args) {
        List<String> list = dd();
        System.out.println(list);
    }

    public static List<String> dd() {
        List<String> aa = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i < 101; i++) {
            aa.add(String.valueOf(i));
        }
        ExecutorService pool = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 5; i++) {
                int begin = i * 20;
                int end = (i + 1) * 20;
                List<String> tmpList = Collections.synchronizedList(aa.subList(begin, end));
                Runnable r = new Runner1(tmpList);
                pool.submit(r);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!pool.isShutdown() && !pool.isTerminated()) {
            pool.shutdown();
        }
        System.out.println(aa);
        return aa;
    }

}
class Runner1 implements Runnable {
    private List<String> aa;

    Runner1(List<String> aa) {
        this.aa = aa;
    }
    public void run() {
        try {
            for (int i = 0; i < this.aa.size(); i++) {
                if (this.aa.get(i).contains("2")) {
                    String gg = this.aa.get(i) + "a";
                    this.aa.set(i, gg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
