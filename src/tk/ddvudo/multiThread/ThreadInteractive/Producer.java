package tk.ddvudo.multiThread.ThreadInteractive;

import java.util.Random;

public class Producer extends Thread {
	private MyStack stack;
	private int size;
	public String getRandomString(int length) {
		String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789`~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(str.length()-1);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	public Producer(MyStack stack,int size) {
		super();
		this.stack = stack;
		this.size = size;
	}
	@Override
	public void run() {
		while(true) {
			stack.push(getRandomString(size));
		}
	}
}