package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Socket框架:MINA 客户端
 * 
 * @author 24470
 *
 */
public class Client {
	public static void main(String[] args) {
		/*
		 * 过程： 1:创建使用UDP通讯的socket 2:准备数据 3:打包 创建包的同时，填地址，放数据 4:通过socket发送
		 */
		try {
			// 1.java.net.DatagramSocket
			DatagramSocket socket = new DatagramSocket();

			// 2
			String str = "你好，服务器！";
			byte[] data = str.getBytes("UTF-8");

			// 3
			// 服务端的IP
			InetAddress address = InetAddress.getByName("localhost");
			// 服务端的端口
			int port = 8088;
			// 打包
			DatagramPacket packet = new DatagramPacket(data, data.length,
					address, port);
			// 4
			socket.send(packet);

			/*
			 * 等待客户端回复
			 */
			// 2.能存下接收数据用的字节数组
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);

			// 3
			socket.receive(packet);

			// 4
			String message = new String(packet.getData(), 0,
					packet.getLength(), "UTF-8");
			System.out.println("服务端说:" + message);

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
