package Person;

import java.util.Scanner;

public class PersonExe {
	static Scanner scn = new Scanner(System.in);
	private static PersonExe create = new PersonExe();
	private Person[] people;

	private PersonExe() {
		people = new Person[100];

	}

	public static PersonExe getInstance() {
		return create;
	}

	public void execute() {
		while (true) {
			System.out.println("==============================");
			System.out.println("1.추가 2.조회 3.수정 4.삭제 5.종료");
			System.out.println("==============================");
			int menu = readInt("메뉴를 선택하세요.");

			if (menu == 1) {
				System.out.println("[추가]");
				System.out.println("------------------------------");
				addPerson();
			} else if (menu == 2) {
				System.out.println("[조회]");
				System.out.println("------------------------------");
				showList();
			} else if (menu == 3) {
				System.out.println("[수정]");
				System.out.println("------------------------------");
				modify();
			} else if (menu == 4) {
				System.out.println("[삭제]");
				System.out.println("------------------------------");
				delete();
			} else if (menu == 5) {
				System.out.println("[종료되었습니다]");
				break;
			}
		}
	}

	private void addPerson() {
		System.out.println("1.Person 2.Student 3.Worker");
		int select = readInt("추가할 타입을 입력하여 주세요");

		String name = readStr("이름 입력");
		String phone = readStr("연락처를 입력");
		Gender gender = null;
		String gen = readStr("성별(남/여)을 입력");
		if (gen.equals("남")) {
			gender = Gender.MEN;
		} else if (gen.equals("여")) {
			gender = Gender.WOMEN;
		}

		Person person = null;

		if (select == 1) {
			person = new Person(name, gender, phone);
		} else if (select == 2) {
			String school = readStr("학교를 입력");
			person = new Student(name, gender, phone, school);
		} else if (select == 3) {
			String company = readStr("회사를 입력");
			person = new Worker(name, gender, phone, company);
		}

		for (int i = 0; i < people.length; i++) {
			if (people[i] == null) {
				people[i] = person;
				break;
			}
		}
		System.out.println("추가되었습니다.");
	}

	private void showList() {
		System.out.println("조회하고 싶은 사람의 이름과 성별(남/여)을 입력하여 주세요");
		String name = readStr("이름");
		String gen = readStr("성별");
		String gender = null;
		if (gen.equals("남")) {
			gender = "MEN";

		} else if (gen.equals("여")) {
			gender = "WOMEN";
		}

		for (int i = 0; i < people.length; i++) {
			if (people[i] != null && people[i].getName().indexOf(name) != -1
					&& people[i].getGender().name().indexOf(gender) != -1) {

				System.out.println(people[i].toString());
			}
		}
	}

	private void modify() {
		System.out.println("[친구 목록]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = readInt("수정할 사람의 번호를 입력하세요");
		String phone = readStr("바꿀 연락처를 입력하세요");
		if (phone != null && phone != "") {
			people[num].setPhone(phone);
			System.out.println("수정완료");
		}
		if (people[num] instanceof Student) {
			String school = readStr("수정할 학교를 입력하세요");
			if (school != null && school != "") {
				((Student) people[num]).setSchool(school);
				System.out.println("수정완료");
			}
		}
		if (people[num] instanceof Worker) {
			String company = readStr("수정할 회사를 입력하세요");
			if (company != null && company != "") {
				((Worker) people[num]).setCompany(company);
				System.out.println("수정완료");
			}
		}

	}

	private void delete() {
		System.out.println("[삭제 목록]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());
		}

		int num = readInt("삭제하려는 사람의 번호를 입력하세요");
		if (people[num] != null) {
			people[num] = null;
			System.out.println("삭제가 완료되었습니다");
		} else if (people[num] == null) {
			System.out.println("삭제 할 것이 없습니다");
		}

	}

	public static int readInt(String msg) {
		System.out.println(msg);
		int num = scn.nextInt();
		scn.nextLine();
		return num;
	}

	public static String readStr(String msg) {
		System.out.println(msg);
		return scn.nextLine();
	}

}
