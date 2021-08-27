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

		try { // ���� �ʱ�ȭ
			BufferedWriter file;
			file = new BufferedWriter(new FileWriter("./src/loginData.txt"));
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		customerList.add(new Customer("���Ƹ����", "1234", "������", 95000));
		customerList.add(new Customer("Simon", "1234", "�ڼ���", 55000));
		customerList.add(new Customer("����", "1234", "�Ž���", 43000));
		customerList.add(new Customer("SkyWalker", "1234", "���ؼ�", 57000));
		customerList.add(new Customer("svra0945", "1234", "�嵿��", 50000));

		// Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("��ũȦ", "���", "������", "���¿�, �輺��, �̱���, ������, ���ٸ� ��",
				"���� �Լ��� �Բ� �� �� ������ ���� �̷� ���� ������(�輺��)�� \n�̻� ù������ ���� ���߷� ��������(���¿�)�� ���ǰ� �ε�����. \n���������� �ڰ������ ����ϸ� ���� ������� �����̿� �ʴ������� �ູ�� �ܲ޵� ���, \n���İ��� ���� ��ü�� �� ������ �������� ����. \n����ġ�⸸ �ϸ� ���ڰŸ��� ���� �ֹ� ���������� �������� ���������� �����̿� �Դ� ����븮��(�̱���)�� ���ϻ�� �����֡�(������)����! \n���� 500m ��ũȦ ������ ������ �̵��� ���� ������ �������� �� ������? \n���� 500m ������ ������ �� ���ơ� ���츮�� ���� �� �������?��",
				"2021-08-11", 0.0);
		Movie bossBB = new Movie("�������̺�2", "�ִϸ��̼�", "�����ΰ�", "����", "�������̺��ٰŸ�", "2021-08-07", 0.0);
		Movie mogaDS = new Movie("�𰡵�", "�׼�", "������", "���μ�", "�𰡵��ٰŸ�", "2021-08-12", 0.0);

		showingList.add(sinkHole);
		showingList.add(mogaDS);
		showingList.add(bossBB);

		Theater lotteJamsil = new Theater("�Ե��ó׸� ���", "���");
		Theater cgvGangnam = new Theater("CGV ����", "����");

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
		// ������ ��ȭ ����Ʈ ���
		int resultCode = 0; //
		do {
			System.out.println("==============================");
			System.out.println("       ���� ������ ��ȭ�Դϴ�");
			System.out.println("==============================");

			for (int i = 0; i < showingList.size(); i++) {
				System.out.println("        " + (i + 1) + ". " + showingList.get(i).getTitle());
			}

			System.out.println("==============================");

			if (inputNum == 1) {

				try {
					System.out.print("���������� ���Ͻô� ��ȭ�� �������ּ���(����ȭ���� 0�� �Է�):");
					selNum = Integer.parseInt(sc.nextLine());
					if (selNum != 0 && selNum <= showingList.size()) {
						resultCode = showDetail(selNum);
						System.out.println("========================================================");

					} else if (selNum > showingList.size()) {
						System.out.println("�ùٸ� ��ȣ�� �Է����ּ���:");

					} else if (selNum == 0) {
						break;
					}
				} catch (Exception e) {
					System.out.println("���Ŀ� �˸��� �ʽ��ϴ�");
				}

			} else if (inputNum == 2) {
				while (true) {
					try {
						System.out.print("������ ���Ͻô� ��ȭ�� �������ּ���(����ȭ���� 0�� �Է�):");
						selNum = Integer.parseInt(sc.nextLine());
						if (selNum != 0 && selNum <= showingList.size()) {
							showTheater(selNum);
						} else if (selNum > showingList.size()) {
							System.out.println("�ùٸ� ��ȣ�� �Է����ּ���");
						} else if (selNum == 0) {
							break;
						}
						break;
					} catch (Exception e) {
						System.out.println("���Ŀ� �˸��� �ʽ��ϴ�");
					}
				}
			} else if (inputNum == 3) {
				System.out.print("���� �Է��� ���ϴ� ��ȭ�� �������ּ���:");
				selNum = Integer.parseInt(sc.nextLine());
				inputRating(selNum);
			} else {
				System.out.println("==============================");
			}

		} while (resultCode == 1);

	}

	public void inputRating(int selectNum) {

		System.out.println("====================");
		System.out.println("������ ��ȭ : " + showingList.get(selectNum - 1).getTitle());
		System.out.println("�ش� ��ȭ�� ���� ���� : " + String.format("%.2f", showingList.get(selectNum - 1).getRating()) + "��");
		System.out.println("====================");

		double inputScore = 0.0;

		while (true) {
			System.out.print("�ش� ��ȭ�� ������ �Է����ּ��� : ");
			try {
				inputScore = Double.parseDouble(sc.nextLine());
				if (!(inputScore >= 0.0 && inputScore <= 10.0)) {
					System.out.println("0���� 10�� �̳��� ���� �Է¸� �����մϴ�.");
					continue;
				} else {
					showingList.get(selectNum - 1).setRating(inputScore);
					System.out.print("�Է��� �Ϸ�Ǿ����ϴ�. �ٸ� ��ȭ�� ������ �Է��Ͻðڽ��ϱ�? (Y/N) : ");
					String inputRetry = sc.nextLine();
					if (inputRetry.equalsIgnoreCase("Y")) {
						nowShowing(3);
					} else {
						System.out.println("�������� ���ư��ϴ�.");
					}
				}
			} catch (Exception e) {
				System.out.println("�߸��� �����Դϴ�.");
				continue;
			}
			break;
		}
	}

	public int showDetail(int selectNum) {
		// ��ȭ ������ ���
		System.out.println("========================================================");
		System.out.println("���� : " + showingList.get(selectNum - 1).getTitle());
		System.out.println("�帣 : " + showingList.get(selectNum - 1).getGenre());
		System.out.println("���� : " + showingList.get(selectNum - 1).getDirector());
		System.out.println("�⿬�� : " + showingList.get(selectNum - 1).getActor());
		System.out.println("������ : " + showingList.get(selectNum - 1).getRelease());
		System.out.println("�������� : " + showingList.get(selectNum - 1).getRating());
		System.out.println("�ٰŸ� : " + showingList.get(selectNum - 1).getPlot());
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
			System.out.print("������ ���ϴ� ������ �������ּ���:");
			try {
				selNum = Integer.parseInt(sc.nextLine());
				System.out.println("==============================");
				if (selNum == 0 || selNum > resultList.size()) {
					System.out.println("�ٽ� �Է����ּ���!");
				} else {
					selectCalData();
					break;
				}
			} catch (Exception e) {
				System.out.println("==============================");
				System.out.println("�ùٸ� �������� �Է����ּ���");
			}
		}
	}

	public void selectCalData() {
		myCalendar = new MyCalendar(2021, 8);
		date = myCalendar.selecteDate();
		System.out.println("���õ� ��¥ Ȯ�� : " + date);
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
			System.out.println("�ش� ������ �󿵽ð�ǥ�� �������� �ʽ��ϴ�.");
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			// nowShowing(2);
			// selectCalData();
		} else {
			do {
				System.out.println("==============================");
				System.out.println("�ش� ������ �󿵽ð�ǥ�� ������ �����ϴ�.");
				System.out.println("==============================");
				Collections.sort(timeList, new TimeTableComparator());
				for (int i = 0; i < timeList.size(); i++) {
					if (i == 0) {
						System.out.print("    [" + timeList.get(i).getShowRoomNum() + "��] " + (i + 1) + ". "
								+ timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "��]");
					} else {
						if (timeList.get(i - 1).getShowRoomNum() == timeList.get(i).getShowRoomNum()) {
							System.out.print(" " + (i + 1) + ". " + timeList.get(i).getStartTime() + " ["
									+ timeList.get(i).getSeatCount() + "��]");
						} else {
							System.out.println();
							System.out.print("    [" + timeList.get(i).getShowRoomNum() + "��] " + (i + 1) + ". "
									+ timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "��]");
						}
					}
				}
				System.out.println();
				System.out.println("==============================");
				System.out.print("������ ���ϴ� �ð�ǥ�� �������ּ��� : ");
				selectTime = Integer.parseInt(sc.nextLine());
				System.out.println("==============================");
				if (selectTime > timeList.size()) {
					System.out.println("�ٽ� �Է����ּ���.");
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

	// seat ��� class
	public void showSeat(TimeTable timetable) {
		// seatNumberList.clear();
		seatNumberList = new ArrayList<Integer>();
		seatMap.get(timetable).seatLook();
		// ������ �¼��� ����

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
		System.out.println(currentCustomer.getNickname() + "���� ���� ���� ������ ������ �����ϴ�");
		System.out.println("1.��ȭ :" + mvName);
		System.out.println("2.��¥ :" + date);
		System.out.println("3.�󿵱��� :" + theaterName);
		System.out.println("4.�󿵰� �� �ð� : " + "[" + timetable.getShowRoomNum() + "��]" + timetable.getStartTime());
		System.out.print("5.�¼���ȣ : ");
		for (int num : seatNumberList) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.print("6.���� : ");
		if (numTime >= 7 && numTime < 12) {
			price = 7000;
			System.out.println(price * seatNumberList.size() + "�� (�������� ����)");
		} else {
			price = 11000;
			System.out.println(price * seatNumberList.size() + "�� (�Ϲݰ�)");
		}
		System.out.println("==============================");
		System.out.print("���Ÿ� ���Ͻø� ��yes�� ó������ ���ư����� ��no���� �Է��ϼ��� :");
		String check = sc.nextLine();
		System.out.println("==============================");

		if (check.equals("yes")) {
			if (currentCustomer.getPrice() < price * seatNumberList.size()) {
				System.out.println("������� �����ݾ��� �����Ͽ� ���Ű� ��� �Ǿ����ϴ�.");
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
				System.out.println("���Ű� �Ϸ� �Ǿ����ϴ�.");
				// return reserveList;
				currentCustomer.setPrice(currentCustomer.getPrice() - (price * seatNumberList.size()));
				System.out.println("������ �ܾ��� " + currentCustomer.getPrice() + "�� �Դϴ�");
			}
		} else {
			seatListRemove(timetable);
			System.out.println("���Ű� ��� �Ǿ����ϴ�.");
			// return null;
		}
	}

	// ���� ��ҽ� �¼� ��ȯ
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
			System.out.println("    " + currentCustomer.getNickname() + "���� ���� ������ �������� �ʽ��ϴ�.    ");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else {
			System.out.println("==================================");
			System.out.println("    " + currentCustomer.getNickname() + "���� ���� ������ ������ �����ϴ�.    ");
			System.out.println("==================================");

			for (int i = 0; i < currentCustomer.getRsvList().size(); i++) {
				System.out.println((i + 1) + ". " + currentCustomer.getRsvList().get(i).getTitle() + " / "
						+ currentCustomer.getRsvList().get(i).getRsvDate() + " / "
						+ currentCustomer.getRsvList().get(i).getTheaterName());
			}

			System.out.print("�󼼳����� ���ϴ� �׸��� �����ϼ��� : ");
			int selectNum = Integer.parseInt(sc.nextLine());
			showDetailList(selectNum);
		}
	}

	public void showDetailList(int selectNum) {

		System.out.println("=======================================");
		System.out.println("  " + currentCustomer.getNickname() + "�Բ��� �����Ͻ� ���� ������ ������ �����ϴ�.   ");
		System.out.println("=======================================");

		System.out.println("1.��ȭ : " + currentCustomer.getRsvList().get(selectNum - 1).getTitle());
		System.out.println("2.��¥ : " + currentCustomer.getRsvList().get(selectNum - 1).getRsvDate());
		System.out.println("3.�󿵱��� : " + currentCustomer.getRsvList().get(selectNum - 1).getTheaterName());
		System.out.println("4.�󿵰� �� �ð� : " + "[" + currentCustomer.getRsvList().get(selectNum - 1).getShowRoomNum()
				+ "��] " + currentCustomer.getRsvList().get(selectNum - 1).getStartTime());
		System.out.println("5.�¼���ȣ : " + currentCustomer.getRsvList().get(selectNum - 1).getSeatNum());
		System.out.print("���� ��Ҹ� ���Ͻø� 'C', ���θ޴��� ���ư��÷��� 'H'�� �����ּ��� : ");
		String select = sc.nextLine();
		if (select.equalsIgnoreCase("C")) {
			System.out.println("=======================================");

			seatListRemove(currentCustomer.getRsvList().get(selectNum - 1));

			ArrayList<ReserveList> rsvList = currentCustomer.getRsvList();
			rsvList.remove(selectNum - 1);
			currentCustomer.setRsvList(rsvList);

			System.out.println("���� ��� �Ϸ�!");

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
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		while (true) {
			System.out.println("�ٽ� �α��� �Ͻðڽ��ϱ�? (��yes�� , ��no���� �Է��ϼ���)");
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
				System.out.println("yes or no �� �Է����ּ���");
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
