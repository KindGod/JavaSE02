package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务端
 * 
 * @author 24470
 *
 */
public class Server {
	public static void main(String[] args) {
		/*
		 * 收数据过程: 1:创建Socket 2:准备一个接收数据用的包 3:将包交给Socket用于接收客户端发送过来 的数据
		 * 当接收后，包就有了很多变化: 1:包中就有客户端发送过来的数据了 2:包也知道实际发送过来的数据量有多少
		 * 3:包也知道了客户端的地址信息(便于我们 通过改地址回复客户端) 4:取数据
		 */
		try {
			// 1.服务端这边要固定端口号，以便客户端连接
			DatagramSocket socket = new DatagramSocket(8088);

			// 2.能存下接收数据用的字节数组
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);

			// 3
			socket.receive(packet);

			// 4
			String message = new String(packet.getData(), 0,
					packet.getLength(), "UTF-8");
			System.out.println("客户端说:" + message);

			/*
			 * 回复客户端
			 */

			// 2
			String str = "你好，客户端！";
			data = str.getBytes("UTF-8");

			// 3
			// 客户端的IP
			InetAddress address = packet.getAddress();
			// 客户端的端口
			int port = packet.getPort();
			// 打包
			packet = new DatagramPacket(data, data.length, address, port);

			// 4
			socket.send(packet);

			/*
			 * 等待客户端回复
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
