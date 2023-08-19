package threadPractice;

public class PracticeThreadYieldM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread();
		mt.start();
		for (int i = 0; i < 10; i++)
			System.out.println("Main Thread");
	}

}

class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread");
			Thread.yield();
		}
	}
}

/*
  In the above program if we are commenting yield then both thread will be executed simultaneously and
  we can't expect which thread will complete 1st.
  
  if we are not commenting yield then child thread always call yield method because of that main 
  thread will get a chance more number of time and the chance of competing main thread 1st is high
  
*/

