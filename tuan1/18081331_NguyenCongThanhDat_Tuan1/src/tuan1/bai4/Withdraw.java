package tuan1.bai4;


import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Withdraw {
	private static Account myAccount = new Account("Dat Ma XM");
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ArrayList<Future<Double>> l = new ArrayList<Future<Double>>();
		Callable<Double> withdrawTask = () -> {	
			return myAccount.withdraw(100);
		};
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			Future<Double> f = service.submit(withdrawTask);
			l.add(f);
			
		}
		service.shutdown();
		while (!service.isTerminated()) {
			//wait
		}
		double money = 0.0;
		for (Future<Double> x : l) {
			money += x.get();
		}
		System.out.println(money);
		System.out.println("balance: " + myAccount.getBalance());
	}
}
