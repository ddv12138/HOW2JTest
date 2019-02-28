package tk.ddvudo.multiThread.LockObject;

public class SampleMain {

	public static void main(String[] args) {
		ThreadSafeStackUseLock<String> stack = new ThreadSafeStackUseLock<>();
		synchronized (stack) {
			for(int i=0;i<3;i++) {
				new Producer(stack,20).start();
			}
		}
		synchronized (stack) {
			for(int i=0;i<2;i++) {
				new Consumer(stack).start();
			}
		}
	}

}
