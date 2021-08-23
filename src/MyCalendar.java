import java.util.Calendar;
import java.util.Scanner;

public class MyCalendar {

	private String date;
	static int mYear = 2021;
	static int mMonth = 8;

	public static void main(String[] args) {
			String result = null;
			result = MyCalendar.selecteDate();
			System.out.println("선택된 날짜:"+result);

		
		}

	public static  String selecteDate() { // 선택가능한 날짜 달력 출력, 날짜선택, 데이터 리턴
		Scanner sc = new Scanner(System.in);
		String input = null;
		while (true) {
			MyCalendar.displayCalendar();
			System.out.println();
			System.out.println("날짜를 입력해주세요: (선택:숫자입력 , > : 다음달  <: 이전달)");

			input = sc.nextLine();
			if (input.equals(">")) {
				MyCalendar.mMonth++;
			}else if (input.equals("<")) {
				MyCalendar.mMonth--;
			}
			else
				break;
			
		}
		return MyCalendar.mYear+"-"+MyCalendar.mMonth+"-"+input;
	}

	static void displayCalendar() {

		int year = mYear;
		int month = mMonth;
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		start.set(year, month - 1, 1);
		end.set(year, month, 1);
		end.add(Calendar.DATE, -1);

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK);
		END_DAY = end.get(Calendar.DATE);

		System.out.println(year + "년 " + month + "월 달력\n" + "일\t월\t화\t수\t목\t금\t토");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) {
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) {
			System.out.print(q + "\t");
			cnt++;
			if (cnt == 7) {
				cnt = 0;
				System.out.println("\n");
			}
		}

	}
}
