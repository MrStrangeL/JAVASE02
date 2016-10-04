package SOCKET;

import java.io.IOException;
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
			System.out.println("服务端:客户端连接了!");
		} catch (Exception e) {

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
