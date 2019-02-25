package tk.ddvudo.multiThread.MultiThreadFileSearch;

import java.io.File;

public class ThreadTest {

	public static void main(String[] args) {
		File rootDir = new File("./src");
		dirFind(rootDir, "public");
	}

	public static void dirFind(File f, String keyword) {
		if (f.isDirectory()) {
			File[] list = f.listFiles();
			for (File tmp : list) {
				if (tmp.isDirectory()) {
					dirFind(tmp, keyword);
				} else {
					new ThreadClass(tmp, keyword).start();
				}
			}
		} else {
			new ThreadClass(f, keyword).start();
		}
	}
}
