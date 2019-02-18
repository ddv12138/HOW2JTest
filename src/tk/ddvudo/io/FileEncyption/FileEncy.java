package tk.ddvudo.io.FileEncyption;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileEncy {
	public static void main(String[] args) {
		File old = new File("./src/tk/ddvudo/FileEncyption/TestFile");
		File newFile = new File("./src/tk/ddvudo/FileEncyption/TestFileEncyption");
		File decodeFile = new File("./src/tk/ddvudo/FileEncyption/TestFileDecode");
		encodeFile(old, newFile);
		decodeFile(newFile, decodeFile);
	}
	public static void encodeFile(File old, File newFile) {
		if(!old.exists() || !old.isFile()) {
			return;
		}
		try {
			if(!old.exists()) {
				newFile.getParentFile().mkdirs();
			}
			newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		char[] charbuffer = new char[(int) old.length()];
		try(FileReader fr = new FileReader(old);FileWriter fw = new FileWriter(newFile)){
			fr.read(charbuffer);
			char[] charbufferEncyption = new char[charbuffer.length];
			for(int i=0;i<charbuffer.length;i++) {
				char c = charbuffer[i];
				char encyc = c;
				if((c>='0' && c<='8') || (c>='a' && c<'z' || c>='A' && c<'Z')) {
					encyc = (char) (c+1);
				}else if(c =='9') {
					encyc = '0';
				}else if(c =='z' || c =='Z') {
					if(c =='z') {
						encyc = 'a';
					}else {
						encyc = 'A';
					}
				}
				charbufferEncyption[i] = encyc;
			}
			fw.write(charbufferEncyption);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void decodeFile(File old, File newFile) {
		if(!old.exists() || !old.isFile()) {
			return;
		}
		try {
			if(!old.exists()) {
				newFile.getParentFile().mkdirs();
			}
			newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		char[] charbuffer = new char[(int) old.length()];
		try(FileReader fr = new FileReader(old);FileWriter fw = new FileWriter(newFile)){
			fr.read(charbuffer);
			char[] charbufferEncyption = new char[charbuffer.length];
			for(int i=0;i<charbuffer.length;i++) {
				char c = charbuffer[i];
				char encyc = c;
				if((c>'0' && c<='8') || (c>'a' && c<='z' || c>'A' && c<='Z')) {
					encyc = (char) (c-1);
				}else if(c =='0') {
					encyc = '9';
				}else if(c =='a' || c =='A') {
					if(c =='a') {
						encyc = 'z';
					}else {
						encyc = 'Z';
					}
				}
				charbufferEncyption[i] = encyc;
			}
			fw.write(charbufferEncyption);
		} catch (IOException e ) {
			e.printStackTrace();
		}
	}
}
