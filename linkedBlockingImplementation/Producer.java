import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
	private String name;
	private LinkedBlockingQueue<String> queue;
	private static boolean finished = false;
	private int produced;
	
	public Producer(String name, LinkedBlockingQueue<String> queue) {
		this.name = name;
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			String producedS = Double.toString(Math.random());
			try {
				queue.put(producedS);
			}	
			catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}	
			if ((i + 1) % 100 == 0) {
				produced = i + 1;
				System.out.println(name + ": " + produced + " events produced");
			}
			finished = true;
			
		}
		System.out.println("Summary: " + name + " produces " + produced + " events.");
		
	}
	public static boolean isFinished() {
		return finished;
	}

}
