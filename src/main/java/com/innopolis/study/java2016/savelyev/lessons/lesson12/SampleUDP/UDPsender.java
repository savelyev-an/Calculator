package com.innopolis.study.java2016.savelyev.lessons.lesson12.SampleUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
//http://crypto.pp.ua/2010/06/datagrammy-i-protokol-udp-v-java/
/**
 * Created by User on 19.10.2016.
 */
public class UDPsender {
	public static void main(String[] args) {
		try(DatagramSocket ds = new DatagramSocket();){
			byte[] data = "Привет".getBytes();
			InetAddress addr = InetAddress.getByName("localhost");
			DatagramPacket pack =
					new DatagramPacket(data, data.length, addr, 8080);
			ds.send(pack);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

//
//	public static void main(String[] args) {
//		try (DatagramSocket datagramSocket=new DatagramSocket(3500);){
//			byte [] string ={'q','w','e'};
//			DatagramPacket datagramPacket= new DatagramPacket(string,3);
//			datagramSocket.send(datagramPacket);
//
//		} catch (SocketException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//
//	}
}
