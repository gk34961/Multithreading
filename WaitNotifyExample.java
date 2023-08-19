package threadPractice;

public class WaitNotifyExample {

	public static void main(String[] args) throws InterruptedException {
		ThreadB b=new ThreadB();
		b.start();
		synchronized(b) {
			System.out.println("Main thread trying to call child method");
			b.wait();
			System.out.println("Main thread got notifiation");
			System.out.println(b.count);
		}
		
	}
}

class ThreadB extends Thread{
	int count =0;
	public void run() {
		synchronized(this) {
			System.out.println("Child thread started calculation");
			for(int i=0;i<=100;i++)
				count=count+i;
			System.out.println("Child thread trying to give notification");
			this.notify();
		}
	}
}