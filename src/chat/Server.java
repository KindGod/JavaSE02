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
 * 聊天室服务端 ServerSocket运行在服务端的Socket(套接字)
 * 
 * @author 24470
 *
 */
public class Server {
	/*
	 * 服务端运行的Socket，负责申请端口，以便 客户端通过该端口连接我们的服务端。 第二个功能就是接受客户端的连接，并生成
	 * 与该客户端通讯的Socket。
	 */
	private ServerSocket server;
	/*
	 * 该集合用来保存所有客户端的输出流
	 */
	private List<PrintWriter> allOut;
                            
	/*
	 * 构造方法，用于初始化属性信息
	 */
	public Server() throws Exception {
		try {
			allOut = new ArrayList<PrintWriter>();
			/*
			 * 创建ServerSocket的同时申请 服务端端口，将来客户端就是通过 这个端口连接到服务端的。
			 */
			server = new ServerSocket(8088);// 8088为服务端端口
		} catch (Exception e) {
			System.out.println("服务端初始化失败！");
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
			 * ServerSocket提供了一个方法: Socket accept( ) 该方法是一个阻塞方法，会一直监听
			 * 其打开的8088端口，等待一个客户端连接， 一旦连接，该方法会返回与该客户端 交互的Socket。
			 */
			while (true) {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了！");
				/*
				 * 当一个客户端连接后，我们就启动一个 线程来负责与该客户端的交互。
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
			System.out.println("服务端运行失败！");
		}
	}

	/**
	 * 服务端的该内部类是一个线程要执行的任务 该线程的工作是完成与给定的客户端交互的工作
	 * 
	 * @author 24470
	 *
	 */
	private class ClientHandler implements Runnable {
		// 该线程用来交互的客户端的Socket
		private Socket socket;
		// 客户端的地址信息
		private String host;

		/**
		 * 创建任务的同时将需要处理的客户端的Socket 一同传入。
		 * 
		 * @param socket
		 */
		public ClientHandler(Socket socket) {
			this.socket = socket;

			// 获取客户端地址信息
			InetAddress address = socket.getInetAddress();
			// 获取客户端IP地址
			host = address.getHostAddress();
		}

		public void run() {
			PrintWriter pw = null;
			try {
				/*
				 * 通过socket获取输出流，用来将消息发送至客户端
				 */
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				pw = new PrintWriter(osw, true);
				// 将该客户端的输出流存入共享
				addOut(pw);

				/*
				 * 通过Socket获取输入流，来获取客户端发送 过来的数据。
				 */
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader br = new BufferedReader(isr);

				String message = null;
				// 读取客户端发送过来的一行字符串
				while ((message = br.readLine()) != null) {
					/*
					 * 上面br.readLine是用于读取客户端发送过来的 一行字符串，由于客户端的操作系统不同，当
					 * 客户端与服务端断开连接后，服务端这里读取一行 字符串的反应也不相同。
					 * windows:断开后，这里的readLine方法会抛出异常
					 * Linux:断开后，这里的readLine方法会读到null
					 */
					sendMessageToAllClient(host + "说:" + message);
				}
			} catch (Exception e) {

			} finally {
				System.out.println("客户端断开连接！");
				// 将该客户端的输出流从共享集合里删除
				removeOut(pw);
				/*
				 * 无论客户端是linux还是windows的操作系统， 断开后服务端都应当释放 socket占用的资源
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
