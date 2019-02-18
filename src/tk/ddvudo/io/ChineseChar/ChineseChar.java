package tk.ddvudo.io.ChineseChar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class ChineseChar {
	public static void main(String[] args) {
		String str = "用UTF-8保存的文件前面有标识符";
		byte[] oldbytes = str.getBytes(Charset.forName("UTF-8"));
		for(byte b:oldbytes) {
			System.out.print(Integer.toHexString(Byte.toUnsignedInt(b))+"|");
		}
		System.out.print("\r\n");
		File f = new File("./src/tk/ddvudo/ChineseChar/TestFile");
		try(FileInputStream fi = new FileInputStream(f)){
			byte[] filebytes = new byte[(int) f.length()];
			fi.read(filebytes);
			for(byte b :filebytes) {
				System.out.print(Integer.toHexString(Byte.toUnsignedInt(b))+"|");
			}
			System.out.print("\r\n");
			filebytes = removeUTF_8_BOM(filebytes);
			for(byte b :filebytes) {
				System.out.print(Integer.toHexString(Byte.toUnsignedInt(b))+"|");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static byte[] removeUTF_8_BOM(byte... bytes) {
		byte[] BOM = new byte[] {(byte) 0xef,(byte) 0xbf,(byte) 0xbb};
		return Arrays.copyOfRange(bytes, BOM.length, bytes.length);
	}
	@SuppressWarnings("unused")
	private static void replacebyte(byte[] bytes, byte b) {
		for(int i=0;i<bytes.length;i++) {
			if(bytes[i] == b) {
				bytes[i] = 1;
				return;
			}
		}
	}
	public static void getChar(int... arr) throws UnsupportedEncodingException {
		byte b[]=new byte[arr.length];
		for(int i=0;i<arr.length;i++) {
			b[i] = (byte)arr[i];
		}
		String str=new String(b,"UTF-8");
		System.out.println("E5 B1 8C 对应的字符是："+str);
	}
}
