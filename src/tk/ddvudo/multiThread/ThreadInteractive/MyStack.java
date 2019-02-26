package tk.ddvudo.multiThread.ThreadInteractive;

import java.util.LinkedList;

public class MyStack {
	private LinkedList<Object> list = new LinkedList<>();
	
	public synchronized Object pull() {
		try {
			while(list.size() == 0) {
				this.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			this.notifyAll();
		}
		return list.removeLast();
	}
	
	public synchronized void push(Object obj) {
		try {
			while(list.size() >= 200) {
				this.wait();
			}
			list.addLast(obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			this.notifyAll();
		}
	}
	
	public synchronized int size() {
		return list.size();
	}
	
	public synchronized Object peek() {
		return list.getLast();
	}
}
