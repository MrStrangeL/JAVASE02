package SOCKET;

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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器端
 * @author Administrator
 *
 */
public class Server2 {
	//运行在服务端的Socket--->>>ServerSocket
	private ServerSocket server;
	//线程池，用于管理客户端连接的交互线程
	private ExecutorService thradPool;
	//由于保存所有的输出流，实现转发
	private List<PrintWriter> allOut;
	
	/**
	 * 构造方法，用于初始化服务端
	 * @throws IOException 
	 */
	public Server2() throws IOException{
		try {
			/**
			 * 创建ServerSocket时需要指定服务端口
			 */
			System.out.println("服务端:初始化服务端!");
			server=new ServerSocket(9628);
			thradPool=Executors.newFixedThreadPool(10);
			
			/**
			 * 初始化存放所有客户端输出流的集合
			 */
			allOut=new ArrayList<PrintWriter>();
			
			System.out.println("服务端:服务端初始化完毕!");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 服务端开始工作的方法
	 */
	public void start(){
		try {
			/**
			 * ServerSocket的accept()方法用于
			 * 监听我们所注册的端口，等待客户端的连接
			 * 该方法是一个阻塞方法，知道一个客户端连接
			 * 否则该方法将一直阻塞。
			 *
			 * 若一个客户端连接了，会返回该客户端的Socket
			 */
			while(true){
				System.out.println("服务端:等待客户端连接......");
				Socket clientSocket=server.accept();
				/**
				 * 当一个客户端连接后，启动一个线程，将该客户端的Socket传入，使得该线程处理与该客户端的交互。
				 * 这样我们能再次进入循环，接收下一个客户端的连接。
				 */
				Runnable clientHandler=new ClientHandler(clientSocket);
				//将任务交给线程池
				thradPool.execute(clientHandler);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	/**
	 * 将给定的输出流存入共享集合
	 */
	public synchronized void addOut(PrintWriter pw){
		allOut.add(pw);
	}
	
	/**
	 * 将给定的输出流从共享集合中删除
	 * @param pw
	 */
	public synchronized void removeOut(PrintWriter pw){
		allOut.remove(pw);
	}
	
	/**
	 * 将给定的消息转发给所有客户端
	 * @param message
	 */
	public synchronized void sendMessage(String message){
		for (PrintWriter printWriter : allOut) {
			printWriter.println(message);
		}
	}
	
	
	public static void main(String[] args){
		Server2 server;
		try {
			server = new Server2();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务端:服务端初始化失败!");
		}
	}
	
		/**
		 * 服务端的 一个线程，用于与某个客户端交互
		 * 使用多线程的目的就是使得服务端可以处理多个客户端。
		 */
		class ClientHandler implements Runnable{
			/**
			 * 当前线程处理的客户端的Socket
			 */
			private Socket clientSocket;
			
			public ClientHandler(Socket socket) {
				this.clientSocket=socket;
				/**
				 * 通过Socket获取远端的地址信息
				 */
				InetAddress clientAddress=clientSocket.getInetAddress();
				//获取客户端的IP地址
				String clientIP=clientAddress.getHostAddress();
				//获取客户端的端口号
				int clientPort=clientSocket.getPort();
				System.out.println("服务端:客户端["+clientIP+":"+clientPort+"]连接了!");
				sendMessage("服务端:客户端["+clientIP+":"+clientPort+"]连接了!");
			}
			
			/**
			 * 该线程会将当前Socket中的输出流获取过来
			 * 用来循环读取客户端发送过来的消息
			 */
			@Override
			public void run() {
				PrintWriter serverPW=null;
				/**
				 * 通过Socket获取远端的地址信息
				 */
				InetAddress clientAddress=clientSocket.getInetAddress();
				//获取客户端的IP地址
				String clientIP=clientAddress.getHostAddress();
				//获取客户端的端口号
				int clientPort=clientSocket.getPort();
				try {
					
					//为了让服务端与客户端发送信息,我们需要通过Socket获取输出流
					/**
					 * 可以通过Socket的getOutputStream()方法获取输入流，由于将信息发送到服务端
					 */
					OutputStream serverOS=clientSocket.getOutputStream();
					
					/**
					 * 将字节流转换为字符流
					 */
					OutputStreamWriter serverOSW=new OutputStreamWriter(serverOS, "UTF-8");
					
					/**
					 * 将字符流包装为缓冲字符输出流，可以按行为单位写出字符串
					 */
					serverPW=new PrintWriter(serverOSW, true);
					
					/**
					 * 将连接上的客户端的输出流存入共享集合,使得该客户端也能接收服务端转发的消息
					 */
					addOut(serverPW);
					
					/**
					 * 通过刚刚连上的客户端的Socket来获取输入流，来读取客户端发送过来的消息
					 */
					InputStream serverIS=clientSocket.getInputStream();
					
					/**
					 * 将字节流转换为字符流
					 */
					InputStreamReader serverISR=new InputStreamReader(serverIS, "UTF-8");
					
					/**
					 * 将字符流包装为缓冲字符输入流
					 */
					BufferedReader serverBR=new BufferedReader(serverISR);
					while(true){
						String content="客户端:["+clientIP+":"+clientPort+"]说:"+serverBR.readLine();
						
						/**
						 * 当收到一个用户的信息之后将信息转发给所有客户端
						 */
						sendMessage(content);
					}
					
				} catch (Exception e) {
						e.printStackTrace();
				}finally {
					/**
					 * 将该客户端的输出流从共享集合中删除
					 */
					removeOut(serverPW);
					//输出当前在线人数
					System.out.println("当前在线人数为:"+allOut.size());
					
					try {
						clientSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					sendMessage("服务端:客户端:["+clientIP+":"+clientPort+"]下线了!");
				}
			}
			
		}
}
