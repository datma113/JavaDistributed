package tuan1.bai3;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Add {
	private static Vector<Integer> list = new Vector<Integer>();

	public static void main(String[] args) {

		Runnable task = () -> {
			list.add(new Random().nextInt(1000));
		};

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) {
			service.submit(task);
		}

		service.shutdown();
		while (!service.isTerminated()) {
			// wait
		}
		System.out.println(list.size());
	}
}
