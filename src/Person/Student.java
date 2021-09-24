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
		System.out.printf("이름 : %s, 성별 : %s, 연락처 : %s, 학교 : %s\n", super.getName(), super.getGender(), super.getPhone(),
				school);
	}

	@Override
	public String toString() {
		return "[이름 : " + super.getName() + ", 성별 : " + super.getGender() + ", 연락처 : " + super.getPhone() + ", 학교 : " + school + "]";
	}

}
