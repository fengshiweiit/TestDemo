package mode;

/**
 * @Author Shiwei Feng
 * @Time 2018/11/7
 * 当类中的属性特别多的情况建议使用Builder模式
 */
public class BuilderMode {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Integer id;

	private String name;

	private Integer age;

	private String username;

	private String password;

	public static class Builder {

		//没有默认值的放入构造方法必须设置值,有默认值的可以手动去设置
		private Integer id;

		private String name;

		private Integer age = 1;

		private String username;

		private String password = "123456";

		public Builder age(int age){
			this.age = age;
			return this;
		}

		public Builder password(String password){
			this.password = password;
			return this;
		}

		public BuilderMode build(){
			return new BuilderMode(this);
		}

		public Builder(Integer id, String name, String username) {
			this.id = id;
			this.name = name;
			this.username = username;
		}
	}

	private BuilderMode(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;
		this.username = builder.username;
		this.password = builder.password;
	}

}
