package tk.ddvudo.NetCoding;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            Socket s = server.accept();
            Thread seerverThread = new Thread(() -> {
                try {
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    while (true) {
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            Thread clientThread = new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                try {
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                    while (true) {
                        String str = sc.next();
                        dos.writeUTF(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    sc.close();
                }
            });
            ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            tpe.execute(seerverThread);
            tpe.execute(clientThread);
            while (tpe.isTerminated()) {
                server.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
