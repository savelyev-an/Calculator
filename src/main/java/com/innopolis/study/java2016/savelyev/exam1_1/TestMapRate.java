package com.innopolis.study.java2016.savelyev.exam1_1;

/**
 * Created by User on 09.10.2016.
 */
public class TestMapRate extends Thread {
	public static void main(String[] args) {
		String A="Мама";
		String B= "Ма";
		System.out.println(A.contains(B));

		int N='Д';

		System.out.println(N>'А');
		System.out.println(N<'Я');

	}



}

//		package Homeworks.resource;
//
//import Homeworks.SuperCache;
//import Homeworks.exeptions.DublicateKeyExeption;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
//	/**
//	 * Created by innopolis on 09.10.16.
//	 */
//	public class FileResource extends Thread {
//		private SuperCache superCache;
//		private String fileName;
//
//		public FileResource(SuperCache superCache, String fileName){
//			this.superCache=superCache;
//			this.fileName = fileName;
//			superCache.addWorkingResource();
//			this.start();
//		}
//
//		@Override
//		public void run() {
//			try (FileInputStream fileInputStream = new FileInputStream(fileName)){
//				Scanner scanner = new Scanner(fileInputStream);
//				String key, value;
//				while (scanner.hasNextLine()&&!isInterrupted()){
//					key=scanner.nextLine();
//					if(scanner.hasNextLine()){
//						value=scanner.nextLine();
//					}else{
//						throw new IOException("Не хватает значения для ключа");
//					}
//					superCache.add(key, value);
//				}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (DublicateKeyExeption dublicateKeyExeption) {
//				dublicateKeyExeption.printStackTrace();
//			}
//			finally {
//				superCache.takeWorkingRecourse();
//				if(superCache.getCountOfWorkingResources()>0){
//					synchronized (superCache.getEndMarker()){
//						superCache.getEndMarker().notifyAll();
//					}
//				}
//			}
//		}
//	}
//
//		super.run();
//}
