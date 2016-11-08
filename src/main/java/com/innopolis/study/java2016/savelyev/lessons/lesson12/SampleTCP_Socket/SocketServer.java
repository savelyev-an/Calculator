package com.innopolis.study.java2016.savelyev.lessons.lesson12.SampleTCP_Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by User on 19.10.2016.
 */
public class SocketServer {
//public static void main(String[] args) {
//	System.out.println("Сервер стартовал");
//	try (ServerSocket ss=new ServerSocket(8080)){
//		System.out.println((ss.getLocalSocketAddress()));
////		while (true) {
//		Socket s = ss.accept();
//		Scanner scanner=  new Scanner(s.getInputStream());
//		while (scanner.hasNext()){
//			String string=scanner.nextLine();
//			System.out.println(scanner.nextLine());
//		}
////		}
//	} catch (IOException e) {
//		e.printStackTrace();
//	}

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8080);
			System.out.println(serverSocket.getInetAddress());
			Socket socket = serverSocket.accept();
			Scanner scanner = new Scanner(socket.getInputStream());
			System.out.println(scanner.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


