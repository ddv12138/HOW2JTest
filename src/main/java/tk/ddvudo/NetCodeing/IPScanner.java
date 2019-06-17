package tk.ddvudo.NetCodeing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class IPScanner {

    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getLocalHost();
        String ipprefix = addr.getHostAddress().substring(0, addr.getHostAddress().lastIndexOf("."));
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i <= 255; i++) {
            String tmpaddr = ipprefix + "." + i;
            Process p = Runtime.getRuntime().exec("ping " + tmpaddr);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("gb2312")))) {
                String tmp = "";
                while (null != (tmp = br.readLine())) {
                    System.out.println(tmp);
                    if (tmp.contains("TTL") && !tmp.contains(tmpaddr)) {
                        res.add(tmpaddr);
                    }
                }
            }
        }
        for (String s : res) {
            System.out.println(s);
        }
    }

}
