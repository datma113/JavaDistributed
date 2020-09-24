package tuan1.bai2;

public class Task implements Runnable {
	private String name;
	private int counter;

	public Task(String name, int counter) {
		super();
		this.name = name;
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < counter; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("task " + name + " :" + i + "::" + Thread.currentThread().getName());

		}

	}

}
