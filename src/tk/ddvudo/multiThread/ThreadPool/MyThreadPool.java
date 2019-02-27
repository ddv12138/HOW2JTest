package tk.ddvudo.multiThread.ThreadPool;

import java.util.LinkedList;

public class MyThreadPool {
	int poolSize;
	LinkedList<Runnable> initThread = new LinkedList<>();
	public MyThreadPool(int poolSize) {
		super();
		this.poolSize = poolSize;
		for(int i=0;i<poolSize;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					synchronized (initThread) {
						try {
							Runnable task;
							while(null == initThread || initThread.size() == 0 || initThread.isEmpty()) {
								initThread.notifyAll();
								initThread.wait();
							}
							initThread.notifyAll();
							task = initThread.removeLast();
							System.out.print(Thread.currentThread().getName()+"--ing...");
							task.run();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			},"Thread-"+i).start();
		}
	}
	
	public Boolean addTask(Runnable r) {
		synchronized (initThread) {
			return this.initThread.add(r);
		}
	}
}
