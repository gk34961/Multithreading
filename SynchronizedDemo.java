package threadPractice;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d=new Display();
		MyThread2 t1=new MyThread2(d,"Gaurav");
		MyThread2 t2=new MyThread2(d,"Yuvraj");
		
		t1.start();
		t2.start();
	}

}
class MyThread2 extends Thread{
	Display d;
	String name;
	
	MyThread2(Display d,String name) {
		this.d=d;
		this.name=name;
	}
	
	public void run() {
		d.display(name);
	}
}
class Display{
	ReentrantLock l=new ReentrantLock();
	public  void display(String name) {
		l.lock();
		for(int i=0;i<10;i++) {
			System.out.print("Good morning: ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
		l.unlock();
	}
}
