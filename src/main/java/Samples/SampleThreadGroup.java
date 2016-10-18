package Samples;

/**
 * Created by User on 13.10.2016.
 */

public class SampleThreadGroup extends Thread {

	// Отдельная группа, в которой будут
	// находиться все потоки ThreadTest
	public final static ThreadGroup GROUP = new ThreadGroup("Daemon demo");

	public void run() {
		// Начинаем обратный отсчет
		for (int i = 1; i < 20; i++) {
			Thread t2 = new Thread2(GROUP, "Thread " + i);
			t2.start();
		}
			Thread[] threads = new Thread[19];
			GROUP.enumerate(threads);
			for (Thread t1: threads) {
				try {
					if (t1!=null) {
					System.out.println(this.getName() +" join to "+t1.getName());
					t1.join();}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		System.out.println("Главный поток - всё !");
	}
	public static void main(String args[]) {
		Thread t1 = new SampleThreadGroup();
		t1.start();
	}
}

class Thread2 extends Thread {
	public Thread2(ThreadGroup group, String name) {
		super(group, name);
		try {
			this.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Конструктор ! "+ name);
	}

	public void run() {
		System.out.println("Сработал run "+this.getName());
		while (!isInterrupted()) {
			long rnd=(long) (Math.random()*100);
//			System.out.println( this.getName() + " Жив ! "+rnd); //проверить какие значения выпадают
			if (rnd==50) {
//				System.out.println(" Всем пизда !!!!!!!!!!!!!!");
//				this.getThreadGroup().interrupt(); // кикнуть все потоки группы
				System.out.println(this.getName()+" - поток interapted");
				this.interrupt();
			}
		}
	}
}

