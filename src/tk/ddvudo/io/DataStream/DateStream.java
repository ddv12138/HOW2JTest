package tk.ddvudo.io.DataStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DateStream {
	public static void main(String... args) throws IOException {
		File f = new File("./src/tk/ddvudo/DataStream/TestFile");
		dataStreamWay(f);
		f.createNewFile();
		bufferStreamWay(f);
	}

	private static void bufferStreamWay(File f) throws IOException {
		try (FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw)) {
			int a=1023;int b=1023;
			bw.write((a+"")+'@'+(b+""));
			bw.flush();
			String s = br.readLine();
			System.out.println(s);
			if(s.indexOf('@') > -1) {
				System.out.println(s.split("@")[0]);
				System.out.println(s.split("@")[1]);
			}
		}
	}

	private static void dataStreamWay(File f) throws IOException {
		try (FileInputStream fi = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fi);
				FileOutputStream fo = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fo)) {
			dos.writeInt(102400);
			dos.writeInt(128);
			dos.flush();
			System.out.println(dis.readInt());
			System.out.println(dis.readInt());
		}
	}
}
