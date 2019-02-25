package tk.ddvudo.multiThread.MultiThreadFileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ThreadClass extends Thread {
	private File f;
	private String keyword;

	@Override
	public void run() {
		try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);) {
			String tmp;
			while (null != (tmp = br.readLine())) {
				if (tmp.indexOf(keyword) > -1) {
					System.out.println(f.getName()+"["+this.toString()+"]" + "--->" + tmp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ThreadClass(File f, String keyword) {
		super();
		this.f = f;
		this.keyword = keyword;
	}
}
