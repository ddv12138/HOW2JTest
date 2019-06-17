package tk.ddvudo.multiThread.DeadLock;

public class DeadLockTest {
    public static void main(String... args) {
        Resource a = new Resource("res-a");
        Resource b = new Resource("res-b");
        Resource c = new Resource("res-c");
        Thread t1 = new Thread(() -> {
            synchronized (a) {
                System.out.println(a.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println(b.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (c) {
                        System.out.println(c.getName());
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (b) {
                System.out.println(b.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (c) {
                    System.out.println(c.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (a) {
                        System.out.println(a.getName());
                    }
                }
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (c) {
                System.out.println(c.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a) {
                    System.out.println(a.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (b) {
                        System.out.println(a.getName());
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
