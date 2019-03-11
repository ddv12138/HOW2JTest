package tk.ddvudo.multiThread.PasswordDecode;

import java.util.ArrayList;
import java.util.List;

public class DecodeThread extends Thread {
    private String passwd;
    private String[] dict = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private List<String> tried = new ArrayList<>();

    public DecodeThread(String passwd) {
        super();
        this.passwd = passwd;
    }

    public static void main(String... args) {
        DecodeThread dt = new DecodeThread("azz");
        dt.start();
    }

    @Override
    public void run() {
        LogThread lt = new LogThread(this);
        lt.setDaemon(true);
        lt.start();
        try {
            for (String c1 : dict) {
                for (String c2 : dict) {
                    for (String c3 : dict) {
                        String tryword = c1 + c2 + c3;
                        synchronized (tried) {
                            tried.add(tryword);
                        }
                        if (lockCheck(tryword)) {
                            System.out.println("unlocked------>" + tryword);
                            throw new RuntimeException("破解完成");
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            if (!e.getMessage().equals("破解完成")) {
                throw e;
            }
        }
    }

    public Boolean lockCheck(String tryword) {
        return passwd.equals(tryword);
    }

    public List<String> getTried() {
        return tried;
    }

}
