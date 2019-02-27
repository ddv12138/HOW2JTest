package tk.ddvudo.multiThread.ThreadInteractive;

public class SampleMain {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		synchronized (stack) {
			for(int i=0;i<3;i++) {
				new Producer(stack,200).start();
			}
		}
		synchronized (stack) {
			for(int i=0;i<2;i++) {
				new Consumer(stack).start();
			}
		}
	}

}
