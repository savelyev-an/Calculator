package Samples;

/**
 * Created by User on 18.11.2016.
 */
public class SampleThread999 {
	public synchronized void doSome() throws InterruptedException {
		doWait(1000);
	}

	void doWait(int k) throws InterruptedException {
		// если метод будет вызван вне syncro блока this, будет жопа: IllegalMonitorStateException
		this.wait(k);
	}

	public static void main(String[] args) throws InterruptedException {
		SampleThread999 s = new SampleThread999();
		s.wait(1000);
		Thread t = new Thread();
		t.yield();
	}

}
