package SOCKET.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端
 * @author 作者 E-mail:1832567496@qq.com
 * @date 创建时间：2016年10月6日 下午2:26:36
 */
public class Client {
	/**
	 * 客户端的启动方法
	 */
	public void start(){
		try {
			/**
			 * 向服务器端发送数据的步骤:
			 * 1.创建好Socket(一次就行)
			 * 2.准备数据
			 * 3.创建数据包(准备包裹、填写地址、装入数据)
			 * 4.将数据存入包中
			 * 5.将数据包通过Socket发送给服务端
			 * 
			 */
			DatagramSocket clientSocket=new DatagramSocket();
			String data="你好，服务端！";
			byte[] buffer=data.getBytes("UTF-8");
			InetAddress address=InetAddress.getByName("localhost");
			int port=9628;
			DatagramPacket dataPacket=new DatagramPacket(buffer, 0, buffer.length, address, port);
			clientSocket.send(dataPacket);
			
			/**
			 * 接收服务端发送过来的消息
			 */
			byte[] buffers=new byte[10240];
			DatagramPacket receiveDataPacket=new DatagramPacket(buffers, buffers.length);
			/**
			 * receive()方法是阻塞方法，知道收到客户端发过来的数据包
			 */
			clientSocket.receive(receiveDataPacket);
			//拆包，拿数据
			byte[] datas=receiveDataPacket.getData();//拿到的其实就是buffer字节数组
			//有效数据长度
			int dataLength=receiveDataPacket.getLength();
			String content=new String(datas, 0, dataLength, "UTF-8");
			System.out.println(content);
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Client client=new Client();
		client.start();
	}
}
