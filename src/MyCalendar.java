import java.util.Calendar;
import java.util.Scanner;

public class MyCalendar {

	int mYear ;
	int mMonth ;
	Calendar start ;
	Calendar end ;
	
	
	MyCalendar(int mYear ,int mMonth){
		this.mYear = mYear;
		this.mMonth = mMonth;
		start = Calendar.getInstance();
		end = Calendar.getInstance();
	}
	
//	public static void main(String[] args) {
//			MyCalendar mycalendar= new MyCalendar(2021,8);
//			String result = null;
//			result = mycalendar.selecteDate();
//			System.out.println("���õ� ��¥:"+result);
//
//		
//		}

	public String selecteDate() { // ���ð����� ��¥ �޷� ���, ��¥����, ������ ����
		Scanner sc = new Scanner(System.in);
		String input = null;
		while (true) {
			displayCalendar();
			System.out.println();
			System.out.println("��¥�� �������ּ���:");

			input = sc.nextLine();
			if (input.equals(">")) {
				mMonth++;
			}else if (input.equals("<")) {
				mMonth--;
			}else if (isNumber( input )) { // ���� ���� üũ
				int nInput = Integer.parseInt(input);
				
				if(nInput <=end.get(Calendar.DATE) && nInput > 0 ) // ���� ������ ��¥���� üũ
					return mYear+"-"+mMonth+"-"+input;
				else
					System.out.println("��ȿ ���� ������ �ƴմϴ�.");
			}
			else
				System.out.println("�ùٸ��� �Է����ּ���");
			
		}
		
	}

	void displayCalendar() {

		int year = mYear;
		int month = mMonth;
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		
		start.set(year, month - 1, 1);  // ���÷��� �� �޿� ù���� ���� (Calendar �� ���� 0 ~ 11�� �����ؼ� month-1 �� �ش� ��)
		end.set(year, month, 1); 		// ���÷��� �����޿� ù���� ����
		end.add(Calendar.DATE, -1);		// ������ ù������ �Ϸ� ���� ���÷��� �� �޿� ������ ��¥�� ����

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // ù���� ���� ���ϱ� 1:�Ͽ��� 7:�����
		END_DAY = end.get(Calendar.DATE); // ������ ���� ���ϱ�
		System.out.println(year + "�� " + month + "�� �޷�\t(>�Է�:���������  <�Է�:���������)");
		System.out.println("��\t��\tȭ\t��\t��\t��\t��");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) {   // ù�� ���� ���� ����
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { //1�Ϻ��� ������ ������ ���
			System.out.print(q + "\t");
			cnt++;
			if (cnt == 7) { //����� ��� �� ���� ����
				cnt = 0;
				System.out.println("\n");
			}
		}

	}
	
	boolean isNumber(String str) { // �Ѱܹ��� ���ڿ��� ���� ���� üũ
		char letter;
		
		if(str.equals("")) {
			return false;
		}
		
		for(int i = 0 ; i<str.length();i++) {
			letter = str.charAt(i);
			if (!Character.isDigit(letter))
				return false;
		}
		return true;
	}
}
