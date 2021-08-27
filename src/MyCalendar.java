import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class MyCalendar {

	LocalDateTime now = LocalDateTime.now();
	int mYear = now.getYear();
	int mMonth = now.getMonthValue();
	Calendar start = Calendar.getInstance();
	Calendar end = Calendar.getInstance();

	public MyCalendar() {
	};

	public MyCalendar(int mYear, int mMonth) {
		this.mYear = mYear;
		this.mMonth = mMonth;
	}

	public Date selecteDate() { // ���ð����� ��¥ �޷� ���, ��¥����, ������ ����
		Scanner sc = new Scanner(System.in);
		String input = null;

		while (true) {
			displayCalendar();
			System.out.println();
			System.out.print("��¥�� �������ּ���:");
			input = sc.nextLine();

			if (input.equals(">")) {
				mMonth++;
			} else if (input.equals("<")) {
				mMonth--;
			} else if (isNumber(input)) { // ���� ���� üũ
				int nInput = Integer.parseInt(input);

				if (nInput <= end.get(Calendar.DATE) && nInput > 0) // ���� ������ ��¥���� üũ
					break;
				else
					System.out.println("��ȿ ���� ������ �ƴմϴ�.");
			} else
				System.out.println("�ùٸ��� �Է����ּ���");
		}
		String result = mYear + "-" + mMonth + "-" + input;
		java.sql.Date transformDate = java.sql.Date.valueOf(result); // String -> Date
		return transformDate;
	}

	public Date selecteDate(int year, int month) { // ���ð����� ��¥ �޷� ���, ��¥����, ������ ����
		Scanner sc = new Scanner(System.in);
		String input = null;

		while (true) {
			displayCalendar(year, month);
			System.out.println();
			System.out.print("��¥�� �������ּ���:");
			input = sc.nextLine();

			if (input.equals(">")) {
				mMonth++;
			} else if (input.equals("<")) {
				mMonth--;
			} else if (isNumber(input)) { // ���� ���� üũ
				int nInput = Integer.parseInt(input);
				if (nInput <= end.get(Calendar.DATE) && nInput > 0) // ���� ������ ��¥���� üũ
					break;
				else
					System.out.println("��ȿ ���� ������ �ƴմϴ�.");
			} else
				System.out.println("�ùٸ��� �Է����ּ���");
		}

		String result = mYear + "-" + mMonth + "-" + input;
		java.sql.Date transformDate = java.sql.Date.valueOf(result); // String -> Date
		return transformDate;
	}

	public Date selecteDate(int year, int month, ArrayList<Integer> displayDays, char[] inputBox) { // ���÷��� �� ���� ����Ʈ �߿�

		Scanner sc = new Scanner(System.in);
		String input = null;

		displayCalendar(year, month, displayDays);
		System.out.println();
		System.out.print("��¥�� �������ּ���:");
		input = sc.nextLine();

		if (input.equals(">")) {
			inputBox[0] = '>';
			return null;
		} else if (input.equals("<")) {
			inputBox[0] = '<';
			return null;
		} else if (isNumber(input)) { // ���� ���� üũ
			int nInput = Integer.parseInt(input);

			if (nInput <= end.get(Calendar.DATE) && nInput > 0) { // ���� ������ ��¥���� üũ
				String result = year + "-" + month + "-" + input;
				java.sql.Date transformDate = java.sql.Date.valueOf(result); // String -> Date
				return transformDate;
			} else {
				System.out.println("��ȿ ���� ������ �ƴմϴ�.");
				return null;
			}
		} else {
			System.out.println("�ùٸ��� �Է����ּ���");
			return null;
		}

	}

	public void displayCalendar() {

		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		start.set(mYear, mMonth - 1, 1); // ���÷��� �� �޿� ù���� ���� (Calendar �� ���� 0 ~ 11�� �����ؼ� month-1 �� �ش� ��)
		end.set(mYear, mMonth, 1); // ���÷��� �����޿� ù���� ����
		end.add(Calendar.DATE, -1); // ������ ù������ �Ϸ� ���� ���÷��� �� �޿� ������ ��¥�� ����

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // ù���� ���� ���ϱ� 1:�Ͽ��� 7:�����
		END_DAY = end.get(Calendar.DATE); // ������ ���� ���ϱ�
		System.out.println(mYear + "�� " + mMonth + "�� �޷�\t(>�Է�:���������  <�Է�:���������)");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) { // ù�� ���� ���� ����
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { // 1�Ϻ��� ������ ������ ���
			System.out.print(q + "\t");
			cnt++;
			if (cnt == 7) { // ����� ��� �� ���� ����
				cnt = 0;
				System.out.println("\n");
			}
		}

	}

	public void displayCalendar(int year, int month) {

		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		start.set(year, month - 1, 1); // ���÷��� �� �޿� ù���� ���� (Calendar �� ���� 0 ~ 11�� �����ؼ� month-1 �� �ش� ��)
		end.set(year, month, 1); // ���÷��� �����޿� ù���� ����
		end.add(Calendar.DATE, -1); // ������ ù������ �Ϸ� ���� ���÷��� �� �޿� ������ ��¥�� ����

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // ù���� ���� ���ϱ� 1:�Ͽ��� 7:�����
		END_DAY = end.get(Calendar.DATE); // ������ ���� ���ϱ�
		System.out.println(year + "�� " + month + "�� �޷�\t(>�Է�:���������  <�Է�:���������)");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) { // ù�� ���� ���� ����
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { // 1�Ϻ��� ������ ������ ���
			System.out.print(q + "\t");
			cnt++;
			if (cnt == 7) { // ����� ��� �� ���� ����
				cnt = 0;
				System.out.println("\n");

			}
		}

	}

	public void displayCalendar(int year, int month, ArrayList<Integer> displayDays) { // ������ ��¥ ����Ʈ�޾Ƽ� �װ͸� ���

		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		start.set(year, month - 1, 1); // ���÷��� �� �޿� ù���� ���� (Calendar �� ���� 0 ~ 11�� �����ؼ� month-1 �� �ش� ��)
		end.set(year, month, 1); // ���÷��� �����޿� ù���� ����
		end.add(Calendar.DATE, -1); // ������ ù������ �Ϸ� ���� ���÷��� �� �޿� ������ ��¥�� ����

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // ù���� ���� ���ϱ� 1:�Ͽ��� 7:�����
		END_DAY = end.get(Calendar.DATE); // ������ ���� ���ϱ�
		System.out.println(year + "�� " + month + "�� �޷�\\t(>�Է�:���������  <�Է�:���������)");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) { // ù�� ���� ���� ����
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { // 1�Ϻ��� ������ ������ ���
			if (displayDays.contains(q))
				System.out.print(q + "\t");
			else
				System.out.print("X" + "\t");
			cnt++;
			if (cnt == 7) { // ����� ��� �� ���� ����
				cnt = 0;
				System.out.println("\n");
			}
		}

	}

	public boolean isNumber(String str) { // �Ѱܹ��� ���ڿ��� ���� ���� üũ
		char letter;

		if (str.equals("")) {
			return false;
		}

		for (int i = 0; i < str.length(); i++) {
			letter = str.charAt(i);
			if (!Character.isDigit(letter))
				return false;
		}
		return true;
	}
}