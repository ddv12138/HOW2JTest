package tk.ddvudo.multiThread.ThreadInteractive;

public class Consumer extends Thread{
	MyStack stack;

	public Consumer(MyStack stack) {
		super();
		this.stack = stack;
	}
	@Override
	public void run() {
		while(null != stack) {
			System.out.println(stack.pull());
		}
	}
}
