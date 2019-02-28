package tk.ddvudo.multiThread.LockObject;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tk.ddvudo.multiThread.DeadLock.Resource;

public class DeadLockTest {
	public static void main(String... args) {
		Resource a = new Resource("res-a");
		Resource b = new Resource("res-b");
		Resource c = new Resource("res-c");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Lock lock = new ReentrantLock();
				System.out.println(a.getName());
				try {
					if (lock.tryLock(1, TimeUnit.SECONDS)) {
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(b.getName());
				try {
					if (lock.tryLock(1, TimeUnit.SECONDS)) {
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					if (lock.tryLock(1, TimeUnit.SECONDS)) {
						System.out.println(c.getName());
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Lock lock = new ReentrantLock();
				System.out.println(b.getName());
				try {
					if (lock.tryLock(1, TimeUnit.SECONDS)) {
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(c.getName());
				try {
					if (lock.tryLock(1, TimeUnit.SECONDS)) {
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(a.getName());
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				Lock lock = new ReentrantLock();
				System.out.println(c.getName());
				try {
					if (lock.tryLock(1, TimeUnit.SECONDS)) {
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(a.getName());
				try {
					if (lock.tryLock(1, TimeUnit.SECONDS)) {
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(a.getName());
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}
}
