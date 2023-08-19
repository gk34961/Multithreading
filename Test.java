package threadPractice;
public class Test {
  class Control {
    public  boolean flag = false;
  }
  final Control control = new Control();

  class T1 implements Runnable {
    @Override
    public void run() {
      while ( !control.flag ) {
    	  System.out.println("Inside t1 thread");
      }
    }
  }

  class T2 implements Runnable {
    @Override
    public void run() {
      control.flag =true;
    }
  }

  private void test() {
    T1 main = new T1();
    T2 help = new T2();

    new Thread(main).start();
    new Thread(help).start();
  }

  public static void main(String[] args) throws InterruptedException {
    try {
      Test test = new Test();
      test.test();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}