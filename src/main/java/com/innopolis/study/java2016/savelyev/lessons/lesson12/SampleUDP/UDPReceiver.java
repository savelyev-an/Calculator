package com.innopolis.study.java2016.savelyev.lessons.lesson12.SampleUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by User on 19.10.2016.
 */
public class UDPReceiver {
//	public static void main(String[] args) {
//		try (DatagramSocket datagramSocket=new DatagramSocket(3500);){
////			byte [] string =new byte [10];
////			DatagramPacket datagramPacket=new DatagramPacket();
////			datagramPacket= datagramSocket.receive(datagramPacket);
//
//		} catch (SocketException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(8080);
			while (true) {
				DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
				ds.receive(pack);
				System.out.println(new String(pack.getData(),0,pack.getLength()));
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
