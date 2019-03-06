package tk.ddvudo.NetCodeing;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {
	public static void main(String... args) {
		try(Socket s = new Socket("127.0.0.1", 1234)){
			Thread seerverThread = new Thread(new Runnable() {
				public void run() {
					try(DataInputStream di = new DataInputStream(s.getInputStream())){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						while(true) {
							System.out.println(sdf.format(new Date())+"---"+di.readUTF());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			Thread clientThread = new Thread(new Runnable() {
				public void run() {
					try(DataOutputStream dos = new DataOutputStream(s.getOutputStream());
							BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
						while(true) {
							dos.writeUTF(br.readLine());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
			tpe.execute(seerverThread);
			tpe.execute(clientThread);
			while(!tpe.isTerminated()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
