package SOCKET;

import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 * @author Administrator
 *
 */
public class Client {
	//客户端的Socket，用于连接服务端
	private Socket client;
	
	public Client() throws Exception{
		try {
			/**
			 * 创建Socket对象时，就会尝试根据所给定的地址与端口连接
			 * 服务端。
			 * 所以，若该对象创建成功，则说明与服务端连接正常。
			 */
			System.out.println("客户端:正在连接服务端......");
			client=new Socket("localhost", 9628);
			System.out.println("客户端:连接服务端成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端:连接服务端失败!");
			throw e;
		}
	}
	
	/**
	 * 客户端启动方法
	 */
	public void start(){
		
	}
	
	public static void main(String[] args){
		try {
			Client client=new Client();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端初始化失败!");
		}
	}
}
