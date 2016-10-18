package com.innopolis.study.java2016.savelyev.lessons.lesson5.Syncro3;

/**
 * Created by User on 08.10.2016.
 */
public class Timer extends Thread{
	MutableInteger timer_value;
	private int period; //милисекунд

	Timer (MutableInteger timer_value, int period) {
		this.period=period;
		this.timer_value= timer_value;
	}

	public void run () {
		while (!isInterrupted()) {
			try {
				Thread.sleep(period);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (timer_value) {
				int cur_timer = timer_value.getValue() + 1;
				timer_value.setValue(cur_timer);
				System.out.println("Время = " + cur_timer + " секунд");
				try {
					timer_value.notifyAll();
				} catch (IllegalMonitorStateException e) {
					System.out.println("Нет потоков привязаных к таймеру!");
				}
			}
		}
	}

}
