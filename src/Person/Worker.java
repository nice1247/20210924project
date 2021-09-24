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
		System.out.printf("�̸� : %s, ���� : %s, ����ó : %s, ȸ�� : %s\n", super.getName(), super.getGender(), super.getPhone(),
				company);
	}

	@Override
	public String toString() {
		return "[�̸� : " + super.getName() + ", ���� : " + super.getGender() + ", ����ó : " + super.getPhone() + ", ȸ�� : " + company + "]";
	}

}
