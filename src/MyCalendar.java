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
//			System.out.println("선택된 날짜:"+result);
//
//		
//		}

	public String selecteDate() { // 선택가능한 날짜 달력 출력, 날짜선택, 데이터 리턴
		Scanner sc = new Scanner(System.in);
		String input = null;
		while (true) {
			displayCalendar();
			System.out.println();
			System.out.println("날짜를 선택해주세요:");

			input = sc.nextLine();
			if (input.equals(">")) {
				mMonth++;
			}else if (input.equals("<")) {
				mMonth--;
			}else if (isNumber( input )) { // 숫자 인지 체크
				int nInput = Integer.parseInt(input);
				
				if(nInput <=end.get(Calendar.DATE) && nInput > 0 ) // 선택 가능한 날짜인지 체크
					return mYear+"-"+mMonth+"-"+input;
				else
					System.out.println("유효 숫자 범위가 아닙니다.");
			}
			else
				System.out.println("올바르게 입력해주세요");
			
		}
		
	}

	void displayCalendar() {

		int year = mYear;
		int month = mMonth;
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		
		start.set(year, month - 1, 1);  // 디스플레이 할 달에 첫날로 세팅 (Calendar 는 달을 0 ~ 11로 저장해서 month-1 이 해당 달)
		end.set(year, month, 1); 		// 디스플레이 다음달에 첫날로 세팅
		end.add(Calendar.DATE, -1);		// 다음달 첫날에서 하루 뺴서 디스플레이 할 달에 마지막 날짜로 세팅

		START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK); // 첫날에 요일 구하기 1:일요일 7:토요일
		END_DAY = end.get(Calendar.DATE); // 마지막 일자 구하기
		System.out.println(year + "년 " + month + "월 달력\t(>입력:다음달출력  <입력:이전달출력)");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		for (int q = 1; q < START_DAY_OF_WEEK; q++) {   // 첫날 요일 까진 공백
			System.out.print("\t");
		}

		int cnt = START_DAY_OF_WEEK - 1;
		for (int q = 1; q <= END_DAY; q++) { //1일부터 마지막 날까지 출력
			System.out.print(q + "\t");
			cnt++;
			if (cnt == 7) { //토요일 출력 후 마다 개행
				cnt = 0;
				System.out.println("\n");
			}
		}

	}
	
	boolean isNumber(String str) { // 넘겨받은 문자열이 숫자 인지 체크
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
