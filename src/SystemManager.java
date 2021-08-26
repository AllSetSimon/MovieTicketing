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
		Movie sinkHole = new Movie("��ũȦ", "�׼�", "������", "�̱���", "��ũȦ�ٰŸ�", "2021-08-15", 0.0);
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
	//	cgvGangnam.setupTimeTable(mogaDS, new TimeTable("2021-08-16", "17:00", 2, 30));
		cgvGangnam.setupTimeTable(bossBB, new TimeTable("2021-08-13", "18:00", 3, 60));

		theaterList.add(lotteJamsil);
		theaterList.add(cgvGangnam);
		showSeatMapAdd();
	}

	public void nowShowing(int inputNum) {
		// ������ ��ȭ ����Ʈ ���
		System.out.println("==============================");
		System.out.println("              ���� ������ ��ȭ�Դϴ�");
		System.out.println("==============================");

		for (int i = 0; i < showingList.size(); i++) {
			System.out.println("        " + (i + 1) + ". " + showingList.get(i).getTitle());
		}
		
		if(inputNum == 1) {
			System.out.println("==============================");
			System.out.print("���������� ���Ͻô� ��ȭ�� �������ּ��� : ");
			selNum = Integer.parseInt(sc.nextLine());
			showDetail(selNum);
		} else {
			System.out.println("==============================");
			System.out.print("������ ���Ͻô� ��ȭ�� �������ּ���:");
			selNum = Integer.parseInt(sc.nextLine());
			showTheater(selNum);
		}
		System.out.println("==============================");
		//showTheater(selNum);
	}

	public void showDetail(int selectNum) {
		// ��ȭ ������ ���
		System.out.println("==============================");
		System.out.println("���� : " + showingList.get(selectNum - 1).getTitle());
		System.out.println("�帣 : " + showingList.get(selectNum - 1).getGenre());
		System.out.println("���� : " + showingList.get(selectNum - 1).getDirector());
		System.out.println("�⿬�� : " + showingList.get(selectNum - 1).getActor());
		System.out.println("������ : " + showingList.get(selectNum - 1).getRelease());
		System.out.println("�������� : " + showingList.get(selectNum).getRating());
		System.out.println("�ٰŸ� : " + showingList.get(selectNum - 1).getPlot());
	}

	public void showTheater(int selectNum) {
		// mvName = showingList���� ���� ������ �ε��� ���� ���������� ����
		mvName = showingList.get(selectNum-1).getTitle();
		resultList.clear();

		// map���� get(key��)
		// p key : 3, value : "C"
		// p.get(3) ==> String ["C"]

		/*
		 * for (int i = 0; i < ��� ���;� ����; i++) { //getMovieMap().get(key) ==> �������
		 * resultList�� add�ϰڴ�. }
		 */
		
		for (int i = 0; i < theaterList.size(); i++) {
			resultList.add(theaterList.get(i).getMovieMap().get(mvName));
		}

		// resultList�� for���� ���ؼ� �� �ȿ� �ִ� ������ �� ������ �ſ���
		// 1. 2. (index+1)���� �ٵ��� --> ���for��X
		
		for (int i = 0; i < resultList.size(); i++) {
			if(resultList.get(i)!=null) {System.out.println("        "+(i+1)+". "+resultList.get(i));}
		}
		
		System.out.println("==============================");
		System.out.print("������ ���ϴ� ������ �������ּ���:");
		selNum = Integer.parseInt(sc.nextLine());
		System.out.println("==============================");
		selectCalData();
	}
	
	public void selectCalData() {			
			myCalendar = new MyCalendar(2021, 8);
			date = myCalendar.selecteDate();
			System.out.println("���õ� ��¥ Ȯ�� : " + date);
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
			System.out.println("�ش� ������ �󿵽ð�ǥ�� �������� �ʽ��ϴ�.");
			System.out.println("XXXXXXXXXXXXXXXXXXX");
			//nowShowing(2);
			//selectCalData();
		} else {
			do {
				System.out.println("==============================");
				System.out.println("�ش� ������ �󿵽ð�ǥ�� ������ �����ϴ�.");
				System.out.println("==============================");
				Collections.sort(timeList,new TimeTableComparator());
				for (int i = 0; i < timeList.size(); i++) {
					if(i == 0) {
						System.out.print("    [" + timeList.get(i).getShowRoomNum() + "��] " +(i+1) + ". " + timeList.get(i).getStartTime()+ " [" + timeList.get(i).getSeatCount() + "��]");
					} else {
						if(timeList.get(i-1).getShowRoomNum() == timeList.get(i).getShowRoomNum()) {
							System.out.print(" " + (i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "��]");				
						} else {
							System.out.println();
							System.out.print("    [" + timeList.get(i).getShowRoomNum() + "��] " +(i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "��]");
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
	
	//seat ��� class
	public void showSeat(TimeTable timetable) {
		seatNumberList.clear();
		seatMap.get(timetable).seatLook();
		//������ �¼��� ����
		seatNumberList.addAll(seatMap.get(timetable).getSeatRangementList());
		showFinalRsv();
	}
	
	public void showFinalRsv () {
		String time = timetable.getStartTime();
		String[] timePieces = time.split(":");	
		int numTime = Integer.parseInt(timePieces[0]);
		
		System.out.println("==============================");
		System.out.println("������ ���� ���� ������ ������ �����ϴ�");
		System.out.println("1.��ȭ :" + mvName);
		System.out.println("2.��¥ :" + date);
		System.out.println("3.�󿵱��� :" + theaterName);
		System.out.println("4.�󿵰� �� �ð� : " + "[" + timetable.getShowRoomNum() +"��]"+ timetable.getStartTime());
		System.out.print("5.�¼���ȣ : ");
		for (int num : seatNumberList) {System.out.print(num + " ");}
		System.out.println();
		System.out.print("6.���� : ");
		if(numTime >= 7 && numTime < 12) {
			price = 7000;
			System.out.println(price*seatNumberList.size() + "�� (�������� ����)");
		} else {
			price = 11000;
			System.out.println(price*seatNumberList.size() + "�� (�Ϲݰ�)");
		}
		System.out.println("==============================");
		System.out.print("���Ÿ� ���Ͻø� ��yes�� ó������ ���ư����� ��no���� �Է��ϼ��� :");
		String check = sc.nextLine();
		System.out.println("==============================");
		
		if(check.equals("yes")) {
			reserveList = new ReserveList(mvName,date,theaterName,timetable.getShowRoomNum(),timetable.getStartTime(),seatNumberList);
			customer.addRsvInfo(reserveList);
			System.out.println("���Ű� �Ϸ� �Ǿ����ϴ�.");
			//return reserveList;
		}else {
			System.out.println("���Ű� ��� �Ǿ����ϴ�.");	
			//return null;  
		}
	}	
	
	public void checkRsv() {
		customer.showRsvInfo();
	}
}
