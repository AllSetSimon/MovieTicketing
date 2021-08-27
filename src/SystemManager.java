import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	private Map<TimeTable, Seat> seatMap;

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
	private String loginId;

	private Customer currentCustomer = null;
	private ArrayList<Customer> customerList;

	public SystemManager() {
		sc = new Scanner(System.in);
		theaterList = new ArrayList<Theater>();
		showingList = new ArrayList<Movie>();
		timeList = new ArrayList<TimeTable>();
		resultList = new ArrayList<String>();
		seatMap = new HashMap<>();
		customerList = new ArrayList<Customer>();

		try { // 파일 초기화
			BufferedWriter file;
			file = new BufferedWriter(new FileWriter("./src/loginData.txt"));
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customerList.add(new Customer("갈아만든배", "1234", "강구현", 95000));
		customerList.add(new Customer("Simon", "1234", "박수빈", 55000));
		customerList.add(new Customer("뜬혁", "1234", "신승혁", 43000));
		customerList.add(new Customer("SkyWalker", "1234", "임준석", 57000));
		customerList.add(new Customer("svra0945", "1234", "장동주", 50000));

		// Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("싱크홀", "드라마", "김지훈", "차승원, 김성균, 이광수, 김혜준, 남다름 등",
				"서울 입성과 함께 내 집 마련의 꿈을 이룬 가장 ‘동원(김성균)’ \n이사 첫날부터 프로 참견러 ‘만수’(차승원)와 사사건건 부딪힌다. \n‘동원’은 자가취득을 기념하며 직장 동료들을 집들이에 초대하지만 행복한 단꿈도 잠시, \n순식간에 빌라 전체가 땅 속으로 떨어지고 만다. \n마주치기만 하면 투닥거리는 빌라 주민 ‘만수’와 ‘동원’ ‘동원’의 집들이에 왔던 ‘김대리’(이광수)와 인턴사원 ‘은주’(김혜준)까지! \n지하 500m 싱크홀 속으로 떨어진 이들은 과연 무사히 빠져나갈 수 있을까? \n“한 500m 정도는 떨어진 것 같아” “우리… 나갈 수 있을까요?”",
				"2021-08-11", 0.0);
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
		// cgvGangnam.setupTimeTable(mogaDS, new TimeTable("2021-08-16", "17:00", 2,
		// 30));
		cgvGangnam.setupTimeTable(bossBB, new TimeTable("2021-08-13", "18:00", 3, 60));

		theaterList.add(lotteJamsil);
		theaterList.add(cgvGangnam);
		showSeatMapAdd();
	}

	public void loginProcess() {
		loginId = null;
		Login login = new Login();
		loginId = login.loginProcess();
		if (loginId == null) {
			currentCustomer = null;
		} else {
			for (Customer customer : customerList) {
				if (customer.getId().equals(loginId)) {
					currentCustomer = customer;
				}
			}
		}
	}

	public void nowShowing(int inputNum) {
		// 상영중인 영화 리스트 출력
		int resultCode = 0; //
		do {
			System.out.println("==============================");
			System.out.println("       현재 상영중인 영화입니다");
			System.out.println("==============================");

			for (int i = 0; i < showingList.size(); i++) {
				System.out.println("        " + (i + 1) + ". " + showingList.get(i).getTitle());
			}

			System.out.println("==============================");

			if (inputNum == 1) {

				try {
					System.out.print("세부정보를 원하시는 영화를 선택해주세요(이전화면은 0번 입력):");
					selNum = Integer.parseInt(sc.nextLine());
					if (selNum != 0 && selNum <= showingList.size()) {
						resultCode = showDetail(selNum);
						System.out.println("========================================================");

					} else if (selNum > showingList.size()) {
						System.out.println("올바른 번호를 입력해주세요:");

					} else if (selNum == 0) {
						break;
					}
				} catch (Exception e) {
					System.out.println("형식에 알맞지 않습니다");
				}

			} else if (inputNum == 2) {
				while (true) {
					try {
						System.out.print("관람을 원하시는 영화를 선택해주세요(이전화면은 0번 입력):");
						selNum = Integer.parseInt(sc.nextLine());
						if (selNum != 0 && selNum <= showingList.size()) {
							showTheater(selNum);
						} else if (selNum > showingList.size()) {
							System.out.println("올바른 번호를 입력해주세요");
						} else if (selNum == 0) {
							break;
						}
						break;
					} catch (Exception e) {
						System.out.println("형식에 알맞지 않습니다");
					}
				}
			} else if (inputNum == 3) {
				System.out.print("평점 입력을 원하는 영화를 선택해주세요:");
				selNum = Integer.parseInt(sc.nextLine());
				inputRating(selNum);
			} else {
				System.out.println("==============================");
			}

		} while (resultCode == 1);

	}

	public void inputRating(int selectNum) {

		System.out.println("====================");
		System.out.println("선택한 영화 : " + showingList.get(selectNum - 1).getTitle());
		System.out.println("해당 영화의 현재 평점 : " + String.format("%.2f", showingList.get(selectNum - 1).getRating()) + "점");
		System.out.println("====================");

		double inputScore = 0.0;

		while (true) {
			System.out.print("해당 영화의 평점을 입력해주세요 : ");
			try {
				inputScore = Double.parseDouble(sc.nextLine());
				if (!(inputScore >= 0.0 && inputScore <= 10.0)) {
					System.out.println("0부터 10점 이내의 평점 입력만 가능합니다.");
					continue;
				} else {
					showingList.get(selectNum - 1).setRating(inputScore);
					System.out.print("입력이 완료되었습니다. 다른 영화의 평점도 입력하시겠습니까? (Y/N) : ");
					String inputRetry = sc.nextLine();
					if (inputRetry.equalsIgnoreCase("Y")) {
						nowShowing(3);
					} else {
						System.out.println("메인으로 돌아갑니다.");
					}
				}
			} catch (Exception e) {
				System.out.println("잘못된 형식입니다.");
				continue;
			}
			break;
		}
	}

	public int showDetail(int selectNum) {
		// 영화 상세정보 출력
		System.out.println("========================================================");
		System.out.println("제목 : " + showingList.get(selectNum - 1).getTitle());
		System.out.println("장르 : " + showingList.get(selectNum - 1).getGenre());
		System.out.println("감독 : " + showingList.get(selectNum - 1).getDirector());
		System.out.println("출연진 : " + showingList.get(selectNum - 1).getActor());
		System.out.println("개봉일 : " + showingList.get(selectNum - 1).getRelease());
		System.out.println("관객평점 : " + showingList.get(selectNum - 1).getRating());
		System.out.println("줄거리 : " + showingList.get(selectNum - 1).getPlot());
		return 1;
	}

	public void showTheater(int selectNum) {

		mvName = showingList.get(selectNum - 1).getTitle();
		resultList.clear();

		for (int i = 0; i < theaterList.size(); i++) {
			resultList.add(theaterList.get(i).getMovieMap().get(mvName));
		}
		System.out.println("==============================");
		for (int i = 0; i < resultList.size(); i++) {
			if (resultList.get(i) != null) {
				System.out.println((i + 1) + "." + resultList.get(i));
			}
		}

		while (true) {
			System.out.println("==============================");
			System.out.print("관람을 원하는 극장을 선택해주세요:");
			try {
				selNum = Integer.parseInt(sc.nextLine());
				System.out.println("==============================");
				if (selNum == 0 || selNum > resultList.size()) {
					System.out.println("다시 입력해주세요!");
				} else {
					selectCalData();
					break;
				}
			} catch (Exception e) {
				System.out.println("==============================");
				System.out.println("올바른 형식으로 입력해주세요");
			}
		}
	}

	public void selectCalData() {
		myCalendar = new MyCalendar(2021, 8);
		date = myCalendar.selecteDate();
		System.out.println("선택된 날짜 확인 : " + date);
		showTimeList(selNum);
	}

	public void showTimeList(int selectNum) {
		theaterName = resultList.get(selectNum - 1);
		resultList.clear();
		timeList.clear();

		// new
		int compare = 0;
		for (int i = 0; i < theaterList.size(); i++) {
			Set<Entry<TimeTable, String>> mapEntry = theaterList.get(i).getTimeMap().entrySet();
			for (Entry<TimeTable, String> entry : mapEntry) {
				compare = date.compareTo(entry.getKey().getDate());
				// System.out.println(compare);
				if (theaterList.get(i).getTheaterName().equals(theaterName) && entry.getValue().equals(mvName)) {
					if (compare == 0) {
						timeList.add(entry.getKey());
					}
				}
			}
		}

		if (timeList.size() == 0) {
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			System.out.println("해당 일자의 상영시간표가 존재하지 않습니다.");
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			// nowShowing(2);
			// selectCalData();
		} else {
			do {
				System.out.println("==============================");
				System.out.println("해당 극장의 상영시간표는 다음과 같습니다.");
				System.out.println("==============================");
				Collections.sort(timeList, new TimeTableComparator());
				for (int i = 0; i < timeList.size(); i++) {
					if (i == 0) {
						System.out.print("    [" + timeList.get(i).getShowRoomNum() + "관] " + (i + 1) + ". "
								+ timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "석]");
					} else {
						if (timeList.get(i - 1).getShowRoomNum() == timeList.get(i).getShowRoomNum()) {
							System.out.print(" " + (i + 1) + ". " + timeList.get(i).getStartTime() + " ["
									+ timeList.get(i).getSeatCount() + "석]");
						} else {
							System.out.println();
							System.out.print("    [" + timeList.get(i).getShowRoomNum() + "관] " + (i + 1) + ". "
									+ timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "석]");
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
			} while (selectTime > timeList.size());
			timetable = timeList.get(selectTime - 1);
			showSeat(timetable);
		}
	}

	// seatMap put class
	public void showSeatMapAdd() {
		for (int i = 0; i < theaterList.size(); i++) {
			for (int j = 0; j < theaterList.get(i).getTimeList().size(); j++) {
				seatMap.put(theaterList.get(i).getTimeList().get(j), new Seat(theaterList.get(i).getTimeList().get(j)));
			}
		}
	}

	// seat 출력 class
	public void showSeat(TimeTable timetable) {
		// seatNumberList.clear();
		seatNumberList = new ArrayList<Integer>();
		seatMap.get(timetable).seatLook();
		// 선택한 좌석들 저장

		seatNumberList.addAll(seatMap.get(timetable).getSeatRangementList());
		if (seatNumberList.size() >= 1) {
			showFinalRsv();
		}
	}

	public void showFinalRsv() {
		String time = timetable.getStartTime();

		String[] timePieces = time.split(":");
		int numTime = Integer.parseInt(timePieces[0]);

		System.out.println("==============================");
		System.out.println(currentCustomer.getNickname() + "님의 최종 예매 정보는 다음과 같습니다");
		System.out.println("1.영화 :" + mvName);
		System.out.println("2.날짜 :" + date);
		System.out.println("3.상영극장 :" + theaterName);
		System.out.println("4.상영관 및 시간 : " + "[" + timetable.getShowRoomNum() + "관]" + timetable.getStartTime());
		System.out.print("5.좌석번호 : ");
		for (int num : seatNumberList) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.print("6.가격 : ");
		if (numTime >= 7 && numTime < 12) {
			price = 7000;
			System.out.println(price * seatNumberList.size() + "원 (조조할인 적용)");
		} else {
			price = 11000;
			System.out.println(price * seatNumberList.size() + "원 (일반가)");
		}
		System.out.println("==============================");
		System.out.print("예매를 원하시면 ‘yes’ 처음으로 돌아가려면 ‘no’을 입력하세요 :");
		String check = sc.nextLine();
		System.out.println("==============================");

		if (check.equals("yes")) {
			if (currentCustomer.getPrice() < price * seatNumberList.size()) {
				System.out.println("사용자의 소지금액이 부족하여 예매가 취소 되었습니다.");
				// System.out.println(currentCustomer.getPrice());
			} else {
				reserveList = new ReserveList(mvName, theaterName, seatNumberList, price * seatNumberList.size(),
						timetable);
				// System.out.println(reserveList.getSeatNum());
				currentCustomer.addRsvInfo(reserveList);
				// ArrayList<ReserveList> resultTest = currentCustomer.getRsvList();
//				for (int i = 0; i < resultTest.size(); i++) {
//					System.out.println(resultTest.get(i).getSeatNum());
//				}
				System.out.println("예매가 완료 되었습니다.");
				// return reserveList;
				currentCustomer.setPrice(currentCustomer.getPrice() - (price * seatNumberList.size()));
				System.out.println("고객님의 잔액은 " + currentCustomer.getPrice() + "원 입니다");
			}
		} else {
			seatListRemove(timetable);
			System.out.println("예매가 취소 되었습니다.");
			// return null;
		}
	}

	// 예매 취소시 좌석 반환
	public void seatListRemove(TimeTable timetable) {

		int firstIndex = 0;
		int secondIndex = 0;

		for (Integer integer : seatNumberList) {

			if (integer % seatMap.get(timetable).getSeatLineNumber() == 0) {

				firstIndex = (integer / seatMap.get(timetable).getSeatLineNumber()) - 1;
				secondIndex = seatMap.get(timetable).getSeatLineNumber() - 1;

			} else {

				firstIndex = integer / seatMap.get(timetable).getSeatLineNumber();
				secondIndex = (integer % seatMap.get(timetable).getSeatLineNumber()) - 1;

			}

			seatMap.get(timetable).getSeatList()[firstIndex][secondIndex] = String
					.valueOf(seatMap.get(timetable).getSeatSelectPossible());

		}

		seatMap.get(timetable).setSeatList(seatMap.get(timetable).getSeatList());

	}

	public void showRsvInfo() {
		if (currentCustomer.getRsvList().size() == 0) {
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println("    " + currentCustomer.getNickname() + "님의 예매 내역이 존재하지 않습니다.    ");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else {
			System.out.println("==================================");
			System.out.println("    " + currentCustomer.getNickname() + "님의 예매 내역은 다음과 같습니다.    ");
			System.out.println("==================================");

			for (int i = 0; i < currentCustomer.getRsvList().size(); i++) {
				System.out.println((i + 1) + ". " + currentCustomer.getRsvList().get(i).getTitle() + " / "
						+ currentCustomer.getRsvList().get(i).getRsvDate() + " / "
						+ currentCustomer.getRsvList().get(i).getTheaterName());
			}

			System.out.print("상세내역을 원하는 항목을 선택하세요 : ");
			int selectNum = Integer.parseInt(sc.nextLine());
			showDetailList(selectNum);
		}
	}

	public void showDetailList(int selectNum) {

		System.out.println("=======================================");
		System.out.println("  " + currentCustomer.getNickname() + "님께서 선택하신 예매 정보는 다음과 같습니다.   ");
		System.out.println("=======================================");

		System.out.println("1.영화 : " + currentCustomer.getRsvList().get(selectNum - 1).getTitle());
		System.out.println("2.날짜 : " + currentCustomer.getRsvList().get(selectNum - 1).getRsvDate());
		System.out.println("3.상영극장 : " + currentCustomer.getRsvList().get(selectNum - 1).getTheaterName());
		System.out.println("4.상영관 및 시간 : " + "[" + currentCustomer.getRsvList().get(selectNum - 1).getShowRoomNum()
				+ "관] " + currentCustomer.getRsvList().get(selectNum - 1).getStartTime());
		System.out.println("5.좌석번호 : " + currentCustomer.getRsvList().get(selectNum - 1).getSeatNum());
		System.out.print("예매 취소를 원하시면 'C', 메인메뉴로 돌아가시려면 'H'를 눌러주세요 : ");
		String select = sc.nextLine();
		if (select.equalsIgnoreCase("C")) {
			System.out.println("=======================================");

			seatListRemove(currentCustomer.getRsvList().get(selectNum - 1));

			ArrayList<ReserveList> rsvList = currentCustomer.getRsvList();
			rsvList.remove(selectNum - 1);
			currentCustomer.setRsvList(rsvList);

			System.out.println("예매 취소 완료!");

		}
	}

	public void seatListRemove(ReserveList reserveList) {
		
		Seat seat = seatMap.get(reserveList.getTimeTable());			
		int seatNum = seat.getSeatLineNumber();
		
		for (int i = 0; i < reserveList.getSeatNum().size(); i++) {
			
			int seatNumber = reserveList.getSeatNum().get(i);
			
			if (seatNumber % seatNum == 0) {
				
				int firstIndex = (seatNumber / seatNum) - 1;
				int secondIndex = seatNum - 1;
				seat.getSeatList()[firstIndex][secondIndex] = String.valueOf(seat.getSeatSelectPossible());
				seat.setSeatList(seat.getSeatList());
				
			} else {
				
				int firstIndex = seatNumber / seatNum;
				int secondIndex = (seatNumber % seatNum) - 1;
				seat.getSeatList()[firstIndex][secondIndex] = String.valueOf(seat.getSeatSelectPossible());
				seat.setSeatList(seat.getSeatList());
				
			}
		}
	}

	public boolean reLogin() {
		String answer = null;
		currentCustomer = null;
		System.out.println("로그아웃 되었습니다.");
		while (true) {
			System.out.println("다시 로그인 하시겠습니까? (‘yes’ , ‘no’을 입력하세요)");
			answer = sc.nextLine();
			if (answer.equals("yes")) {
				loginProcess();
				if (currentCustomer != null)
					return true;
				else
					return false;

			} else if (answer.equals("no")) {
				return false;
			} else
				System.out.println("yes or no 를 입력해주세요");
		}
	}

	public void checkRsv() {
		showRsvInfo();
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

}
