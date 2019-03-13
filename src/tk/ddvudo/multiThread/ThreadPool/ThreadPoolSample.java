package tk.ddvudo.multiThread.ThreadPool;

public class ThreadPoolSample {

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                }
            };

            pool.addTask(task);

            try {
                Thread.sleep(1000 / i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
