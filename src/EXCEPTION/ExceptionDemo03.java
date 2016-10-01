package EXCEPTION;
/**
 * finally引发的血案
 * @author Administrator
 *
 */
public class ExceptionDemo03 {

	public static void main(String[] args) {
		System.out.println(test(null)+","+test("")+","+test("0"));
	}
	
	public static int test(String string){
		try {
			return string.charAt(0)-'0';
		} catch (NullPointerException e) {
			return 1;
		}catch(Exception e){
			return 2;
		}finally {
			//finally块中的代码一定会执行
			return 3;
		}
	}
}
