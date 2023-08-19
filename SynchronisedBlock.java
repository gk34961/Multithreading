package threadPractice;

public class SynchronisedBlock {

	public static void main(String[] args) {
		Display1 d1 = new Display1();
		Display1 d2 = new Display1();
		MyThread3 t1 = new MyThread3(d1, "Gaurav");
		MyThread3 t2 = new MyThread3(d2, "DHONI");
		t1.start();
		t2.start();
	}

}

class MyThread3 extends Thread {
	Display1 d;
	String name;

	MyThread3(Display1 d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {
		d.wish(name);
	}
}

class Display1 {
	public  void wish(String name) {
		synchronized (Display1.class) {
			for (int i = 0; i < 10; i++) {
				System.out.print("Good morning   :");
				System.out.println(Thread.activeCount());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name);
			}
		}
	}
}
