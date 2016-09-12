package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * �����ҷ���� ServerSocket�����ڷ���˵�Socket(�׽���)
 * 
 * @author 24470
 *
 */
public class Server {
	/*
	 * ��������е�Socket����������˿ڣ��Ա� �ͻ���ͨ���ö˿��������ǵķ���ˡ� �ڶ������ܾ��ǽ��ܿͻ��˵����ӣ�������
	 * ��ÿͻ���ͨѶ��Socket��
	 */
	private ServerSocket server;
	/*
	 * �ü��������������пͻ��˵������
	 */
	private List<PrintWriter> allOut;
                            
	/*
	 * ���췽�������ڳ�ʼ��������Ϣ
	 */
	public Server() throws Exception {
		try {
			allOut = new ArrayList<PrintWriter>();
			/*
			 * ����ServerSocket��ͬʱ���� ����˶˿ڣ������ͻ��˾���ͨ�� ����˿����ӵ�����˵ġ�
			 */
			server = new ServerSocket(8088);// 8088Ϊ����˶˿�
		} catch (Exception e) {
			System.out.println("����˳�ʼ��ʧ�ܣ�");
			throw e;
		}
	}

	private void addOut(PrintWriter out) {
		allOut.add(out);
	}

	private void removeOut(PrintWriter out) {
		allOut.remove(out);
	}

	private synchronized void sendMessageToAllClient(String message) {
		for (PrintWriter out : allOut) {
			out.println(message);
		}
	}

	public void start() throws Exception {
		try {
			/*
			 * ServerSocket�ṩ��һ������: Socket accept( ) �÷�����һ��������������һֱ����
			 * ��򿪵�8088�˿ڣ��ȴ�һ���ͻ������ӣ� һ�����ӣ��÷����᷵����ÿͻ��� ������Socket��
			 */
			while (true) {
				System.out.println("�ȴ��ͻ�������...");
				Socket socket = server.accept();
				System.out.println("һ���ͻ��������ˣ�");
				/*
				 * ��һ���ͻ������Ӻ����Ǿ�����һ�� �߳���������ÿͻ��˵Ľ�����
				 */
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			System.out.println("���������ʧ�ܣ�");
		}
	}

	/**
	 * ����˵ĸ��ڲ�����һ���߳�Ҫִ�е����� ���̵߳Ĺ��������������Ŀͻ��˽����Ĺ���
	 * 
	 * @author 24470
	 *
	 */
	private class ClientHandler implements Runnable {
		// ���߳����������Ŀͻ��˵�Socket
		private Socket socket;
		// �ͻ��˵ĵ�ַ��Ϣ
		private String host;

		/**
		 * ���������ͬʱ����Ҫ����Ŀͻ��˵�Socket һͬ���롣
		 * 
		 * @param socket
		 */
		public ClientHandler(Socket socket) {
			this.socket = socket;

			// ��ȡ�ͻ��˵�ַ��Ϣ
			InetAddress address = socket.getInetAddress();
			// ��ȡ�ͻ���IP��ַ
			host = address.getHostAddress();
		}

		public void run() {
			PrintWriter pw = null;
			try {
				/*
				 * ͨ��socket��ȡ���������������Ϣ�������ͻ���
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				pw = new PrintWriter(osw, true);
				// ���ÿͻ��˵���������빲��
				addOut(pw);

				/*
				 * ͨ��Socket��ȡ������������ȡ�ͻ��˷��� ���������ݡ�
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);

				String message = null;
				// ��ȡ�ͻ��˷��͹�����һ���ַ���
				while ((message = br.readLine()) != null) {
					/*
					 * ����br.readLine�����ڶ�ȡ�ͻ��˷��͹����� һ���ַ��������ڿͻ��˵Ĳ���ϵͳ��ͬ����
					 * �ͻ��������˶Ͽ����Ӻ󣬷���������ȡһ�� �ַ����ķ�ӦҲ����ͬ��
					 * windows:�Ͽ��������readLine�������׳��쳣
					 * Linux:�Ͽ��������readLine���������null
					 */
					sendMessageToAllClient(host + "˵:" + message);
				}
			} catch (Exception e) {

			} finally {
				System.out.println("�ͻ��˶Ͽ����ӣ�");
				// ���ÿͻ��˵�������ӹ�������ɾ��
				removeOut(pw);
				/*
				 * ���ۿͻ�����linux����windows�Ĳ���ϵͳ�� �Ͽ������˶�Ӧ���ͷ� socketռ�õ���Դ
				 */
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
