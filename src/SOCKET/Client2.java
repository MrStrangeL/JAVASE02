package SOCKET;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
public class Client2 {
	//客户端的Socket，用于连接服务端
	private Socket client;
	
	public Client2() throws Exception{
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
			Runnable serverHandler=new GetServerInfoHandler();
			Thread serverThread=new Thread(serverHandler);
			serverThread.start();
			
			/**
			 * 可以通过Socket的getOutputStream()方法获取输入流，由于将信息发送到客户端
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
			Client2 client=new Client2();
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端初始化失败!");
		}
	}
	
	class GetServerInfoHandler implements Runnable{
		public void run(){
			try {
				/**
				 * 通过客户端的Socket来获取输入流，来读取服务端发送过来的消息
				 */
				InputStream clientIS=client.getInputStream();
				
				/**
				 * 将字节流转换为字符流
				 */
				InputStreamReader clientISR=new InputStreamReader(clientIS, "UTF-8");
				
				/**
				 * 将字符流包装为缓冲字符输入流
				 */
				BufferedReader clientBR=new BufferedReader(clientISR);
				String content=null;
				while((content=clientBR.readLine())!=null){
					System.out.println(content);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
