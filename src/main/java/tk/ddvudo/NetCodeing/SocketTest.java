package tk.ddvudo.NetCodeing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SocketTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Thread t1 = new Thread(() -> {
            String sql = "select * From dictionary where receive like ?";
            try (ServerSocket server = new ServerSocket(5023);
                 Socket socket = server.accept();
                 DataInputStream dis = new DataInputStream(socket.getInputStream());
                 Connection c = DriverManager.getConnection("jdbc:mysql://tk.ddvudo.java.tk:3306/mysql?characterEncoding=UTF-8",
                         "root", "liukang951006"); PreparedStatement ps = c.prepareStatement(sql)) {
                String tmp = "";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                while (null != (tmp = dis.readUTF())) {
                    ps.setString(1, "%" + tmp + "%");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        System.out.println(sdf.format(new Date()) + "---" + rs.getString("response"));
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try (Socket client = new Socket("127.0.0.1", 5023);
                 DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String tmp = "";
                while (null != (tmp = br.readLine())) {
                    dos.writeUTF(tmp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        tpe.execute(t1);
        tpe.execute(t2);

    }

}
