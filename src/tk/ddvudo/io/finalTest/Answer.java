package tk.ddvudo.io.finalTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Answer {
	public static void main(String... args) throws IOException {
		Answer.getInstance().fileFolderCopy(new File("./src/tk/ddvudo/io/finalTest/source/TestSource"),
				new File("./src/tk/ddvudo/io/finalTest/target"));
	}

	private static Answer answer = new Answer();

	public static Answer getInstance() {
		return answer;
	}

	private Answer() {
	}

	public boolean fileCopy(File source, File target) throws IOException {
		if (!source.exists()) {
			throw new IOException("源文件不存在");
		}
		FileCheck(target);
		try (FileInputStream fis = new FileInputStream(source);
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream(target);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			byte[] buffer = new byte[1 * 10240];
			while (bis.read(buffer) > 0) {
				bos.write(buffer);
			}
			bos.flush();
		}
		return true;
	}

	public boolean fileFolderCopy(File source, File target) throws IOException {
		if (!source.exists()) {
			throw new IOException("源文件不存在");
		}
		while (!source.isDirectory()) {
			source = source.getParentFile();
		}
		while (!target.isDirectory()) {
			target = target.getParentFile();
		}
		FileCheck(target);
		File[] list = source.listFiles();
		for (File f : list) {
			if (f.isDirectory()) {
				fileFolderCopy(f, new File(target, f.getName()));
			} else {
				fileCopy(f, new File(target, f.getName()));
			}
		}
		return false;
	}

	public boolean FileCheck(File f) throws IOException {
		if (!f.exists() || (f.exists() && f.isDirectory())) {
			f.getParentFile().mkdirs();
		}
		return f.createNewFile();
	}
}
