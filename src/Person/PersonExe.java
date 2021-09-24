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
			System.out.println("1.�߰� 2.��ȸ 3.���� 4.���� 5.����");
			System.out.println("==============================");
			int menu = readInt("�޴��� �����ϼ���.");

			if (menu == 1) {
				System.out.println("[�߰�]");
				System.out.println("------------------------------");
				addPerson();
			} else if (menu == 2) {
				System.out.println("[��ȸ]");
				System.out.println("------------------------------");
				showList();
			} else if (menu == 3) {
				System.out.println("[����]");
				System.out.println("------------------------------");
				modify();
			} else if (menu == 4) {
				System.out.println("[����]");
				System.out.println("------------------------------");
				delete();
			} else if (menu == 5) {
				System.out.println("[����Ǿ����ϴ�]");
				break;
			}
		}
	}

	private void addPerson() {
		System.out.println("1.Person 2.Student 3.Worker");
		int select = readInt("�߰��� Ÿ���� �Է��Ͽ� �ּ���");

		String name = readStr("�̸� �Է�");
		String phone = readStr("����ó�� �Է�");
		Gender gender = null;
		String gen = readStr("����(��/��)�� �Է�");
		if (gen.equals("��")) {
			gender = Gender.MEN;
		} else if (gen.equals("��")) {
			gender = Gender.WOMEN;
		}

		Person person = null;

		if (select == 1) {
			person = new Person(name, gender, phone);
		} else if (select == 2) {
			String school = readStr("�б��� �Է�");
			person = new Student(name, gender, phone, school);
		} else if (select == 3) {
			String company = readStr("ȸ�縦 �Է�");
			person = new Worker(name, gender, phone, company);
		}

		for (int i = 0; i < people.length; i++) {
			if (people[i] == null) {
				people[i] = person;
				break;
			}
		}
		System.out.println("�߰��Ǿ����ϴ�.");
	}

	private void showList() {
		System.out.println("��ȸ�ϰ� ���� ����� �̸��� ����(��/��)�� �Է��Ͽ� �ּ���");
		String name = readStr("�̸�");
		String gen = readStr("����");
		String gender = null;
		if (gen.equals("��")) {
			gender = "MEN";

		} else if (gen.equals("��")) {
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
		System.out.println("[ģ�� ���]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());
		}
		int num = readInt("������ ����� ��ȣ�� �Է��ϼ���");
		String phone = readStr("�ٲ� ����ó�� �Է��ϼ���");
		if (phone != null && phone != "") {
			people[num].setPhone(phone);
			System.out.println("�����Ϸ�");
		}
		if (people[num] instanceof Student) {
			String school = readStr("������ �б��� �Է��ϼ���");
			if (school != null && school != "") {
				((Student) people[num]).setSchool(school);
				System.out.println("�����Ϸ�");
			}
		}
		if (people[num] instanceof Worker) {
			String company = readStr("������ ȸ�縦 �Է��ϼ���");
			if (company != null && company != "") {
				((Worker) people[num]).setCompany(company);
				System.out.println("�����Ϸ�");
			}
		}

	}

	private void delete() {
		System.out.println("[���� ���]");
		for (int i = 0; i < people.length; i++) {
			if (people[i] != null)
				System.out.println("[" + i + "]" + people[i].toString());
		}

		int num = readInt("�����Ϸ��� ����� ��ȣ�� �Է��ϼ���");
		if (people[num] != null) {
			people[num] = null;
			System.out.println("������ �Ϸ�Ǿ����ϴ�");
		} else if (people[num] == null) {
			System.out.println("���� �� ���� �����ϴ�");
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
