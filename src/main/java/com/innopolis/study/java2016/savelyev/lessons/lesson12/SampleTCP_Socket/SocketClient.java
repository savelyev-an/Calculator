package com.innopolis.study.java2016.savelyev.lessons.lesson12.SampleTCP_Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by User on 19.10.2016.
 */
public class SocketClient {
//	public static void main(String[] args) {
//		System.out.println("Клиент отдал!");
//
//		try (Socket socket =new Socket("0.0.0.0", 8080)){
//			OutputStream outputStream = socket.getOutputStream();
//			for (int i = 1;i < 1000000;i++) {
//				outputStream.write(("Привет" + i).getBytes());
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8080);
			OutputStream outputStream = socket.getOutputStream();
			for (int i = 1;i < 10;i++) {
				outputStream.write(("Привет" + i+" ").getBytes());
			}

		} catch (IOException e) {


		}
	}

}

//public class ClientSocket {
//	public static void main(String[] args) {
//		try {
//			Socket socket = new Socket("127.0.0.1",8080);
//			OutputStream outputStream = socket.getOutputStream();
//			for (int i = 1;i < 1000000;i++) {
//				outputStream.write(("Привет" + i).getBytes());
//			}
//
//		} catch (IOException e) {
//
//
//		}
//	}
//}