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

	public Date selecteDate() { // 선택가능한 날짜 달력 출력, 날짜선택, 데이터 리턴
		Scanner sc = new Scanner(System.in);
		String input = null;

		while (true) {
			displayCalendar();
			System.out.println();
			System.out.print("날짜를 선택해주세요:");
			input = sc.nextLine();

			if (input.equals(">")) {
				mMonth++;
			} else if (input.equals("<")) {
				mMonth--;
			} else if (isNumber(input)) { // 숫자 인지 체크
				int nInput = Integer.parseInt(input);

				if (nInput <= end.get(Calendar.DATE) && nInput > 0) // 선택 가능한 날짜인지 체크
					break;
				else
					System.out.println("유효 숫자 범위가 아닙니다.");
			} else
				System.out.println("올바르게 입력해주세요");
		}
		String result = mYear + "-" + mMonth + "-" + input;
		java.sql.Date transformDate = java.sql.Date.valueOf(result); // String -> Date
		return transformDate;
	}

	public Date selecteDate(int year, int month) { // 선택가능한 날짜 달력 출력, 날짜선택, 데이터 리턴
		Scanner sc = new Scanner(System.in);
		String input = null;

		while (true) {
			displayCalendar(year, month);
			System.out.println();
			System.out.print("날짜를 선택해주세요:");
			input = sc.nextLine();

			if (input.equals(">")) {
				mMonth++;
			} else if (input.equals("<")) {
				mMonth--;
			} else if (isNumber(input)) { // 숫자 인지 체크
				int nInput = Integer.parseInt(input);
				if (nInput <= end.get(Calendar.DATE) && nInput > 0) // 선택 가능한 날짜인지 체크
					break;
				else
					System.out.println("유효 숫자 범위가 아닙니다.");
			} else
				System.out.println("올바르게 입력해주세요");
		}

		String result = mYear + "-" + mMonth + "-" + input;
		java.sql.Date transformDate = java.sql.Date.valueOf(result); // String -> Date
		return transformDate;
	}

	public Date selecteDate(int year, int month, ArrayList<Integer> displayDays, char[] inputBox) { // 디스플레이 될 숫자 리스트 중에

		Scanner sc = new Scanner(System.in);
		String input = null;

		displayCalendar(year, month, displayDays);
		System.out.println();
		System.out.print("날짜를 선택해주세요:");
		input = sc.nextLine();

		if (input.equals(">")) {
			inputBox[0] = '>';
			return null;
		} else if (input.equals("<")) {
			inputBox[0] = '<';
			return null;
		} else if (isNumber(input)) { // 숫자 인지 체크
			int nInput = Integer.parseInt(input);

			if (nInput <= end.get(Calendar.DATE) && nInput > 0) { // 선택 가능한 날짜인지 체크
				String result = year + "-" + month + "-" + input;
				java.sql.Date transformDate = java.sql.Date.valueOf(result); // String -> Date
				return transformDate;
			} else {
				System.out.println("유효 숫자 범위가 아닙니다.");
				return null;
			}
		} else {
			System.out.println("올바르게 입력해주세요");
			return null;
		}

	}

	public void displayCalendar() {

		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		start.set(mYear, mMonth - 1, 1); // 디스플레이 할 달에 첫날로 세팅 (Calendar 는 달을 0 ~ 11로 저장해서 month-1 이 해당 달)
		end.set(mYear, mMonth, 1); // 디스플레이 다음달에 첫날로 세팅
		end.add(Calendar.DATE, -1); // 다음달 첫날에서 하루 뺴서 디스플레이 할 달에 마지막 날짜로 세팅

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // 첫날에 요일 구하기 1:일요일 7:토요일
		END_DAY = end.get(Calendar.DATE); // 마지막 일자 구하기
		System.out.println(mYear + "년 " + mMonth + "월 달력\t(>입력:다음달출력  <입력:이전달출력)");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) { // 첫날 요일 까진 공백
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { // 1일부터 마지막 날까지 출력
			System.out.print(q + "\t");
			cnt++;
			if (cnt == 7) { // 토요일 출력 후 마다 개행
				cnt = 0;
				System.out.println("\n");
			}
		}

	}

	public void displayCalendar(int year, int month) {

		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		start.set(year, month - 1, 1); // 디스플레이 할 달에 첫날로 세팅 (Calendar 는 달을 0 ~ 11로 저장해서 month-1 이 해당 달)
		end.set(year, month, 1); // 디스플레이 다음달에 첫날로 세팅
		end.add(Calendar.DATE, -1); // 다음달 첫날에서 하루 뺴서 디스플레이 할 달에 마지막 날짜로 세팅

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // 첫날에 요일 구하기 1:일요일 7:토요일
		END_DAY = end.get(Calendar.DATE); // 마지막 일자 구하기
		System.out.println(year + "년 " + month + "월 달력\t(>입력:다음달출력  <입력:이전달출력)");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) { // 첫날 요일 까진 공백
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { // 1일부터 마지막 날까지 출력
			System.out.print(q + "\t");
			cnt++;
			if (cnt == 7) { // 토요일 출력 후 마다 개행
				cnt = 0;
				System.out.println("\n");

			}
		}

	}

	public void displayCalendar(int year, int month, ArrayList<Integer> displayDays) { // 보여줄 날짜 리스트받아서 그것만 출력

		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		start.set(year, month - 1, 1); // 디스플레이 할 달에 첫날로 세팅 (Calendar 는 달을 0 ~ 11로 저장해서 month-1 이 해당 달)
		end.set(year, month, 1); // 디스플레이 다음달에 첫날로 세팅
		end.add(Calendar.DATE, -1); // 다음달 첫날에서 하루 뺴서 디스플레이 할 달에 마지막 날짜로 세팅

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // 첫날에 요일 구하기 1:일요일 7:토요일
		END_DAY = end.get(Calendar.DATE); // 마지막 일자 구하기
		System.out.println(year + "년 " + month + "월 달력\\t(>입력:다음달출력  <입력:이전달출력)");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) { // 첫날 요일 까진 공백
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { // 1일부터 마지막 날까지 출력
			if (displayDays.contains(q))
				System.out.print(q + "\t");
			else
				System.out.print("X" + "\t");
			cnt++;
			if (cnt == 7) { // 토요일 출력 후 마다 개행
				cnt = 0;
				System.out.println("\n");
			}
		}

	}

	public boolean isNumber(String str) { // 넘겨받은 문자열이 숫자 인지 체크
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