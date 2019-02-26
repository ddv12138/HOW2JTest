package tk.ddvudo.multiThread.ThreadInteractive;

public class NumClass {
	int hp = 1000;

	public int modifyHP(int i) {
		return this.hp += i;
	}

	public int getHP() {
		return this.hp;
	}

	public static void main(String... args) {
		System.out.println(Character.getNumericValue('b'));
		NumClass nc = new NumClass();
		for(int i=0;i<2;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						synchronized (nc) {
							while (nc.getHP() >= 1000) {
								try {
									nc.wait();
									nc.notifyAll();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							nc.modifyHP(1);
							nc.notifyAll();
							System.out.println(Thread.currentThread().getName()+"--add-->" + nc.getHP());
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}).start();
		}
		for(int i=0;i<5;i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						synchronized (nc) {
							while(nc.getHP()<=0) {
								try {
									nc.notifyAll();
									nc.wait();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							nc.modifyHP(-1);
							System.out.println(Thread.currentThread().getName()+"--minus-->" + nc.hp);
							try {
								nc.notifyAll();
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}).start();
		}
	}
}
