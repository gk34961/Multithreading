package threadPractice;

class Printer implements Runnable {
	static int counter = 1;
	int reminder;
	static Object lock = new Object();

	Printer(int reminder) {
		this.reminder = reminder;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (lock) {
				while (counter % 2 != reminder)
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				printer();
				lock.notifyAll();
			}
		}
	}

	public void printer() {
		System.out.println(Thread.currentThread().getName() + "  " + counter++);
	}

}

public class PrintEvenOdd {

	public static void main(String[] args) {
		Printer evenp = new Printer(0);
		Printer oddp = new Printer(1);
		Thread even = new Thread(evenp, "Even Thread");
		Thread odd = new Thread(oddp, "Odd Thread");

		even.start();
		odd.start();
	}

}
