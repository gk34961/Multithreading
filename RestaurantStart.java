package threadPractice;

class Restaurant implements Runnable {

	static String key="Lock";
	@Override
	public void run() {
		System.out.println("In a Restaurant " + Thread.currentThread().getName());
		kitchen();
	}

	public void kitchen() {
		System.out.println("In a Kitchen "+Thread.currentThread().getName());
		synchronized(key) {
			System.out.println("Food started cooking for "+Thread.currentThread().getName());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Done for "+Thread.currentThread().getName());
		}
	}

}

public class RestaurantStart {

	public static void main(String[] args) {
		Restaurant restaurant1 = new Restaurant();
		Thread thread1 = new Thread(restaurant1);
		thread1.start();

		Restaurant restaurant2 = new Restaurant();
		Thread thread2 = new Thread(restaurant2);
		thread2.start();

		Restaurant restaurant3 = new Restaurant();
		Thread thread3 = new Thread(restaurant3);
		thread3.start();
	}

}
