package tk.ddvudo.multiThread.AtomAccess;

import java.util.concurrent.atomic.AtomicInteger;

public class NumClass {
	private AtomicInteger hp = new AtomicInteger(1000);

	public Integer modifyHP(int i) {
		if((this.hp.get()<1000 && i>0)||(this.hp.get()>0 && i<0)) {
			return this.hp.addAndGet(i);
		}else {
			return this.getHP();
		}
	}

	public Integer getHP() {
		return this.hp.get();

	}

	public static void main(String... args) {
		NumClass nc = new NumClass();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						if(nc.getHP() <1000) {
							nc.modifyHP(1);
							System.out.println(Thread.currentThread().getName() + "--add-->" + nc.getHP());
						}else {
							System.out.println(Thread.currentThread().getName() + "--add------>" + nc.getHP());
						}
					}
				}
			}).start();
		}
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						if(nc.getHP() >0) {
							nc.modifyHP(-1);
							System.out.println(Thread.currentThread().getName() + "--minus-->" + nc.getHP());
						}
					}
				}
			}).start();
		}
	}
}
