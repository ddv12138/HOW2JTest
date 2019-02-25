package tk.ddvudo.multiThread.ThreadState;

public class Testskill extends Thread{
	private Integer TimesCount = 0;
	@Override
	public void run() {
		while(true) {
			try {
				if(TimesCount < 3) {
					System.out.println("doing skill");
					Thread.sleep(1000);
					TimesCount++;
				}else {
					System.out.println("reloading...");
					Thread.sleep(5000);
					TimesCount = 0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
