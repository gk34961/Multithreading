package threadPractice;

public class PracticeThreadJoinM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadDemo t=new MyThreadDemo();
		t.start();
		try {
			t.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<10000;i++) 
			System.out.println("MAIN THREAD");
	}
}

class MyThreadDemo extends Thread{
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println("CHILD THREAD");
		}
	}
}
