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
		Movie sinkHole = new Movie("��ũȦ", "�׼�", "������", "�̱���", "��ũȦ�ٰŸ�", "2021-08-15", 0.0);
		Movie bossBB = new Movie("�������̺�2", "�ִϸ��̼�", "�����ΰ�", "����", "�������̺��ٰŸ�", "2021-08-07", 0.0);
		Movie mogaDS = new Movie("�𰡵�", "�׼�", "������", "���μ�", "�𰡵��ٰŸ�", "2021-08-12", 0.0);
		
		showingList.add(sinkHole);
		showingList.add(mogaDS);
		showingList.add(bossBB);

		Theater lotteJamsil = new Theater("�Ե��ó׸� ���", "���");
		Theater cgvGangnam = new Theater("CGV ����", "����");

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
		// ������ ��ȭ ����Ʈ ���
		System.out.println("======================");
		System.out.println("���� ������ ��ȭ�Դϴ�");
		System.out.println("======================");

		for (int i = 0; i < showingList.size(); i++) {
			System.out.println((i + 1) + ". " + showingList.get(i).getTitle());
		}
		
		if(inputNum == 1) {
			System.out.println("======================");
			System.out.print("���������� ���Ͻô� ��ȭ�� �������ּ���:");
			selNum = Integer.parseInt(sc.nextLine());
			showDetail(selNum);
		} else {
			System.out.println("======================");
			System.out.print("������ ���Ͻô� ��ȭ�� �������ּ���:");
			selNum = Integer.parseInt(sc.nextLine());
			showTheater(selNum);
		}

		System.out.println("======================");
	}

	public void showDetail(int selectNum) {
		// ��ȭ ������ ���
		System.out.println("======================");
		System.out.println("���� :" + showingList.get(selectNum - 1).getTitle());
		System.out.println("�帣 :" + showingList.get(selectNum - 1).getGenre());
		System.out.println("���� :" + showingList.get(selectNum - 1).getDirector());
		System.out.println("�⿬�� :" + showingList.get(selectNum - 1).getActor());
		System.out.println("������ :" + showingList.get(selectNum - 1).getRelease());
		System.out.println("�������� :" + showingList.get(selectNum).getRating());
		System.out.println("�ٰŸ� :" + showingList.get(selectNum - 1).getPlot());
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
			if(resultList.get(i)!=null) {System.out.println((i+1)+"."+resultList.get(i));}
		}
		
		System.out.println("================");
		System.out.print("������ ���ϴ� ������ �������ּ���:");
		selNum = Integer.parseInt(sc.nextLine());
		System.out.println("================");
		selectCalData();
	}
	
	public void selectCalData() {
		MyCalendar myCalendar = new MyCalendar(2021, 8);
		String selectedDate = myCalendar.selecteDate();
		System.out.println("���õ� ��¥ Ȯ��:" + selectedDate);
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
			System.out.println("��ȸ�� �ð�ǥ�� �����ϴ�.");
			System.out.println("XXXXXXXXXXXXXXXXXXX");
		} else {
			System.out.println("==============================");
			System.out.println("�ش� ������ �󿵽ð�ǥ�� ������ �����ϴ�.");
			System.out.println("==============================");
			for (int i = 0; i < timeList.size(); i++) {
				if(i == 0) {
					System.out.print("[" + timeList.get(i).getShowRoomNum() + "��] " +(i+1) + ". " + timeList.get(i).getStartTime()+ " [" + timeList.get(i).getSeatCount() + "��]");
				} else {
					if(timeList.get(i-1).getShowRoomNum() == timeList.get(i).getShowRoomNum()) {
						System.out.print(" " + (i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "��]");				
					} else {
						System.out.println();
						System.out.print("[" + timeList.get(i).getShowRoomNum() + "��] " +(i+1) + ". " + timeList.get(i).getStartTime() + " [" + timeList.get(i).getSeatCount() + "��]");
					}
				}
			}			
			System.out.println();
			System.out.println("=============================");
			System.out.print("������ ���ϴ� �ð�ǥ�� �������ּ��� : ");
			int selectTime = Integer.parseInt(sc.nextLine());
			System.out.println("=============================");
		}		
	}
	
	
	
	
	
	
	
	
}
