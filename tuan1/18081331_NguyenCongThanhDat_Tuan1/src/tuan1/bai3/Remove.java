package tuan1.bai3;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Remove {
	private static Vector<Integer> list = new Vector<Integer>();
	public static void main(String[] args) {
		for (int i = 0; i <1000; i++) {
			list.add(10);
		}
		@SuppressWarnings("deprecation")
		Runnable taskRemove = () -> {
				list.remove(new Integer(10));	
		};
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) { 
			service.submit(taskRemove);
		}
		service.shutdown();
		while (!service.isTerminated()) {
			//wait
		}
		System.out.println(list.size());
	}
}
