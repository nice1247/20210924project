package Person;

public class Worker extends Person {
	private String company;

	public Worker(String name, Gender gender, String phone, String company) {
		super(name, gender, phone);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void showInfo() {
		System.out.printf("이름 : %s, 성별 : %s, 연락처 : %s, 회사 : %s\n", super.getName(), super.getGender(), super.getPhone(),
				company);
	}

	@Override
	public String toString() {
		return "[이름 : " + super.getName() + ", 성별 : " + super.getGender() + ", 연락처 : " + super.getPhone() + ", 회사 : " + company + "]";
	}

}
