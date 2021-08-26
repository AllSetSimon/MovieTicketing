import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class SystemManager {

	private Scanner sc;
	
	private Customer customer;
	private ArrayList<Theater> theaterList;
	private ArrayList<Movie> showingList;
	private ArrayList<TimeTable> timeList;
	private ArrayList<String> resultList;
	private Map<TimeTable,Seat> seatMap;
	
	private ReserveList reserveList;
	private MyCalendar myCalendar;
	
	private int selNum;
	private String mvName;
	private Date date;
	private String theaterName;
	private TimeTable timetable;
	private ArrayList<Integer> seatNumberList;
	private int price;
	private int selectTime;
	
	public SystemManager() {
		sc = new Scanner(System.in);
		theaterList = new ArrayList<Theater>();
		showingList = new ArrayList<Movie>();
		timeList = new ArrayList<TimeTable>();
		resultList = new ArrayList<String>();
		seatMap = new HashMap<>();
		customer = new Customer();
		seatNumberList = new ArrayList<Integer>();
		
		// Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("싱크홀", "액션", "봉찬욱", "이광수", "싱크홀줄거리", "2021-08-15", 0.0);
		Movie bossBB = new Movie("보스베이비2", "애니메이션", "세스로건", "보스", "보스베이비줄거리", "2021-08-07", 0.0);
		Movie mogaDS = new Movie("모가디슈", "액션", "박찬봉", "조인성", "모가디슈줄거리", "2021-08-12", 0.0);
		
		showingList.add(sinkHole);
		showingList.add(mogaDS);
		showingList.add(bossBB);

		Theater lotteJamsil = new Theater("롯데시네마 잠실", "잠실");
		Theater cgvGangnam = new Theater("CGV 강남", "강남");

		lotteJamsil.setupTimeTable(sinkHole, new TimeTable("2021-08-25", "09:00", 5, 35));
		lotteJamsil.setupTimeTable(sinkHole, new TimeTable("2021-08-25", "10:00", 4, 32));
		lotteJamsil.setupTimeTable(mogaDS, new TimeTable("2021-08-12", "11:00", 7, 36));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-07", "12:00", 6, 38));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-08", "13:00", 1, 50));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-08", "14:00", 3, 40));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-10", "15:00", 2, 20));
		cgvGangnam.setupTimeTable(sinkHole, new TimeTable("2021-08-18", "16:00", 1, 15));
	//	cgvGangnam.setupTimeTable(mogaDS, new TimeTable("2021-08-16", "17:00", 2, 30));
		cgvGangnam.setupTimeTable(bossBB, new TimeTable("2021-08-13", "18:00", 3, 60));

		theaterList.add(lotteJamsil);
		theaterList.add(cgvGangnam);
		showSeatMapAdd();
	}

	public void nowShowing(int inputNum) {
		// 상영중인 영화 리스트 출력
		System.out.println("==============================");
		System.out.println("              현재 상영중인 영화입니다");
		System.out.println("==============================");

		for (int i = 0; i < showingList.size(); i++) {
			System.out.println("        " + (i + 1) + ". " + showingList.get(i).getTitle());
		}
		
		if(inputNum == 1) {
			System.out.println("==============================");
			System.out.print("세부정보를 원하시는 영화를 선택해주세요 : ");
			selNum = Integer.parseInt(sc.nextLine());
			showDetail(selNum);
		} else {
			System.out.println("==============================");
			System.out.print("관람을 원하시는 영화를 선택해주세요:");
			selNum = Integer.parseInt(sc.nextLine());
			showTheater(selNum);
		}
		System.out.println("==============================");
		//showTheater(selNum);
	}

	public void showDetail(int selectNum) {
		// 영화 상세정보 출력
		System.out.println("==============================");
		System.out.println("제목 : " + showingList.get(selectNum - 1).getTitle());
		System.out.println("장르 : " + showingList.get(selectNum - 1).getGenre());
		System.out.println("감독 : " + showingList.get(selectNum - 1).getDirector());
		System.out.println("출연진 : " + showingList.get(selectNum - 1).getActor());
		System.out.println("개봉일 : " + showingList.get(selectNum - 1).getRelease());
		System.out.println("관객평점 : " + showingList.get(selectNum).getRating());
		System.out.println("줄거리 : " + showingList.get(selectNum - 1).getPlot());
	}

	public void showTheater(int selectNum) {
		// mvName = showingList에서 내가 선택한 인덱스 값을 가져오도록 설정
		mvName = showingList.get(selectNum-1).getTitle();
		resultList.clear();

		// map에서 get(key값)
		// p key : 3, value : "C"
		// p.get(3) ==> String ["C"]

		/*
		 * for (int i = 0; i < 어떤게 들어와야 할지; i++) { //getMovieMap().get(key) ==> 결과값을
		 * resultList에 add하겠다. }
		 */
		
		for (int i = 0; i < theaterList.size(); i++) {
			resultList.add(theaterList.get(i).getMovieMap().get(mvName));
		}

		// resultList를 for문을 통해서 그 안에 있는 내용을 다 꺼내는 거에요
		// 1. 2. (index+1)값이 붙도록 --> 향상for문X
		
		for (int i = 0; i < resultList.size(); i++) {
			if(resultList.get(i)!=null) {System.out.println("        "+(i+1)+". "+resultList.get(i));}
		}
		
		System.out.println("==============================");
		System.out.print("관람을 원하는 극장을 선택해주세요:");
		selNum = Integer.parseInt(sc.nextLine());
		System.out.println("==============================");
		selectCalData();
	}
	
	public void selectCalData() {			
			myCalendar = new MyCalendar(2021, 8);
			date = myCalendar.selecteDate();
			System.out.println("선택된 날짜 확인 : " + date);
			showTimeList(selNum);
	}
	
	public void showTimeList(int selectNum) {
		theaterName = resultList.get(selectNum-1);
		resultList.clear();
		timeList.clear();
		
		//new
		int compare = 0;
		for (int i = 0; i < theaterList.size(); i++) {
			Set<Entry<TimeTable, String>> mapEntry = theaterList.get(i).getTimeMap().entrySet();
			for(Entry<TimeTable, String> entry : mapEntry) {
				compare = date.compareTo(entry.getKey().getDate());
				//System.out.println(compare);
				if(theaterList.get(i).getTheaterName().equals(theaterName) && entry.getValue().equals(mvName)) {
					if(compare == 0) {						
						timeList.add(entry.getKey());
					}
				}
			}
		}
		
		if(timeList.size() == 0) {
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			System.out.println("해당 일자의 상영시간표가 존재하지 않습니다.");
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			//nowShowing(2);
			//selectCalData();
		} else {
			do {
				System.out.println("==============================");
				System.out.println("해당 극장의 상영시간표는 다음과 같습니다.");
				System.out.println("==============================");
				Collections.sort(timeList,new TimeTableComparator());
				for (int i = 0; i < timeList.size(); i++) {
					if(i == 0) {
						System.out.print("    [" + timeList.get(i).getShowRoomNum() + "관] " +(i+1) + ". " + timeList.get(i).getStartTime()+ " [" + timeList.get(i).getSeatCount() + "석]");
					} else {
						if(timeList.get(i-1).getShowRoomNum() == timeList.get(i).getShowRoomNum()) {
							System.out.print(" " + (i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "석]");				
						} else {
							System.out.println();
							System.out.print("    [" + timeList.get(i).getShowRoomNum() + "관] " +(i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "석]");
						}
					}
				}				
				System.out.println();
				System.out.println("==============================");
				System.out.print("관람을 원하는 시간표를 선택해주세요 : ");
				selectTime = Integer.parseInt(sc.nextLine());
				System.out.println("==============================");
				if (selectTime > timeList.size()) {
					System.out.println("다시 입력해주세요.");
				}
			}while(selectTime > timeList.size());
				timetable = timeList.get(selectTime-1);
				showSeat(timetable);
		}	
	}
	
	//seatMap put class
	public void showSeatMapAdd() {
		for (int i = 0; i <theaterList.size(); i++) {
			for (int j = 0; j <theaterList.get(i).getTimeList().size(); j++) {
				seatMap.put(theaterList.get(i).getTimeList().get(j), new Seat(theaterList.get(i).getTimeList().get(j)));
			}
		}
	}
	
	//seat 출력 class
	public void showSeat(TimeTable timetable) {
		seatNumberList.clear();
		seatMap.get(timetable).seatLook();
		//선택한 좌석들 저장
		seatNumberList.addAll(seatMap.get(timetable).getSeatRangementList());
		showFinalRsv();
	}
	
	public void showFinalRsv () {
		String time = timetable.getStartTime();
		String[] timePieces = time.split(":");	
		int numTime = Integer.parseInt(timePieces[0]);
		
		System.out.println("==============================");
		System.out.println("고객님의 최종 예매 정보는 다음과 같습니다");
		System.out.println("1.영화 :" + mvName);
		System.out.println("2.날짜 :" + date);
		System.out.println("3.상영극장 :" + theaterName);
		System.out.println("4.상영관 및 시간 : " + "[" + timetable.getShowRoomNum() +"관]"+ timetable.getStartTime());
		System.out.print("5.좌석번호 : ");
		for (int num : seatNumberList) {System.out.print(num + " ");}
		System.out.println();
		System.out.print("6.가격 : ");
		if(numTime >= 7 && numTime < 12) {
			price = 7000;
			System.out.println(price*seatNumberList.size() + "원 (조조할인 적용)");
		} else {
			price = 11000;
			System.out.println(price*seatNumberList.size() + "원 (일반가)");
		}
		System.out.println("==============================");
		System.out.print("예매를 원하시면 ‘yes’ 처음으로 돌아가려면 ‘no’을 입력하세요 :");
		String check = sc.nextLine();
		System.out.println("==============================");
		
		if(check.equals("yes")) {
			reserveList = new ReserveList(mvName,date,theaterName,timetable.getShowRoomNum(),timetable.getStartTime(),seatNumberList);
			customer.addRsvInfo(reserveList);
			System.out.println("예매가 완료 되었습니다.");
			//return reserveList;
		}else {
			System.out.println("예매가 취소 되었습니다.");	
			//return null;  
		}
	}	
	
	public void checkRsv() {
		customer.showRsvInfo();
	}
}
