package tuan1.bai2;

public class Task1 implements Runnable {
	private double number;

	public Task1(double number) {
		super();
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println(number + "::" + Thread.currentThread().getName());

		}

	}

}
