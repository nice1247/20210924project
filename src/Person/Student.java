package Person;

public class Student extends Person {
	private String school;

	public Student(String name, Gender gender, String phone, String school) {
		super(name, gender, phone);
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public void showInfo() {
		System.out.printf("�̸� : %s, ���� : %s, ����ó : %s, �б� : %s\n", super.getName(), super.getGender(), super.getPhone(),
				school);
	}

	@Override
	public String toString() {
		return "[�̸� : " + super.getName() + ", ���� : " + super.getGender() + ", ����ó : " + super.getPhone() + ", �б� : " + school + "]";
	}

}
