package SOCKET;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
		try {
			/**
			 * 可以通过Socket的getOutputStream()方法获取输入流，由于将信息发送到服务端
			 */
			OutputStream clientOS=client.getOutputStream();
			
			/**
			 * 将字节流转换为字符流
			 */
			OutputStreamWriter clientOSW=new OutputStreamWriter(clientOS, "UTF-8");
			
			/**
			 * 将字符流包装为缓冲字符输出流，可以按行为单位写出字符串
			 */
			PrintWriter clientPW=new PrintWriter(clientOSW, true);
			/**
			 * 循环读取客户端发送过来的消息
			 */
			while(true){
				Scanner scanner=new Scanner(System.in);
				String content=scanner.nextLine();
				clientPW.println(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
