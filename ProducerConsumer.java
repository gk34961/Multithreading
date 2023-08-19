package threadPractice;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	public static void main(String ar[]) {
		Object key = new Object();
		Queue<Integer> queue = new LinkedList<Integer>();
		int size = 10;

		Thread Producer = new Thread(new Runnable() {

			@Override
			public void run() {
				int count = 0;
				while (true) {
					synchronized (key) {
						try {
							while (queue.size() == size)
								key.wait();
							
							queue.offer(count++);
							key.notifyAll();
							
							Thread.sleep(1000);
							System.out.println("MOMO PRODUCER, PLATE SIZE " + queue.size());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
			}

		});

		Thread Consumer = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					synchronized (key) {
						try {
							while (queue.size() == 0)
								key.wait();
							queue.poll();
							key.notifyAll();
							
							Thread.sleep(800);
							System.out.println("MOMO CONSUMED, PLATE SIZE " + queue.size());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
			}

		});

		Producer.start();
		Consumer.start();

	}
}
