package threadPractice;

public class WaitChildforMainTJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread1.mt=Thread.currentThread();
		MyThread1 mt=new MyThread1();
		mt.start();
		mt.join();
		for(int i=0;i<10;i++) {
			System.out.println("MAIN THREAD");
			Thread.sleep(2000);
		}
	}

}

class MyThread1 extends Thread{
	static Thread mt;
	
	public void run() {
		try {
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			System.out.println("CHILD THREAD");
		}
	}
}
