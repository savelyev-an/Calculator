package Samples;


import java.util.Calendar;
import java.util.Date;

/**
 * Created by User on 20.11.2016.
 */
public class SampleVolatile {
	static ThreadGroup threadGroup;
	volatile boolean ready=false;
	int a;


	MyThread1 P1 = new MyThread1( threadGroup, "p1");
	MyThread2 P2 = new MyThread2( threadGroup, "p2");

	public static void main(String[] args) {
		threadGroup= Thread.currentThread().getThreadGroup();
		Date date0 = Calendar.getInstance().getTime();
		Date date = null;
		int count=0;
		System.out.println(date);
		while (true) {

			for (int i=1; i<100;i++) {
				SampleVolatile s = new SampleVolatile();
//			System.out.println("новый ");

				s.P1.start();
				s.P2.start();
			}

			date = Calendar.getInstance().getTime();
			if (date.getSeconds()==(date0.getSeconds())){
				count++;
			} else {
				System.out.println(count);
				count=0;
				date0=date;
			}


			threadGroup.interrupt();
		}
	}

	class MyThread1 extends Thread {
		public MyThread1(ThreadGroup group, String name) {
			super(group, name);
		}

		@Override
		public void run (){
			a=41;
			a=42;
			ready=true;
			a=43;
		}
	}

	class MyThread2 extends Thread {
		public MyThread2(ThreadGroup group, String name) {
			super(group, name);
		}

		@Override
		public void run(){
			while  (!(a==43 && !ready) && !isInterrupted());
				if (!isInterrupted())System.out.println("прокинулся!");
//			if (a==43) System.out.println(" сорок три!");
//			else System.out.println("не 42");
		}
	}

}

