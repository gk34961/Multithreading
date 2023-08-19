package threadPractice;

public class CreatingThread {

	public static void main(String[] args) {
		System.out.println("Thread Started");
			Task task1=new Task();
			//Task task2=new Task();
		System.out.println("Thread End");
	}

}

class Task extends Thread{
	
	private static int count;
	private int id;
	
	Task(){
		id=++count;
		this.start();
	}
	public void run(){
		for(int i=0;i<10;i++) {
			System.out.println(id+" Running ="+i+" "+Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
