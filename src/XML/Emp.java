package XML;

/**
 * 由于描述Emp.xml文件中表示的员工
 * @author 作者 E-mail:1832567496@qq.com
 * @date 创建时间：2016年10月6日 下午6:13:48
 */
public class Emp {
	private long id;
	private String name;
	private int age;
	private String gender;
	private int salary;
	
	public Emp()
	{}
	
	public Emp(long id, String name, int age, String gender, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary + "]";
	}
	
	
}
