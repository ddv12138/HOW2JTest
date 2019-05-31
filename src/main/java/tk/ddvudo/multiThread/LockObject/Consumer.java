package tk.ddvudo.multiThread.LockObject;

public class Consumer extends Thread {
    ThreadSafeStackUseLock<String> stack;

    public Consumer(ThreadSafeStackUseLock<String> stack) {
        super();
        this.stack = stack;
    }

    @Override
    public void run() {
        while (null != stack) {
            System.out.println(stack.pull());
        }
    }
}
