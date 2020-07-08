import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;

public class Consumer implements Runnable {
	
	private String name;
	private LinkedBlockingQueue<String> queue;
	private int consumed = 0;
	private String producedE;
	private Random random;
	
	public Consumer(String name, LinkedBlockingQueue<String> queue) {
		this.name = name;
		this.queue = queue;
		random = new Random();
	}
	
	public void run() {
		
		while (!(queue.isEmpty() && Producer.isFinished())) {
			consume();
			if (consumed > 0 && consumed % 100 == 0) {
				System.out.println(name + ": " + consumed + " events consumed");
			}
		}
		System.out.println("Summary: " + name + " consumes " + consumed + " events.");
	}

	private void consume() {
		try {
			producedE = queue.poll(10, TimeUnit.MILLISECONDS);
			if (producedE != null) {
				consumed++;
			}
			int sleepT = random.nextInt(9) + 1;
			Thread.sleep(sleepT);
		} 
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}

	}

}
