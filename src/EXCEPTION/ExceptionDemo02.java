package EXCEPTION;
/**
 * finally块
 * 无论try块中的代码是否出现异常finally块中的代码都会执行
 * 
 * 通常我们会在finally块里面做清理操作
 * 比如：释放连接、关闭流等。
 * @author Administrator
 *
 */
public class ExceptionDemo02 {

	public static void main(String[] args) {
		try {
			System.out.println("与数据库建立连接！");
			System.out.println("连接成功！");
			System.out.println("从数据库中获取数据！");
			System.out.println("对数据进行操作！");
			String string="q";
			int i=Integer.valueOf(string);
			System.out.println("数据处理完毕！");
			System.out.println("将数据保存到数据库！");
		} catch (Exception e) {
			System.out.println("出现了错误！");
			System.out.println(e.getMessage());
		} finally {
			//该块中的代码一定会执行
			System.out.println("与数据库断开连接！");
		}
	}

}
