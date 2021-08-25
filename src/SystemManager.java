import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class SystemManager {

	Scanner sc = new Scanner(System.in);
	
	ArrayList<Theater> theaterList = new ArrayList<Theater>();
	ArrayList<Movie> showingList = new ArrayList<Movie>();
	ArrayList<TimeTable> timeList = new ArrayList<TimeTable>();
	ArrayList<String> resultList = new ArrayList<String>();;
	
	int selNum;
	String mvName;
	String theaterName;

	public SystemManager() {
		// Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("싱크홀", "액션", "봉찬욱", "이광수", "싱크홀줄거리", "2021-08-15", 0.0);
		Movie bossBB = new Movie("보스베이비2", "애니메이션", "세스로건", "보스", "보스베이비줄거리", "2021-08-07", 0.0);
		Movie mogaDS = new Movie("모가디슈", "액션", "박찬봉", "조인성", "모가디슈줄거리", "2021-08-12", 0.0);
		
		showingList.add(sinkHole);
		showingList.add(mogaDS);
		showingList.add(bossBB);

		Theater lotteJamsil = new Theater("롯데시네마 잠실", "잠실");
		Theater cgvGangnam = new Theater("CGV 강남", "강남");

		lotteJamsil.setupTimeTable(sinkHole, new TimeTable("2021-08-15", "09:00", 5, 30));
		lotteJamsil.setupTimeTable(sinkHole, new TimeTable("2021-08-16", "10:00", 4, 30));
		lotteJamsil.setupTimeTable(mogaDS, new TimeTable("2021-08-12", "11:00", 7, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-07", "12:00", 6, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-08", "13:00", 1, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-09", "14:00", 3, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-10", "15:00", 2, 30));
		cgvGangnam.setupTimeTable(sinkHole, new TimeTable("2021-08-18", "16:00", 1, 30));
	//	cgvGangnam.setupTimeTable(mogaDS, new TimeTable("2021-08-16", "17:00", 2, 30));
		cgvGangnam.setupTimeTable(bossBB, new TimeTable("2021-08-13", "18:00", 3, 30));

		theaterList.add(lotteJamsil);
		theaterList.add(cgvGangnam);

	}

	public void nowShowing(int inputNum) {
		// 상영중인 영화 리스트 출력
		System.out.println("======================");
		System.out.println("현재 상영중인 영화입니다");
		System.out.println("======================");

		for (int i = 0; i < showingList.size(); i++) {
			System.out.println((i + 1) + ". " + showingList.get(i).getTitle());
		}
		
		if(inputNum == 1) {
			System.out.println("======================");
			System.out.print("세부정보를 원하시는 영화를 선택해주세요:");
			selNum = Integer.parseInt(sc.nextLine());
			showDetail(selNum);
		} else {
			System.out.println("======================");
			System.out.print("관람을 원하시는 영화를 선택해주세요:");
			selNum = Integer.parseInt(sc.nextLine());
			showTheater(selNum);
		}

		System.out.println("======================");
	}

	public void showDetail(int selectNum) {
		// 영화 상세정보 출력
		System.out.println("======================");
		System.out.println("제목 :" + showingList.get(selectNum - 1).getTitle());
		System.out.println("장르 :" + showingList.get(selectNum - 1).getGenre());
		System.out.println("감독 :" + showingList.get(selectNum - 1).getDirector());
		System.out.println("출연진 :" + showingList.get(selectNum - 1).getActor());
		System.out.println("개봉일 :" + showingList.get(selectNum - 1).getRelease());
		System.out.println("관객평점 :" + showingList.get(selectNum).getRating());
		System.out.println("줄거리 :" + showingList.get(selectNum - 1).getPlot());
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
			if(resultList.get(i)!=null) {System.out.println((i+1)+"."+resultList.get(i));}
		}
		
		System.out.println("================");
		System.out.print("관람을 원하는 극장을 선택해주세요:");
		selNum = Integer.parseInt(sc.nextLine());
		System.out.println("================");
		selectCalData();
	}
	
	public void selectCalData() {
		MyCalendar myCalendar = new MyCalendar(2021, 8);
		String selectedDate = myCalendar.selecteDate();
		System.out.println("선택된 날짜 확인:" + selectedDate);
		showTimeList(selNum);
	}
	
	public void showTimeList(int selectTh) {
		theaterName = resultList.get(selectTh-1);
		resultList.clear();
		timeList.clear();

		for (int i = 0; i < theaterList.size(); i++) {
			Set<Entry<TimeTable, String>> mapEntry = theaterList.get(i).getTimeMap().entrySet();
			for(Entry<TimeTable, String> entry : mapEntry) {
				if(theaterList.get(i).getTheaterName().equals(theaterName) && entry.getValue().equals(mvName)) {
					timeList.add(entry.getKey());
				}
			}
		}
		
		if(timeList.size() == 0) {
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			System.out.println("조회된 시간표가 없습니다.");
			System.out.println("XXXXXXXXXXXXXXXXXXX");
		} else {
			System.out.println("==============================");
			System.out.println("해당 극장의 상영시간표는 다음과 같습니다.");
			System.out.println("==============================");
			for (int i = 0; i < timeList.size(); i++) {
				if(i == 0) {
					System.out.print("[" + timeList.get(i).getShowRoomNum() + "관] " +(i+1) + ". " + timeList.get(i).getStartTime()+ " [" + timeList.get(i).getSeatCount() + "석]");
				} else {
					if(timeList.get(i-1).getShowRoomNum() == timeList.get(i).getShowRoomNum()) {
						System.out.print(" " + (i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "석]");				
					} else {
						System.out.println();
						System.out.print("[" + timeList.get(i).getShowRoomNum() + "관] " +(i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "석]");
					}
				}
			}			
			System.out.println();
			System.out.println("=============================");
			System.out.print("관람을 원하는 시간표를 선택해주세요 : ");
			int selectTime = Integer.parseInt(sc.nextLine());
			System.out.println("=============================");
		}		
	}
	
	
	
	
	
	
	
	
}
