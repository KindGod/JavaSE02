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
 * /sbin/ifconfig 聊天室客户端
 * 
 * @author 24470
 *
 */
public class Client {
	/*
	 * 运行在客户端的Socket，用它来连接服务端的 ServerSocket并与服务端进行通讯。
	 */
	private Socket socket;

	/*
	 * 构造方法，用来初始化客户端
	 */
	public Client() throws Exception {
		try {
			/*
			 * 创建Socket时通常要传入两个参数 1：远程计算机IP地址 2：服务端应用程序申请的服务端口
			 * 创建的过程就是连接的过程，只有与服务端 建立了连接才会创建成功，否则会抛出异常。
			 */
			socket = new Socket("localhost", 8088 // localhost为ip地址
			);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 客户端开始工作的方法
	 */
	public void start() throws Exception {
		try {
			/*
			 * 启动一个线程，用来接收服务端 发送过来的消息
			 */
			GetMessageHandler handler = new GetMessageHandler();
			Thread t = new Thread(handler);
			t.start();

			/*
			 * 创建Scanner用于获取用户输入
			 */
			Scanner scanner = new Scanner(System.in);
			/*
			 * 若希望将数据发送到服务端，需要通过 socket获取输出流。
			 */
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			PrintWriter pw = new PrintWriter(osw, true);
			while (true) {
				/*
				 * 将用户输入的每一行字符串发送给服务端
				 */
				pw.println(scanner.nextLine());

			}

			// pw.println("你好！服务端！");
			// pw.flush( );//？
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
			System.out.println("客户端运行失败");
		}
	}

	/**
	 * 该线程负责读取服务器端发送过来的每一行消息 并输出到客户端的控制台上。
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
