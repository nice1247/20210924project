package Person;

public class Person {
	private String name;
	private Gender gender;
	private String phone;


	public Person(String name, Gender gender, String phone) {
		this.name = name;
		this.gender = gender;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void showInfo() {
		System.out.printf("이름 : %s, 성별 : %s, 연락처 : %s\n", name, gender, phone);
	}

	@Override
	public String toString() {
		return "[이름 : " + name + ", 성별 : " + gender + ", 연락처 : " + phone + "]";
	}

}
