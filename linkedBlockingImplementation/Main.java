import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	
	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(100);
		
		Producer producer = new Producer("Producer", queue);
		
		Consumer consumer1 = new Consumer("Consumer 1", queue);
		Consumer consumer2 = new Consumer("Consumer 2", queue);
		Consumer consumer3 = new Consumer("Consumer 3", queue);
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(producer);
		
		executor.execute(consumer1);
		executor.execute(consumer2);
		executor.execute(consumer3);
		
		executor.shutdown();

	}

}
