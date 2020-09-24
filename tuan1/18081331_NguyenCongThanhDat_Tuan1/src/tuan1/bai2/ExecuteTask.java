package tuan1.bai2;

public class ExecuteTask {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread( new Task("task 1",10) );
		Thread t2 = new Thread( new Task("task 2",10) );
		Thread t3 = new Thread( new Task("task 3",10) );
		Thread t4 = new Thread( new Task("task 4",10) );
		Thread td = new Thread( new Task1(20.3));
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " +Thread.currentThread().getName());
			if( i == 3 ) {
				t1.start();
				t1.join();
			}
			if (i == 4) {
				t2.start();
				t2.join();
				t4.start();
				t4.join();
				
			}
			if( i == 6 ) {		
				t3.start();
				t3.join();
				td.start();
			}
			if( i == 7 ) {
				td.join();
			}
		}

		System.out.println("finished");
	}
}
