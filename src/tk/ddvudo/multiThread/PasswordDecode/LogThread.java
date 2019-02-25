package tk.ddvudo.multiThread.PasswordDecode;

import java.util.ArrayList;

public class LogThread extends Thread{
	DecodeThread dt;
	ArrayList<String> diff = new ArrayList<>();
	public void run() {
		try {
			while(true) {
				synchronized (dt.getTried()) {
					ArrayList<String> list = (ArrayList<String>) dt.getTried();
					if(null != list) {
						for(String s :list) {
							if(!diff.contains(s)) {
								diff.add(s);
								System.out.println("tried--->"+s);
							}
						}
					}
				}
//				ArrayList<String> list = new ArrayList<>(dt.getTried());
//				if(null != list) {
//					for(String s :list) {
//						if(!diff.contains(s)) {
//							diff.add(s);
//							System.out.println("tried--->"+s);
//						}
//					}
//				}
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public LogThread(DecodeThread dt) {
		super();
		this.dt = dt;
	}
}
