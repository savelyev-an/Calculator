package com.innopolis.study.java2016.savelyev.test.lessons.lesson4.HomeWork;
// http://prologistic.com.ua/java-lock-teoriya-i-primer-ispol-zovaniya-concurrency-lock.html



		import java.util.concurrent.TimeUnit;
		import java.util.concurrent.locks.Lock;
		import java.util.concurrent.locks.ReentrantLock;

// класс для работы с Lock API. Переписан с приведенной выше программы,
// но уже без использования ключевого слова synchronized
public class ConcurrencyLockExample extends Thread {

	private Resource resource;
	private Lock lock;
	private String name;

	public ConcurrencyLockExample(Resource r, String name){
		this.resource = r;
		this.lock = new ReentrantLock();
		this.name = name;
	}

	public String getname (){return this.name;}

	@Override
	public void run() {
		try {
			// лочим на 10 секунд
			if(lock.tryLock(10, TimeUnit.SECONDS)){
				for (int i =0; i<20;i++) {
					System.out.println("Поток: "+ name + "шаг "+ i+" DoSomething");
					//resource.doSomething();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//убираем лок
			lock.unlock();
		}
		// Для логгирования не требуется потокобезопасность
		//resource.doLogging();
		System.out.println("Поток: "+ name + " DoLogging");
	}

	public static void main(String[] args) {
		Resource r1= new Resource();
		Thread  t1 = new ConcurrencyLockExample(r1, "thread-1");
		Thread t2 = new ConcurrencyLockExample(r1, "thread-2");

		t1.start();
		t2.start ();
	}
}

class Resource {

	void doSomething(){
		// пусть здесь происходит работа с базой данных
		System.out.println(" -> doSomething");
	}

	void doLogging(){
		System.out.println(" -> doLogging");
		// потокобезопасность для логгирования нам не требуется
	}
}