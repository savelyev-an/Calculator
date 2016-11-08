package com.innopolis.study.java2016.savelyev.lessons.lesson13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by User on 20.10.2016.
 */
public class SampleCallable {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<String> future2 = executorService.submit (()-> {
				Thread.sleep(1000);
				return "123";
			});
		Future<String> future = executorService.submit (()->"456"+"aaaa");
		Future<String> future3 = executorService.submit (Test1::ReturnHello);

		try {
			System.out.println("first res= "+future.get()) ;
			System.out.println(" second res="+future2.get() + " third result =" + future3.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Dfcz");
//		future.cancel();
		executorService.shutdown();
	}

}

class Test1 {
	static String ReturnHello() {return "Hello";}
}
