package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Socket���:MINA �ͻ���
 * 
 * @author 24470
 *
 */
public class Client {
	public static void main(String[] args) {
		/*
		 * ���̣� 1:����ʹ��UDPͨѶ��socket 2:׼������ 3:��� ��������ͬʱ�����ַ�������� 4:ͨ��socket����
		 */
		try {
			// 1.java.net.DatagramSocket
			DatagramSocket socket = new DatagramSocket();

			// 2
			String str = "��ã���������";
			byte[] data = str.getBytes("UTF-8");

			// 3
			// ����˵�IP
			InetAddress address = InetAddress.getByName("localhost");
			// ����˵Ķ˿�
			int port = 8088;
			// ���
			DatagramPacket packet = new DatagramPacket(data, data.length,
					address, port);
			// 4
			socket.send(packet);

			/*
			 * �ȴ��ͻ��˻ظ�
			 */
			// 2.�ܴ��½��������õ��ֽ�����
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);

			// 3
			socket.receive(packet);

			// 4
			String message = new String(packet.getData(), 0,
					packet.getLength(), "UTF-8");
			System.out.println("�����˵:" + message);

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
