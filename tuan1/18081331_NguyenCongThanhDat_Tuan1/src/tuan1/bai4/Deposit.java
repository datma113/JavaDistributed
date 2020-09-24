package tuan1.bai4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Deposit {
	private static Account myAccount = new Account("Dat Ma XM");

	public static void main(String[] args) {

		Runnable depositTask = () -> {
			synchronized (myAccount) {
				myAccount.deposit(100);
			}
		
		};

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 1000; i++) {
			service.submit(depositTask);
		}
		service.shutdown();
		while (!service.isTerminated()) {
			//wait
		}
		System.out.println(myAccount.getBalance());
	}

}
