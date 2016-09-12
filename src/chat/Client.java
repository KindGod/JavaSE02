 package chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * ipconfig
 * 
 * /sbin/ifconfig �����ҿͻ���
 * 
 * @author 24470
 *
 */
public class Client {
	/*
	 * �����ڿͻ��˵�Socket�����������ӷ���˵� ServerSocket�������˽���ͨѶ��
	 */
	private Socket socket;

	/*
	 * ���췽����������ʼ���ͻ���
	 */
	public Client() throws Exception {
		try {
			/*
			 * ����Socketʱͨ��Ҫ������������ 1��Զ�̼����IP��ַ 2�������Ӧ�ó�������ķ���˿�
			 * �����Ĺ��̾������ӵĹ��̣�ֻ�������� ���������ӲŻᴴ���ɹ���������׳��쳣��
			 */
			socket = new Socket("localhost", 8088 // localhostΪip��ַ
			);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * �ͻ��˿�ʼ�����ķ���
	 */
	public void start() throws Exception {
		try {
			/*
			 * ����һ���̣߳��������շ���� ���͹�������Ϣ
			 */
			GetMessageHandler handler = new GetMessageHandler();
			Thread t = new Thread(handler);
			t.start();

			/*
			 * ����Scanner���ڻ�ȡ�û�����
			 */
			Scanner scanner = new Scanner(System.in);
			/*
			 * ��ϣ�������ݷ��͵�����ˣ���Ҫͨ�� socket��ȡ�������
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			PrintWriter pw = new PrintWriter(osw, true);
			while (true) {
				/*
				 * ���û������ÿһ���ַ������͸������
				 */
				pw.println(scanner.nextLine());

			}

			// pw.println("��ã�����ˣ�");
			// pw.flush( );//��
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) {
		try {
			Client client = new Client();
			client.start();
		} catch (Exception e) {
			System.out.println("�ͻ�������ʧ��");
		}
	}

	/**
	 * ���̸߳����ȡ�������˷��͹�����ÿһ����Ϣ ��������ͻ��˵Ŀ���̨�ϡ�
	 * 
	 * @author 24470
	 *
	 */
	private class GetMessageHandler implements Runnable {
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);

				String message = null;
				
				while ((message = br.readLine()) != null) {
					System.out.println(message);
				}

			} catch (Exception e) {

			}
		}
	}
}
