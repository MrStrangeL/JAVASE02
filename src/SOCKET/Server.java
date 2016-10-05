package SOCKET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * @author Administrator
 *
 */
public class Server {
	//运行在服务端的Socket--->>>ServerSocket
	private ServerSocket server;
	
	/**
	 * 构造方法，用于初始化服务端
	 * @throws IOException 
	 */
	public Server() throws IOException{
		try {
			/**
			 * 创建ServerSocket时需要指定服务端口
			 */
			System.out.println("服务端:初始化服务端!");
			server=new ServerSocket(9628);
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
			System.out.println("服务端:等待客户端连接......");
			Socket clientSocket=server.accept();
			
			/**
			 * 通过Socket获取远端的地址信息
			 */
			InetAddress clientAddress=clientSocket.getInetAddress();
			//获取客户端的IP地址
			String clientIP=clientAddress.getHostAddress();
			//获取客户端的端口号
			int clientPort=clientSocket.getPort();
			System.out.println("服务端:客户端["+clientIP+":"+clientPort+"]连接了!");
			
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
			/**
			 * 通过键盘循环的发送消息
			 */
			while(true){
				String content=serverBR.readLine();
				System.out.println(clientIP+":"+clientPort+":"+content);
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Server server;
		try {
			server = new Server();
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务端:服务端初始化失败!");
		}
	}
}
