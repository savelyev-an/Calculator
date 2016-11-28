package tests;

import java.util.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by User on 28.11.2016.
 */
public class TestGC {


	private static List cache = new LinkedList();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNext()) {
				String command = scanner.nextLine();
				switch (command) {
					case "createCollectable": {
						createCollectableObject();
						System.out.println("Collectable created");
						break;
					}
					case "createLeakable": {
						createLeakable();
						System.out.println("Leakable created");
						break;
					}
					case "createThread": {
						createThread();
						System.out.println("Thread created");
						break;
					}
				}
			}
		}
	}

	private static void createThread() {
		Thread thread = new Thread(()-> {
			while (true) {
				for(int i=0; i<100_000;i++) {
					Random random = new Random();
					int j = random.nextInt();
					System.out.println(j);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}

	private static void createLeakable() {
		cache.add(createBigObject());
	}

	private static void createCollectableObject() {
		createBigObject();
	}

	private static Object createBigObject() {
		List<String> stringList = new LinkedList<>();
		final Random random = new Random();
		for (int i = 0; i < 10_000_000; i++) {
			stringList.add(random.nextInt() + "|" + i);
		}
		return stringList;
	}


}