package SOCKET.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务端
 * @author 作者 E-mail:1832567496@qq.com
 * @date 创建时间：2016年10月6日 下午2:26:04
 */
public class Server {
	/**
	 * 服务端的启动方法
	 */
	public void start(){
		try {
			/**
			 * 接收包的步骤：
			 * 1.创建Socket(一次)
			 * 2.创建一个合适大小的包
			 * 3.通过Socket接收数据到包中
			 * 4.拆包取数据
			 */
			DatagramSocket serverSocket=new DatagramSocket(9628);
			byte[] buffer=new byte[10240];
			DatagramPacket dataPacket=new DatagramPacket(buffer, buffer.length);
			/**
			 * receive()方法是阻塞方法，知道收到客户端发过来的数据包
			 */
			serverSocket.receive(dataPacket);
			//拆包，拿数据
			byte[] data=dataPacket.getData();//拿到的其实就是buffer字节数组
			//有效数据长度
			int dataLength=dataPacket.getLength();
			String content=new String(data, 0, dataLength, "UTF-8");
			System.out.println(content);
			
			/**
			 * 向客户端发送数据包
			 */
			String sendData="你好，客户端！";
			byte[] buffers=sendData.getBytes("UTF-8");
			DatagramPacket sendDataPacket=new DatagramPacket(buffers, 0, buffers.length, dataPacket.getAddress(), dataPacket.getPort());
			serverSocket.send(sendDataPacket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Server server=new Server();
		server.start();
	}
}
