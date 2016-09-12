package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * �����
 * 
 * @author 24470
 *
 */
public class Server {
	public static void main(String[] args) {
		/*
		 * �����ݹ���: 1:����Socket 2:׼��һ�����������õİ� 3:��������Socket���ڽ��տͻ��˷��͹��� ������
		 * �����պ󣬰������˺ܶ�仯: 1:���о��пͻ��˷��͹����������� 2:��Ҳ֪��ʵ�ʷ��͹������������ж���
		 * 3:��Ҳ֪���˿ͻ��˵ĵ�ַ��Ϣ(�������� ͨ���ĵ�ַ�ظ��ͻ���) 4:ȡ����
		 */
		try {
			// 1.��������Ҫ�̶��˿ںţ��Ա�ͻ�������
			DatagramSocket socket = new DatagramSocket(8088);

			// 2.�ܴ��½��������õ��ֽ�����
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);

			// 3
			socket.receive(packet);

			// 4
			String message = new String(packet.getData(), 0,
					packet.getLength(), "UTF-8");
			System.out.println("�ͻ���˵:" + message);

			/*
			 * �ظ��ͻ���
			 */

			// 2
			String str = "��ã��ͻ��ˣ�";
			data = str.getBytes("UTF-8");

			// 3
			// �ͻ��˵�IP
			InetAddress address = packet.getAddress();
			// �ͻ��˵Ķ˿�
			int port = packet.getPort();
			// ���
			packet = new DatagramPacket(data, data.length, address, port);

			// 4
			socket.send(packet);

			/*
			 * �ȴ��ͻ��˻ظ�
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
